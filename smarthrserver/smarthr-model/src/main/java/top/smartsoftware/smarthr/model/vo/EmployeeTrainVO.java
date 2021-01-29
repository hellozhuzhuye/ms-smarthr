package top.smartsoftware.smarthr.model.vo;

import lombok.Data;
import top.smartsoftware.smarthr.model.EmployeeTrain;

/**
 * @Description
 * @Author xjx
 * @Date 2021-01-28
 */
@Data
public class EmployeeTrainVO extends EmployeeTrain {
    private String workID;
    private String name;

}
