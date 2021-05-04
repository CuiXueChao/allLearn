package cxc.third;

import cxc.third.entity.BeanDefinitionRegistrarOne;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

/**
 * @author cxc
 * @date 2021/5/4
 */
@Component
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry,
                                        BeanNameGenerator importBeanNameGenerator) {
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();

        genericBeanDefinition.setBeanClass(BeanDefinitionRegistrarOne.class);

        //genericBeanDefinition.setBeanClass(BeanDefinitionRegistrarTwo.class);

        registry.registerBeanDefinition("beanDefinitionRegistrarOne", genericBeanDefinition);
    }
}
