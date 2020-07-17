package com.atguigu.gmail.service.stub;

import com.atguigu.gmail.bean.UserAddress;
import com.atguigu.gmail.service.UserService;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hezihao
 * @version 1.0
 * <p>
 * @date 2020/7/17 2:50 下午
 * <p>
 * 本地存根，用于调用远程服务时，先走一遍自己的本地实现，可以在这里做参数验证、拦截、容错以及结果缓存等操作
 * 类似于一个静态代理的拦截器，或者说AOP的效果
 */
public class UserServiceStub implements UserService {
    private final UserService userService;

    /**
     * 必须提供一个有惨构造器，dubbo会传入远程服务的代理对象，通过这个对象，来进行调用远程方法
     *
     * @param userService 远程服务的代理对象
     */
    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("UserServiceStub.getUserAddressList() => 本地存根被调用...");
        try {
            if (StringUtils.isEmpty(userId)) {
                throw new RuntimeException("传入的用户Id不能为空！");
            }
            return userService.getUserAddressList(userId);
        } catch (Exception e) {
            e.printStackTrace();
            //容错处理，如果调用出错，返回空
            return new ArrayList<UserAddress>();
        }
    }
}