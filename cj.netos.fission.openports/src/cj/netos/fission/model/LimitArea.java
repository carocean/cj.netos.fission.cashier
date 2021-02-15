package cj.netos.fission.model;

public class LimitArea {
    String person;
    String areaType;
    String areaCode;
    String areaTitle;
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

    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaTitle() {
        return areaTitle;
    }

    public void setAreaTitle(String areaTitle) {
        this.areaTitle = areaTitle;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }
}
