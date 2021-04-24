package top.smartsoftware.smarthr.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.smartsoftware.smarthr.model.vo.BankCardVO;
import top.smartsoftware.smarthr.model.vo.IdCardVO;

/**
 * <p>
 * 员工高级资料
 * </p>
 *
 * @author xjx
 * @since 2021-04-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="EmployeeSenior对象", description="员工高级资料")
public class EmployeeSenior extends Model<EmployeeSenior> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "员工id")
    private Integer eid;


    @ApiModelProperty(value = "身份证识别信息")
    @TableField("idCardData")
    private String idCardData;

    @ApiModelProperty(value = "银行卡识别信息")
    @TableField("bankCardData")
    private String bankCardData;

    @ApiModelProperty(value = "银行卡图片url")
    @TableField("bankCardUrl")
    private String bankCardUrl;

    @ApiModelProperty(value = "身份证图片url")
    @TableField("idCardUrl")
    private String idCardUrl;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("updateTime")
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private IdCardVO idCardVO;

    @TableField(exist = false)
    private BankCardVO bankCardVO;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
