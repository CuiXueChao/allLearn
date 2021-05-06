package cxc.aop.myProxy;

import cxc.aop.myProxy.Static.Game;
import cxc.aop.myProxy.Static.StaticProxy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StaticProxyTest {
    @Test
    @DisplayName("静态代理测试")
    void staticTest() {
        /*
        静态代理通过实现同一个接口，并调用被代理类的方法
        以此种形式对被代理类内容进行不改变原有基础上的增强
        */
        //静态代理的缺点：要对每一个被代理的类都生成一个代理类，工作重复且繁重
        Game cxc = new Game("cxc");
        cxc.login();
        cxc.play();
        StaticProxy proxy = new StaticProxy("cxc");
        proxy.login();
        proxy.play();

    }

}