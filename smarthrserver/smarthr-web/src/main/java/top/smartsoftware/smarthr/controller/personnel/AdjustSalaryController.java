package top.smartsoftware.smarthr.controller.personnel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.smartsoftware.smarthr.model.RespBean;
import top.smartsoftware.smarthr.model.vo.AdjustSalaryVO;
import top.smartsoftware.smarthr.service.AdjustSalaryService;

/**
 * @Description
 * @Author xjx
 * @Date 2021-05-07
 */
@RestController
@RequestMapping("/personnel/salary")
public class AdjustSalaryController {
    @Autowired
    AdjustSalaryService adjustSalaryService;

    @GetMapping("/")
    public RespBean getAdjustSalary(Integer pageNum, Integer pageSize, AdjustSalaryVO adjustSalaryVO){
        return RespBean.ok(adjustSalaryService.getAdjustSalary(pageNum,pageSize,adjustSalaryVO));
    }
}
