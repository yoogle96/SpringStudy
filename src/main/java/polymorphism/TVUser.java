package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
    public static void main(String[] args) {

        AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

        TV tv1 = (TV)factory.getBean("tv");
        tv1.powerOn();
        tv1.powerOff();
        tv1.volumeUp();
        tv1.volumeDown();
//        TV tv2 = (TV)factory.getBean("tv");
//        TV tv3 = (TV)factory.getBean("tv");

        factory.close();

    }
}
