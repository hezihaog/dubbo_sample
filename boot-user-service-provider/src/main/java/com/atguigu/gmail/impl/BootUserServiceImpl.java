package com.atguigu.gmail.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmail.bean.UserAddress;
import com.atguigu.gmail.service.UserService;
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
//注解@Service，标识暴露给dubbo的服务
@Service
//因为和spring的@Service注解同名，这里用@Component注解也是一样的
@Component
public class BootUserServiceImpl implements UserService {
    public List<UserAddress> getUserAddressList(String userId) {
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