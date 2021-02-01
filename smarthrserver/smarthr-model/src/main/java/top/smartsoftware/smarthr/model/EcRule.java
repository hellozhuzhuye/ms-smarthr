package top.smartsoftware.smarthr.model;

/**
 * @Description
 * @Author xjx
 * @Date 2021-01-13
 */
public class EcRule {
    private Integer id;
    private int ecType;
    private int ecPoint;
    private String ecReason;

    public EcRule() {
    }

    public EcRule(int ecPoint, String ecReason) {
        this.ecPoint = ecPoint;
        this.ecReason = ecReason;
    }
    public EcRule(int id, int ecPoint, String ecReason) {
        this.id = id;
        this.ecPoint = ecPoint;
        this.ecReason = ecReason;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEcType() {
        return ecType;
    }

    public void setEcType(int ecType) {
        this.ecType = ecType;
    }

    public int getEcPoint() {
        return ecPoint;
    }

    public void setEcPoint(int ecPoint) {
        this.ecPoint = ecPoint;
    }

    public String getEcReason() {
        return ecReason;
    }

    public void setEcReason(String ecReason) {
        this.ecReason = ecReason;
    }
}
