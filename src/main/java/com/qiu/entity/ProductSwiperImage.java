package com.qiu.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@TableName("t_product_swiper_image")
@Data
public class ProductSwiperImage {
    private Integer id;//编号
    private String name;//名称
    private String sort;//排序
    private String productId;//产品id
}
