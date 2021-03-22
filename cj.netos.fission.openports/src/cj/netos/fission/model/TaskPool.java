package cj.netos.fission.model;

public class TaskPool {
    String task;
    boolean isMustDo;//必做任务，如分享到群、朋友圈
    String eventTitle;
    String eventNav;
    String eventNote;
    String tipsTitle;
    String tipsNav;
    String tipsNote;
    int state;//0停用；1使用

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public boolean isMustDo() {
        return isMustDo;
    }

    public void setMustDo(boolean mustDo) {
        isMustDo = mustDo;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventNav() {
        return eventNav;
    }

    public void setEventNav(String eventNav) {
        this.eventNav = eventNav;
    }

    public String getEventNote() {
        return eventNote;
    }

    public void setEventNote(String eventNote) {
        this.eventNote = eventNote;
    }

    public String getTipsTitle() {
        return tipsTitle;
    }

    public void setTipsTitle(String tipsTitle) {
        this.tipsTitle = tipsTitle;
    }

    public String getTipsNav() {
        return tipsNav;
    }

    public void setTipsNav(String tipsNav) {
        this.tipsNav = tipsNav;
    }

    public String getTipsNote() {
        return tipsNote;
    }

    public void setTipsNote(String tipsNote) {
        this.tipsNote = tipsNote;
    }
}
