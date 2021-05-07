package top.smartsoftware.smarthr.controller.emp;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.smartsoftware.smarthr.model.OperationLog;
import top.smartsoftware.smarthr.model.RespBean;
import top.smartsoftware.smarthr.model.entity.EmployeeSenior;
import top.smartsoftware.smarthr.service.EmpSeniorService;
import top.smartsoftware.smarthr.service.OperationLogService;

/**
 * @Description
 * @Author xjx
 * @Date 2021-04-18
 */
@RestController
@RequestMapping("/employee/advanced")
public class EmpSeniorController {
    @Autowired
    EmpSeniorService empSeniorService;


    @GetMapping("/getEmpSeniorByPage")
    public PageInfo getEmpSeniorByPage(Integer pageNum, Integer pageSize) {
        return empSeniorService.getEmpSeniorByPage(pageNum, pageSize);
    }

    @PostMapping("/addEmpSenior")
    public RespBean addEmpSenior(@RequestBody EmployeeSenior employeeSenior) {
        empSeniorService.addEmpSenior(employeeSenior);
        OperationLogService.insertLog(new OperationLog("添加了员工高级资料，id为："+employeeSenior.getId(),0));
        return RespBean.ok("添加成功");
    }

    @GetMapping("/getEmpSeniorDetail")
    public EmployeeSenior getEmpSeniorDetail(Integer id) {
        return empSeniorService.getEmpSeniorDetail(id);
    }

    @PostMapping("/idCardOcr")
    public String idCardOcr(String url) {
        return empSeniorService.idCardOcr(url);

    }

    @PostMapping("/bankCardOcr")
    public String bankCardOcr(String url) {
        return empSeniorService.bankCardOcr(url);
    }

    @DeleteMapping("/{id}")
    public RespBean delEmpSenior(@PathVariable String id) {
        empSeniorService.delEmpSenior(id);
        OperationLogService.insertLog(new OperationLog("删除了员工高级资料，id为："+id,1));
        return RespBean.ok("删除成功");
    }
}
