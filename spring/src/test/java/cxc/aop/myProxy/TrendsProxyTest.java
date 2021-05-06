package cxc.aop.myProxy;

import cxc.aop.myProxy.trends.Game;
import cxc.aop.myProxy.trends.IGame;
import cxc.aop.myProxy.trends.TrendsProxy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TrendsProxyTest {

    @Test
    @DisplayName("动态代理")
    void trendsTest() {
        IGame proxy = (IGame) TrendsProxy.getProxy(new Game("cxc"));
        proxy.login();
        proxy.play();

    }
}