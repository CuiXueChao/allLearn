package cxc.tests;

import cxc.second.controller.UserController;
import cxc.second.dao.impl.UserDaoImpl;
import cxc.second.entity.School;
import cxc.second.entity.User;
import cxc.second.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class User_Second_Test {

    private static ClassPathXmlApplicationContext ioc;

    @BeforeAll
    @DisplayName("加载")
    static void Test() {
        ioc = new ClassPathXmlApplicationContext("spring_second.xml");
    }

    @Test
    @DisplayName("测试扫描包的排除选项")
    void oneTest() {
        UserServiceImpl bean = ioc.getBean(UserServiceImpl.class);
        System.out.println(bean);
    }

    @Test
    @DisplayName("测试扫描包的包含选项")
    void twoTest() {
        UserDaoImpl bean = ioc.getBean(UserDaoImpl.class);
        System.out.println(bean);
    }

    @Test
    @DisplayName("value注解配置依赖注入")
    void dITest() {
        User bean = ioc.getBean(User.class);
        System.out.println(bean.getUserName());
    }

    @Test
    @DisplayName("自动装配设置")
    void autoTest() {
        //自动装配默认首先根据类型进行装配
        UserController bean = ioc.getBean(UserController.class);
        bean.getUser();
    }

    @Test
    @DisplayName("注解配置声明周期")
    void lifecycleTest() {
        School bean = ioc.getBean(School.class);
        ioc.close();
    }
}