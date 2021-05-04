package cxc.third.entity;

import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author cxc
 * @date 2021/5/3
 */
@Component
@DependsOn("user")
@Lazy
@Scope
public class School {

    public School() {
        System.out.println("school已加载");
    }

    @PostConstruct
    public void init() {
        //声明周期回调函数注解
        System.out.println("初始化");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("销毁");
    }

}
