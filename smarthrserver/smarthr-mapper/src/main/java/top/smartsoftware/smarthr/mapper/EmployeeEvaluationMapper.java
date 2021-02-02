package top.smartsoftware.smarthr.mapper;

import top.smartsoftware.smarthr.model.entity.EmployeeEvaluation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.smartsoftware.smarthr.model.vo.EmployeeEvaluationVO;

import java.util.List;

/**
 * <p>
 * 员工考评表 Mapper 接口
 * </p>
 *
 * @author xjx
 * @since 2021-02-01
 */
public interface EmployeeEvaluationMapper extends BaseMapper<EmployeeEvaluation> {

    List<EmployeeEvaluationVO> getAllEmpEval(String name);
}
