package cxc.jvm.memoryAllocation;

/**
 * 对象逃逸分析实例--针对可在虚拟机栈上的对象分配，而避免分配到堆中等待GC
 *
 * @ClassName:ObjectRunAway
 * @DESCRIPTION:
 * @author: cxc
 * @DATE: 2021/4/8
 */

public class ObjectRunAway {

    public static void main(String[] args) {
        /* 使用如下参数不会发生GC
         * -Xmx15m -Xms15m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:+EliminateAllocations
         * +DoEscapeAnalysis:表示开启逃逸分析
         * +EliminateAllocations:表示开启标量替换
         *
         *  使用如下参数都会发生大量GC
         * -Xmx15m -Xms15m -XX:-DoEscapeAnalysis -XX:+PrintGC -XX:+EliminateAllocations
         * -Xmx15m -Xms15m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-EliminateAllocations
         * */
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void alloc() {
        ObjectSize obj = new ObjectSize();
    }


    /**
     * 方法逃逸，即方法内部的变量被方法外部所引用
     *
     * @param
     * @return cxc.jvm.memoryAllocation.ObjectSize
     * @author cxc
     * @date 2021/4/8
     */
    public ObjectSize guideOne() {
        ObjectSize objectSize = new ObjectSize();
        return objectSize;
        /*方法外引用该方法所返回的对象--即该对象逃出了此方法的作用域*/
    }

    /**
     * 无逃逸对象
     *
     * @param
     * @return void
     * @author cxc
     * @date 2021/4/8
     */
    public void guideTwo() {
        ObjectSize objectSize = new ObjectSize();

        /*objectSize对象会随着该方法栈帧释放而一起释放，无需分配到堆空间等待GC*/
    }
}
