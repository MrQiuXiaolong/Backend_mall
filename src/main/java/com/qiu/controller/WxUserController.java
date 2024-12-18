package com.qiu.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qiu.constant.SystemConstant;
import com.qiu.entity.Result;
import com.qiu.entity.WeixinProperties;
import com.qiu.entity.WxUserInfo;
import com.qiu.service.WxUserService;
import com.qiu.utils.HttpClientUtil;
import com.qiu.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class WxUserController {
    @Autowired
    private WeixinProperties weixinProperties;

    @Autowired
    private HttpClientUtil httpClientUtil;

    @Autowired
    private WxUserService wxUserService;


    @PostMapping("/wxLogin")
    public Result wxLogin(@RequestBody WxUserInfo wxUserInfo){

        // https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
        String jscode2sessionUrl=weixinProperties.getJscode2sessionUrl()+
                "?appid="+weixinProperties.getAppid()+"&secret="+
                weixinProperties.getSecret()+"&js_code="+
                wxUserInfo.getCode()+"&grant_type=authorization_code";

        String result = httpClientUtil.sendHttpGet(jscode2sessionUrl);

        JSONObject jsonObject= JSON.parseObject(result);
        String openid = jsonObject.get("openid").toString();


        WxUserInfo resultWxUserInfo = wxUserService.getOne(new QueryWrapper<WxUserInfo>().eq("openid", openid));
        if (resultWxUserInfo==null){
            System.out.println("用户不存在 插入");
            wxUserInfo.setOpenid(openid);
            wxUserInfo.setRegisterDate(new Date());
            wxUserInfo.setLastLoginDate(new Date());
            wxUserService.save(wxUserInfo);
        }else{
            System.out.println("用户存在 更新");
            resultWxUserInfo.setNickName(wxUserInfo.getNickName());
            resultWxUserInfo.setAvatarUrl(wxUserInfo.getAvatarUrl());
            resultWxUserInfo.setLastLoginDate(new Date());
            wxUserService.updateById(resultWxUserInfo);

        }
        String token = JwtUtils.createJWT(openid, wxUserInfo.getNickName(), SystemConstant.JWT_TTL);
        System.out.println(token);
        Map<String,Object> mapToken =new HashMap<>();
        mapToken.put("token",token);
        return Result.ok(mapToken);
    }
}
