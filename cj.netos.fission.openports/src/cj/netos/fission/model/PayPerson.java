package cj.netos.fission.model;

public class PayPerson extends PayRecord {
    Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void load(PayRecord record) {
        setAmount(record.getAmount());
        setCtime(record.getCtime());
        setCurrency(record.getCurrency());
        setMessage(record.getMessage());
        setNote(record.getNote());
        setPayee(record.getPayee());
        setPayeeName(record.getPayeeName());
        setPayer(record.getPayer());
        setPayerName(record.getPayerName());
        setSn(record.getSn());
        setState(record.getState());
        setStatus(record.getStatus());
    }
}
