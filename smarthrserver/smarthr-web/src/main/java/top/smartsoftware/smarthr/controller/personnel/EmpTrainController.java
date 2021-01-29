package top.smartsoftware.smarthr.controller.personnel;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.smartsoftware.smarthr.model.EmployeeTrain;
import top.smartsoftware.smarthr.model.RespBean;
import top.smartsoftware.smarthr.model.vo.EmployeeTrainVO;
import top.smartsoftware.smarthr.service.EmpTrainService;


/**
 * @Description
 * @Author xjx
 * @Date 2021-01-28
 */

@RestController
@RequestMapping("/personnel/train")
public class EmpTrainController {
    @Autowired
    EmpTrainService empTrainService;

    @GetMapping("/")
    public PageInfo<EmployeeTrainVO> getAllEmpTrain(@RequestParam(defaultValue = "1") Integer page,
                                                    @RequestParam(defaultValue = "10")Integer size,
                                                    String name){
        return empTrainService.getAllEmpTrain(page,size,name);
    }

    @PostMapping("/")
    public RespBean addEmpTrain(@RequestBody EmployeeTrain employeeTrain){
        empTrainService.addEmpTrain(employeeTrain);
        return RespBean.ok("添加成功");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteEmpTrain(@PathVariable Integer id) {
        if (empTrainService.deleteEmpTrainByEid(id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PutMapping("/")
    public RespBean updateEmpTrain(@RequestBody EmployeeTrain employeeTrain) {
        if (empTrainService.updateEmpTrain(employeeTrain) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }



}
