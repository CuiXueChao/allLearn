package cxc.aop;

import cxc.aop.dao.UserDao;
import cxc.aop.entity.School;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class MyAopTest {
    static ClassPathXmlApplicationContext ioc;

    @BeforeAll
    @DisplayName("beforeAll")
    static void BeforeAllTest() {
        ioc = new ClassPathXmlApplicationContext("spring_aop.xml");
    }

    @Test
    @DisplayName("我的第一个aop测试")
    void firstAopTest() {
        //接口的
        UserDao bean = ioc.getBean(UserDao.class);
        System.out.println(bean.getClass());
        bean.getUser();
    }

    @Test
    @DisplayName("aop测试使用的代理模式")
    void modelTest() {
        School bean = ioc.getBean(School.class);
        //未实现接口的类实现代理将会使用CGLIB代理模式
        System.out.println(bean.getClass());
    }


}