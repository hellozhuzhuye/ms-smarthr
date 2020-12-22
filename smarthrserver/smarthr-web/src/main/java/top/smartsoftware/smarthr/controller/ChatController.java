package top.smartsoftware.smarthr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.smartsoftware.smarthr.model.Hr;
import top.smartsoftware.smarthr.service.HrService;

import java.util.List;

/**
 * @Description
 * @Author xjx
 * @Date 2020-12-13
 */
@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    HrService hrService;
    @GetMapping("/hrs")
    public List<Hr> getAllHrs() {
        return hrService.getAllHrsExceptCurrentHr();
    }
}
