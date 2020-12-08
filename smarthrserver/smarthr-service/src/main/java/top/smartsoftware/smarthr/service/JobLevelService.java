package top.smartsoftware.smarthr.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.smartsoftware.smarthr.mapper.JobLevelMapper;
import top.smartsoftware.smarthr.model.JobLevel;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author xjx
 * @Date 2020-11-28
 */
@Service
public class JobLevelService {
    @Autowired
    JobLevelMapper jobLevelMapper;


    public List<JobLevel> getAllJobLevels() {
        return jobLevelMapper.getAllJobLevels();
    }


    public Integer addJobLevel(JobLevel jobLevel) {
        jobLevel.setCreateDate(new Date());
        jobLevel.setEnabled(true);
        return jobLevelMapper.insertSelective(jobLevel);
    }

    public Integer updateJobLevelById(JobLevel jobLevel) {
        return jobLevelMapper.updateByPrimaryKeySelective(jobLevel);
    }

    public Integer deleteJobLevelById(Integer id) {
        return jobLevelMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteJobLevelsByIds(Integer[] ids) {
        return jobLevelMapper.deleteJobLevelsByIds(ids);
    }
}
