package top.smartsoftware.smarthr.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import top.smartsoftware.smarthr.mapper.OperationLogMapper;
import top.smartsoftware.smarthr.model.Hr;
import top.smartsoftware.smarthr.model.OperationLog;
import top.smartsoftware.smarthr.model.OperationLogBO;
import top.smartsoftware.smarthr.model.vo.OperationLogVO;

import javax.annotation.PostConstruct;

/**
 * @Description
 * @Author xjx
 * @Date 2021-04-28
 */
@Service
public class OperationLogService {
    @Autowired
    OperationLogMapper operationLogMapper;

    public static OperationLogService staticMapper;

    @PostConstruct
    public void init() {
        staticMapper = this;
        staticMapper.operationLogMapper = this.operationLogMapper;
    }

    public PageInfo<OperationLogVO> getAllLog(Integer pageNum, Integer pageSize, OperationLogBO operationLogBO) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<OperationLogVO>(operationLogMapper.getAllLog(operationLogBO));
    }

    public static void insertLog(OperationLog operationLog) {
        staticMapper.operationLogMapper.insertSelective(operationLog);
    }

    public static void insertUpdateLog(String operate) {
        OperationLog operationLog = new OperationLog("修改了"+operate, 2);
        staticMapper.operationLogMapper.insertSelective(operationLog);
    }

    public static void insertInsertLog(String operate) {
        OperationLog operationLog = new OperationLog("添加了"+operate, 0);
        staticMapper.operationLogMapper.insertSelective(operationLog);
    }

    public static void insertDeleteLog(String operate) {
        OperationLog operationLog = new OperationLog("删除了"+operate, 1);
        staticMapper.operationLogMapper.insertSelective(operationLog);
    }

}
