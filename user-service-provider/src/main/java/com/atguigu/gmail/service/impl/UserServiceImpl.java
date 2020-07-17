package com.atguigu.gmail.service.impl;

import com.atguigu.gmail.bean.UserAddress;
import com.atguigu.gmail.service.UserService;

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
public class UserServiceImpl implements UserService {
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