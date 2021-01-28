package top.smartsoftware.smarthr.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.smartsoftware.smarthr.mapper.PointMapper;
import top.smartsoftware.smarthr.model.Employee;
import top.smartsoftware.smarthr.model.vo.EmpEcVO;
import top.smartsoftware.smarthr.model.vo.EmpPointVO;

import java.util.List;

/**
 * @Description
 * @Author xjx
 * @Date 2021-01-19
 */

@Service
public class PointService {
    @Autowired
    PointMapper pointMapper;

    public PageInfo getAllPoints(Integer page, Integer size ,String name) {
        PageHelper.startPage(page,size);
        List<EmpPointVO> allPoints = pointMapper.getAllPoints(name);
        PageInfo<EmpPointVO> pageInfo = new PageInfo<EmpPointVO>(allPoints);
        return pageInfo;
    }
}
