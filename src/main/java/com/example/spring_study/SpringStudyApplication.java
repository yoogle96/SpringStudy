package com.example.spring_study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import polymorphism.SamsungTV;

@SpringBootApplication
public class SpringStudyApplication {

    public static void main(String[] args) {
//        SamsungTV samsungTV = new SamsungTV();
//        samsungTV.powerOff();
        SpringApplication.run(SpringStudyApplication.class, args);
    }

}
