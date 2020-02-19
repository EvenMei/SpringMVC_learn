package com.meiyukai.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionHandler implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        String msg = "发生不可预期的错误   ....  .... ";
        String message = e.getMessage();
        if(message !=null){
            msg = message;
        }
        ModelAndView mav  =  new ModelAndView();
        mav.addObject("msg"  ,  msg);
        mav.setViewName("error");
        return mav;
    }

}
