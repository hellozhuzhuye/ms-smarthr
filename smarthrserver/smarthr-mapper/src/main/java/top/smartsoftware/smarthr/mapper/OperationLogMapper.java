package top.smartsoftware.smarthr.mapper;

import top.smartsoftware.smarthr.model.OperationLog;

public interface OperationLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OperationLog record);

    int insertSelective(OperationLog record);

    OperationLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OperationLog record);

    int updateByPrimaryKey(OperationLog record);
}