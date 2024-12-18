package com.qiu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiu.entity.SmallType;
import com.qiu.mapper.SmallTypeMapper;
import com.qiu.service.SmallTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品业务处理层
 */
@Service("smallTypeService")
public class SmallTypeServiceImpl extends ServiceImpl<SmallTypeMapper, SmallType> implements SmallTypeService {
    @Autowired
    private SmallTypeMapper smallTypeMapper;
}
