package top.smartsoftware.smarthr.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 员工考评表
 * </p>
 *
 * @author xjx
 * @since 2021-02-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="EmployeeEvaluation对象", description="员工考评表")
public class EmployeeEvaluation extends Model<EmployeeEvaluation> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "员工id")
    private Integer eid;

    @ApiModelProperty(value = "考评日期")
    private LocalDate date;

    @ApiModelProperty(value = "考评内容")
    private String content;

    @ApiModelProperty(value = "考评结果 0未通过  1通过")
    private Integer result;

    @ApiModelProperty(value = "备注")
    private String remark;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
