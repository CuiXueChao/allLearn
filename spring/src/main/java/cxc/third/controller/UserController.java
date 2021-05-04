package cxc.third.controller;

import cxc.third.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author cxc
 * @date 2021/5/3
 */
@Controller
public class UserController {


    @Autowired
    UserService userService;

    public void getUser() {
        userService.getUser();
    }
}
