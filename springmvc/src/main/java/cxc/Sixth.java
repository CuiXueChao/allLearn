package cxc;

import cxc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 有关json
 *
 * @author cxc
 * @date 2021/5/17
 */
@Controller
public class Sixth {

    /*
     * json的响应及请求
     * @ResponseBody 设置响应格式为Json
     * @RequestBody 设置请求参数为Json
     * @JsonIgnore 设置返回时忽略所注解的属性（不将隐私信息暴露到前端）
     *
     * */

    /**
     * 响应json格式的对象
     *
     * @return cxc.entity.User
     * @author cxc
     * @date 2021/5/18
     */
    @RequestMapping("/SixthOne")
    @ResponseBody
    public User one() {
        User user = new User();
        user.setName("cxc");
        return user;
    }

    /**
     * 限制请求参数需为json格式
     *
     * @param name 用户姓名
     * @return java.lang.String
     * @author cxc
     * @date 2021/5/18
     */
    @RequestMapping("/SixthTwo")
    @ResponseBody
    public String two(@RequestBody String name) {
        return name;
    }

    /**
     * 接收实体对象的json，需注意所传参数名要和实体对象的属性名保持一致
     * 利用map传递参数则不需担心
     *
     * @param user user对象
     * @return cxc.entity.User
     * @author cxc
     * @date 2021/5/18
     */
    @RequestMapping("/SixthThree")
    @ResponseBody
    public User three(@RequestBody User user) {
        return user;
    }


    /**
     * 通过map传递json
     *
     * @param map user对象
     * @return cxc.entity.User
     * @author cxc
     * @date 2021/5/18
     */
    @RequestMapping("/SixthFour")
    @ResponseBody
    public Map four(@RequestBody Map map) {
        map.forEach((o, o2) -> System.out.println(o + "===" + o2));
        return map;
    }
}
