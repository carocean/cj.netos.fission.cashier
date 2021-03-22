package cj.netos.fission.service;

import cj.lns.chip.sos.cube.framework.IDocument;
import cj.lns.chip.sos.cube.framework.IQuery;
import cj.lns.chip.sos.cube.framework.TupleDocument;
import cj.netos.fission.AbstractService;
import cj.netos.fission.ITaskService;
import cj.netos.fission.model.TaskCounter;
import cj.netos.fission.model.TaskEvent;
import cj.netos.fission.model.TaskPool;
import cj.netos.fission.model.Utils;
import cj.studio.ecm.annotation.CjService;
import cj.studio.openport.util.Encript;
import cj.ultimate.util.StringUtil;
import org.bson.Document;

import java.util.UUID;

@CjService(name = "taskService")
public class TaskService extends AbstractService implements ITaskService {
    static final String _COL_TASK_COUNTER = "fission.mf.task.counters";
    static final String _COL_TASK_EVENT = "fission.mf.task.events";
    static final String _COL_TASK_POOL = "fission.mf.task.pool";

    public TaskCounter getCounter(String person) {
        String cjql = String.format("select {'tuple':'*'} from tuple %s %s where {'tuple.person':'%s'}", _COL_TASK_COUNTER, TaskCounter.class.getName(), person);
        IQuery<TaskCounter> query = getHome().createQuery(cjql);
        IDocument<TaskCounter> document = query.getSingleResult();
        if (document == null) {
            return null;
        }
        return document.tuple();
    }

    @Override
    public long addOpTimers(String person) {
        String filter = String.format("{'tuple.person':'%s'}", person);
        TaskCounter counter = getCounter(person);
        if (counter != null) {
            long timers = counter.getOpTimes();
            timers = timers + 1;
            String update = String.format("{'$set':{'tuple.opTimes':%s}}", timers);
            getHome().updateDocOne(_COL_TASK_COUNTER, Document.parse(filter), Document.parse(update));
            return timers;
        }
        counter = new TaskCounter();
        counter.setOpTimes(1);
        counter.setPerson(person);
        getHome().saveDoc(_COL_TASK_COUNTER, new TupleDocument<>(counter));
        return counter.getOpTimes();
    }

    @Override
    public boolean isTask(String principal, String task) {
        TaskCounter counter = getCounter(principal);
        if (counter == null) {
            return false;
        }
        if (StringUtil.isEmpty(counter.getTask())) {
            return false;
        }
        return counter.getTask().equals(task);
    }

    public TaskPool getTask(String task) {
        String cjql = String.format("select {'tuple':'*'} from tuple %s %s where {'tuple.task':'%s'}", _COL_TASK_POOL, TaskPool.class.getName(), task);
        IQuery<TaskPool> query = getHome().createQuery(cjql);
        IDocument<TaskPool> document = query.getSingleResult();
        if (document == null) {
            return null;
        }
        return document.tuple();
    }

    @Override
    public void doneTask(String principal, String nickName) {
        TaskCounter counter = getCounter(principal);
        if (counter == null) {
            return;
        }
        TaskPool task = null;
        if (!StringUtil.isEmpty(counter.getTask())) {
            task = getTask(counter.getTask());
        }
        if (task == null) {
            return;
        }
        TaskEvent event = new TaskEvent();
        long opTimers = getOpTimers(event.getPerson());
        event.setId(Encript.md5(UUID.randomUUID().toString()));
        event.setPerson(principal);
        event.setNickName(nickName);
        event.setEventType(task.getTask());
        event.setEventTitle(task.getEventTitle());
        event.setOpTimes(opTimers);
        event.setCtime(Utils.timeToStr(System.currentTimeMillis()));
        getHome().saveDoc(_COL_TASK_EVENT, new TupleDocument<>(event));
        //做了任务则清除计数
        clearOptions(event.getPerson());
    }

    public long getOpTimers(String person) {
        TaskCounter counter = getCounter(person);
        if (counter == null) {
            return 0;
        }
        return counter.getOpTimes();
    }

    private void clearOptions(String person) {
        String filter = String.format("{'tuple.person':'%s'}", person);
        if (getHome().tupleCount(_COL_TASK_COUNTER, filter) > 0) {
            String update = String.format("{'$set':{'tuple.opTimes':0},'$unset':{'tuple.condition':'','tuple.task':''}}");
            getHome().updateDocOne(_COL_TASK_COUNTER, Document.parse(filter), Document.parse(update));
            return;
        }
        TaskCounter counter = new TaskCounter();
        counter.setOpTimes(0);
        counter.setPerson(person);
        counter.setCondition(null);
        counter.setTask(null);
        getHome().saveDoc(_COL_TASK_COUNTER, new TupleDocument<>(counter));
    }
}
