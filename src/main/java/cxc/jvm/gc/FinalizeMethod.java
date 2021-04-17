package cxc.jvm.gc;

/**
 * finalize方法的验证
 *
 * @ClassName:FInalizeMethod
 * @DESCRIPTION:
 * @author: cxc
 * @DATE: 2021/4/15
 */

public class FinalizeMethod {
    private static FinalizeMethod finalizeMethod = null;

    @Override
    protected void finalize() throws Throwable {
        //将该对象赋给一个”GcRoot“
        finalizeMethod = this;
        System.out.println("finalize被执行");
    }

    public static void main(String[] args) throws InterruptedException {
        finalizeMethod = new FinalizeMethod();
        finalizeMethod = null;
        System.gc();
        Thread.sleep(500);
        //第一次查看线程是否被自救
        if (finalizeMethod == null) {
            System.out.println("未自救");
        } else {
            System.out.println("已自救");
            //自救后再次置空，通知gc
            finalizeMethod = null;
            System.gc();
            Thread.sleep(500);
            //finalize只执行一次
            if (finalizeMethod == null) {
                System.out.println("未自救");
            } else {
                System.out.println("已自救");
            }
        }

    }
}
