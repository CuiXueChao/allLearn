package cxc.jvm;

import org.junit.jupiter.api.Test;

/**
 * 该类将体现String在虚拟机中对象创建的多中情况
 * <p>
 * jdk8-字符串常量池存在于堆中，intern方法，如果常量池中存在该对象则返回，否则将返回堆中该对象
 * </p>
 *
 * @PROJECT_NAME: allLearn
 * @ClassName: TheString
 * @DESCRIPTION:
 * @author: cxc
 * @date: 2021/4/28
 */

public class TheStringTest {

    /**
     * 相同的字符串针对不同的引用对象，引用对象指向的都是字符串常量池中的同一个字符串
     * <br>故 one == two
     * <br><br>three 在经过编译器的优化之后也会变成 cxc 故 one == three
     *
     * @param
     * @return void
     * @author cxc
     * @date: 2021/4/28
     */
    @Test
    void firstStringTest() {
        String one = "cxc";
        String two = "cxc";
        //经过编译器的优化将变为 cxc
        /*
         * String a  = "a";
         * String b  = "b";
         * String c  = "c";
         * String s1  =  a + b + c;
         * 此种情况将无法进行优化
         */
        String three = "c" + "x" + "c";
        //true
        System.out.println(one == two);
        //true
        System.out.println(one == three);
    }

    @Test
    void secondStringTest() {
        String one = "cxc";
        String two = new String("cxc");
        String three = "c" + "x" + new String("c");
        //false
        System.out.println(one == two);
        //false
        System.out.println(one == three);
        //false
        System.out.println(two == three);
    }

    @Test
    void thirdTest() {
        //没有出现"计算机技术"字面量，所以不会在常量池里生成"计算机技术"对象，故会将引用指向堆中的对象
        String str2 = new StringBuilder("计算机").append("技术").toString();
        //true
        System.out.println(str2 == str2.intern());
    }

}
