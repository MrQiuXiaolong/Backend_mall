package com.qiu.config;

import com.qiu.interceptor.GlobalInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自定义配置
 */
@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {
    /**
     * 用来处理静态资源
     * @param registry 用来注册资源处理器
     * addResourceHandler("/image/swiper/**") 表示当访问 /image/swiper/ 路径时，匹配所有以 /image/swiper 开头的请求。
     * addResourceLocations("file:*") 则表示将请求映射到本地 E:* 目录下。
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/swiper/**").addResourceLocations("file:E:/期末作业/微信小程序电商项目/images/swiperImgs/");
        registry.addResourceHandler("/image/bigType/**").addResourceLocations("file:E:/期末作业/微信小程序电商项目/images/bigTypeImgs/");
        registry.addResourceHandler("/image/product/**").addResourceLocations("file:E:/期末作业/微信小程序电商项目/images/productImgs/");
        registry.addResourceHandler("/images/productSwiperImgs/**").addResourceLocations("file:E:/期末作业/微信小程序电商项目/images/productSwiperImgs/");

    }
    @Bean
    public GlobalInterceptor globalInterceptor(){
        return new GlobalInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        String[] patterns=new String[]{"/adminLogin","/product/**","/bigType/**","/user/wxLogin","/weixinpay/**"};
        registry.addInterceptor(globalInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(patterns);

    }
}
