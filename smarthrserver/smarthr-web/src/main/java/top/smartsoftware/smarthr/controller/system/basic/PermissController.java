package top.smartsoftware.smarthr.controller.system.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.smartsoftware.smarthr.service.MenuService;
import top.smartsoftware.smarthr.service.OperationLogService;
import top.smartsoftware.smarthr.service.RoleService;
import top.smartsoftware.smarthr.model.Menu;
import top.smartsoftware.smarthr.model.RespBean;
import top.smartsoftware.smarthr.model.Role;

import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author xjx
 * @Date 2020-11-28
 */
@RestController
@RequestMapping("/system/basic/permiss")
public class PermissController {
    @Autowired
    RoleService roleService;
    @Autowired
    MenuService menuService;
    @GetMapping("/")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }
    @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("/mids/{rid}")
    public List<Integer> getMidsByRid(@PathVariable Integer rid) {
        return menuService.getMidsByRid(rid);
    }

    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        if (menuService.updateMenuRole(rid, mids)) {
            OperationLogService.insertUpdateLog("菜单角色关联:"+rid+";"+ Arrays.toString(mids));
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role) {
        if (roleService.addRole(role) == 1) {
            OperationLogService.insertInsertLog("角色:"+role.getName());
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/role/{rid}")
    public RespBean deleteRoleById(@PathVariable Integer rid) {
        if (roleService.deleteRoleById(rid) == 1) {
            OperationLogService.insertDeleteLog("角色:"+rid);
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
}
