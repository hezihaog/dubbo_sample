package com.atguigu.gmail;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

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
 * <p>
 * dubbo整合springboot的三种方式
 * 1）导入dubbo的starter，在application.properties配置属性，使用@Service暴露服务，使用@Reference引用服务，并且Application入口类必须加上@EnableDubbo注解来开启注解功能
 * 2）导入dubbo的starter，保留dubbo的xml配置文件，再在Application入口类上使用@ImportResource注解，引入xml配置文件，使用原始方式，就不需要用注解了
 * 3）使用注解API的方式，就是SpringJavaConfig的方式提供类对象，将每个组件手动创建放到Spring容器中，让dubbo扫描出组件
 * 注意！！！
 * 上面3种配置方式，不能共存，只能选一种，否则会出现重复定义的异常，例如注解和JavaConfig的方式都做了，而@EnableDubbo内部又使用@DubboComponentScan注解，导致2种配置方式都开启了，出现了重复定义
 *
 * 服务容错，使用Hystrix，使用@EnableHystrix注解开启Hystrix，在需要保护的方法上使用@HystrixCommand注解，在调用方，也依赖Hystrix，同样使用@EnableHystrix注解开启Hystrix，在调用的方法上，也加上@HystrixCommand注解
 */
//1）注解方式，使用@EnableDubbo注解，开启基于注解的dubbo功能，例如@Service注解才能生效
@EnableDubbo
//2）xml方式，使用@ImportResource注解导入配置
//@ImportResource(locations = "classpath:provider.xml")
//3）JavaConfig配置方式，需要使用@DubboComponentScan注解配置扫描包的包名，用来扫描到Dubbo的Java配置类，用@EnableDubbo也是可以的，@EnableDubbo注解就已经引用了@DubboComponentScan注解
//@DubboComponentScan(basePackages = "com.atguigu.gmail")
//开启服务容错
@EnableHystrix
@SpringBootApplication
public class BootProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootProviderApplication.class, args);
    }
}