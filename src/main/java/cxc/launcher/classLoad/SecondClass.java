package cxc.launcher.classLoad;

/**
 * 测试类的加载顺序及验证类加载的特性（懒加载，用到该类加载，用不到不加载）
 * @ClassName:SceondClass
 * @DESCRIPTION:
 * @author: cxc
 * @DATE: 2021/4/3
 */

public class SecondClass {

    //静态代码块
    static {
        System.out.println("secondClass中静态代码块-----加载");
    }

    public SecondClass() {
        System.out.println("secondClass构造函数-----调用");
    }
}
