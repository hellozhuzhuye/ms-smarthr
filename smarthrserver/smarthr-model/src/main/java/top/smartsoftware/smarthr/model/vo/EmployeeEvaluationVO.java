package top.smartsoftware.smarthr.model.vo;

import lombok.Data;
import top.smartsoftware.smarthr.model.entity.EmployeeEvaluation;

/**
 * @Description
 * @Author xjx
 * @Date 2021-02-01
 */
@Data
public class EmployeeEvaluationVO extends EmployeeEvaluation {
    private String workID;
    private String name;
}
