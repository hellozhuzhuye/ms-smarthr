package top.smartsoftware.smarthr.controller.system.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.smartsoftware.smarthr.model.EcRule;
import top.smartsoftware.smarthr.model.JobLevel;
import top.smartsoftware.smarthr.model.RespBean;
import top.smartsoftware.smarthr.service.EcRuleService;
import top.smartsoftware.smarthr.service.OperationLogService;

import java.util.List;

/**
 * @Description
 * @Author xjx
 * @Date 2021-01-13
 */

@RestController
@RequestMapping("/system/basic/ecrule")
public class EcRuleController {
    @Autowired
    EcRuleService ecRuleService;

    @GetMapping("/")
    public List<EcRule> getAllEcRules() {
        return ecRuleService.getAllEcRules();
    }

    @PostMapping("/")
    public RespBean addEcRule(@RequestBody EcRule ecRule) {
        if (ecRuleService.addEcRule(ecRule) == 1) {
            OperationLogService.insertInsertLog("员工奖惩:"+ecRule.getEcReason());
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteEcRuleById(@PathVariable Integer id) {
        if (ecRuleService.deleteEcRuleById(id) == 1) {
            OperationLogService.insertDeleteLog("员工奖惩:"+id);
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PutMapping("/")
    public RespBean updateEcRuleById(@RequestBody EcRule ecRule) {
        if (ecRuleService.updateEcRuleById(ecRule) == 1) {
            OperationLogService.insertUpdateLog("员工奖惩:"+ecRule.getEcReason());
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @DeleteMapping("/")
    public RespBean deleteEcRulesByIds(Integer[] ids) {
        if (ecRuleService.deleteEcRulesByIds(ids) == ids.length) {
            OperationLogService.insertDeleteLog("员工奖惩:"+ids);
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

}
