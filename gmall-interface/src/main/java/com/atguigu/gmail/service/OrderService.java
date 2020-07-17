package com.atguigu.gmail.service;

import com.atguigu.gmail.bean.UserAddress;

import java.util.List;

/**
 * @author hezihao
 * @version 1.0
 * <p>
 * @date 2020/7/16 9:11 下午
 * <p>
 * 订单服务
 */
public interface OrderService {
    /**
     * 初始化订单
     *
     * @param userId 用户Id
     */
    List<UserAddress> initOrder(String userId);
}