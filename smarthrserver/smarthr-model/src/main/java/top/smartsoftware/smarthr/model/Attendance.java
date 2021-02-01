package top.smartsoftware.smarthr.model;

import cn.hutool.core.date.DateTime;

import java.util.Date;

/**
 * @Description
 * @Author xjx
 * @Date 2021-01-12
 */
public class Attendance {
    private Integer id;
    private int eid;
    private String date;
    private String weekOfDay;
    private DateTime morning;
    private int morningStatus;
    private DateTime afternoon;
    private int afternoonStatus;
    private String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeekOfDay() {
        return weekOfDay;
    }

    public void setWeekOfDay(String weekOfDay) {
        this.weekOfDay = weekOfDay;
    }

    public DateTime getMorning() {
        return morning;
    }

    public void setMorning(DateTime morning) {
        this.morning = morning;
    }

    public int getMorningStatus() {
        return morningStatus;
    }

    public void setMorningStatus(int morningStatus) {
        this.morningStatus = morningStatus;
    }

    public DateTime getAfternoon() {
        return afternoon;
    }

    public void setAfternoon(DateTime afternoon) {
        this.afternoon = afternoon;
    }

    public int getAfternoonStatus() {
        return afternoonStatus;
    }

    public void setAfternoonStatus(int afternoonStatus) {
        this.afternoonStatus = afternoonStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
