package cxc.second.dao.impl;

import cxc.second.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author cxc
 * @date 2021/5/3
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public void getUser() {
        System.out.println("查询数据库");
    }
}
