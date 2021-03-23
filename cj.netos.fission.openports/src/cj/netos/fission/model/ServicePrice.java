package cj.netos.fission.model;

/**
 * Table: service_price
 */
public class ServicePrice {
    /**
     * Column: id
     */
    private String id;

    /**
     * Column: price
     * Remark: 单位为分
     */
    private Long price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}