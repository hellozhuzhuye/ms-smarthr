package top.smartsoftware.smarthr.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class AdjustSalary {
    private Integer id;

    private Integer eid;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date asDate;

    private Double beforeSalary;

    private Double afterSalary;

    private String reason;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Date getAsDate() {
        return asDate;
    }

    public void setAsDate(Date asDate) {
        this.asDate = asDate;
    }

    public Double getBeforeSalary() {
        return beforeSalary;
    }

    public void setBeforeSalary(Double beforeSalary) {
        this.beforeSalary = beforeSalary;
    }

    public Double getAfterSalary() {
        return afterSalary;
    }

    public void setAfterSalary(Double afterSalary) {
        this.afterSalary = afterSalary;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}