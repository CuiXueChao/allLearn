package cxc.aop.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author cxc
 * @date 2021/5/3
 */
@Component
public class User {


    /**
     * 用户名称 -- 通过value注解进行依赖注入
     * 也可以通过${用来引用外部资源文件}、#{用来书写spEL}来进行书写
     */
    @Value("cxc")
    private String userName;

    public User() {
        System.out.println("user已加载");
    }


    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
