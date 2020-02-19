package com.meiyukai.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("---- ---- ---- ---- ---- ---- welcome to preHandler page ---- ---- ---- ---- ---- ");
        Object username = request.getSession().getAttribute("username");
        //判断session中是否有值 ， 没有就重新登陆，有就放行
        if(username==null){
            request.getRequestDispatcher("/jsp/login.jsp").forward(request ,  response);
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
