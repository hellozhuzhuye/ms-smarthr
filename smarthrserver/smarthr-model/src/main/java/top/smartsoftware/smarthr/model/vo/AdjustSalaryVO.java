package top.smartsoftware.smarthr.model.vo;

import top.smartsoftware.smarthr.model.AdjustSalary;

import java.util.Date;

/**
 * @Description
 * @Author xjx
 * @Date 2021-05-07
 */
public class AdjustSalaryVO extends AdjustSalary {
    private String ename;
    private Date startTime;
    private Date endTime;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }
}
