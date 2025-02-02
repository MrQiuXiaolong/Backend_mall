package com.qiu.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@TableName("t_product")
@Data
public class Product {
    private Integer id; //商品id
    private String name; //名称
    private BigDecimal price; //价格
    private String productIntroImgs; //商品介绍图片
    private String productParaImgs; //商品规格参数图片
    private Integer stock; //库存
    private String proPic="default.jpg"; //商品图片
    private boolean isHost=false; //是否是热门商品
    private boolean isSwiper=false; //是否轮播图商品
    private Integer swiperSort=0; //轮播排序
    private Integer typeId;
    private String swiperPic="default.jpg"; //商品轮播图片
    private String description; //描述

    @JsonSerialize(using = CustomDateTimeSerializer.class)
    private Date hotDateTime;

    @TableField(select = false)
    private List<ProductSwiperImage> productSwiperImageList;

}
