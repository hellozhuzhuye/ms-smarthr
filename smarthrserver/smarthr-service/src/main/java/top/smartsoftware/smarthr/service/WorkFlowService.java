package top.smartsoftware.smarthr.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.smartsoftware.smarthr.mapper.HrMapper;
import top.smartsoftware.smarthr.mapper.WorkFlowStatusMapper;
import top.smartsoftware.smarthr.mapper.WorkFlowTypeMapper;
import top.smartsoftware.smarthr.model.entity.WorkFlow;
import top.smartsoftware.smarthr.mapper.WorkFlowMapper;
import top.smartsoftware.smarthr.model.entity.WorkFlowStatus;
import top.smartsoftware.smarthr.model.vo.MyApplyVO;
import top.smartsoftware.smarthr.utils.DateTimeUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author xjx
 * @Date 2021-02-03
 */
@Service
public class WorkFlowService {
    @Autowired
    WorkFlowMapper workFlowMapper;
    @Autowired
    WorkFlowStatusMapper workFlowStatusMapper;

    @Autowired
    HrMapper hrMapper;
    @Autowired
    WorkFlowTypeMapper workFlowTypeMapper;

    public int addWorkFlow(WorkFlow workFlow) throws ParseException {
        String date = workFlow.getSelectDateTime();
        if (workFlow.getWorkFlowTypeId() == 1 || workFlow.getWorkFlowTypeId() == 5 || workFlow.getWorkFlowTypeId() == 6) {
            date = date.replace("Z", " UTC");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
            Date d = format.parse(date);
            String formatDate = DateTimeUtil.format(d, "yyyy-MM-dd");
            workFlow.setSelectDateTime(formatDate);
            workFlow.setCreateTime(LocalDateTime.now());
        } else {
            String[] split = date.split(",");
            Date start = DateTimeUtil.parse(split[0]);
            Date end = DateTimeUtil.parse(split[1]);
            String startStr = DateTimeUtil.format(start, "yyyy-MM-dd HH:mm:ss");
            String endStr = DateTimeUtil.format(end, "yyyy-MM-dd HH:mm:ss");
            workFlow.setSelectDateTime(startStr + "," + endStr);
        }
        workFlowMapper.insert(workFlow);
        WorkFlowStatus workFlowStatus = new WorkFlowStatus();
        workFlowStatus.setWfid(workFlow.getId());
        String hrids = workFlow.getHrid();
        String[] split = hrids.split(",");
        Arrays.stream(split).forEach(e -> {
            workFlowStatus.setHrid(Integer.valueOf(e));
            workFlowStatusMapper.insert(workFlowStatus);
        });
        return 1;
    }

    public List<MyApplyVO> getMyApply(Integer eid,Integer workFlowTypeId) {
        List<MyApplyVO> myApplyVOS = workFlowMapper.queryMyApply(eid,workFlowTypeId);
        myApplyVOS.forEach(e -> {
            String[] split = e.getHrid().split(",");
            StringBuilder hrNames = new StringBuilder();
            Arrays.stream(split).forEach(s -> hrNames.append(hrMapper.selectByPrimaryKey(Integer.valueOf(s)).getName()).append(" "));
            e.setHrNames(hrNames.toString());
        });
        return myApplyVOS;
    }
}
