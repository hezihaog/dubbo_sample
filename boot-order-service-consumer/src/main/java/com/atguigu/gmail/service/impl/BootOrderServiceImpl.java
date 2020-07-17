package com.atguigu.gmail.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmail.bean.UserAddress;
import com.atguigu.gmail.service.OrderService;
import com.atguigu.gmail.service.UserService;
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
public class BootOrderServiceImpl implements OrderService {
    /**
     * 依赖注入dubbo的远程服务，因为服务是远程服务，不能用spring的@Autowired注解了
     * 1.url属性，可以实现dubbo直连，直接配置远程服务的ip和端口，不经过注册中心
     * 2.loadbalance属性，负载均衡配置，负载均衡实现有4种，分别是
     *  1）roundrobin：轮训，挨个按顺序分配，第一轮：A-B-C 第二轮：A-B-C
     *  2）leastactive：最小活跃调用数，选中处理速度最快的服务。活跃数指调用前后计数差,优先调用高的，相同活跃数的随机。使慢的提供者收到更少请求，因为越慢的提供者的调用前后计数差会越大。
     *  3）random：随机抽取，dubbo模式使用这种
     *  4）一致性哈希，只要请求过1次，后面的请求都会找到上次的机器进行处理
     */
//    @Autowired
//    @Reference(url = "127.0.0.1:20881")
//    @Reference(loadbalance = "roundrobin")
    @Reference()
    private UserService userService;

    public List<UserAddress> initOrder(String userId) {
        //1.查询用户的搜索地址
        return userService.getUserAddressList(userId);
    }
}