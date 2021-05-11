package cxc;

import cxc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author cxc
 * @date 2021/5/11
 */
@Controller
public class SecondMvc {

    /* @RequestMapping+@PathVariable
     * @RequestMapping
     * 可声明在类和方法上
     * 在类上即可约束该类中所有的映射路径
     * 在方法上即映射当前方法的请求路径
     *
     *  method - 设置请求方式，可声明多个（不写则匹配所有）
     *      RequestMethod.POST（@PostMapping） - 设置该方法只处理POST提交方式的请求
     *      RequestMethod.GET（@GetMapping） - 设置该方法只处理GET提交方式的请求
     *      RequestMethod.DELETE（@DeleteMapping）
     *      RequestMethod.PUT（@PutMapping）
     *      ···
     *
     *  params - 设置参数，即规定请求当前方法必须具备的参数条件
     *      定义字符串即规定必须有的参数，在前方加！即不能有该参数
     *      可同时限定参数的值，！则限定属性不能等于该值
     *
     *  header - 设置请求头中必须含有所指定的参数
     *
     *  consumes - 设置请求内容类型(不演示)
     *  produces - 设置响应内容类型(不演示)
     *
     *  通配符
     *  ？- 匹配单个字符
     *  * - 匹配任意字符
     *
     * @PathVariable
     *  将占位符中的值，传递给参数
     * */

    /**
     * method 属性的使用
     *
     * @return java.lang.String
     * @author cxc
     * @date 2021/5/11
     */
    @RequestMapping(value = "/requestOne", method = {RequestMethod.POST})
    public String one() {
        //该方法只相应POST请求
        return "/index.jsp";
    }


    /**
     * params 属性的使用
     *
     * @param userName 限定参数
     * @return java.lang.String
     * @author cxc
     * @date 2021/5/11
     */
    @RequestMapping(value = "/requestTwo", params = {"userName"})
    public String two(String userName) {
        System.out.println(userName);
        return "/index.jsp";
    }


    @RequestMapping(value = "/requestThree?")
    public String three() {
        System.out.println("？通配符");
        return "/index.jsp";
    }

    @RequestMapping(value = "/requestFour*")
    public String four() {
        System.out.println("*通配符");
        return "/index.jsp";
    }

    @RequestMapping(value = "/**/requestFive")
    public String five() {
        System.out.println("**通配符");
        return "/index.jsp";
    }

    /**
     * {id}定义占位符，通过@PathVariable注解将占位符上的值赋给 Integer的对象
     * 对象不需要加该注解，只需占位符中的名称和javaBean的属性对应即可
     *
     * @param id
     * @return java.lang.String
     * @author cxc
     * @date 2021/5/11
     */
    @RequestMapping(value = "/PathVariable/{id}")
    public String six(@PathVariable("id") Integer id) {
        System.out.println("PathVariable" + id);
        return "/index.jsp";
    }

    @RequestMapping(value = "/PathVariable/{name}/{age}/{hello}")
    public String seven(User user, @PathVariable("hello") String hello) {
        System.out.println("PathVariable" + user + hello);
        return "/index.jsp";
    }
}
