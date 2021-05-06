package cxc.aop.myProxy.Static;

/**
 * 需要被代理的类
 *
 * @author cxc
 * @date 2021/5/5
 */

public class Game implements IGame {
    private String name;

    public Game() {
    }

    public Game(String name) {
        this.name = name;
    }


    @Override
    public void login() {
        System.out.println(name + "登录！");
    }

    @Override
    public void play() {
        System.out.println(name + "在玩游戏！");
    }
}
