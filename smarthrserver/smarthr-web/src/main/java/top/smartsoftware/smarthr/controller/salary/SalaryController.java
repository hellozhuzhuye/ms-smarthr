package top.smartsoftware.smarthr.controller.salary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.smartsoftware.smarthr.model.RespBean;
import top.smartsoftware.smarthr.model.Salary;
import top.smartsoftware.smarthr.service.OperationLogService;
import top.smartsoftware.smarthr.service.SalaryService;

import java.util.List;

/**
 * @Description
 * @Author xjx
 * @Date 2020-12-10
 */
@RestController
@RequestMapping("/salary/sob")
public class SalaryController {
    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public RespBean getAllSalaries() {
        return RespBean.ok(salaryService.getAllSalaries());
    }

    @PostMapping("/")
    public RespBean addSalary(@RequestBody Salary salary) {
        if (salaryService.addSalary(salary) == 1) {
            OperationLogService.insertInsertLog("工资账套:"+salary.getName());
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteSalaryById(@PathVariable Integer id) {
        if (salaryService.deleteSalaryById(id) == 1) {
            OperationLogService.insertDeleteLog("工资账套:"+id);
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PutMapping("/")
    public RespBean updateSalaryById(@RequestBody Salary salary) {
        if (salaryService.updateSalaryById(salary) == 1) {
            OperationLogService.insertUpdateLog("工资账套:"+salary.getName());
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
}
