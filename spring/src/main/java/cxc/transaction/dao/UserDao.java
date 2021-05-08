package cxc.transaction.dao;

import cxc.transaction.entity.User;

import java.util.List;

/**
 * @author cxc
 * @date 2021/5/7
 */

public interface UserDao {

    /**
     * 查询用户
     *
     * @param id 用户id
     * @return cxc.transaction.entity.User
     * @author cxc
     * @date 2021/5/8
     */
    User getUserById(int id);

    /**
     * 查询所有用户
     *
     * @return java.util.List<cxc.transaction.entity.User>
     * @author cxc
     * @date 2021/5/8
     */
    List<User> getUsers();

    /**
     * 添加用户
     *
     * @param user 用户
     * @return int
     * @author cxc
     * @date 2021/5/8
     */
    int addUser(User user);

    /**
     * 修改用户
     *
     * @param user 用户id
     * @return int
     * @author cxc
     * @date 2021/5/8
     */
    int updateUser(User user);

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return int
     * @author cxc
     * @date 2021/5/8
     */
    int deleteUserById(int id);
}
