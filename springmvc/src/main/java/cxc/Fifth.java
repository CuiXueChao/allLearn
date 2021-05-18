package cxc;

import cxc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cxc
 * @date 2021/5/14
 */

@Controller
public class Fifth {

    /* 类型转换+数据格式化+数据验证
     *  类型转换:自定义类型转换器（mvc提供了自动的类型转换）
     *      所有类型转换器皆需实现Converter接口
     *      具体可转换的类型在Converters converters有所显示
     *      private final Converters converters = new Converters();
     *
     *  数据格式化
     *      @DateTimeFormat - 对日期进行格式化（于属性上方声明）
     *      @NumberFormat - 对数字进行格式化
     * */

    @RequestMapping("/FifthOne")
    public String one(User user) {
        System.out.println(user);
        return "five";
    }
}
