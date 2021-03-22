package cj.netos.fission.model;

public class TaskCounter {
    String person;
    long opTimes;
    String condition;//条件一般是个串，在需要用户做任务时生成该串，要求用户分享的链接带上该参数，用户必须从分享的链接中进入，点击进入主页时则对比该串，而后算是完成任务并清除counter
    String task;//当前任务，关联任务池代码

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public long getOpTimes() {
        return opTimes;
    }

    public void setOpTimes(long opTimes) {
        this.opTimes = opTimes;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
