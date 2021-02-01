package top.smartsoftware.smarthr.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 员工调动表
 * </p>
 *
 * @author xjx
 * @since 2021-02-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="EmployeeRemove对象", description="员工调动表")
public class EmployeeRemove extends Model<EmployeeRemove> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "员工id")
    private Integer eid;

    @ApiModelProperty(value = "调动前部门")
    @TableField("beforeDepId")
    private Integer beforeDepId;

    @ApiModelProperty(value = "调动前职位")
    @TableField("beforeJobId")
    private Integer beforeJobId;

    @ApiModelProperty(value = "调动后部门")
    @TableField("afterDepId")
    private Integer afterDepId;

    @ApiModelProperty(value = "调动后职位")
    @TableField("afterJobId")
    private Integer afterJobId;

    @ApiModelProperty(value = "调动日期")
    @TableField("removeDate")
    private LocalDate removeDate;

    @ApiModelProperty(value = "调动原因")
    private String reason;

    @ApiModelProperty(value = "备注")
    private String remark;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
