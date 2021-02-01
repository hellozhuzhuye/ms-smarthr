package top.smartsoftware.smarthr.controller.personnel;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.smartsoftware.smarthr.model.EmployeeRemove;
import top.smartsoftware.smarthr.model.EmployeeTrain;
import top.smartsoftware.smarthr.model.RespBean;
import top.smartsoftware.smarthr.model.vo.EmployeeRemoveVO;
import top.smartsoftware.smarthr.service.EmpRemoveService;

import java.util.List;

/**
 * @Description
 * @Author xjx
 * @Date 2021-02-01
 */
@RestController
@RequestMapping("/personnel/remove")
public class EmpRemoveController {

    @Autowired
    EmpRemoveService empRemoveService;

    @GetMapping("/")
    public PageInfo<EmployeeRemoveVO> getAllEmpRemove(@RequestParam(defaultValue = "1") Integer page,
                                                      @RequestParam(defaultValue = "10") Integer size,
                                                      String name){
        return empRemoveService.getAllEmpRemove(page,size,name);
    }

    @PutMapping("/")
    public RespBean updateEmpRemove(@RequestBody EmployeeRemove employeeRemove) {
        if (empRemoveService.updateEmpRemove(employeeRemove) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
}
