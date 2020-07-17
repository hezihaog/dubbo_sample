package com.atguigu.gmail.controller;

import com.atguigu.gmail.bean.UserAddress;
import com.atguigu.gmail.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author hezihao
 * @version 1.0
 * <p>
 * @date 2020/7/17 9:01 上午
 */
@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 初始化订单
     */
    @ResponseBody
    @RequestMapping("/initOrder")
    public List<UserAddress> initOrder(@RequestParam("uid") String userId) {
        return orderService.initOrder(userId);
    }
}