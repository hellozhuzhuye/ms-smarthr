package top.smartsoftware.smarthr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.smartsoftware.smarthr.model.EmployeeRemove;
import top.smartsoftware.smarthr.model.vo.EmployeeRemoveVO;

import java.util.List;

/**
 * <p>
 * 员工调动表 Mapper 接口
 * </p>
 *
 * @author xjx
 * @since 2021-02-01
 */
public interface EmployeeRemoveMapper extends BaseMapper<EmployeeRemove> {
    List<EmployeeRemoveVO> getAllEmpRemove(String name);
}
