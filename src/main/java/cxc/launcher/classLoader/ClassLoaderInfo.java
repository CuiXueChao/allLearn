package cxc.launcher.classLoader;

import com.sun.crypto.provider.DESKeyFactory;
import sun.misc.Launcher;

import java.net.URL;

/**
 * 查看类加载器的信息
 * @ClassName:ClassLoaderInfo
 * @DESCRIPTION: 打印各个类加载器的加载路径并验证
 * @author: cxc
 * @DATE: 2021/4/3
 */

public class ClassLoaderInfo {

    public static void main(String[] args) {
        //BootstrapClassLoader加载的路径
        System.out.println("BootstrapClassLoader加载的路径");
        URL[] bootstrapClassPath = Launcher.getBootstrapClassPath().getURLs();
        for (int i = bootstrapClassPath.length - 1; i >= 0; i--) {
            System.out.println(bootstrapClassPath[i]);
        }

        //ExtClassLoader加载的路径
        System.out.println();
        System.out.println("ExtClassLoader加载的路径");
        System.out.println(System.getProperty("java.ext.dirs"));

        //AppClassLoader加载的路径
        System.out.println();
        System.out.println("AppClassLoader加载的路径");
        System.out.println(System.getProperty("java.class.path"));

        System.out.println();
        System.out.println();

        //查看三个类加载器的parent属性
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        //即默认第一个使用的类加载器
        System.out.println("systemClassLoader = " + systemClassLoader);

        ClassLoader ext = systemClassLoader.getParent();
        System.out.println("ext = " + ext);

        ClassLoader bootStrap = ext.getParent();
        System.out.println("bootStrap = " + bootStrap);


        System.out.println();
        System.out.println();
        /*
        String类为java核心类，由引导类加载器所加载。
        引导类加载器并非由java实现
        */
        ClassLoader classLoader = String.class.getClassLoader();
        //null
        System.out.println(classLoader);

        //找一个ext包下的类打印其类加载器--ExtClassLoader
        String name1 = DESKeyFactory.class.getClassLoader().getClass().getName();
        System.out.println(name1);

        //打印自己写的类的类加载器--AppClassLoader
        String name2 = ClassLoaderInfo.class.getClassLoader().getClass().getName();
        System.out.println(name2);



    }
}
