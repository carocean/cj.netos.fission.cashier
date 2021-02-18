package cj.netos.fission.service;

import cj.lns.chip.sos.cube.framework.IDocument;
import cj.lns.chip.sos.cube.framework.IQuery;
import cj.lns.chip.sos.cube.framework.TupleDocument;
import cj.netos.fission.AbstractService;
import cj.netos.fission.ITaskService;
import cj.netos.fission.model.TaskCounter;
import cj.netos.fission.model.TaskEvent;
import cj.studio.ecm.annotation.CjService;
import org.bson.Document;

@CjService(name = "taskService")
public class TaskService extends AbstractService implements ITaskService {
    static final String _COL_TASK_COUNTER = "fission.mf.task.counters";

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
}
