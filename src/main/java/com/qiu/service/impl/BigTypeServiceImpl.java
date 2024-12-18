package com.qiu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiu.entity.BigType;
import com.qiu.entity.Product;
import com.qiu.mapper.BigTypeMapper;
import com.qiu.mapper.ProductMapper;
import com.qiu.service.BigTypeService;
import com.qiu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品业务处理层
 */
@Service("bigTypeService")
public class BigTypeServiceImpl extends ServiceImpl<BigTypeMapper, BigType> implements BigTypeService {
    @Autowired
    private BigTypeMapper bigTypeMapper;
}
