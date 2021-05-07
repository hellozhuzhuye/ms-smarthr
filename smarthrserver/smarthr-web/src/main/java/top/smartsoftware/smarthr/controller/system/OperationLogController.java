package top.smartsoftware.smarthr.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import top.smartsoftware.smarthr.model.Hr;
import top.smartsoftware.smarthr.model.OperationLog;
import top.smartsoftware.smarthr.model.OperationLogBO;
import top.smartsoftware.smarthr.model.RespBean;
import top.smartsoftware.smarthr.service.OperationLogService;

import java.util.Date;

/**
 * @Description
 * @Author xjx
 * @Date 2021-04-28
 */
@RestController
@RequestMapping("/system/log")
public class OperationLogController {
    @Autowired
    OperationLogService operationLogService;

    @GetMapping("/")
    public RespBean getAllLog(Integer pageNum, Integer pageSize, OperationLogBO operationLogBO){
        return RespBean.ok(operationLogService.getAllLog(pageNum,pageSize,operationLogBO));
    }

    @PostMapping("/")
    public RespBean insertLog(@RequestBody OperationLog operationLog){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Hr hr = (Hr) authentication.getPrincipal();
        operationLog.setHrid(hr.getId());
        operationLog.setAddDate(new Date());
        operationLogService.insertLog(operationLog);
        return RespBean.ok();
    }

}
