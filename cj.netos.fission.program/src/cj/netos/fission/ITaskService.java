package cj.netos.fission;

public interface ITaskService {
    long addOpTimers(String person);

    boolean isTask(String principal, String task);

    void doneTask(String principal, String nickName);

}
