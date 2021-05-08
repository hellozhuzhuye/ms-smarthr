package top.smartsoftware.smarthr.mapper;

import top.smartsoftware.smarthr.model.entity.EmployeeAccount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.smartsoftware.smarthr.model.vo.EmpAccountVO;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xjx
 * @since 2021-05-07
 */
public interface EmployeeAccountMapper extends BaseMapper<EmployeeAccount> {

    List<EmpAccountVO> getSalaryAccount(EmpAccountVO empAccountVO);
    EmpAccountVO getAccountDetail(Integer id);
}
