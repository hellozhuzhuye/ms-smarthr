package top.smartsoftware.smarthr.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Description
 * @Author xjx
 * @Date 2021-05-07
 */
public class EmpAccountVO {
    private Integer id;
    private String ename;
    private String sname;
    private Double basicSalary;
    private Double lunchSalary;
    private Double trafficSalary;
    private Double pension;
    private Double medical;
    private Double unemploy;
    private Double jobInjury;
    private Double birth;
    private Double accumulationFund;
    private Double bonus;
    private Double netSalary;
    private Double attendanceDeduction;
    @JsonFormat(pattern = "yyyy-MM",timezone = "Asia/Shanghai")
    private Date currentMonth;
    private String startTime;
    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Double getLunchSalary() {
        return lunchSalary;
    }

    public void setLunchSalary(Double lunchSalary) {
        this.lunchSalary = lunchSalary;
    }

    public Double getTrafficSalary() {
        return trafficSalary;
    }

    public void setTrafficSalary(Double trafficSalary) {
        this.trafficSalary = trafficSalary;
    }

    public Double getPension() {
        return pension;
    }

    public void setPension(Double pension) {
        this.pension = pension;
    }

    public Double getMedical() {
        return medical;
    }

    public void setMedical(Double medical) {
        this.medical = medical;
    }

    public Double getUnemploy() {
        return unemploy;
    }

    public void setUnemploy(Double unemploy) {
        this.unemploy = unemploy;
    }

    public Double getJobInjury() {
        return jobInjury;
    }

    public void setJobInjury(Double jobInjury) {
        this.jobInjury = jobInjury;
    }

    public Double getBirth() {
        return birth;
    }

    public void setBirth(Double birth) {
        this.birth = birth;
    }

    public Double getAccumulationFund() {
        return accumulationFund;
    }

    public void setAccumulationFund(Double accumulationFund) {
        this.accumulationFund = accumulationFund;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(Double netSalary) {
        this.netSalary = netSalary;
    }

    public Double getAttendanceDeduction() {
        return attendanceDeduction;
    }

    public void setAttendanceDeduction(Double attendanceDeduction) {
        this.attendanceDeduction = attendanceDeduction;
    }

    public Date getCurrentMonth() {
        return currentMonth;
    }

    public void setCurrentMonth(Date currentMonth) {
        this.currentMonth = currentMonth;
    }
}
