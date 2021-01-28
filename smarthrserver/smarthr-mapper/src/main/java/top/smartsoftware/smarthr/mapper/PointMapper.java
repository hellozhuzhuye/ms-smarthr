package top.smartsoftware.smarthr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.smartsoftware.smarthr.model.Point;
import top.smartsoftware.smarthr.model.vo.EmpPointVO;

import java.util.List;


/**
 * @Description
 * @Author xjx
 * @Date 2021-01-19
 */
public interface PointMapper extends BaseMapper<Point> {
    List<EmpPointVO> getAllPoints(String name);
}
