package cj.netos.fission.model;

public class LimitTag {
    String person;
    String tag;
    /**
     * 扮演
     * payer 即支付者限定想要获取什么标签的用户
     * payee即被支付者限定想要获取什么标签的用户
     */
    String direct;

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }
}
