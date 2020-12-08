package top.smartsoftware.smarthr.model;

import java.util.List;

/**
 * @Description
 * @Author xjx
 * @Date 2020-12-01
 */
public class RespPageBean {
    private Long total;
    private List<?> data;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
