package top.smartsoftware.smarthr.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.smartsoftware.smarthr.mapper.EmployeeTrainMapper;
import top.smartsoftware.smarthr.model.EmployeeTrain;
import top.smartsoftware.smarthr.model.vo.EmployeeTrainVO;

import java.util.List;

/**
 * @Description
 * @Author xjx
 * @Date 2021-01-28
 */
@Service
public class EmpTrainService {
    @Autowired
    EmployeeTrainMapper employeeTrainMapper;


    public PageInfo<EmployeeTrainVO> getAllEmpTrain(Integer page,Integer size,String name) {
        PageHelper.startPage(page,size);
        return new PageInfo<EmployeeTrainVO>(employeeTrainMapper.getAllEmpTrain(name));
    }

    public int addEmpTrain(EmployeeTrain employeeTrain) {
        return employeeTrainMapper.insert(employeeTrain);
    }



    public int deleteEmpTrainByEid(Integer id) {
        return employeeTrainMapper.deleteByPrimaryKey(id);
    }

    public int updateEmpTrain(EmployeeTrain employeeTrain) {
        return employeeTrainMapper.updateByPrimaryKeySelective(employeeTrain);
    }
}
