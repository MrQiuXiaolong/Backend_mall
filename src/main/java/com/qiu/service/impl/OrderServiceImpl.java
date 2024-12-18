package com.qiu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiu.entity.Order;
import com.qiu.mapper.OrderMapper;
import com.qiu.service.OrderService;
import org.springframework.stereotype.Service;

@Service("orderServiceImpl")
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
}
