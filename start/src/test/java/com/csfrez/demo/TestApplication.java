package com.csfrez.demo;

import org.springframework.boot.SpringApplication;

import com.alibaba.cola.container.TestsContainer;

public class TestApplication {

    public static void main(String[] args) {
        //这里填的是Application
        SpringApplication.run(Application.class, args);
        //启动测试容器
        TestsContainer.start();
    }
}
