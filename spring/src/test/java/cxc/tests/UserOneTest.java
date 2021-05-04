package cxc.tests;

import cxc.first.UserOne;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserOneTest {
    private ClassPathXmlApplicationContext ioc;

    @BeforeAll
    void Test() {
        ioc = new ClassPathXmlApplicationContext("spring-ioc_firstA.xml");
    }

    /**
     * 基于maven项目XML方式来配置spring-ioc
     *
     * @author cxc
     * @date 2021/5/3
     */
    @Test
    void firstIocTest() {

        //ioc = new ClassPathXmlApplicationContext("spring-ioc_firstA.xml");
        //可得到结论--配置文件加载完成之后所有的bean就已经被注册到了ioc容器之中
        System.out.println("spring-容器已经被加载");

        //User user = User.class.newInstance();
        UserOne bean = ioc.getBean("user", UserOne.class);
        //通过所配置的id配置
        //User bean = ((User) ioc.getBean("user"));
        //最保险的最准确的定位
        //User bean = ioc.getBean("user", User.class);
        System.out.println(bean);
    }

    /**
     * 别名测试
     *
     * @author cxc
     * @date 2021/5/3
     */
    @Test
    void aliasTest() {
        UserOne anotherNameOfUserClass = (UserOne) ioc.getBean("anotherNameOfUserClass");
        UserOne user2 = (UserOne) ioc.getBean("user2");
        UserOne user3 = (UserOne) ioc.getBean("user3");
        System.out.println(anotherNameOfUserClass);
        System.out.println(user2);
        System.out.println(user3);
    }

    /**
     * 构造器注入及两个命名空间的简化注入
     *
     * @author cxc
     * @date 2021/5/3
     */
    @Test
    void consTest() {
        UserOne user4 = (UserOne) ioc.getBean("user4");
        UserOne user5 = (UserOne) ioc.getBean("user5");
        UserOne user6 = (UserOne) ioc.getBean("user6");
        System.out.println(user4);
        System.out.println(user5);
        System.out.println(user6);

    }
}