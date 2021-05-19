package cxc.entity;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * 用于进行数据校验的类
 *
 * @author cxc
 * @date 2021/5/19
 */

@Component
public class VerifyUser {

    @NotNull(message = "请写名字")
    private String name;
    @Range(min = 1, max = 150, message = "超脱三界之外？")
    private int age;
    @Past(message = "您难道穿越了么？")
    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private Date birthday;


    @Override
    public String toString() {
        return "VerifyUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public VerifyUser() {
    }

    public VerifyUser(String name, int age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }
}
