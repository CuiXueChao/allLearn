package cxc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

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
     * 通过@Pointcut注解定义公共的切点
     *
     * @author cxc
     * @date 2021/5/6
     */
    @Pointcut("execution(* cxc.aop.dao..*.*(..))")
    public void pointCut() {
    }

    /**
     * 前置通知方法
     * * cxc.aop.dao..*.*(..)
     * 第一个星号 - 表示返回值类型（星号表示所有-在前面省略了访问修饰符（省略即都可以））
     * cxc.aop.dao..* - 表示dao下所有类（包含子孙类）
     * .*(..) - 表示类的所有方法-且参数类型不做限制
     *
     * @param
     * @return void
     * @author cxc
     * @date 2021/5/5
     */
    @Before("execution(* cxc.aop.dao..*.*(..))||" + "execution(* cxc.aop.entity.School.*(..))")
    public void before(JoinPoint joinPoint) {
        //当同一个方法需要辐射到多个表达式上使用“||”即可
        // @Before("execution(* cxc.aop.dao..*.*(..))||execution(* cxc.aop.myProxy..*.*(..))")

        //通过链接点对象获取当前方法名
        String name = joinPoint.getSignature().getName();
        //获取所有参数
        Object[] args = joinPoint.getArgs();
        System.out.println(name + "方法执行前,传入参数为" + Arrays.asList(args));
    }

    @After("pointCut()")
    public void after() {
        System.out.println("方法执行后");
    }

    @AfterReturning(value = "pointCut()",
            returning = "o")
    public void afterReturn(Object o) {
        //通过returning来指定返回值
        System.out.println("方法返回后");
    }

    @AfterThrowing(value = "pointCut()",
            throwing = "ex")
    public void afterThrow(Exception ex) {
        //通过throwing指定抛出异常对象
        //打印异常栈日志的固定写法
        StringWriter stringWriter = new StringWriter();
        ex.printStackTrace(new PrintWriter(stringWriter, true));
        String s = stringWriter.getBuffer().toString();

        System.out.println("方法出现异常" + s);
    }

    /**
     * 环绕通知相当于根据需求手动写通知，方法也需要手动执行
     *
     * @param joinPoint 链接点
     * @return java.lang.Object
     * @author cxc
     * @date 2021/5/6
     */
    @Around(value = "pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取方法名
        String name = joinPoint.getSignature().getName();
        //获取参数
        Object[] args = joinPoint.getArgs();
        Object o = null;
        try {
            System.out.println("前置通知");
            o = joinPoint.proceed();
            System.out.println("后置通知");
        } catch (Exception e) {
            System.out.println("异常通知");
            e.printStackTrace();
        } finally {
            System.out.println("返回通知");
        }
        return o;
    }

}
