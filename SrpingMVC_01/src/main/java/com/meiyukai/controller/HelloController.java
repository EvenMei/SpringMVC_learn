package com.meiyukai.controller;

import com.meiyukai.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping(value = "/hello")
public class HelloController {

    @RequestMapping(value = "/sayHello.do")
    public String hello(){

        try{
            int i  =  1/0;
        }catch(Exception e){
            e.printStackTrace();
        }

        return "hello";
    }

    @RequestMapping(value = "/converterDate.do")
    public String myTime(Date date , Model model){
        System.out.println("date :  "  + date);
        model.addAttribute("date" , new Date());
        return"success";
    }







}
