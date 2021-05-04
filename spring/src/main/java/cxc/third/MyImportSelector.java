package cxc.third;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author cxc
 * @date 2021/5/4
 */

public class MyImportSelector implements ImportSelector {

    /**
     * 以字符串的形式注册多个Bean
     *
     * @param importingClassMetadata 注解接口
     * @return java.lang.String[]
     * @author cxc
     * @date 2021/5/4
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"cxc.third.entity.SelectorOne", "cxc.third.entity.SelectorTwo"};
    }
}
