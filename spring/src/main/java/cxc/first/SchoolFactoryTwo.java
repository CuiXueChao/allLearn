package cxc.first;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author cxc
 * @date 2021/5/3
 */

public class SchoolFactoryTwo implements InitializingBean, DisposableBean {

    public SchoolTwo getSchool() {

        MySchoolTwo mySchoolTwo = new MySchoolTwo();
        mySchoolTwo.setSchoolName("许衡实验中学");
        return mySchoolTwo;
    }

    @Override
    public void destroy() {
        System.out.println("销毁SchoolFactoryTwo——Bean");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("初始化SchoolFactoryTwo");
    }
}
