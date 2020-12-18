package com.example.stock.Config;

import com.example.stock.Interceptor.SessionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author huwen
 * @date 2019/3/23
 */
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
    //不同的角色设置不同的SessionKey
    public final static String SESSION_KEY = "user";
    public final static String ISADMIN= "isAdmin";
    public final static String ISUSE = "isUse";
    public final static String GRAPH = "graph";

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new SessionInterceptor());
        //不登陆也能访问的界面不予拦截
//        interceptorRegistration.excludePathPatterns(
//        		"/login", "/index", "/signUp", "/register", "/error",
//                "/**/*.css", "/**/*.js", "/**/*.png", "/**/*.gif", "/**/*.jpg", "/**/*.jpeg", "/font/**");
        //其他界面都拦截，进入登陆角色判断逻辑
        interceptorRegistration.addPathPatterns("/**");
    }


}
