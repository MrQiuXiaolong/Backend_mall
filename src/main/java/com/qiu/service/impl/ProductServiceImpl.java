package com.qiu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiu.entity.Product;
import com.qiu.mapper.ProductMapper;
import com.qiu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品业务处理层
 */
@Service("productService")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
    @Autowired
    private ProductMapper productMapper;
}
