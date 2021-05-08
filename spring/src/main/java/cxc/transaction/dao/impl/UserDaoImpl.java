package cxc.transaction.dao.impl;

import cxc.transaction.dao.UserDao;
import cxc.transaction.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cxc
 * @date 2021/5/7
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate db;


    @Override
    public User getUserById(int id) {
        return db.queryForObject("select * from user where id =?",
                new BeanPropertyRowMapper<>(User.class), id);
    }

    @Override
    public List<User> getUsers() {
        return db.query("select * from user",
                new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public int addUser(User user) {
        return db.update("insert into user(realName, cardNo, balance) " +
                        "values (?,?,?)",
                user.getRealName(), user.getCardNo(), user.getBalance());
    }

    @Override
    public int updateUser(User user) {
        return db.update("update user set realName=?,cardNo=?,balance=? " +
                "where id=?", user.getRealName(), user.getCardNo(), user.getBalance(), user.getId());
    }

    @Override
    public int deleteUserById(int id) {
        return db.update("delete from user where id=?", id);
    }
}
