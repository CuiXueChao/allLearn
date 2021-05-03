package cxc.entity;

/**
 * @author cxc
 * @date 2021/5/3
 */

public class SchoolTwo {
    private String schoolName;


    @Override
    public String toString() {
        return "SchoolTwo{" +
                "schoolName='" + schoolName + '\'' +
                '}';
    }

    public String getSchoolName() {
        return schoolName;
    }

    void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public SchoolTwo() {
        System.out.println("school已经被加载");
    }


    public SchoolTwo(String schoolName) {
        this.schoolName = schoolName;
        System.out.println("school已经被加载");
    }

    /**
     * 静态工厂方法模式，不同于配置，可干预对象的实例化
     *
     * @return cxc.entity.SchoolTwo
     * @author cxc
     * @date 2021/5/3
     */
    public static SchoolTwo staticFactory() {
        MySchoolTwo mySchoolTwo = new MySchoolTwo();
        mySchoolTwo.setSchoolName("焦作八中");
        return mySchoolTwo;
    }
}
