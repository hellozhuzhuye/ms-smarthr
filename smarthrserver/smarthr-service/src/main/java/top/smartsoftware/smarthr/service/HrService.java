package top.smartsoftware.smarthr.service;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import top.smartsoftware.smarthr.config.OssConfig;
import top.smartsoftware.smarthr.mapper.HrMapper;
import top.smartsoftware.smarthr.mapper.HrRoleMapper;
import top.smartsoftware.smarthr.model.Hr;
import top.smartsoftware.smarthr.utils.HrUtils;
import top.smartsoftware.smarthr.utils.DateTimeUtil;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author xjx
 * @Date 2020-11-15
 */

@Service
public class HrService implements UserDetailsService {
    @Autowired
    HrMapper hrMapper;
    @Autowired
    HrRoleMapper hrRoleMapper;
    @Autowired
    private OssConfig ossConfig;
    @Autowired
    private OSSClient ossClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(username);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不存在!");
        }
        hr.setRoles(hrMapper.getHrRolesById(hr.getId()));
        return hr;
    }

    public List<Hr> getAllHrs(String keywords) {
        return hrMapper.getAllHrs(HrUtils.getCurrentHr().getId(), keywords);
    }

    public Integer updateHr(Hr hr) {
        return hrMapper.updateByPrimaryKeySelective(hr);
    }

    @Transactional
    public boolean updateHrRole(Integer hrid, Integer[] rids) {
        hrRoleMapper.deleteByHrid(hrid);
        return hrRoleMapper.addRole(hrid, rids) == rids.length;
    }

    public Integer deleteHrById(Integer id) {
        return hrMapper.deleteByPrimaryKey(id);
    }

    public List<Hr> getAllHrsExceptCurrentHr() {
        return hrMapper.getAllHrsExceptCurrentHr(HrUtils.getCurrentHr().getId());
    }

    public Integer updateHyById(Hr hr) {
        return hrMapper.updateByPrimaryKeySelective(hr);
    }

    public boolean updateHrPasswd(String oldpass, String pass, Integer hrid) {
        Hr hr = hrMapper.selectByPrimaryKey(hrid);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches(oldpass, hr.getPassword())) {
            String encodePass = encoder.encode(pass);
            Integer result = hrMapper.updatePasswd(hrid, encodePass);
            if (result == 1) {
                return true;
            }
        }
        return false;
    }

    public String updateUserface(MultipartFile multipartFile, Integer id, Authentication authentication) throws IOException {
        if (multipartFile == null || multipartFile.isEmpty()) {
            return null;
        }
        String objectName = "images/userface/" +  DateTimeUtil.dateToDateString(new Date(), "yyyyMMddHHmmss") + "_" + id + "_" + multipartFile.getOriginalFilename();
        PutObjectRequest putObjectRequest = new PutObjectRequest(ossConfig.getALIYUN_OSS_BUCKET_NAME(), objectName, multipartFile.getInputStream());
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setObjectAcl(CannedAccessControlList.PublicRead);
        putObjectRequest.setMetadata(metadata);
        ossClient.putObject(putObjectRequest);
        String url="http://"+ossConfig.getALIYUN_OSS_ENDPOINT()+"/"+objectName;
        Hr hr = (Hr) authentication.getPrincipal();
        hr.setUserface(url);
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(hr, authentication.getCredentials(), authentication.getAuthorities()));
        if (hrMapper.updateUserface(url, id)==1) {
            return url;
        }else {
            return null;
        }
    }
}
