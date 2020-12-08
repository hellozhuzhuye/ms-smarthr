package top.smartsoftware.smarthr.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import top.smartsoftware.smarthr.model.Hr;

/**
 * @Description
 * @Author xjx
 * @Date 2020-11-29
 */
public class HrUtils {
    public static Hr getCurrentHr() {
        return ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
