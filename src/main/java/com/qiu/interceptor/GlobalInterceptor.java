package com.qiu.interceptor;

import com.qiu.utils.JwtUtils;
import com.qiu.utils.StringUtil;
import io.jsonwebtoken.Claims;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局拦截器
 */
public class GlobalInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path= request.getRequestURI();
        System.out.println(path);
        if(handler instanceof HandlerMethod){//只处理控制器方法的请求，跳过静态资源等其他请求。
            String token = request.getHeader("token");
            if (StringUtil.isEmpty(token)){
                throw new RuntimeException("token不存在");
            }else{
                Claims claims = JwtUtils.validateJWT(token).getClaims();
                if (claims==null){
                    throw new RuntimeException("鉴权失败");
                }else{
                    return true;
                }

            }

        }else{
            return true;
        }

    }
}
