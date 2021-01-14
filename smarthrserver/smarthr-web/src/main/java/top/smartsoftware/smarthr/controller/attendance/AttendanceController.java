package top.smartsoftware.smarthr.controller.attendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.smartsoftware.smarthr.model.Employee;
import top.smartsoftware.smarthr.model.RespBean;
import top.smartsoftware.smarthr.service.AttendanceService;

import java.util.Date;

/**
 * @Description
 * @Author xjx
 * @Date 2021-01-12
 */
@RequestMapping("/attendance/empatt")
@RestController
public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;

    @GetMapping("/")
    public RespBean getAttendanceListByPage(@RequestParam(defaultValue = "1") Integer page,
                                            @RequestParam(defaultValue = "10") Integer size,
                                            Employee employee,
                                            Date[] beginDateScope){
        return RespBean.ok(attendanceService.getAttendanceListByPage(page, size, employee,beginDateScope));
    }

    @GetMapping("/week")
    public RespBean getWeekAttendance(@RequestParam(defaultValue = "1") Integer page,
                                      @RequestParam(defaultValue = "10") Integer size,
                                      Employee employee){
        return RespBean.ok(attendanceService.getWeekAttendance(page, size, employee));
    }

    @GetMapping("/month")
    public RespBean getMonthAttendance(@RequestParam(defaultValue = "1") Integer page,
                                      @RequestParam(defaultValue = "10") Integer size,
                                      Employee employee){
        return RespBean.ok(attendanceService.getMonthAttendance(page, size, employee));
    }

    @GetMapping("/currentWeek")
    public RespBean getCurrentWeek(){
        return RespBean.ok((Object) attendanceService.getCurrentWeek());
    }

    @GetMapping("/currentMonth")
    public RespBean getCurrentMonth(){
        return RespBean.ok((Object) attendanceService.getCurrentMonth());
    }


}
