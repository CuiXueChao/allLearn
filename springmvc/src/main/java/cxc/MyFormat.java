package cxc;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义类型转换器
 * 通过实现Converter接口，来实现自定义的类型转换器两个泛型为原类型和目标类型
 *
 * @author cxc
 * @date 2021/5/14
 */
@Component
public class MyFormat implements Converter<String, Date> {

    /**
     * 定义String向Date类型转换的类型转换器
     * 自定义了类型转换器之后，须在配置文件中进行配置，要将该类交给springMvc的类型转换工厂
     *
     * @param source 原类型
     * @return java.util.Date
     * @author cxc
     * @date 2021/5/14
     */
    @Override
    public Date convert(String source) {
        DateFormat dateFormat;
        //所传参数不为空时进入
        if (!ObjectUtils.isEmpty(source)) {
            try {
                if (source.split("-").length == 3) {
                    dateFormat = new SimpleDateFormat("YYYY-MM-dd");
                    System.out.println("YYYY-MM-dd");
                    return dateFormat.parse(source);
                }
                if (source.split("/").length == 3) {
                    dateFormat = new SimpleDateFormat("YYYY/MM/dd");
                    System.out.println("YYYY/MM/dd");
                    return dateFormat.parse(source);
                }
            } catch (ParseException e) {
                e.printStackTrace();
                throw new RuntimeException("日期格式错误：" + source +
                        "支持YYYY-MM-dd、YYYY/MM/dd");
            }
        }
        return null;
    }
}
