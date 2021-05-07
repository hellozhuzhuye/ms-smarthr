package top.smartsoftware.smarthr.controller.system.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.smartsoftware.smarthr.service.JobLevelService;
import top.smartsoftware.smarthr.model.JobLevel;
import top.smartsoftware.smarthr.model.RespBean;
import top.smartsoftware.smarthr.service.OperationLogService;

import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author xjx
 * @Date 2020-11-28
 */
@RestController
@RequestMapping("/system/basic/joblevel")
public class JobLevelController {
    @Autowired
    JobLevelService jobLevelService;

    @GetMapping("/")
    public List<JobLevel> getAllJobLevels() {
        return jobLevelService.getAllJobLevels();
    }

    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.addJobLevel(jobLevel) == 1) {
            OperationLogService.insertInsertLog("职称:"+jobLevel.getName());
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @PutMapping("/")
    public RespBean updateJobLevelById(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.updateJobLevelById(jobLevel) == 1) {
            OperationLogService.insertUpdateLog("职称:"+jobLevel.getName());
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteJobLevelById(@PathVariable Integer id) {
        if (jobLevelService.deleteJobLevelById(id) == 1) {
            OperationLogService.insertDeleteLog("职称:"+id);
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @DeleteMapping("/")
    public RespBean deleteJobLevelsByIds(Integer[] ids) {
        if (jobLevelService.deleteJobLevelsByIds(ids) == ids.length) {
            OperationLogService.insertDeleteLog("职称:"+ Arrays.toString(ids));
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
}
