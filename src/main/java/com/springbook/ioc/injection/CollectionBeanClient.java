package com.springbook.ioc.injection;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionBeanClient {
    public static void main(String[] args){
        AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

        CollectionBean bean = (CollectionBean)factory.getBean("collectionBean");
        Map<String, String> addressList = bean.getAddressList();
        for(String address : addressList.keySet()){
            System.out.println(address.toString());
        }

        factory.close();
    }
}
