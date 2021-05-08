package top.smartsoftware.smarthr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;

public class OperationLog {
    private Integer id;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addDate;

    private String operate;

    private Integer type;

    private Integer hrid;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public Integer getHrid() {
        return hrid;
    }

    public void setHrid(Integer hrid) {
        this.hrid = hrid;
    }

    public OperationLog() {
    }

    public OperationLog(String operate,Integer type) {
        this.addDate = new Date();
        this.operate = operate;
        this.type=type;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Hr hr = (Hr) authentication.getPrincipal();
        this.hrid = hr.getId();
    }

    public OperationLog(String operate) {
        this.addDate = new Date();
        this.operate = operate;
        this.type=type;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Hr hr = (Hr) authentication.getPrincipal();
        this.hrid = hr.getId();
    }

}