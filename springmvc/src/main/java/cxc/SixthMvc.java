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
public class SixthMvc {

    /*
     * json的响应及请求  -- <mvc:annotation-driven/>
     * @ResponseBody 设置响应格式为Json
     * @RequestBody 设置请求参数为Json
     * @JsonIgnore 设置返回时忽略所注解的属性（不将隐私信息暴露到前端）
     *
     * */


    /*
     * json数据格式描述
     * 集合 - 使用中括号描述 —— []
     * 对象 - 使用大括号描述,属性用双引号包裹，和值使用冒号分开 —— {"xxx":...}
     * map - 同对象 —— {}
     * 字符串 - 使用双引号描述 —— ""
     * 数字 - 直接书写即可 —— 1
     * 对象中含其他对象 - 大括号+(声明属性)大括号 —— {"xxx":{...}}
     * 集合中包含多个对象 - 中括号+大括号 —— [{"xxx":...},{"xxx":...}]
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
