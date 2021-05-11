package cxc;

import cxc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cxc
 * @date 2021/5/9
 */
@Controller
public class FirstMvc {
    /*
     * mvc中return 默认为转发，只有指定了“redirect:”即可实现转发
     *
     * @RequestParam+@RequestHeader+@CookieValue+mvc和servletAPI搭配使用
     * */

    /**
     * 简单参数的传递
     *
     * @param name 姓名
     * @return java.lang.String
     * @author cxc
     * @date 2021/5/10
     */
    @RequestMapping("/one")
    public String one(
            //@RequestParam注解 -- 对参数名进行重命名（原有的名称无效）
            //声明此注解后required（必填）该属性默认为true，未声明该注解在未传值时会附null
            //defaultValue -- 定义默认值,定义了默认值那么必填的属性就为false了
            @RequestParam(value = "userName", defaultValue = "cxc") String name
    ) {
        System.out.println(name);
        return "/index.jsp";
    }

    /**
     * 复杂参数的传递，详情见index.jsp
     * 当参数为多个对象的情况时，通过再新建一个类将所有参数对象封装，采用打点调用的方式实现
     *
     * @param user 用户
     * @return java.lang.String
     * @author cxc
     * @date 2021/5/10
     */
    @RequestMapping("/two")
    public String two(User user) {
        //当参数为对象时，表单中的元素name属性只需要对象所传入对象的属性指即可
        System.out.println(user);
        return "/index.jsp";
    }


    /**
     * RequestHeader注解用来获取请求头中的任意参数，只可加载参数上
     *
     * @param host
     * @return java.lang.String
     * @author cxc
     * @date 2021/5/10
     */
    @RequestMapping("/header")
    public String three(@RequestHeader("Host") String host) {
        System.out.println(host);
        return "/index.jsp";
    }

    /**
     * 获取cookie中的信息
     *
     * @param jessionId cookid的id
     * @return java.lang.String
     * @author cxc
     * @date 2021/5/10
     */
    @RequestMapping("/cookie")
    public String four(@CookieValue("JSESSIONID") String jessionId) {
        System.out.println(jessionId);
        return "/index.jsp";

    }

    /**
     * 当使用了mvc后仍然可以使用servlet原生的api两者可兼容
     *
     * @param request  请求对象
     * @param response 响应对象
     * @return java.lang.String
     * @author cxc
     * @date 2021/5/10
     */
    @RequestMapping("/servlet")
    public String five(String userName, HttpServletRequest request, HttpServletResponse response) {
        System.out.println(userName);
        String parameter = request.getParameter("name");
        request.setAttribute("name", parameter);
        return "/index.jsp";

    }
}
