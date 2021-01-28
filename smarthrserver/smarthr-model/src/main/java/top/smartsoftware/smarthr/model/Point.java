package top.smartsoftware.smarthr.model;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Description
 * @Author xjx
 * @Date 2021-01-19
 */
@TableName("employee_point")
public class Point {
    private int id;
    private int eid;
    private String point;

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

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}
