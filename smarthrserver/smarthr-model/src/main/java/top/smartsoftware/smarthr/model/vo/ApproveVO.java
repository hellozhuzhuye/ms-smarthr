package top.smartsoftware.smarthr.model.vo;

import lombok.Data;

/**
 * @Description
 * @Author xjx
 * @Date 2021-02-05
 */
@Data
public class ApproveVO {
    private Integer id;
    private Integer eid;
    private String name;
    private String typeName;
    private String content;
    private String selectDateTime;
    private String url;
    private String createTime;
    private Integer status;
    private String approveContent;
    private String approveTime;

}
