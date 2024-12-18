package com.qiu.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiu.entity.ProductSwiperImage;
import com.qiu.mapper.ProductSwiperImageMapper;
import com.qiu.service.ProductSwiperImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productSwiperImageServiceImpl")
public class ProductSwiperImageServiceImpl extends ServiceImpl<ProductSwiperImageMapper, ProductSwiperImage> implements ProductSwiperImageService {
    @Autowired
    private ProductSwiperImageMapper productSwiperImageMapper;
}
