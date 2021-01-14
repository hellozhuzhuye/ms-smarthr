package top.smartsoftware.smarthr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import top.smartsoftware.smarthr.model.Attendance;
import top.smartsoftware.smarthr.model.Employee;
import top.smartsoftware.smarthr.model.vo.AttendanceVO;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author xjx
 * @Date 2021-01-12
 */
public interface AttendanceMapper extends BaseMapper<Attendance>{
    List<AttendanceVO> getAttendanceListByPage(@Param("employee") Employee employee, @Param("beginDateScope") Date[] beginDateScope);


    List<AttendanceVO> getCountAttendance(@Param("employee")Employee employee, @Param("beginDateScope")Date[] beginDateScope);


}
