package top.smartsoftware.smarthr.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.smartsoftware.smarthr.model.RespBean;

/**
 * @Description
 * @Author xjx
 * @Date 2020-11-16
 */

@RestController
public class LoginController {
    @GetMapping("/login")
    public RespBean login(){
        return RespBean.error("尚未登录，请登录！");
    }
}
