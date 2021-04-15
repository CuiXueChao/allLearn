package cxc.jvm.memoryAllocation;

/**
 * 对象内存分配的演示
 * 添加JVM参数： -XX:+PrintGCDetails（打印分配情况）
 *
 * @ClassName:MemoryAllocation
 * @DESCRIPTION:
 * @author: cxc
 * @DATE: 2021/4/8
 */

public class MemoryAllocation {
    private final static int _1m = 1024 * 1024;

    public static void main(String[] args) {

        byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6, allocation7;

        /*
         * 大对象直接进入老年代参数：-Xmx30M -Xms30M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:PretenureSizeThreshold=1024000
         * 这个参数只在 Serial 和ParNew两个收集器下有效。 故需特殊设置
         * 1024 * 1024 > 1024*1000 将被分配至老年代
         */
        //allocation1 = new byte[_1m];

        /*
         * 长期存活的对象进入老年代：-verbose=gc -Xmx20M -Xms20M -Xmn10M -XX:MaxTenuringThreshold=1 -XX:+UseSerialGC
         * -XX:+PrintTenuringDistribution -XX:+PrintGCDetails
         * */

        //allocation1 = new byte[_1m / 4];
        //allocation2 = new byte[4 * _1m];
        //allocation3 = new byte[4 * _1m];
        //allocation3 = null;
        //allocation3 = new byte[4 * _1m];

        /*
         * 动态年龄判断：-verbose=gc -Xmx20M -Xms20M -Xmn10M -XX:MaxTenuringThreshold=15 -XX:+PrintTenuringDistribution
         * -XX:+PrintGCDetails -XX:+UseSerialGC
         * */
        //allocation1 = new byte[_1m / 4];
        //allocation2 = new byte[_1m / 4];
        //allocation3 = new byte[4 * _1m];
        //allocation4 = new byte[4 * _1m];
        //allocation4 = null;
        //allocation4 = new byte[4 * _1m];

        /*
         * 空间分配担保：-Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
         * -XX:-HandlePromotionFailure 默认设置但此参数已失效
         * */

        allocation1 = new byte[_1m * 2];
        allocation2 = new byte[_1m * 2];
        allocation3 = new byte[_1m * 2];
        allocation1 = null;
        allocation4 = new byte[_1m * 2];
        allocation5 = new byte[_1m * 2];
        allocation6 = new byte[_1m * 2];
        allocation4 = null;
        allocation5 = null;
        allocation6 = null;
        allocation7 = new byte[_1m * 2];


    }

}
