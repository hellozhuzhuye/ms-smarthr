package top.smartsoftware.smarthr.controller.salary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.smartsoftware.smarthr.model.RespBean;
import top.smartsoftware.smarthr.model.RespPageBean;
import top.smartsoftware.smarthr.model.Salary;
import top.smartsoftware.smarthr.service.EmployeeService;
import top.smartsoftware.smarthr.service.OperationLogService;
import top.smartsoftware.smarthr.service.SalaryService;

import java.util.List;

/**
 * @Description
 * @Author xjx
 * @Date 2020-12-10
 */
@RestController
@RequestMapping("/salary/sobcfg")
public class SobConfigController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public RespPageBean getEmployeeByPageWithSalary(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size,String name) {
        return employeeService.getEmployeeByPageWithSalary(page, size,name);
    }

    @GetMapping("/salaries")
    public List<Salary> getAllSalaries() {
        return salaryService.getAllSalaries();
    }

    @PutMapping("/")
    public RespBean updateEmployeeSalaryById(Integer eid, Integer sid) {
        Integer result = employeeService.updateEmployeeSalaryById(eid, sid);
        if (result == 1 || result == 2) {
            OperationLogService.insertUpdateLog("员工账套:"+eid+","+sid);
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }
}

