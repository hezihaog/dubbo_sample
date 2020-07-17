package com.atguigu.gmail.config;

import com.alibaba.dubbo.config.*;
import com.atguigu.gmail.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author hezihao
 * @version 1.0
 * <p>
 * @date 2020/7/17 3:16 下午
 * <p>
 * SpringJavaConfig的方式，配置dubbo的组件
 */
@Configuration
public class MyDubboConfig {
    /**
     * 提供Application标签的功能
     * 相当于：dubbo.application.name=boot-user-service-provider
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig config = new ApplicationConfig();
        config.setName("boot-user-service-provider");
        return config;
    }

    /**
     * 提供注册中心配置
     * 相当于：
     * dubbo.registry.address=127.0.0.1:2181
     * dubbo.registry.protocol=zookeeper
     */
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig config = new RegistryConfig();
        config.setAddress("127.0.0.1:2181");
        config.setProtocol("zookeeper");
        return config;
    }

    /**
     * 提供通信协议的配置
     * 相当于：
     * dubbo.protocol.name=dubbo
     * dubbo.protocol.port=20881
     */
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig config = new ProtocolConfig();
        config.setName("dubbo");
        config.setPort(20881);
        return config;
    }

    /**
     * 提供暴露服务的配置
     * 相当于
     * <dubbo:service interface="com.atguigu.gmail.service.UserService" ref="userServiceImpl1"
     * version="1.0.0">
     * <dubbo:method name="getUserAddressList" timeout="1000"/>
     * </dubbo:service>
     */
    @Bean
    public ServiceConfig<UserService> userServiceConfig(@Qualifier("userService1") UserService userService) {
        ServiceConfig<UserService> serviceConfig = new ServiceConfig<>();
        //配置暴露的服务的接口
        serviceConfig.setInterface(UserService.class);
        //配置暴露的服务的具体实现，spring会自动注入到参数上
        serviceConfig.setRef(userService);
        //设置版本
        serviceConfig.setVersion("1.0.0");
        //配置每一个方法的信息
        MethodConfig methodConfig = new MethodConfig();
        //设置方法名
        methodConfig.setName("getUserAddressList");
        //设置超时时间
        methodConfig.setTimeout(1000);
        //将MethodConfig关联到Service的配置中
        serviceConfig.setMethods(Arrays.asList(methodConfig));
        return serviceConfig;
    }

    /**
     * 提供监控中心的配置
     */
    @Bean
    public MonitorConfig monitorConfig() {
        MonitorConfig config = new MonitorConfig();
        config.setProtocol("registry");
        return config;
    }
}