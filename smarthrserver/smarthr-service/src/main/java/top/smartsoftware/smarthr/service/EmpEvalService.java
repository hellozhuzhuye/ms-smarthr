package top.smartsoftware.smarthr.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.smartsoftware.smarthr.mapper.EmployeeEvaluationMapper;
import top.smartsoftware.smarthr.model.Employeeec;
import top.smartsoftware.smarthr.model.entity.EmployeeEvaluation;
import top.smartsoftware.smarthr.model.vo.EmployeeEvaluationVO;
import top.smartsoftware.smarthr.model.vo.EmployeeRemoveVO;

import java.util.List;

/**
 * @Description
 * @Author xjx
 * @Date 2021-02-01
 */
@Service
public class EmpEvalService {

    @Autowired
    EmployeeEvaluationMapper employeeEvaluationMapper;

    public PageInfo<EmployeeEvaluationVO> getAllEmpEval(Integer page, Integer size, String name) {
        PageHelper.startPage(page, size);
        List<EmployeeEvaluationVO> list = employeeEvaluationMapper.getAllEmpEval(name);
        PageInfo<EmployeeEvaluationVO> pageInfo = new PageInfo<EmployeeEvaluationVO>(list);
        return pageInfo;
    }


    public int addEmpEval(EmployeeEvaluation employeeEvaluation) {
        return employeeEvaluationMapper.insert(employeeEvaluation);
    }

    public int deleteEmpEvalById(Integer id) {
        return employeeEvaluationMapper.deleteById(id);
    }

    public int updateEmpEvalById(EmployeeEvaluation employeeEvaluation) {
        return employeeEvaluationMapper.updateById(employeeEvaluation);
    }
}
