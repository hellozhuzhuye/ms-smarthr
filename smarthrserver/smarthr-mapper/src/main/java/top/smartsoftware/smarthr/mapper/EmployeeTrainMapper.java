package top.smartsoftware.smarthr.mapper;

import top.smartsoftware.smarthr.model.EmployeeTrain;
import top.smartsoftware.smarthr.model.vo.EmployeeTrainVO;

import java.util.List;

public interface EmployeeTrainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeTrain record);

    int insertSelective(EmployeeTrain record);

    EmployeeTrain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmployeeTrain record);

    int updateByPrimaryKey(EmployeeTrain record);

    List<EmployeeTrainVO> getAllEmpTrain(String name);
}