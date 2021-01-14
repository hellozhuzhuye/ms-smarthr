package top.smartsoftware.smarthr.service;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.smartsoftware.smarthr.mapper.AttendanceMapper;
import top.smartsoftware.smarthr.model.Attendance;
import top.smartsoftware.smarthr.model.Employee;
import top.smartsoftware.smarthr.model.RespBean;
import top.smartsoftware.smarthr.model.vo.AttendanceVO;
import top.smartsoftware.smarthr.utils.DateTimeUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author xjx
 * @Date 2021-01-12
 */
@Service
public class AttendanceService {
    @Autowired
    AttendanceMapper attendanceMapper;


    public PageInfo getAttendanceListByPage(Integer page, Integer size, Employee employee, Date[] beginDateScope) {
        PageHelper.startPage(page,size);
        List<AttendanceVO> list=attendanceMapper.getAttendanceListByPage(employee,beginDateScope);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    public PageInfo getWeekAttendance(Integer page, Integer size, Employee employee) {
        Map<String, Date> weekDate = DateTimeUtil.getWeekDate(new Date());
        Date[] beginDateScope={weekDate.get("start"),weekDate.get("end")};
        PageHelper.startPage(page,size);
        List<AttendanceVO> list = attendanceMapper.getCountAttendance(employee, beginDateScope);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }



    public PageInfo getMonthAttendance(Integer page, Integer size, Employee employee) {
        Map<String, Date> monthDate = DateTimeUtil.getMonthDate(new Date());
        Date[] beginDateScope={monthDate.get("start"),monthDate.get("end")};
        PageHelper.startPage(page,size);
        List<AttendanceVO> list=attendanceMapper.getCountAttendance(employee,beginDateScope);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    public String getCurrentWeek() {
        Map<String, String> weekDate = DateTimeUtil.getWeekDateFormat(new Date());
        return weekDate.get("start")+"~"+weekDate.get("end");
    }

    public String getCurrentMonth() {
        Map<String, Date> weekDate = DateTimeUtil.getMonthDate(new Date());
        return DateTimeUtil.format(weekDate.get("start"),"yyyy-MM-dd")+"~"+DateTimeUtil.format(weekDate.get("end"),"yyyy-MM-dd");
    }
}
