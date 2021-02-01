package top.smartsoftware.smarthr.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.smartsoftware.smarthr.mapper.EmployeeRemoveMapper;
import top.smartsoftware.smarthr.model.EmployeeRemove;
import top.smartsoftware.smarthr.model.vo.EmployeeRemoveVO;

import java.util.List;

/**
 * @Description
 * @Author xjx
 * @Date 2021-02-01
 */
@Service
public class EmpRemoveService {
    @Autowired
    EmployeeRemoveMapper employeeRemoveMapper;


    public PageInfo<EmployeeRemoveVO> getAllEmpRemove(Integer page, Integer size ,String name) {
        PageHelper.startPage(page,size);
        List<EmployeeRemoveVO> list = employeeRemoveMapper.getAllEmpRemove(name);
        PageInfo<EmployeeRemoveVO> pageInfo = new PageInfo<EmployeeRemoveVO>(list);
        return pageInfo;
    }

    public int updateEmpRemove(EmployeeRemove employeeRemove) {
        return employeeRemoveMapper.updateById(employeeRemove);
    }
}
