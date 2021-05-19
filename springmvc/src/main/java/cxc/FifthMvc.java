package cxc;

import cxc.entity.User;
import cxc.entity.VerifyUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

/**
 * @author cxc
 * @date 2021/5/14
 */

@Controller
public class FifthMvc {

    /* 类型转换+数据格式化+数据验证
     *  类型转换:自定义类型转换器（mvc提供了自动的类型转换）
     *      所有类型转换器皆需实现Converter接口
     *      具体可转换的类型在Converters converters有所显示
     *      private final Converters converters = new Converters();
     *
     *  数据格式化
     *      @DateTimeFormat - 对日期进行格式化（于属性上方声明）
     *      @NumberFormat - 对数字进行格式化
     *
     * 数据验证
     *  使用前端校验+后端校验的方式，既能够满足用户的体验度，同时也能保证数据的安全。
     *  常用注解 @Valid - 开启验证 !!! 不使用该注解则javaBean中定义的注解无效
     *          @NotNull 定义不能为null
     *          @Past 定义必须为一个过去的时间
     *          @Future 定义必须为一个将来的时间
     *          @Max 定义最大值即值不能超过该注解所定义的值
     *          @Min 定义最小值即值必须大于该注解所定义的值
     *          @Pattern 定义一个正则表达式
     *          @Email 定义必须为一个Email
     *          @NotEmpty 定义不许为空
     *          @Range 定义值在一个范围
     *
     *  BindingResult 该对象的声明则表示我们要自己处理错误，不需要浏览器给我们报错
     *      见 - /FifthThree
     *
     *  spring的form表单 -- 自动的回显转换，更加智能化
     *      采用该模式需附加一步，使用映射的方式向jsp中传入所适配的对象
     *      但是不需要做错误信息的传递和格式的转换。
     *      需要使用jstl来进行遍历的在spring的form标签下更加方便
     *
     * */

    @RequestMapping("/FifthOne")
    public String one(User user) {
        //FifthOne?birthday=2021-07-01  -- 需将jsp中注释放开
        System.out.println(user);
        return "five";
    }


    @RequestMapping("/FifthTwo")
    public String two(@Valid VerifyUser verifyUser) {
        System.out.println(verifyUser);
        return "five";
    }


    /**
     * 静态的数据绑定 测试该方法需将配置文件中的视图控制器打开/five
     *
     * @param verifyUser
     * @param bindingResult
     * @param model
     * @return java.lang.String
     * @author cxc
     * @date 2021/5/19
     */
    @PostMapping("/FifthThree")
    public String three(@Valid VerifyUser verifyUser,
                        BindingResult bindingResult, Model model) {
        bindingResult.getFieldErrors().forEach(System.out::println);
        System.out.println(verifyUser);
        if (bindingResult.hasErrors()) {
            System.out.println("出现错误");
            //获取所有出错的字段
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            //定义一个存放错误信息的map
            HashMap<String, String> errors = new HashMap<>(16);
            //将错误信息存入map
            fieldErrors.forEach(fieldError ->
                    errors.put(fieldError.getField(), fieldError.getDefaultMessage())
            );
            //将map返回到页面
            model.addAttribute("errors", errors);
            return "/five";
        } else {
            System.out.println("验证成功");
            return "viewController";
        }
    }

    /**
     * 测试该方法需将视图控制器注释掉/five
     * 因为需要在页面上添加一个空的适配对象
     *
     * @param verifyUser
     * @param bindingResult
     * @param model
     * @return java.lang.String
     * @author cxc
     * @date 2021/5/19
     */
    @RequestMapping("/FifthFour")
    public String four(@Valid VerifyUser verifyUser,
                       BindingResult bindingResult, Model model) {
        System.out.println(verifyUser);

        if (bindingResult.hasErrors()) {
            return "five";
        }
        return "viewController";
    }


    @RequestMapping("/FifthFive")
    public String five(VerifyUser verifyUser) {
        System.out.println(verifyUser);
        return "five";
    }
}
