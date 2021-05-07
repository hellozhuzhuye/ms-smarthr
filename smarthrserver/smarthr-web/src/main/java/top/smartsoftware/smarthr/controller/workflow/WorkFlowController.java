package top.smartsoftware.smarthr.controller.workflow;

import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import top.smartsoftware.smarthr.model.Employeeec;
import top.smartsoftware.smarthr.model.Hr;
import top.smartsoftware.smarthr.model.RespBean;
import top.smartsoftware.smarthr.model.entity.WorkFlow;
import top.smartsoftware.smarthr.model.entity.WorkFlowStatus;
import top.smartsoftware.smarthr.model.vo.ApproveVO;
import top.smartsoftware.smarthr.model.vo.MyApplyDetailVO;
import top.smartsoftware.smarthr.model.vo.MyApplyVO;
import top.smartsoftware.smarthr.service.OperationLogService;
import top.smartsoftware.smarthr.service.WorkFlowService;
import top.smartsoftware.smarthr.service.WorkFlowStatusService;

import java.text.ParseException;
import java.util.List;

/**
 * @Description
 * @Author xjx
 * @Date 2021-02-03
 */
@RestController
@RequestMapping("/workflow")
public class WorkFlowController {

    @Autowired
    WorkFlowService workFlowService;
    @Autowired
    WorkFlowStatusService workFlowStatusService;


    @PostMapping("/apply/")
    public RespBean addWorkFlow(@RequestBody WorkFlow workFlow, Authentication authentication) throws ParseException {
        Hr hr = (Hr) authentication.getPrincipal();
        workFlow.setEid(hr.getId());
        if (workFlowService.addWorkFlow(workFlow) == 1) {
            OperationLogService.insertInsertLog("流程申请:"+workFlow.getContent());
            return RespBean.ok("申请成功!");
        }
        return RespBean.error("申请失败!");
    }

    @GetMapping("/my/")
    public List<MyApplyVO> getMyApply(Authentication authentication) {
        Hr hr = (Hr) authentication.getPrincipal();
        return workFlowService.getMyApply(hr.getId());
    }

    @GetMapping("/detail/{wfid}")
    public List<MyApplyDetailVO> getDetailApply(@PathVariable Integer wfid) {
        return workFlowStatusService.getDetailApply(wfid);
    }

    @GetMapping("/approve/")
    public List<ApproveVO> getApprove(Authentication authentication) {
        Hr hr = (Hr) authentication.getPrincipal();
        return workFlowStatusService.getApprove(hr.getId());
    }

    @GetMapping("/processApproval")
    public RespBean processApproval(Integer id,Integer status,String content) {
        if (workFlowStatusService.processApproval(id,status,content)==1){
            OperationLogService.insertInsertLog("流程审批:"+content);
            return RespBean.ok();
        }
        return RespBean.error("审批失败");
    }


}
