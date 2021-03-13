package cj.netos.fission.model;

import java.math.BigDecimal;

/**
 * Table: business_income_ratio
 */
public class BusinessIncomeRatio {
    /**
     * Column: id
     */
    private String id;

    /**
     * Column: min_amount_edge
     * Remark: 区间内最小金额
     */
    private Long minAmountEdge;

    /**
     * Column: max_amount_edge
     * Remark: 区间内最大金额
     */
    private Long maxAmountEdge;

    /**
     * Column: ratio
     * Remark: 提成
     */
    private BigDecimal ratio;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Long getMinAmountEdge() {
        return minAmountEdge;
    }

    public void setMinAmountEdge(Long minAmountEdge) {
        this.minAmountEdge = minAmountEdge;
    }

    public Long getMaxAmountEdge() {
        return maxAmountEdge;
    }

    public void setMaxAmountEdge(Long maxAmountEdge) {
        this.maxAmountEdge = maxAmountEdge;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }
}