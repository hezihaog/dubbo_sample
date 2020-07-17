package com.atguigu.gmail;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hezihao
 * @version 1.0
 * <p>
 * @date 2020/7/17 9:00 上午
 */
//注解@EnableDubbo，开启dubbo的注解功能
@EnableDubbo
@SpringBootApplication
public class BootConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootConsumerApplication.class, args);
    }
}