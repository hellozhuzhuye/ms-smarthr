package top.smartsoftware.smarthr.mapper;

import top.smartsoftware.smarthr.model.entity.WorkFlowStatus;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.smartsoftware.smarthr.model.vo.ApproveVO;
import top.smartsoftware.smarthr.model.vo.MyApplyDetailVO;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xjx
 * @since 2021-02-03
 */
public interface WorkFlowStatusMapper extends BaseMapper<WorkFlowStatus> {

    List<MyApplyDetailVO> getDetailApply(Integer wfid);

    List<ApproveVO> getApprove(Integer id);
}
