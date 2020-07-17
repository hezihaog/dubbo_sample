package com.atguigu.gmail;

import com.atguigu.gmail.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author hezihao
 * @version 1.0
 * <p>
 * @date 2020/7/16 10:13 下午
 */
public class ConsumerApplication {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        OrderService orderService = context.getBean(OrderService.class);
        orderService.initOrder("1");
        System.out.println("调用完成");
        //阻塞
        System.in.read();
    }
}