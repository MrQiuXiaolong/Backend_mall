package com.qiu.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@TableName("t_wxuserinfo")
@Data
public class WxUserInfo implements Serializable {
    private Integer id; //用户编号
    private String openid; //用户唯一id
    private String nickName; //用户昵称
    private String avatarUrl; //用户头像
    @JsonSerialize(using = CustomDateTimeSerializer.class)
    private Date registerDate; //注册日期
    @JsonSerialize(using = CustomDateTimeSerializer.class)
    private Date lastLoginDate; //最后登录日期
    @TableField(select = false,exist = false)//select表示该字段不会查询 exist表示该字段不会映射在数据库
    private String code; //微信用户code 前端传输过来
}
