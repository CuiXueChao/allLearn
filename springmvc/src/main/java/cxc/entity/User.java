package cxc.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author cxc
 * @date 2021/5/10
 */

@Component
public class User {

    private String name;
    private Integer age;
    private List<String> hobby;
    private Map<String, String> parents;
    private String[] nickname;
    private User user;
    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private Date birthday;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobby=" + hobby +
                ", parents=" + parents +
                ", nickname=" + Arrays.toString(nickname) +
                ", user=" + user +
                ", birthday=" + birthday +
                '}';
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public User(String name, Integer age, List<String> hobby, Map<String, String> parents, String[] nickname,
                User user, Date birthday) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
        this.parents = parents;
        this.nickname = nickname;
        this.user = user;
        this.birthday = birthday;
    }

    public User() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    public Map<String, String> getParents() {
        return parents;
    }

    public void setParents(Map<String, String> parents) {
        this.parents = parents;
    }

    public String[] getNickname() {
        return nickname;
    }

    public void setNickname(String[] nickname) {
        this.nickname = nickname;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
