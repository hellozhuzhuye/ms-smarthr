package top.smartsoftware.smarthr.model.vo;

import lombok.Data;
import top.smartsoftware.smarthr.model.entity.WorkFlow;

/**
 * @Description
 * @Author xjx
 * @Date 2021-02-04
 */
@Data
public class MyApplyVO extends WorkFlow {
    private String applyTypeName;
    private String hrNames;
}
