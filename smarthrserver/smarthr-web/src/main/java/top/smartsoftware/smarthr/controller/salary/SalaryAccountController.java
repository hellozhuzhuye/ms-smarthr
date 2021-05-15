package top.smartsoftware.smarthr.controller.salary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.smartsoftware.smarthr.model.RespBean;
import top.smartsoftware.smarthr.model.vo.EmpAccountVO;
import top.smartsoftware.smarthr.service.SalaryAccountService;

/**
 * @Description
 * @Author xjx
 * @Date 2021-05-07
 */
@RestController
@RequestMapping("/salary/search")
public class SalaryAccountController {
    @Autowired
    SalaryAccountService salaryAccountService;

    @GetMapping("/")
    public RespBean getSalaryAccount(Integer pageNum, Integer pageSize, EmpAccountVO empAccountVO){
        return RespBean.ok(salaryAccountService.getSalaryAccount(pageNum,pageSize,empAccountVO));
    }

    @GetMapping("/{id}")
    public RespBean getAccountDetail(@PathVariable String id){
        return RespBean.ok(salaryAccountService.getAccountDetail(Integer.valueOf(id)));
    }

    @PostMapping("/insertAccount")
    public RespBean insertAccount(Integer eid){
        return RespBean.ok(salaryAccountService.insertAccount(eid));
    }

}
