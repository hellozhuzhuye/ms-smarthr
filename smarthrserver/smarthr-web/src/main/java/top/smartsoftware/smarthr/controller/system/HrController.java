package top.smartsoftware.smarthr.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.smartsoftware.smarthr.service.HrService;
import top.smartsoftware.smarthr.service.OperationLogService;
import top.smartsoftware.smarthr.service.RoleService;
import top.smartsoftware.smarthr.model.Hr;
import top.smartsoftware.smarthr.model.RespBean;
import top.smartsoftware.smarthr.model.Role;

import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author xjx
 * @Date 2020-11-29
 */
@RestController
@RequestMapping("/system/hr")
public class HrController {
    @Autowired
    HrService hrService;
    @Autowired
    RoleService roleService;
    @GetMapping("/")
    public List<Hr> getAllHrs(String keywords) {
        return hrService.getAllHrs(keywords);
    }

    @PutMapping("/")
    public RespBean updateHr(@RequestBody Hr hr) {
        if (hrService.updateHr(hr) == 1) {
            OperationLogService.insertUpdateLog("hr信息:"+ hr.getName());
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PutMapping("/role")
    public RespBean updateHrRole(Integer hrid, Integer[] rids) {
        if (hrService.updateHrRole(hrid, rids)) {
            OperationLogService.insertUpdateLog("hr角色关联:"+hrid+";"+ Arrays.toString(rids));
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteHrById(@PathVariable Integer id) {
        if (hrService.deleteHrById(id) == 1) {
            OperationLogService.insertDeleteLog("hr角色关联:"+id);
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
}

