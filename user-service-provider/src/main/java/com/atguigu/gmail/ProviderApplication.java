package com.atguigu.gmail;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author hezihao
 * @version 1.0
 * <p>
 * @date 2020/7/16 9:40 下午
 */
public class ProviderApplication {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
        context.start();
        //阻塞
        System.in.read();
    }
}