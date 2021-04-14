package cxc.jvm.memoryAllocation;

/**
 * <p>
 * 内存溢出 out of memory，是指程序在申请内存时，没有足够的内存空间供其使用，出现out of memory；比如申请了一个integer,但给它存了long才能存下的数，那就是内存溢出。<br>
 * ------借钱缺没钱。
 *
 * </p><br>
 * 内存泄露 memory leak，是指程序在申请内存后，无法释放已申请的内存空间，一次内存泄露危害可以忽略，但内存泄露堆积后果很严重，无论多少内存,迟早会被占光。<br>
 * ------借了钱不还钱
 *
 * @ClassName:StackOverflow
 * @DESCRIPTION:
 * @author: cxc
 * @DATE: 2021/4/10
 */

public class StackOverflowFirst {
    static int count = 0;

    static void redo() {
        count++;
        redo();
    }

    /**
     * JVM设置  -Xss128k 设置线程栈的大小,循环调用方法本机可调用1087次
     * <p>memory leak</p>
     *
     * @param args 虚拟机参数
     * @return void
     * @author cxc
     * @date 2021/4/10
     */
    public static void main(String[] args) {
        try {
            redo();
        } catch (Throwable t) {
            t.printStackTrace();
            System.out.println(count);
        }
    }


}
