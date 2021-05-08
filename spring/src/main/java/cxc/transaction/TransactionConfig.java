package cxc.transaction;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author cxc
 * @date 2021/5/7
 */

@Configuration
@ComponentScan
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class TransactionConfig {
    /*
     * 事务的四大特性（ACID）
     * 原子性-A：指在一组业务操作下,要么都成功,要么都失败,在一组增删改查的业务下要么都提交要么都回滚
     * 一致性-C：事务前后的数据要保证数据的一致性在一组的查询业务下必须要保证前后关联数据的一致性
     * 隔离性-I：在并发情况下事物之间要相互隔离。
     * 持久性-D：数据一旦保存就是持久性的
     *
     * 编程式事务：在代码中直接加入处理事务的逻辑，可能需要在代码中显式调用beginTransaction()、
     * commit()、rollback()等事务管理相关的方法。
     *
     * 声明式事务：在方法的外部添加注解或者直接在配置文件中定义，
     * 将事务管理代码从业务方法中分离出来，以声明的方式来实现事务管理。（aop）
     *
     * 声明式事务的使用：
     *  1.配置事务管理器TransactionManager(三方Bean)
     *  2.开启声明式事务的驱动
     *      2.1 @EnableTransactionManagement
     *      2.2Xml配置-<tx:annotation-driven transaction-manager="transactionManager"/>
     *
     *  3.事务配置的属性
     *      3.1 isolation
     *      3.2 propagation：事务的传播行为
     *      3.3 noRollbackFor：那些异常事务可以不回滚
     *      3.4 noRollbackForClassName：填写的参数是全类名
     *      3.5 rollbackFor：哪些异常事务需要回滚
     *      3.6 rollbackForClassName：填写的参数是全类名
     *      3.7 readOnly：设置事务是否为只读事务
     *      3.8 timeout：事务超出指定执行时长后自动终止并回滚,单位是秒
     *
     *  4.当类和方法上同时存在事务注解，将依照方法上标准的注解进行执行（尽量写在方法上-粒度更细）
     *
     *  5.事务的传播行为：
     *    针对多个被事务注解的方法嵌套调用时，该使用那个方法的事务标准执行
     *
     *      1.REQUIRED（默认） --- 适用增删改查
     *        外部无事务即开启新的事务，外部有事务即融合到外部事务中
     *        @Transactional(Propagation.REQUIRED)
     *
     *      2.SUPPORTS --- 适用查询
     *        外部无事务即不开启新的事务，外部有事务即融合到外部事务中
     *        @Transactional(Propagation.SUPPORTS)
     *
     *      3.REQUIRES_NEW --- 适用内部事务和外部事务不存在业务关
     *        外部无事务即开启新的事务，外部有事务即挂起外部事务，创建新的事务
     *        @Transactional(Propagation.REQUIRES_NEW)
     *
     *      不常用的传播行为
     *      NOT_SUPPORTED
     *      外部无事务即不开启新的事务，外部有事务即挂起外部事务
     *      NEVER
     *      外部无事务即不开启新的事务，外部有事务即抛出异常
     *      NESTED
     *      外部无事务即抛出异常，外部有事务即融合到外部事务中
     * */



    /*
     * 事务的隔离级别
     * 读未提交（READ_UNCOMMITTED）---》啥也解决不了
     * 读提交（READ_COMMITTED） ---》脏读
     * 可重复读（REPEATABLE_READ）---》不可重复读
     * 串行化（SERIALIZABLE）---》幻读
     *
     * */


    @Value("${mysql.name}")
    private String name;
    @Value("${mysql.password}")
    private String passWord;
    @Value("${mysql.url}")
    private String url;
    @Value("${mysql.driverClassName}")
    private String driveClassName;

    /**
     * 配置三方数据源
     *
     * @return com.alibaba.druid.pool.DruidDataSource
     * @author cxc
     * @date 2021/5/8
     */
    @Bean
    public DruidDataSource getSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(name);
        druidDataSource.setPassword(passWord);
        druidDataSource.setDriverClassName(driveClassName);
        druidDataSource.setUrl(url);
        return druidDataSource;
    }

    /**
     * 获取JdbcTemplate
     *
     * @return org.springframework.jdbc.core.JdbcTemplate
     * @author cxc
     * @date 2021/5/8
     */
    @Bean
    public JdbcTemplate getTemplate() {
        return new JdbcTemplate(getSource());
    }

    /**
     * 获取事务管理器
     *
     * @return org.springframework.jdbc.support.JdbcTransactionManager
     * @author cxc
     * @date 2021/5/8
     */
    @Bean
    public TransactionManager getTransactionManager() {
        return new JdbcTransactionManager(getSource());
    }
}
