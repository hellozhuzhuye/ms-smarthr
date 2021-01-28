package top.smartsoftware.smarthr.controller.statistics;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.smartsoftware.smarthr.service.PointService;

/**
 * @Description
 * @Author xjx
 * @Date 2021-01-19
 */
@RestController
@RequestMapping("/statistics/point")
public class PointController {
    @Autowired
    PointService pointService;

    @GetMapping("/")
    public PageInfo getAllPoints(@RequestParam(defaultValue = "1") Integer page,
                                 @RequestParam(defaultValue = "10") Integer size,
                                 String name) {
        return pointService.getAllPoints(page,size,name);
    }
}
