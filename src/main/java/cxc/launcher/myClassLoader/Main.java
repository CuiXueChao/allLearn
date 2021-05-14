package cxc.launcher.myClassLoader;

import java.lang.reflect.Method;

/**
 * @ClassName:Main
 * @DESCRIPTION: 双亲委派机制，由loadClass方法调用findClass方法进行实现，findClass最终调用
 * defineClass方法将类进行加载。所以要实现一个自己的类加载器或者打破双亲委派机制就要从
 * loadClass和findClass两个方法进行入手。
 * @author: cxc
 * @DATE: 2021/4/3
 */

public class Main {
    public static void main(String[] args) throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader("D:/A_CXC_workSpace/");
        /*调用loadClass方法则会调用父加载器的loadClass方法，调用this.parent.loadClass(name, false)
         * 来加载(构造方法会自动为parent属性赋值)，失败后依次向上进行调用。
         * 如果classpath下有所要加载的class文件则会使用AppClassLoader来加载。
         * classPath下没有的话最终会调用自己重写的findClass方法。
         * 也可以直接调用findClass方法也可实现效果。
         * */
        Class clazz = myClassLoader.loadClass("cxc.launcher.classLoad.FirstClass");
        Object o = clazz.newInstance();
        Method print = clazz.getMethod("aa", (Class<?>) null);
        print.invoke(o, (Object) null);
        System.out.println(clazz.getClassLoader().getClass().getName());

    }

}
