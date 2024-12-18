package com.qiu.controller;


import com.qiu.entity.Order;
import com.qiu.entity.OrderDetail;
import com.qiu.entity.Result;
import com.qiu.service.OrderDetailService;
import com.qiu.service.OrderService;
import com.qiu.utils.DateUtil;
import com.qiu.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/my/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;

    /**
     * 创建订单返回订单号
     * @return
     */
    @PostMapping("/create")
    public Result create(@RequestBody Order order, @RequestHeader(value = "token") String token){
        System.out.println(order);
        Claims claims = JwtUtils.validateJWT(token).getClaims();
        //判断是否为空
        if (claims!=null){
            order.setUserId(claims.getId());
        }
        //创建订单
        order.setOrderNo("Mr.Qxl"+ DateUtil.getCurrentDateStr());
        //创建订单日期
        order.setCreateDate(new Date());
        //获取商品详情
        OrderDetail[] orderDetailList =order.getOrderDetail();

        //存入数据库
        orderService.save(order);
        for(int i=0;i<orderDetailList.length;i++){
          OrderDetail orderDetail =  orderDetailList[i];
          orderDetail.setMId(order.getId());
          orderDetailService.save(orderDetail);
        }
        return Result.ok();
    }


    @PostMapping("/list")
    public Result orderList(){
        List<Order> list = orderService.list();
        System.out.println(list);
        Map<String,Object> map = new HashMap<>();
        map.put("message",list);
        return Result.ok(map);
    }
}
