package top.smartsoftware.smarthr.controller.system.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.smartsoftware.smarthr.service.OperationLogService;
import top.smartsoftware.smarthr.service.PositionService;
import top.smartsoftware.smarthr.model.Position;
import top.smartsoftware.smarthr.model.RespBean;

import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author xjx
 * @Date 2020-11-27
 */
@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {

    @Autowired
    PositionService positionService;

    @GetMapping("/")
    public List<Position> getAllPositions(){
        return positionService.getAllPositions();
    }

    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position){
        if (positionService.addPosition(position)==1){
            OperationLogService.insertInsertLog("职位:"+position.getName());
            return RespBean.ok("添加成功");
        }else {
            return RespBean.error("添加失败");
        }
    }

    @PutMapping("/")
    public RespBean updatePosition(@RequestBody Position position){
        if (positionService.updatePosition(position)==1){
            OperationLogService.insertUpdateLog("职位:"+position.getName());
            return RespBean.ok("更新成功");
        }else {
            return RespBean.error("更新失败");
        }
    }

    @DeleteMapping("/{id}")
    public RespBean deletePositionById(@PathVariable Integer id){
        if (positionService.deletePositionById(id)==1){
            OperationLogService.insertDeleteLog("职位:"+id);
            return RespBean.ok("删除成功");
        }else {
            return RespBean.error("删除失败");
        }
    }

    @DeleteMapping("/")
    public RespBean deletePositionByIds(Integer[] ids){
        if (positionService.deletePositionByIds(ids)==ids.length){
            OperationLogService.insertDeleteLog("职位:"+ Arrays.toString(ids));
            return RespBean.ok("删除成功");
        }else {
            return RespBean.error("删除失败");
        }
    }


}
