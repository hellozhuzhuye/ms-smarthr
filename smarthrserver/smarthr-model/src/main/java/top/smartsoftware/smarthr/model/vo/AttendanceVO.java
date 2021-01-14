package top.smartsoftware.smarthr.model.vo;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Description
 * @Author xjx
 * @Date 2021-01-12
 */
public class AttendanceVO {
    private int id;
    private String workID;
    private String dname;
    private String ename;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date date;
    private String weekOfDay;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private String morning;
    private int morningStatus;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private String afternoon;
    private int afternoonStatus;
    private String remark;
    private int normal;
    private int late;
    private int early;
    private int asked;
    private int workout;
    private int leaved;


    public int getNormal() {
        return normal;
    }

    public void setNormal(int normal) {
        this.normal = normal;
    }

    public int getLate() {
        return late;
    }

    public void setLate(int late) {
        this.late = late;
    }

    public int getEarly() {
        return early;
    }

    public void setEarly(int early) {
        this.early = early;
    }

    public int getAsked() {
        return asked;
    }

    public void setAsked(int asked) {
        this.asked = asked;
    }

    public int getWorkout() {
        return workout;
    }

    public void setWorkout(int workout) {
        this.workout = workout;
    }

    public int getLeaved() {
        return leaved;
    }

    public void setLeaved(int leaved) {
        this.leaved = leaved;
    }

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

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getWeekOfDay() {
        return weekOfDay;
    }

    public void setWeekOfDay(String weekOfDay) {
        this.weekOfDay = weekOfDay;
    }

    public String getMorning() {
        return morning;
    }

    public void setMorning(String morning) {
        this.morning = morning;
    }

    public int getMorningStatus() {
        return morningStatus;
    }

    public void setMorningStatus(int morningStatus) {
        this.morningStatus = morningStatus;
    }

    public String getAfternoon() {
        return afternoon;
    }

    public void setAfternoon(String afternoon) {
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
