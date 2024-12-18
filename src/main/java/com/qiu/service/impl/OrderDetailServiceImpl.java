package com.qiu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiu.entity.OrderDetail;
import com.qiu.mapper.OrderDetailMapper;
import com.qiu.service.OrderDetailService;
import org.springframework.stereotype.Service;

@Service("orderDetailServiceImpl")
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
}
