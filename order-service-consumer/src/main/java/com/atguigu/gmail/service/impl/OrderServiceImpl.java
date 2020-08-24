package com.atguigu.gmail.service.impl;

import com.atguigu.gmail.bean.UserAddress;
import com.atguigu.gmail.service.OrderService;
import com.atguigu.gmail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hezihao
 * @version 1.0
 * <p>
 * @date 2020/7/16 9:13 下午
 * <p>
 * 订单服务接口实现
 * 步骤：
 * 1.服务提供者注册接口到注册中心（暴露服务）
 * 1）导入dubbo依赖（2.6.2）、zookeeper的客户端（curator）
 * 2）配置服务提供者
 * 2.服务消费者在注册中心订阅服务提供者的服务地址
 */
@Service
public class OrderServiceImpl implements OrderService {
    /**
     * 注入用户服务
     */
    @Autowired
    private UserService userService;

    public List<UserAddress> initOrder(String userId) {
        //1.查询用户的搜索地址
        return userService.getUserAddressList(userId);
    }
}