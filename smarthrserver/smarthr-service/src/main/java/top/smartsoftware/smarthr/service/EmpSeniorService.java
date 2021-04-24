package top.smartsoftware.smarthr.service;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.smartsoftware.smarthr.config.CloudMarketConfig;
import top.smartsoftware.smarthr.mapper.EmployeeSeniorMapper;
import top.smartsoftware.smarthr.model.entity.EmployeeSenior;
import top.smartsoftware.smarthr.model.vo.BankCardVO;
import top.smartsoftware.smarthr.model.vo.IdCardVO;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description
 * @Author xjx
 * @Date 2021-04-18
 */
@Service
public class EmpSeniorService {
    @Autowired
    EmployeeSeniorMapper employeeSeniorMapper;
    @Autowired
    CloudMarketConfig cloudMarketConfig;

    public PageInfo getEmpSeniorByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<EmployeeSenior> list = employeeSeniorMapper.selectList(null);
        list.forEach(e->{
            String idCardData = e.getIdCardData();
            IdCardVO idCardVO = JSONUtil.toBean(idCardData, IdCardVO.class);
            e.setIdCardVO(idCardVO);
            String bankCardData = e.getBankCardData();
            BankCardVO bankCardVO = JSONUtil.toBean(bankCardData, BankCardVO.class);
            e.setBankCardVO(bankCardVO);
        });
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    public EmployeeSenior getEmpSeniorDetail(Integer id) {
        EmployeeSenior employeeSenior = employeeSeniorMapper.selectById(id);
        IdCardVO idCardVO = JSONUtil.toBean(employeeSenior.getIdCardData(), IdCardVO.class);
        employeeSenior.setIdCardVO(idCardVO);
        BankCardVO bankCardVO = JSONUtil.toBean(employeeSenior.getBankCardData(), BankCardVO.class);
        employeeSenior.setBankCardVO(bankCardVO);
        return employeeSenior;
    }

    public String idCardOcr(String url) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("image", url);
        jsonObject.put("configure", JSONObject.parseObject("{\"side\":\"face\"}"));
        try {
            HttpResponse response = HttpRequest.post(cloudMarketConfig.getOCR_IDCARDURL())
                    .header("Authorization", "APPCODE " + cloudMarketConfig.getOCR_APPCODE())
                    .header("Content-Type", "application/json; charset=UTF-8")
                    .body(jsonObject.toJSONString()).execute();
            String resBody = response.body();
            System.out.println(resBody);
            return resBody;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String bankCardOcr(String url) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("image", url);
        try {
            HttpResponse response = HttpRequest.post(cloudMarketConfig.getOCR_BANKCARDURL())
                    .header("Authorization", "APPCODE " + cloudMarketConfig.getOCR_APPCODE())
                    .header("Content-Type", "application/json; charset=UTF-8")
                    .body(jsonObject.toJSONString()).execute();
            String resBody = response.body();
            System.out.println(resBody);
            return resBody;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public int addEmpSenior(EmployeeSenior employeeSenior) {
        employeeSenior.setCreateTime(LocalDateTime.now());
        return employeeSeniorMapper.insert(employeeSenior);
    }

    public int delEmpSenior(String id) {
        return employeeSeniorMapper.deleteById(Integer.valueOf(id));
    }
}
