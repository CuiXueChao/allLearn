package cxc.tests;

import com.alibaba.druid.pool.DruidDataSource;
import cxc.entity.SchoolFactoryTwo;
import cxc.entity.SchoolTwo;
import cxc.entity.UserOne;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SchoolTwoTest {
    private ClassPathXmlApplicationContext ioc;

    @BeforeAll
    void beforeTest() {
        ioc = new ClassPathXmlApplicationContext("spring-ioc_Two.xml");
    }

    /**
     * dependsOn配置依赖来修改bean的加载顺序--通过dependsOn属性来配置依赖关系
     *
     * @author cxc
     * @date 2021/5/3
     */
    @Test
    void dependsOnTest() {
        //可得user先于school被加载
        SchoolTwo schoolTwo = (SchoolTwo) ioc.getBean("schoolTwo");
        System.out.println(schoolTwo);
    }

    /**
     * 懒加载 --通过lazy-init属性配置懒加载，在初始化spring容器时不会将bean注入，而是在使用时注入
     *
     * @author cxc
     * @date 2021/5/3
     */
    @Test
    void lazyInitTest() {
        //配置懒加载之后，加载配置文件时不会将bean加载到spring容器之中，只有再使用的时候才会加载
        UserOne userOne = (UserOne) ioc.getBean("userOne");
        System.out.println(userOne);
    }

    /**
     * Bean的作用域--单例singleton、原型prototype(默认为单例模式)
     *
     * @author cxc
     * @date 2021/5/3
     */
    @Test
    void scopeTest() {
        //构造函数被执行两次
        UserOne userOne = (UserOne) ioc.getBean("userOne");
        UserOne userTwo = (UserOne) ioc.getBean("userOne");
        //false--每次使用都会创建一个bean加载到spring容器中
        System.out.println(userOne == userTwo);
    }

    /**
     * 静态工厂方法实现对象的创建
     *
     * @author cxc
     * @date 2021/5/3
     */
    @Test
    @DisplayName("静态工厂方法实现对象的创建")
    void staticFactoryTest() {
        SchoolTwo schoolTwo2 = (SchoolTwo) ioc.getBean("schoolTwo2");
        System.out.println(schoolTwo2);
    }

    /**
     * 实例工厂实现对象的创建
     *
     * @author cxc
     * @date 2021/5/3
     */
    @Test
    @DisplayName("实例工厂实现对象的创建")
    void instanceFactoryTest() {
        SchoolTwo schoolTwo3 = (SchoolTwo) ioc.getBean("schoolTwo3");
        System.out.println(schoolTwo3);
    }


    /**
     * 实现声明周期回调函数<br/>
     * 实现两个接口可分别实现初始化和销毁函数<br/>
     * InitializingBean -- DisposableBean <br/>
     * 在类中定义方法通过配置文件中的两个属性进行指定同样也可实现<br/>
     * init-method -- destroy-method
     *
     * @author cxc
     * @date 2021/5/3
     */
    @Test
    @DisplayName("生命周期测试")
    void lifeCycleTest() {
        SchoolFactoryTwo schoolFactoryTwo2 = (SchoolFactoryTwo) ioc.getBean("schoolFactoryTwo2");
        System.out.println(schoolFactoryTwo2);
        ioc.close();
    }


    /**
     * 第三方Bean的配置
     *
     * @author cxc
     * @date 2021/5/3
     */
    @Test
    @DisplayName("第三方Bean的配置")
    void otherClassConfigTest() {
        DruidDataSource dataSource = (DruidDataSource) ioc.getBean("dataSource");
        System.out.println(dataSource);
    }

}