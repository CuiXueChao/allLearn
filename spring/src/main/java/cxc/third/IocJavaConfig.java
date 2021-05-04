package cxc.third;

import com.alibaba.druid.pool.DruidDataSource;
import cxc.third.entity.School;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

/**
 * @author cxc
 * @date 2021/5/4
 */
@Configuration
@ComponentScan(basePackages = "cxc.third")
@PropertySource("classpath:db.properties")
@Import({MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class IocJavaConfig {
    /*
     * @Configuration - 定义当前类为配置类 -》完全代替xml文件
     * @ComponentScan - 定义扫描包 - 默认为当前类同文件夹下所有内容
     * @PropertySource - 引入外部资源文件 classpath:db.properties
     * @Import
     * 1.可引入其他配置类、2.注入一个Bean
     * 3.导入实现了ImportSelector接口的类以字符串形式返回多个Bean
     * 4.导入实现了ImportBeanDefinitionRegistrar接口的类,可以注册多个bean定义
     * @Bean - 方法级别的注解 - 可定义第三方的Bean对象
     * */

    @Value("%{mysql.name}")
    private String name;
    @Value("%{mysql.passWord}")
    private String passWord;
    @Value("%{mysql.url}")
    private String url;
    @Value("%{mysql.driverClassName}")
    private String driveClassName;


    @Bean(name = "dataSource", initMethod = "", destroyMethod = "")
    public DruidDataSource dataSource() {
        //方法名作为Bean的id,也可以进行初始化之后执行的方法和销毁时执行的方法
        DruidDataSource db = new DruidDataSource();
        //在此可引用上面的属性
        db.setName(name);
        db.setPassword("root");
        db.setUrl("jdbc:mysql//localhost:8080/cxc");
        db.setDriverClassName("com.mysql.jdbc.Driver");
        return db;
    }

    @Bean
    public School getUser() {
        return new School();
    }
}
