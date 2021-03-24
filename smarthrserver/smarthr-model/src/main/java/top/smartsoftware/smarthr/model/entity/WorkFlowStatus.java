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
@ApiModel(value="WorkFlowStatus对象", description="")
public class WorkFlowStatus extends Model<WorkFlowStatus> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "工作流程id")
    private Integer wfid;

    @ApiModelProperty(value = "审批人id")
    private Integer hrid;

    @ApiModelProperty(value = "审批状态 0 未审批 1 批准 2 未批准")
    private Integer status;

    @ApiModelProperty(value = "审批返回正文")
    private String content;

    @ApiModelProperty(value = "优先级")
    private Integer priority;

    @ApiModelProperty(value = "审批时间")
    @TableField("approveTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private LocalDateTime approveTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
