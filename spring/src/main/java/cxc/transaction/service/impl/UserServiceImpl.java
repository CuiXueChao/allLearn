package cxc.transaction.service.impl;

/**
 * @author cxc
 * @date 2021/5/7
 */


import cxc.transaction.dao.UserDao;
import cxc.transaction.entity.User;
import cxc.transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void transfer() {
        User cxc = userDao.getUserById(1);
        cxc.setBalance(cxc.getBalance() - 10);

        User zlx = userDao.getUserById(2);
        zlx.setBalance(zlx.getBalance() + 10);
        //修改
        userDao.updateUser(cxc);
        System.out.println("扣钱结束");
        int e = 1 / 0;
        userDao.updateUser(zlx);
        System.out.println("加钱结束");
    }

    @Override
    public int deleteUserById(int id) {
        return userDao.deleteUserById(id);
    }


}
