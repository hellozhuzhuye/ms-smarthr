package top.smartsoftware.smarthr.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.smartsoftware.smarthr.mapper.EmployeeAccountMapper;
import top.smartsoftware.smarthr.model.vo.EmpAccountVO;

/**
 * @Description
 * @Author xjx
 * @Date 2021-05-07
 */
@Service
public class SalaryAccountService {
    @Autowired
    EmployeeAccountMapper employeeAccountMapper;


    public PageInfo<EmpAccountVO> getSalaryAccount(Integer pageNum, Integer pageSize,EmpAccountVO empAccountVO) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<EmpAccountVO>(employeeAccountMapper.getSalaryAccount(empAccountVO));
    }
    public EmpAccountVO getAccountDetail(Integer id) {
        return employeeAccountMapper.getAccountDetail(id);
    }


}
