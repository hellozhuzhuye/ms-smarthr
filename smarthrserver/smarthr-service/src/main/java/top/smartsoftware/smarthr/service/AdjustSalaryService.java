package top.smartsoftware.smarthr.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.smartsoftware.smarthr.mapper.AdjustSalaryMapper;
import top.smartsoftware.smarthr.model.AdjustSalary;
import top.smartsoftware.smarthr.model.vo.AdjustSalaryVO;
import top.smartsoftware.smarthr.model.vo.EmpAccountVO;

import java.util.Date;

/**
 * @Description
 * @Author xjx
 * @Date 2021-05-07
 */
@Service
public class AdjustSalaryService {
    @Autowired
    AdjustSalaryMapper adjustSalaryMapper;

    public PageInfo<AdjustSalaryVO> getAdjustSalary(Integer pageNum, Integer pageSize, AdjustSalaryVO adjustSalaryVO) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<AdjustSalaryVO>(adjustSalaryMapper.getSalaryAccount(adjustSalaryVO));

    }

    public void insertAdjustSalary(AdjustSalaryVO adjustSalaryVO) {
        Double currAfterSalary = adjustSalaryMapper.getCurrAfterSalary(adjustSalaryVO.getEid());
        AdjustSalary adjustSalary = new AdjustSalary();
        adjustSalary.setEid(adjustSalaryVO.getEid());
        adjustSalary.setBeforeSalary(currAfterSalary);
        adjustSalary.setAfterSalary(adjustSalaryVO.getAfterSalary());
        adjustSalary.setAsDate(new Date());
        adjustSalary.setReason(adjustSalaryVO.getReason());
        adjustSalary.setRemark(adjustSalaryVO.getRemark());
        adjustSalaryMapper.insertSelective(adjustSalary);
    }
}
