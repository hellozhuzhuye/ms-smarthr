package top.smartsoftware.smarthr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.smartsoftware.smarthr.mapper.WorkFlowStatusMapper;
import top.smartsoftware.smarthr.model.entity.WorkFlowStatus;
import top.smartsoftware.smarthr.model.vo.ApproveVO;
import top.smartsoftware.smarthr.model.vo.MyApplyDetailVO;

import java.util.List;

/**
 * @Description
 * @Author xjx
 * @Date 2021-02-04
 */
@Service
public class WorkFlowStatusService {
    @Autowired
    WorkFlowStatusMapper workFlowStatusMapper;


    public List<MyApplyDetailVO> getDetailApply(Integer wfid) {
        return workFlowStatusMapper.getDetailApply(wfid);
    }

    public List<ApproveVO> getApprove(Integer id) {
        return workFlowStatusMapper.getApprove(id);
    }

    public Integer processApproval(Integer id, Integer status,String content) {
        WorkFlowStatus workFlowStatus = workFlowStatusMapper.selectById(id);
        workFlowStatus.setStatus(status);
        workFlowStatus.setContent(content);
        return workFlowStatusMapper.updateById(workFlowStatus);
    }
}
