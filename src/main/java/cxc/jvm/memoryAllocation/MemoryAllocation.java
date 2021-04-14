package cxc.jvm.memoryAllocation;

/**
 * 对象内存分配的演示
 * 添加运行JVM参数： -XX:+PrintGCDetails
 *
 * @ClassName:MemoryAllocation
 * @DESCRIPTION:
 * @author: cxc
 * @DATE: 2021/4/8
 */

public class MemoryAllocation {

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6;
        //数组的大小设置及运行结果根据个人电脑配置将有不同
        //allocation1，将占用99%的eden区
        allocation1 = new byte[90000 * 1024];

        //将会把allocation1对象放入老年代，此后的对象忘eden放
        allocation2 = new byte[8000 * 1024];
        allocation3 = new byte[10000 * 1024];
        allocation4 = new byte[10000 * 1024];
        allocation5 = new byte[10000 * 1024];
        //eden放不下，直接进老年代
        allocation6 = new byte[500000 * 1024];
    }

}
