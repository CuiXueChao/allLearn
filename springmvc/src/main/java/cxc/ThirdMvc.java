package cxc;

import cxc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author cxc
 * @date 2021/5/12
 */

@Controller
public class ThirdMvc {
    /* REST + 静态资源的访问（css、js等）
     *
     * REST - 一种url的命名风格
     *  查询用户: http://localhost:8080/xxx/user/1      GET     --查询
     *  查询多个用户: http://localhost:8080/xxx/users  GET
     *  新增用户: http://localhost:8080/xxx/user         POST  ---新增
     *  修改用户: http://localhost:8080/xxx/user/1      PUT    --修改
     *  删除用户:http://localhost:8080/xxx/user/1      DELETE --删除
     *
     * jsp - 不支持put、delete方式的请求
     * 可通过过滤器进行请求的变更（见web.xml中过滤器的配置）
     *
     * 解决转发到jsp出现：HTTP Status 405 - JSPs only permit GET POST or HEAD
     *   1.用tomcat7
     *   2.不用转发，用重定向
     *   3. 将jsp的page指定 isErrorPage属性改成true(不建议)
     *   4. 自定义一个过滤器，将request.method改回POST
     *
     *
     * 静态资源的访问（css、js等） - 配置可直接访问静态资源
     * 见spring-mvc-first.xml配置文件
     * */


    /**
     * GetMapping注解用来体现查询
     *
     * @param id 用户id
     * @return java.lang.String
     * @author cxc
     * @date 2021/5/12
     */
    @GetMapping(value = "/third/one/{id}")
    public String one(@PathVariable("id") Integer id) {
        System.out.println("查询" + id);
        return "/third.jsp";
    }

    /**
     * PostMapping用来体现新增
     *
     * @param user 用户
     * @return java.lang.String
     * @author cxc
     * @date 2021/5/12
     */
    @PostMapping(value = "/third/two/")
    public String two(User user) {
        System.out.println("新增" + user);
        return "/third.jsp";
    }

    /**
     * PutMapping用来体现修改
     *
     * @param id 用户id
     * @return java.lang.String
     * @author cxc
     * @date 2021/5/12
     */
    @PutMapping(value = "/third/three/{id}")
    public String three(@PathVariable("id") Integer id) {
        System.out.println("修改" + id);
        return "redirect:/third.jsp";
    }

    /**
     * DeleteMapping用来体现删除
     *
     * @param id 用户id
     * @return java.lang.String
     * @author cxc
     * @date 2021/5/12
     */
    @DeleteMapping(value = "/third/four/{id}")
    public String four(@PathVariable("id") Integer id) {
        System.out.println("删除" + id);
        return "redirect:/third.jsp";
    }


}
