package cxc.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面类
 *
 * @author cxc
 * @date 2021/5/5
 */
@Component
@Aspect
public class MyAop {

    /**
     * 前置通知方法
     * * cxc.aop.dao..*.*(..)
     * 第一个星号 - 表示访问修饰符和返回值类型（星号表示所有）
     * cxc.aop.dao..* - 表示dao下所有类（包含子孙类）
     * .*(..) - 表示类的所有方法-且参数类型不做限制
     *
     * @param
     * @return void
     * @author cxc
     * @date 2021/5/5
     */
    @Before("execution(* cxc.aop.dao..*.*(..))||" + "execution(* cxc.aop.entity.School.*(..))")
    public void before() {
        //当同一个方法需要辐射到多个表达式上使用“||”加“+”模式
        // @Before("execution(* cxc.aop.dao..*.*(..))||"+ "execution(* cxc.aop.myProxy..*.*(..))")
        System.out.println("方法执行前");
    }

    @After("execution(* cxc.aop.dao..*.*(..))")
    public void after() {
        System.out.println("方法执行后");
    }

    @AfterReturning("execution(* cxc.aop.dao..*.*(..))")
    public void afterReturn() {
        System.out.println("方法返回后");
    }

    @AfterThrowing("execution(* cxc.aop.dao..*.*(..))")
    public void afterThrow() {
        System.out.println("方法出现异常");
    }


}
