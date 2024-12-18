package com.qiu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiu.entity.WxUserInfo;
import com.qiu.mapper.WxUserMapper;
import com.qiu.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("wxUserService")
public class WxUserServiceImpl extends ServiceImpl<WxUserMapper, WxUserInfo> implements WxUserService {
    @Autowired
    private WxUserMapper wxUserMapper;
}
