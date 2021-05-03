package cxc.entity;

/**
 * @author cxc
 * @date 2021/5/3
 */

public class UserOne {

    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;

    public UserOne(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public UserOne() {
        System.out.println("User已经被加载");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setMyName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
