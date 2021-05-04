package cxc.second.controller;

import cxc.second.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author cxc
 * @date 2021/5/3
 */
@Controller
public class UserController {

    //@Value("#{userServiceImpl}") 自动装配

    @Autowired
    UserService userService;

    public void getUser() {
        userService.getUser();
    }
}
