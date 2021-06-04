package cxc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 拦截器学习（记录日志，权限管理，记录方法的调用时间）
 *
 * @author cxc
 * @date 2021/5/27
 */

@Controller
public class EighthMvc {
    /*
     * 实现拦截器需实现该接口 - HandlerInterceptor
     * 该接口下共三个方法 - 见 - MyInterceptor 有对以下方法详细描述
     *  preHandle
     *  postHandle
     *  afterCompletion
     *
     * */

    @RequestMapping("/eighthOne")
    public String eighthOne() {
        System.out.println("eighthOne");
        return "eight";
    }


    @RequestMapping("/eighthTwo")
    public String eighthTwo(HttpSession session) {
        System.out.println("eighthTwo");
        session.setAttribute("userName", "cxc");
        return "eight";
    }
}
