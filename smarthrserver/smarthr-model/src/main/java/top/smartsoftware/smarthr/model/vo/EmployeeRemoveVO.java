package top.smartsoftware.smarthr.model.vo;

import lombok.Data;
import top.smartsoftware.smarthr.model.EmployeeRemove;

/**
 * @Description
 * @Author xjx
 * @Date 2021-02-01
 */
@Data
public class EmployeeRemoveVO extends EmployeeRemove {
    private String workID;
    private String ename;
    private String dbeforename;
    private String pbeforename;
    private String daftername;
    private String paftername;

}
