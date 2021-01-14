package top.smartsoftware.smarthr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.smartsoftware.smarthr.mapper.EcRuleMapper;
import top.smartsoftware.smarthr.model.EcRule;

import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author xjx
 * @Date 2021-01-13
 */
@Service
public class EcRuleService {
    @Autowired
    EcRuleMapper ecRuleMapper;

    public List<EcRule> getAllEcRules() {
        List<EcRule> ecRules = ecRuleMapper.selectList(null);
        return ecRules;
    }

    public int addEcRule(EcRule ecRule) {
        return ecRuleMapper.insert(ecRule);
    }

    public int deleteEcRuleById(Integer id) {
        return ecRuleMapper.deleteById(id);
    }


    public int updateEcRuleById(EcRule ecRule) {
        return ecRuleMapper.updateById(ecRule);
    }

    public int deleteEcRulesByIds(Integer[] ids) {
        return ecRuleMapper.deleteBatchIds(Arrays.asList(ids));
    }
}
