package top.smartsoftware.smarthr.controller.personnel;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.smartsoftware.smarthr.model.RespBean;
import top.smartsoftware.smarthr.model.entity.EmployeeEvaluation;
import top.smartsoftware.smarthr.model.vo.EmployeeEvaluationVO;
import top.smartsoftware.smarthr.service.EmpEvalService;
import top.smartsoftware.smarthr.service.OperationLogService;

/**
 * @Description
 * @Author xjx
 * @Date 2021-02-01
 */
@RestController
@RequestMapping("/personnel/eval")
public class EmpEvalController {
    @Autowired
    EmpEvalService empEvalService;

    @GetMapping("/")
    public PageInfo<EmployeeEvaluationVO> getAllEmpEval(@RequestParam(defaultValue = "1") Integer page,
                                                        @RequestParam(defaultValue = "10") Integer size,
                                                        String name){
        return empEvalService.getAllEmpEval(page,size,name);
    }

    @PostMapping("/")
    public RespBean addEmpEval(@RequestBody EmployeeEvaluation employeeEvaluation) {

        if (empEvalService.addEmpEval(employeeEvaluation) == 1) {
            OperationLogService.insertInsertLog("员工考评："+employeeEvaluation.getContent());
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteEmpEvalById(@PathVariable Integer id) {
        if (empEvalService.deleteEmpEvalById(id) == 1) {
            OperationLogService.insertDeleteLog("员工考评,id为："+id);
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PutMapping("/")
    public RespBean updateEmpEvalById(@RequestBody EmployeeEvaluation employeeEvaluation) {
        if (empEvalService.updateEmpEvalById(employeeEvaluation) == 1) {
            OperationLogService.insertDeleteLog("员工考评,id为："+employeeEvaluation.getId());
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }






}
