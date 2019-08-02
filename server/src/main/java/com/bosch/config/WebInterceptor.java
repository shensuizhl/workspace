package com.bosch.config;

import com.bosch.vo.UserVO;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: demo
 * @description: 自定义拦截器
 * @author: wjy
 * @create: 2019-06-13 15:53
 */

public class WebInterceptor  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        boolean flag = true;
        UserVO user = (UserVO)request.getSession().getAttribute("user");
        if(user==null){
            response.sendRedirect("/demo/login.html");
            flag = false;
        }
        return flag;
    }
}
