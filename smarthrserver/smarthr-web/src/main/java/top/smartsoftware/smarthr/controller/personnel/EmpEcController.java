package top.smartsoftware.smarthr.controller.personnel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.smartsoftware.smarthr.model.Employee;
import top.smartsoftware.smarthr.model.Employeeec;
import top.smartsoftware.smarthr.model.RespBean;
import top.smartsoftware.smarthr.model.vo.EmpEcVO;
import top.smartsoftware.smarthr.service.EmpEcService;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author xjx
 * @Date 2021-01-15
 */

@RestController
@RequestMapping("/personnel/ec")
public class EmpEcController {
    @Autowired
    EmpEcService empEcService;

    @GetMapping("/")
    public List<EmpEcVO> getAllEmpEcs(Employee employee, Date[] beginDateScope) {
        return empEcService.getAllEmpEcs(employee,beginDateScope);
    }

    @PostMapping("/")
    public RespBean addEmpEc(@RequestBody Employeeec employeeec) {

        if (empEcService.addEmpEc(employeeec) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteEmpEcById(@PathVariable Integer id) {
        if (empEcService.deleteEmpEcById(id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PutMapping("/")
    public RespBean updateEmpEcById(@RequestBody Employeeec employeeec) {
        if (empEcService.updateEmpEcById(employeeec) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @DeleteMapping("/")
    public RespBean deleteEmpEcsByIds(Integer[] ids) {
        if (empEcService.deleteEmpEcsByIds(ids) == ids.length) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

}
