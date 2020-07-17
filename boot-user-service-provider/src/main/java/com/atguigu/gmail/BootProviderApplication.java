package com.atguigu.gmail;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hezihao
 * @version 1.0
 * <p>
 * @date 2020/7/17 9:00 上午
 * <p>
 * SpringBoot方式，使用Dubbo
 * 步骤：
 * 1.导入dubbo-starter依赖
 * 2.导入dubbo的其他依赖（例如zookeeper的客户端）
 */
@EnableDubbo//开启基于注解的dubbo功能，例如@Service注解才能生效
@SpringBootApplication
public class BootProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootProviderApplication.class, args);
    }
}