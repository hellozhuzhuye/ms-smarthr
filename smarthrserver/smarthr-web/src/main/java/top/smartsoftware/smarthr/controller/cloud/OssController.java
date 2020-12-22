package top.smartsoftware.smarthr.controller.cloud;

/**
 * @Description
 * @Author xjx
 * @Date 2020-12-19
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.smartsoftware.smarthr.model.OSSObjectVO;
import top.smartsoftware.smarthr.model.OssCallbackResult;
import top.smartsoftware.smarthr.model.OssPolicyResult;
import top.smartsoftware.smarthr.model.RespBean;
import top.smartsoftware.smarthr.service.OssService;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cloud/oss")
public class OssController {
    @Autowired
    private OssService ossService;

    @RequestMapping(value = "/policy", method = RequestMethod.GET)
    public RespBean policy(String dir) {
        OssPolicyResult result = ossService.policy(dir);
        return RespBean.ok(result);
    }

    @RequestMapping(value = "callback", method = RequestMethod.POST)
    public RespBean callback(HttpServletRequest request) {
        OssCallbackResult ossCallbackResult = ossService.callback(request);
        return RespBean.ok(ossCallbackResult);
    }


    @RequestMapping(value = "/deleteObject", method = RequestMethod.GET)
    public RespBean deleteObject(String delObject) {
        ossService.deleteObject(delObject);
        return RespBean.ok("删除成功");
    }

    @RequestMapping(value = "/renameObject", method = RequestMethod.GET)
    public RespBean renameObject(String sourceObjectName,String destinationObjectName) {
        ossService.renameObject(sourceObjectName,destinationObjectName);
        return RespBean.ok("删除成功");
    }


    @RequestMapping(value = "/getObjectList", method = RequestMethod.GET)
    public RespBean getObjectList(String objectName) throws ParseException, IOException {
        List<OSSObjectVO> objectList = ossService.getObjectList(objectName);
        return RespBean.ok(objectList);
    }

    @RequestMapping(value = "/signUrl", method = RequestMethod.GET)
    public RespBean signUrl(String objectName) {
        String signUrl = ossService.signUrl(objectName);
        return RespBean.ok("请求下载成功,正在下载...",signUrl);
    }

}

