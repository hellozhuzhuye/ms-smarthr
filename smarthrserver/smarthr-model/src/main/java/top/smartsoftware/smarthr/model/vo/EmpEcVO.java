package top.smartsoftware.smarthr.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Description
 * @Author xjx
 * @Date 2021-01-15
 */
public class EmpEcVO {
    private int id;
    private String workID;
    private String name;
    private int ecType;
    private int ecPoint;
    private String ecReason;
    private int beforePoint;
    private int afterPoint;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date ecDate;
    private String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkID() {
        return workID;
    }

    public void setWorkID(String workID) {
        this.workID = workID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getBeforePoint() {
        return beforePoint;
    }

    public void setBeforePoint(int beforePoint) {
        this.beforePoint = beforePoint;
    }

    public int getAfterPoint() {
        return afterPoint;
    }

    public void setAfterPoint(int afterPoint) {
        this.afterPoint = afterPoint;
    }

    public Date getEcDate() {
        return ecDate;
    }

    public void setEcDate(Date ecDate) {
        this.ecDate = ecDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
