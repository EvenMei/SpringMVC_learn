package com.meiyukai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/interceptor")
public class LoginController {

    @RequestMapping(value = "/login.do")
    public String login(String username , String password , HttpServletRequest request , HttpServletResponse response , Model model){
        System.out.println("username :  " + username+  "    "+  "password : " +  password );

        if("meiyukai".equals(username) && "meiyukai123".equals(password)){
            System.out.println("loginSuccess ! ");
            request.getSession().setAttribute("username" , username);
            model.addAttribute("msg"  ,  "welcome   "+username);
            return "success";
        }else{
            return  "login";
        }


    }


    @RequestMapping(value = "/toLogin.do")
    public String toLogin(){

        return "login";
    }











}
