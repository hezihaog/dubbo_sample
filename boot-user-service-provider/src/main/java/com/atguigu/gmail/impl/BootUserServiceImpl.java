package com.atguigu.gmail.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmail.bean.UserAddress;
import com.atguigu.gmail.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author hezihao
 * @version 1.0
 * <p>
 * @date 2020/7/16 9:05 下午
 * <p>
 * 用户接口实现类
 */
//注解@Service，标识暴露给dubbo的服务，timeout属性配置远程服务调用超时时间，version属性配置多版本功能，可实现灰度
@Service(timeout = 3000, version = "*")
//因为和spring的@Service注解同名，这里用@Component注解也是一样的
@Component("userService1")
public class BootUserServiceImpl implements UserService {
    /**
     * Hystrix容错处理，该方法会被Hystrix代理，来处理容错异常
     *
     * @param userId 用户Id
     */
    @HystrixCommand
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("---------- 线上版本订单服务，版本1.0.0 ----------");

        UserAddress userAddress1 = new UserAddress(1,
                "北京市昌平区xx科技园综合楼3层",
                userId,
                "李老师",
                "010-yyyyy",
                "Y");
        UserAddress userAddress2 = new UserAddress(2,
                "深圳市宝安区西部硅谷大厦B座3层",
                userId,
                "王老师",
                "010-xxxxx",
                "N"
        );
        return Arrays.asList(userAddress1, userAddress2);
    }
}