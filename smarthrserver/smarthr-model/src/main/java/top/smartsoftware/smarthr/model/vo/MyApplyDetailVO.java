package top.smartsoftware.smarthr.model.vo;

import lombok.Data;
import top.smartsoftware.smarthr.model.entity.WorkFlowStatus;

/**
 * @Description
 * @Author xjx
 * @Date 2021-02-04
 */
@Data
public class MyApplyDetailVO extends WorkFlowStatus {
    private String hrName;
}
