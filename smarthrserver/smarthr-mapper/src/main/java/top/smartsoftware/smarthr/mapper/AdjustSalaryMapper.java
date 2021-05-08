package top.smartsoftware.smarthr.mapper;

import top.smartsoftware.smarthr.model.AdjustSalary;
import top.smartsoftware.smarthr.model.vo.AdjustSalaryVO;

import java.util.List;

public interface AdjustSalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdjustSalary record);

    int insertSelective(AdjustSalary record);

    AdjustSalary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdjustSalary record);

    int updateByPrimaryKey(AdjustSalary record);

    List<AdjustSalaryVO> getSalaryAccount(AdjustSalaryVO adjustSalaryVO);
}