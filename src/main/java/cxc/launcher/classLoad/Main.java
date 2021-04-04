package cxc.launcher.classLoad;

/**
 * 测试代码的加载顺序，加载逻辑
 * @ClassName:Main
 * @DESCRIPTION: 类加载——是将一个class文件读入到内存，并为之创建一个Class对像。完成了类加载过程才可以真正的使用该类。
 * 1.加载——根据路径查找并读入相应的class文件
 * 2.验证——验证该文件的格式是否正确。（即验证字节码文件是否符合java字节码文件的规范）
 * 3.准备——给静态变量，分配内存并赋初始值（变量类型的初始值，并非自定义的值）
 * 4.解析——将符号引用替换为直接引用。
 * 5.初始化——初始化静态变量的值，执行静态代码块。
 * @author: cxc
 * @DATE: 2021/4/3
 */

public class Main {

    public static void main(String[] args) {
        /*Main类被使用，要进行加载，及会将静态变量复制并执行静态代码块
        * 静态变量和静态代码块的执行顺序即为代码的先后顺序*/


        FirstClass firstClass = new FirstClass();
        System.out.println("------------main------------");
        //不使用SecondClass类，验证是否会被加载
        SecondClass secondClass = null;
        System.out.println("------------main------------");
        //可得验证只有在使用某个类时，才会进行加载。
        secondClass=new SecondClass();
    }

    static {
        System.out.println("主类的静态代码块");
        //出现在静态变量之前进行调用，则会报错
        //System.out.println(a);
    }

    static int a=10;


    static {
        System.out.println(a);
    }
    public Main() {
        System.out.println("主类被加载");
    }
}
