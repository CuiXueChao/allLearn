package cxc.aop.myProxy.Static;

/**
 * @author cxc
 * @date 2021/5/5
 */

public class StaticProxy implements IGame {
    private String name;
    private Game game;

    public StaticProxy(String name) {
        this.name = name;
        this.game = new Game(name);
    }

    @Override
    public void login() {
        System.out.println("代理拿到" + name + "的账号！");
        game.login();
    }

    @Override
    public void play() {
        System.out.println("代理在玩" + name + "的账号！");
    }
}
