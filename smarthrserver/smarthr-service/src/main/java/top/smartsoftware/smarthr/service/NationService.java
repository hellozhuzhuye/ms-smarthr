package top.smartsoftware.smarthr.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.smartsoftware.smarthr.mapper.NationMapper;
import top.smartsoftware.smarthr.model.Nation;

import java.util.List;

/**
 * @Description
 * @Author xjx
 * @Date 2020-12-04
 */
@Service
public class NationService {
    @Autowired
    NationMapper nationMapper;
    public List<Nation> getAllNations() {
        return nationMapper.getAllNations();
    }
}
