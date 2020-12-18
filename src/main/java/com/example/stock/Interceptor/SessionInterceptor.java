package com.example.stock.Interceptor;

import com.example.stock.Config.InterceptorConfiguration;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author huwen
 * @date 2019/3/23
 */
public class SessionInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception{
        HttpSession session = httpServletRequest.getSession();
        if(null!=session && null!=session.getAttribute(InterceptorConfiguration.SESSION_KEY)) {
            String url = httpServletRequest.getRequestURI();
            if (url.contains("/testUser")) {
//                if (null != session.getAttribute(InterceptorConfiguration.ISUSE)) {
//                    return true;
//                } else {
//                    return false;
//                }
            	return true;
            } else if(url.contains("/testAdmin")) {
//            	if (null != session.getAttribute(InterceptorConfiguration.ISADMIN)) {
//                    return true;
//                } else {
//                    return false;
//                }
            	return true;
            }
            else {
            	return true;
            }
        }
        return false;
    }
}
