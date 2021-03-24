package top.smartsoftware.smarthr.mapper;

import top.smartsoftware.smarthr.model.entity.WorkFlow;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.smartsoftware.smarthr.model.vo.MyApplyVO;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xjx
 * @since 2021-02-03
 */
public interface WorkFlowMapper extends BaseMapper<WorkFlow> {
    List<MyApplyVO> queryMyApply(Integer eid);
}
