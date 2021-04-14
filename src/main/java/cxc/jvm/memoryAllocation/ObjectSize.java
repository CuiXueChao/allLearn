package cxc.jvm.memoryAllocation;

import org.openjdk.jol.info.ClassLayout;

/**
 * 对象的大小探索
 *
 * @ClassName:ObjectSize
 * @DESCRIPTION:
 * @author: cxc
 * @DATE: 2021/4/8
 */

public class ObjectSize {
    public static void main(String[] args) {
        //查看空对象的情况
        ClassLayout layout = ClassLayout.parseInstance(new Object());
        System.out.println(layout.toPrintable());
        /* Mark Word占8字节
         * 类型指针占4字节 --对齐填充4字节
         * Instance size: 16 bytes--实例大小
         * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total --损失了4字节
         * */


        System.out.println("--------------------------------");
        ClassLayout layout1 = ClassLayout.parseInstance(new int[]{});
        System.out.println(layout1.toPrintable());
        /* Mark Word占8字节
         * 类型指针占4字节 --对齐填充4字节
         * 数组对象会增加一个数组长度字段
         * Instance size: 16 bytes
         * Space losses: 0 bytes internal + 0 bytes external = 0 bytes total
         * */

        System.out.println("--------------------------------");
        ClassLayout layout2 = ClassLayout.parseInstance(new FirstClass());
        System.out.println(layout2.toPrintable());
        /* Mark Word占8字节
         * 类型指针占4字节 --对齐填充4字节
         * Instance size: 32 bytes
         * Space losses: 3 bytes internal + 4 bytes external = 7 bytes total
         * */
    }


    public static class FirstClass {
        //8B mark word
        //4B Klass Pointer  如果关闭压缩-XX:-UseCompressedClassPointers或-XX:-UseCompressedOops，则占用8B
        int id;        //4B
        String name;   //4B  如果关闭压缩-XX:-UseCompressedOops，则占用8B
        byte b;        //1B  会为该字段也填充3字节
        Object o;      //4B  如果关闭压缩-XX:-UseCompressedOops，则占用8B
    }

}
