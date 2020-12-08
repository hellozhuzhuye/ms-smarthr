package top.smartsoftware.smarthr.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.smartsoftware.smarthr.mapper.PositionMapper;
import top.smartsoftware.smarthr.model.Position;
import top.smartsoftware.smarthr.model.RespBean;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author xjx
 * @Date 2020-11-27
 */
@Service
public class PositionService {
    @Autowired
    PositionMapper positionMapper;

    public List<Position> getAllPositions() {
        return positionMapper.getAllPositions();
    }


    public Integer addPosition(Position position) {
        position.setEnabled(true);
        position.setCreateDate(new Date());
        return positionMapper.insertSelective(position);
    }

    public Integer updatePosition(Position position) {
        return positionMapper.updateByPrimaryKeySelective(position);
    }

    public Integer deletePositionById(Integer id) {
        return positionMapper.deleteByPrimaryKey(id);
    }

    public Integer deletePositionByIds(Integer[] ids) {
        return positionMapper.deletePositionByIds(ids);
    }

}
