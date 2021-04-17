package cxc.jvm.bytecode;

/**
 * 字节码分析类，将阅读部分字节码
 *
 * @ClassName:Bytecode
 * @DESCRIPTION:
 * @author: cxc
 * @DATE: 2021/4/17
 */

public class Bytecode {
    private String userName;
    private final int AGE = 10;

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
