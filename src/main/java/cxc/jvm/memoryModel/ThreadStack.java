package cxc.jvm.memoryModel;

/**
 * 线程栈的演示（栈）
 * @ClassName:ThreadStack
 * @DESCRIPTION:
 * @author: cxc
 * @DATE: 2021/4/5
 */

public class ThreadStack {

    public int compute() {
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        print();
        return c;
    }

    public void print(){
        System.out.println("-----print-----");
    }

    public void funOne(){
        int a = 1;
        int b = 5;
        int c = (a + b) * 10;
    }

    public static void main(String[] args) {
        ThreadStack threadStack = new ThreadStack();
        threadStack.compute();
        threadStack.funOne();

    }
}
