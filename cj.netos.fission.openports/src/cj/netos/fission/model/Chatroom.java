package cj.netos.fission.model;

public class Chatroom {
    String room;
    String title;
    String creator;
    String leading;
    String microsite;
    String type;//fission.mf|normal|person，分别为裂变游戏｜一般｜公众群,如果为空表示normal类型
    int flag;//0为正常；1为已删除
    long ctime;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getMicrosite() {
        return microsite;
    }

    public void setMicrosite(String microsite) {
        this.microsite = microsite;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getLeading() {
        return leading;
    }

    public void setLeading(String leading) {
        this.leading = leading;
    }

    public long getCtime() {
        return ctime;
    }

    public void setCtime(long ctime) {
        this.ctime = ctime;
    }
}
