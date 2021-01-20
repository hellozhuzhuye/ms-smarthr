package top.smartsoftware.smarthr.service;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.smartsoftware.smarthr.mapper.EcRuleMapper;
import top.smartsoftware.smarthr.mapper.EmployeePointMapper;
import top.smartsoftware.smarthr.mapper.EmployeeecMapper;
import top.smartsoftware.smarthr.model.EcRule;
import top.smartsoftware.smarthr.model.Employee;
import top.smartsoftware.smarthr.model.EmployeePoint;
import top.smartsoftware.smarthr.model.Employeeec;
import top.smartsoftware.smarthr.model.vo.EmpEcVO;
import top.smartsoftware.smarthr.utils.DateTimeUtil;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author xjx
 * @Date 2021-01-15
 */
@Service
public class EmpEcService {
    @Autowired
    EmployeeecMapper employeeecMapper;

    @Autowired
    EcRuleMapper ecRuleMapper;

    @Autowired
    EmployeePointMapper employeePointMapper;

    public List<EmpEcVO> getAllEmpEcs(Employee employee, Date[] beginDateScope) {
        return employeeecMapper.getAllEmpEcs(employee,beginDateScope);
    }

    public int addEmpEc(Employeeec employeeec) {
        employeeec.setId(0);
        EcRule ecRule = ecRuleMapper.selectById(employeeec.getEcid());
        QueryWrapper<EmployeePoint> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("eid",employeeec.getEid());
        EmployeePoint employeePoint = employeePointMapper.selectOne(queryWrapper);
        if (employeePoint==null){
            EmployeePoint insertEmpPoint=new EmployeePoint();
            insertEmpPoint.setEid(employeeec.getEid());
            insertEmpPoint.setPoint(0);
            employeePointMapper.insert(insertEmpPoint);
        }
        employeeec.setBeforePoint(employeePoint.getPoint());
        Integer afterPoint = employeePoint.getPoint()+ecRule.getEcPoint();
        employeeec.setAfterPoint(afterPoint);
        employeePoint.setPoint(afterPoint);
        employeeec.setEcDate(DateTimeUtil.getDate());
        employeePointMapper.updateById(employeePoint);
        return employeeecMapper.insert(employeeec);
    }

    public int deleteEmpEcById(Integer id) {
        return employeeecMapper.deleteById(id);
    }

    public int updateEmpEcById(Employeeec employeeec) {
        return employeeecMapper.updateById(employeeec);
    }

    public int deleteEmpEcsByIds(Integer[] ids) {
        return employeeecMapper.deleteBatchIds(Arrays.asList(ids));
    }
}
