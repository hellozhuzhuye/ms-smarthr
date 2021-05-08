package top.smartsoftware.smarthr.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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
 * @since 2021-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="EmployeeAccount对象", description="")
public class EmployeeAccount extends Model<EmployeeAccount> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "员工id")
    private Integer eid;

    @ApiModelProperty(value = "工资账套id")
    private Integer sid;

    @ApiModelProperty(value = "绩效奖金")
    private Double achievement;

    @ApiModelProperty(value = "绩效基数比率")
    private Double performance;

    @ApiModelProperty(value = "实发工资")
    @TableField("netSalary")
    private Double netSalary;

    @ApiModelProperty(value = "考勤扣款")
    @TableField("attendanceDeduction")
    private Double attendanceDeduction;

    @ApiModelProperty(value = "当前月份")
    @TableField("currentMonth")
    private LocalDate currentMonth;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("updateTime")
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
