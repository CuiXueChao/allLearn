package cxc.third;

import com.alibaba.druid.pool.DruidDataSource;
import cxc.third.entity.BeanDefinitionRegistrarOne;
import cxc.third.entity.SelectorOne;
import cxc.third.entity.SelectorTwo;
import cxc.third.entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class IocJavaConfigTest {
    static AnnotationConfigApplicationContext ioc;

    @BeforeAll
    @DisplayName("before")
    static void before() {
        ioc = new AnnotationConfigApplicationContext(IocJavaConfig.class);
    }

    @Test
    @DisplayName("iocJavaConfig启动测试")
    void Test() {
        User bean = ioc.getBean(User.class);
        System.out.println(bean);
    }

    @Test
    @DisplayName("第三方bean的定义")
    void anOtherTest() {
        DruidDataSource bean = ioc.getBean(DruidDataSource.class);
        System.out.println(bean);
    }

    @Test
    @DisplayName("实现ImportSelect接口实现注入")
    void importSelectTest() {
        //此种方式只能通过类名的形式来进行调用
        SelectorOne beanA = ioc.getBean(SelectorOne.class);
        SelectorTwo beanB = ioc.getBean(SelectorTwo.class);
        System.out.println(beanA);
        System.out.println(beanB);
    }

    @Test
    @DisplayName("BeanDefinition接口")
    void BeanDefinitionTest() {
        BeanDefinitionRegistrarOne beanA = ((BeanDefinitionRegistrarOne) ioc.getBean("beanDefinitionRegistrarOne"));
        System.out.println(beanA);

        
    }

}