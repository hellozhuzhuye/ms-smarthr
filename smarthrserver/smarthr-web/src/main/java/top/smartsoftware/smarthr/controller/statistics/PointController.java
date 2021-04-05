package top.smartsoftware.smarthr.controller.statistics;

import cn.hutool.core.util.RandomUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.smartsoftware.smarthr.mapper.PointMapper;
import top.smartsoftware.smarthr.model.Point;
import top.smartsoftware.smarthr.service.PointService;

import java.util.List;

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
    @Autowired
    PointMapper pointMapper;

    @GetMapping("/")
    public PageInfo getAllPoints(@RequestParam(defaultValue = "1") Integer page,
                                 @RequestParam(defaultValue = "10") Integer size,
                                 String name) {
        return pointService.getAllPoints(page,size,name);
    }
    
    @GetMapping("/test")
    public void test(){
        List<Point> points = pointMapper.selectList(null);
        points.forEach(e->{
            int i1 = RandomUtil.randomInt(1, 50);
            e.setPoint(String.valueOf(i1*10));
            pointMapper.updateById(e);
        });
    }
    
}
