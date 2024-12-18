package com.qiu.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


@TableName("t_order")
@Data
public class Order {
    private Integer id; //编号
    private String orderNo; //订单号
    private String userId; //openid微信用户ID
    @TableField(select = false)
    private WxUserInfo wxUserInfo; //微信用户
    private BigDecimal totalPrice; //总价
    private String address; //收货地址
    private String consignee; //收获人
    private String telNumber; //电话号码
    @JsonSerialize(using= CustomDateTimeSerializer.class)
    private Date createDate; //订单创建日期
    @JsonSerialize(using= CustomDateTimeSerializer.class)
    private Date payDate; //订单支付日期

    private Integer status; //支付状态 1->未支付 2->已经支付/待发货 3->退货/退款


    @TableField(select = false,exist = false)
    private OrderDetail[] orderDetail; //订单详情
}
