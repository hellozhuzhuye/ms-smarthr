package top.smartsoftware.smarthr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import top.smartsoftware.smarthr.Service.MenuService;
import top.smartsoftware.smarthr.model.Menu;
import top.smartsoftware.smarthr.model.Role;

import java.util.Collection;
import java.util.List;

/**
 * @Description 根据用户传来的请求地址，分析出请求需要的角色
 * @Author xjx
 * @Date 2020-11-24
 */
@Component
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    MenuService menuService;

    AntPathMatcher antPathMatcher=new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl=((FilterInvocation)o).getRequestUrl();
        List<Menu> menus = menuService.getAllMenusWithRole();
        for (Menu m : menus) {
            if (antPathMatcher.match(m.getUrl(),requestUrl)){
                List<Role> roles = m.getRoles();
                String[] strings = new String[roles.size()];
                for (int i = 0; i < strings.length; i++) {
                    strings[i]=roles.get(i).getName();
                }
                return SecurityConfig.createList(strings);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
