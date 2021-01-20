package top.smartsoftware.smarthr.model;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("employee_ec")
public class Employeeec {
    private Integer id;

    private Integer eid;

    private Integer ecid;

    private Integer beforePoint;

    private Integer afterPoint;

    private Date ecDate;

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

    public Integer getEcid() {
        return ecid;
    }

    public void setEcid(Integer ecid) {
        this.ecid = ecid;
    }

    public Integer getBeforePoint() {
        return beforePoint;
    }

    public void setBeforePoint(Integer beforePoint) {
        this.beforePoint = beforePoint;
    }

    public Integer getAfterPoint() {
        return afterPoint;
    }

    public void setAfterPoint(Integer afterPoint) {
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