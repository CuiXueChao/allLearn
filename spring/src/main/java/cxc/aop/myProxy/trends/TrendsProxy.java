package cxc.aop.myProxy.trends;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理类 - 动态代理类致命缺点：必须实现接口！！
 *
 * @author cxc
 * @date 2021/5/6
 */

public class TrendsProxy {

    /**
     * 获取动态代理所得到的类
     *
     * @param o 被代理的类
     * @return java.lang.Object
     * @author cxc
     * @date 2021/5/6
     */
    public static Object getProxy(Object o) {
        //获取被代理对象的类加载器
        ClassLoader c = o.getClass().getClassLoader();
        //获得被代理对象所实现的接口
        Class<?>[] interfaces = o.getClass().getInterfaces();
        //方法执行器
        InvocationHandler invocationHandler = new InvocationHandler() {
            /**
             * 被代理类将会执行此处代码
             * @param proxy 被代理的对象 —— 需实现接口
             * @param method 被代理对象将要执行的方法
             * @param args 方法的参数
             * @return java.lang.Object
             * @author cxc
             * @date 2021/5/6
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Object invoke = null;
                try {
                    System.out.println("方法执行前");
                    invoke = method.invoke(o, args);
                    System.out.println("方法执行后");
                } catch (Exception e) {
                    System.out.println("方法执行出现异常");
                    e.printStackTrace();
                }
                return invoke;
            }
        };
        //生成代理对象所需的三个参数
        //ClassLoader loader - 被代理类的类加载器
        //Class<?>[] interfaces - 被代理类所有接口
        //InvocationHandler h - 方法执行器
        Object o1 = Proxy.newProxyInstance(c, interfaces, invocationHandler);
        //返回代理对象
        return o1;
    }


}
