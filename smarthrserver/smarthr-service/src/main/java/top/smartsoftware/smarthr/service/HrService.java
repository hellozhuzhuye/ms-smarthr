package top.smartsoftware.smarthr.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.smartsoftware.smarthr.mapper.HrMapper;
import top.smartsoftware.smarthr.mapper.HrRoleMapper;
import top.smartsoftware.smarthr.model.Hr;
import top.smartsoftware.smarthr.utils.HrUtils;

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(username);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不存在");
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

//    public List<Hr> getAllHrsExceptCurrentHr() {
//        return hrMapper.getAllHrsExceptCurrentHr(HrUtils.getCurrentHr().getId());
//    }
//
//    public Integer updateHyById(Hr hr) {
//        return hrMapper.updateByPrimaryKeySelective(hr);
//    }
//
//    public boolean updateHrPasswd(String oldpass, String pass, Integer hrid) {
//        Hr hr = hrMapper.selectByPrimaryKey(hrid);
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        if (encoder.matches(oldpass, hr.getPassword())) {
//            String encodePass = encoder.encode(pass);
//            Integer result = hrMapper.updatePasswd(hrid, encodePass);
//            if (result == 1) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public Integer updateUserface(String url, Integer id) {
//        return hrMapper.updateUserface(url, id);
//    }
}
