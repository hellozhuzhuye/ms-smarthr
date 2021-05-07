package top.smartsoftware.smarthr.controller.system.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.smartsoftware.smarthr.service.DepartmentService;
import top.smartsoftware.smarthr.model.Department;
import top.smartsoftware.smarthr.model.RespBean;
import top.smartsoftware.smarthr.service.OperationLogService;

import java.util.List;

/**
 * @Description
 * @Author xjx
 * @Date 2020-11-29
 */
@RestController
@RequestMapping("/system/basic/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    public RespBean getAllDepartments() {
        return RespBean.ok(departmentService.getAllDepartments());
    }

    @PostMapping("/")
    public RespBean addDep(@RequestBody Department dep) {
        departmentService.addDep(dep);
        if (dep.getResult() == 1) {
            OperationLogService.insertInsertLog("部门:"+dep.getName());
            return RespBean.ok("添加成功", dep);
        }
        return RespBean.error("添加失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteDepById(@PathVariable Integer id) {
        Department dep = new Department();
        dep.setId(id);
        departmentService.deleteDepById(dep);
        if (dep.getResult() == -2) {
            return RespBean.error("该部门下有子部门，删除失败");
        } else if (dep.getResult() == -1) {
            return RespBean.error("该部门下有员工，删除失败");
        } else if (dep.getResult() == 1) {
            OperationLogService.insertDeleteLog("部门:"+id);
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
