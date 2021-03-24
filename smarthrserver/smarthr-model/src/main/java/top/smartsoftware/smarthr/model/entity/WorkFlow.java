package top.smartsoftware.smarthr.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author xjx
 * @since 2021-02-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "WorkFlow对象", description = "")
public class WorkFlow extends Model<WorkFlow> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "申请人id")
    private Integer eid;

    @ApiModelProperty(value = "申请类型id")
    @TableField("workFlowTypeId")
    private Long workFlowTypeId;

    @ApiModelProperty(value = "审核人id")
    private String hrid;

    @ApiModelProperty(value = "申请内容")
    private String content;

    @ApiModelProperty(value = "选择日期时间")
    @TableField("selectDateTime")
    private String selectDateTime;

    @ApiModelProperty(value = "附件url")
    private String url;

    @ApiModelProperty(value = "申请时间")
    @TableField("createTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private LocalDateTime createTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
