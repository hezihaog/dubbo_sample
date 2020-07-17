package com.atguigu.gmail.service;

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
    void initOrder(String userId);
}