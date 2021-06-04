package cxc;

import org.springframework.util.ObjectUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @author cxc
 * @date 2021/5/27
 */

public class MyInterceptor implements HandlerInterceptor {

    /**
     * 方法执行之前执行
     *
     * @param request  请求对象
     * @param response 响应对象
     * @param handler  当前所请求方法的信息（方法名，所在类，方法的参数）
     * @return boolean
     * @author cxc
     * @date 2021/5/27
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;

            System.out.println("preHandle - 方法执行之前执行");
            System.out.println("类名 - " + hm.getBean().getClass().getName());
            System.out.println("方法名 - " + hm.getMethod().getName());
            System.out.println("参数列表获取" + Arrays.toString(hm.getMethod().getParameters()));
        }

        //新增登录验证
        HttpSession session = request.getSession();
        if (!ObjectUtils.isEmpty(session.getAttribute("userName"))) {
            //return false 将不会执行拦截器之后所处理的方法 - 即调用链中断
            return true;
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return false;
        }


    }


    /**
     * 方法执行之后，视图未渲染时执行，异常时不执行(preHandle 返回false则不会被运行)
     *
     * @param request      请求对象
     * @param response     响应对象
     * @param handler      当前请求方法信息的封装
     * @param modelAndView 方法处理完成后可进行响应对象的存储和页面的跳转
     * @return void
     * @author cxc
     * @date 2021/5/27
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle - 方法执行之后，视图未渲染时执行，异常时不执行");

    }

    /**
     * 方法执行之后，视图渲染后执行，多了异常参数，出现了异常时，该方法仍会被执行，类似finally
     * 中的代码(preHandle 返回false则不会被运行)
     *
     * @param request  请求对象
     * @param response 响应对象
     * @param handler  当前请求方法信息的封装
     * @param ex       异常对象 -当方法出现了异常时，该方法仍会被执行，可用来记录异常的信息
     * @return void
     * @author cxc
     * @date 2021/5/27
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
        System.out.println("afterCompletion - 方法执行之后，视图渲染后执行，多了异常参数");
    }
}
