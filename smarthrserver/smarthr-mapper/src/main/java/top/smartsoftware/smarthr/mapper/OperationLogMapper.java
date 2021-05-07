package top.smartsoftware.smarthr.mapper;

import top.smartsoftware.smarthr.model.OperationLog;
import top.smartsoftware.smarthr.model.OperationLogBO;
import top.smartsoftware.smarthr.model.vo.OperationLogVO;

import java.util.List;

public interface OperationLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OperationLog record);

    int insertSelective(OperationLog record);

    OperationLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OperationLog record);

    int updateByPrimaryKey(OperationLog record);

    List<OperationLogVO> getAllLog(OperationLogBO operationLogBO);
}