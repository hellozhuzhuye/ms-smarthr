package top.smartsoftware.smarthr.model.vo;

import top.smartsoftware.smarthr.model.OperationLog;

/**
 * @Description
 * @Author xjx
 * @Date 2021-04-28
 */
public class OperationLogVO extends OperationLog {
    private String name;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
