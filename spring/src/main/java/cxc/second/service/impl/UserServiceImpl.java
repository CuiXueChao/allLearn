package cxc.second.service.impl;

import cxc.second.dao.UserDao;
import cxc.second.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author cxc
 * @date 2021/5/3
 */
@Service
public class UserServiceImpl implements UserService {
    @Value("#{userDaoImpl}")
    UserDao userDao;

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
