package top.smartsoftware.smarthr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.smartsoftware.smarthr.model.Hr;
import top.smartsoftware.smarthr.model.RespBean;
import top.smartsoftware.smarthr.service.HrService;

import java.io.IOException;
import java.util.Map;

/**
 * @Description
 * @Author xjx
 * @Date 2020-12-15
 */
@RestController
public class HrInfoController {

    @Autowired
    HrService hrService;

    @Value("${fastdfs.nginx.host}")
    String nginxHost;

    @GetMapping("/hr/info")
    public Hr getCurrentHr(Authentication authentication) {
        return ((Hr) authentication.getPrincipal());
    }

    @PutMapping("/hr/info")
    public RespBean updateHr(@RequestBody Hr hr, Authentication authentication) {
        if (hrService.updateHr(hr) == 1) {
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(hr, authentication.getCredentials(), authentication.getAuthorities()));
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @PutMapping("/hr/pass")
    public RespBean updateHrPasswd(@RequestBody Map<String, Object> info) {
        String oldpass = (String) info.get("oldpass");
        String pass = (String) info.get("pass");
        Integer hrid = (Integer) info.get("hrid");
        if (hrService.updateHrPasswd(oldpass, pass, hrid)) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }


    @PostMapping("/hr/userface")
    public RespBean updateHrUserface(MultipartFile file, Integer id, Authentication authentication) throws IOException {
        String url = hrService.updateUserface(file, id, authentication);
        if (url!=null && url!="") {
            return RespBean.ok("更新成功!", url);
        }
        return RespBean.error("更新失败!");
    }
}