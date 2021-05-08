package top.smartsoftware.smarthr.controller.salary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
