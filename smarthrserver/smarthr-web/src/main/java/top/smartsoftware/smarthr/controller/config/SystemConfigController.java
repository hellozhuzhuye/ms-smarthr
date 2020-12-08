package top.smartsoftware.smarthr.controller.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.smartsoftware.smarthr.Service.MenuService;
import top.smartsoftware.smarthr.model.Menu;

import java.util.List;

/**
 * @Description
 * @Author xjx
 * @Date 2020-11-19
 */

@RestController
@RequestMapping("/system/config")
public class SystemConfigController {

    @Autowired
    MenuService menuService;

    @GetMapping("/menu")
    public List<Menu> getMenusByHrId(){
        return menuService.getMenusByHrId();

    }
}
