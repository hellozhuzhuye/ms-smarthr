package top.smartsoftware.smarthr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import top.smartsoftware.smarthr.model.Employee;
import top.smartsoftware.smarthr.model.Employeeec;
import top.smartsoftware.smarthr.model.vo.EmpEcVO;

import java.util.Date;
import java.util.List;

public interface EmployeeecMapper extends BaseMapper<Employeeec> {

    List<EmpEcVO> getAllEmpEcs(@Param("employee") Employee employee, @Param("beginDateScope") Date[] beginDateScope);


}