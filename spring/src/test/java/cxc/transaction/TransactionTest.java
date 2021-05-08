package cxc.transaction;

import com.alibaba.druid.pool.DruidDataSource;
import cxc.transaction.controller.UserController;
import cxc.transaction.entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

class TransactionTest {

    private static AnnotationConfigApplicationContext ioc;

    @BeforeAll
    @DisplayName("before")
    static void before() {
        ioc = new AnnotationConfigApplicationContext(TransactionConfig.class);
    }

    /**
     * 测试获取Bean
     *
     * @author cxc
     * @date 2021/5/7
     */
    @Test
    @DisplayName("获取连接对象")
    void getSourceTest() {
        DruidDataSource getSource = ((DruidDataSource) ioc.getBean("getSource"));
        System.out.println(getSource);
        JdbcTemplate getTemplate = ((JdbcTemplate) ioc.getBean("getTemplate"));
        System.out.println(getTemplate);
    }

    /**
     * 查询单个对象
     *
     * @author cxc
     * @date 2021/5/7
     */
    @Test
    @DisplayName("JdbcTemplate测试一")
    void jdbcTemplateTest() {
        JdbcTemplate db = ((JdbcTemplate) ioc.getBean("getTemplate"));
        //当属性名和字段名相等时可使用BeanPropertyRowMapper对象进行自动接收
        User user = db.queryForObject("select * from `user` where id =1",
                new BeanPropertyRowMapper<>(User.class));
        System.out.println(user);
    }

    /**
     * 查询单个对象，属性名于字段名不同时使用此类接收对象
     *
     * @author cxc
     * @date 2021/5/7
     */
    @Test
    @DisplayName("JdbcTemplate测试二")
    void jdbcTemplateTwoTest() {
        JdbcTemplate db = ((JdbcTemplate) ioc.getBean("getTemplate"));
        //RowMapper该对象需返回值,可使用“？”进行值的动态绑定
        User user1 = db.queryForObject("select * from `user` where id =?",
                (resultSet, i) -> {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setRealName(resultSet.getString("realName"));
                    return user;
                }, 1);
        System.out.println(user1);
    }


    /**
     * 查询集合
     *
     * @author cxc
     * @date 2021/5/7
     */
    @Test
    @DisplayName("查询集合")
    void queryListTest() {
        JdbcTemplate db = ((JdbcTemplate) ioc.getBean("getTemplate"));
        List<User> query = db.query("select * from `user`", new BeanPropertyRowMapper<>(User.class));
        query.forEach(System.out::println);

        //属性和字段不同时查询集合
        List<User> queryTwo = db.query("select * from `user`", (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setRealName(rs.getString("realName"));
            return user;
        });
        queryTwo.forEach(System.out::println);
    }


    @Test
    @DisplayName("增删改")
    void addDelUpdTest() {
        JdbcTemplate db = ((JdbcTemplate) ioc.getBean("getTemplate"));
        //新增数据
        //int update = db.update("insert into user(realName,cardNo,balance) " +
        //        "values(?,?,?)", "cxc", "cxc", 100);

        //修改数据
        //db.update("update user set realName='aaa' where id=?", 3);

        //删除数据
        //db.update("delete from user where id=?", 3);
    }

    @Test
    @DisplayName("事务测试一")
    void firstTransactionTest() {
        UserController bean = ioc.getBean(UserController.class);
        bean.transfer();

    }
}