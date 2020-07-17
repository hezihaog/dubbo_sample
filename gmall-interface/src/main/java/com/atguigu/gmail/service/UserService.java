package com.atguigu.gmail.service;

import com.atguigu.gmail.bean.UserAddress;

import java.util.List;

/**
 * @author hezihao
 * @version 1.0
 * <p>
 * @date 2020/7/16 9:04 下午
 * <p>
 * 用户接口
 */
public interface UserService {
    /**
     * 按照用户Id，获取用户的所有搜索地址
     *
     * @param userId 用户Id
     */
    List<UserAddress> getUserAddressList(String userId);
}