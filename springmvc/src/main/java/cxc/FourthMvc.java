package cxc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author cxc
 * @date 2021/5/13
 */
@Controller
@SessionAttributes("type")
public class FourthMvc {

    /* 视图解析器+视图控制器+响应数据传输+@ModelAttribute
     *
     * 配置响应所使用的视图解析器
     *  作用：由于web目录下的jsp页面可直接进行访问，但是针对一些需要查询数据库来展示值的页面
     *       来说，直接访问jsp页面将无法进行映射及查询数据库操作，那么就无法显示用来展示的内
     *       容，故通过视图解析器将jsp文件放在WEB-INF目录下，来阻止直接访问，并提供简写
     *
     * 视图控制器（见配置文件）
     *       针对不需要访问数据库就可以直接显示的jsp以上操作则需为其专门新增一个控制方法
     *       有些没有必要，可通过视图控制器来进行jsp页面的直接映射
     *
     * 响应数据传输（request+session）
     *  request
     *      servlet原生方式;
     *      Model+ModelMap+Map-此三种方式同源，最终传的对象都为BindingAwareModelMap
     *      modelAndView --- 稍有不同，需将返回值设置为modelAndView
     *
     *  session
     *      servlet原生方式;
     *      spring自动注入模式
     *      注解模式
     *        @SessionAttributes-在类之上使用，设置属性后可从request中copy到session
     *         用来写入（依赖model）
     *        @SessionAttribute-在参数上使用，用来将session中的数据绑定到参数中
     *
     * @ModelAttribute
     *  写在方法上
     *      ModelAttribute的方法会在当前处理器中所有的处理方法之前调用
     *  写在参数上
     * */


    @RequestMapping("/FourthOne")
    public String one() {
        return "fourth";
    }


    /**
     * 原生api方式
     *
     * @param request http请求对象
     * @return java.lang.String
     * @author cxc
     * @date 2021/5/13
     */
    @RequestMapping("/FourthTwo")
    public String two(HttpServletRequest request) {
        request.setAttribute("request", "原生api的方式");
        return "fourth";
    }

    /**
     * 使用Model对象传输数据
     *
     * @param model model对象
     * @return java.lang.String
     * @author cxc
     * @date 2021/5/13
     */
    @RequestMapping("/FourthThree")
    public String three(Model model) {
        System.out.println(model.getClass());
        model.addAttribute("type", "model");
        return "fourth";
    }

    /**
     * 使用modelMap对象传输数据
     *
     * @param modelMap modelMap对象
     * @return java.lang.String
     * @author cxc
     * @date 2021/5/13
     */
    @RequestMapping("/FourthFour")
    public String four(ModelMap modelMap) {
        System.out.println(modelMap.getClass());
        modelMap.addAttribute("type", "modelMap");
        return "fourth";
    }

    /**
     * 使用Map对象传输数据
     *
     * @param map map对象
     * @return java.lang.String
     * @author cxc
     * @date 2021/5/13
     */
    @RequestMapping("/FourthFive")
    public String five(Map map) {
        System.out.println(map.getClass());
        map.put("type", "map");
        return "fourth";
    }


    /**
     * ModelAndView实现响应数据传输
     *
     * @return org.springframework.web.servlet.ModelAndView
     * @author cxc
     * @date 2021/5/13
     */
    @RequestMapping("/FourthSix")
    public ModelAndView six() {
        //设置转发的页面
        ModelAndView fourth = new ModelAndView("fourth");
        fourth.addObject("type", "ModelAndView");
        return fourth;
    }


    /**
     * 原生session存放对象
     *
     * @param session session对象
     * @return java.lang.String
     * @author cxc
     * @date 2021/5/13
     */
    @RequestMapping("/FourthSeven")
    public String seven(HttpSession session) {
        session.setAttribute("type", "原生api");
        return "fourth";
    }

    @Autowired
    private HttpSession session;

    /**
     * 自动注入的方式实现session存放对象
     *
     * @return java.lang.String
     * @author cxc
     * @date 2021/5/13
     */
    @RequestMapping("/FourthEight")
    public String eight() {
        session.setAttribute("type", "Autowired");
        return "fourth";
    }


    @RequestMapping("/FourthNine")
    public String nine() {
        //测试@SessionAttributes
        return "fourth";
    }

    /**
     * SessionAttribute注解的使用，该注解其中有必填属性，若无值会报错
     *
     * @param type
     * @return java.lang.String
     * @author cxc
     * @date 2021/5/13
     */
    @RequestMapping("/FourthTen")
    public String ten(@SessionAttribute(value = "type", required = false) String type) {
        System.out.println(type);
        return "fourth";
    }

    /**
     * ModelAttribute的使用，只需定义为普通方法
     *
     * @author cxc
     * @date 2021/5/13
     */
    @ModelAttribute
    public void eleven() {
        System.out.println("ModelAttribute");
    }
}
