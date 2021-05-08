package cxc.transaction.controller;

import cxc.transaction.entity.User;
import cxc.transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author cxc
 * @date 2021/5/7
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public UserController() {
    }

    /**
     * 获取用户
     *
     * @param id 用户id
     * @return cxc.transaction.entity.User
     * @author cxc
     * @date 2021/5/8
     */
    public User getUser(int id) {
        return userService.getUserById(id);
    }

    /**
     * 通过两条修改语句模拟转账，测试事务的使用
     *
     * @author cxc
     * @date 2021/5/8
     */

    public void transfer() {
        userService.transfer();
    }
}
