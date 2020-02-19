package com.meiyukai.controller;

import com.meiyukai.domain.QueryVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping(value = "/anno")
@SessionAttributes(value = "msg")   // 等于存入 msg = "hello hello sessionAttribute// " 先往Model（request域）中存
public class AnnoController {

    /**
     * 测试 restful 风格
     */
    @RequestMapping(value = "restful/{param}")
    public String restfylStyle(@PathVariable(value = "param") Integer param){
        System.out.println("param  :  "+param );
        return"anno";
    }


    /**
     * 获取含有 accept 的请求头
     */

    @RequestMapping(value = "/header.do")
    public ModelAndView getRequestHeader(@RequestHeader(value = "Accept" ) String header){
        ModelAndView mav =  new ModelAndView();
        System.out.println("获取到的请求头 ： "+  header);
        mav.setViewName("anno");
        return mav;
    }

    /**
     * 获取含有  JSESSIONID 的 cookie
     */
    @RequestMapping(value = "cookie.do")
    public String getCookie(@CookieValue(value = "JSESSIONID") String cookie){
        System.out.println("cookie 是  ： "+ cookie);
        return "anno";
    }


    /**
     * 第一种方式
     * modelAttribute 会在方法执行之前执行, 对原先没有的数值进行一些封装
     */

    /*@RequestMapping(value = "modelAttribute_1.do")
    public String actualModelAttribute(QueryVo vo){
        System.out.println("实际拿到的 vo  ：  " + vo);
        return "anno";
    }

    @ModelAttribute
    public void originalModelAttribute(QueryVo vo){
        System.out.println("原始数据 :   "  + vo);
        vo.setDate(new Date());
    }*/


    /*--------------------------------------------------------------------------------------------------------------------------------------------------------*/

    /**
     * 第二种方式
     */

    /*@RequestMapping(value = "modelAttribute_2.do")
    public String actualModelAttribute(QueryVo vo){
        System.out.println("实际拿到的数据 ：  "+vo );
        return "anno";
    }

    @ModelAttribute
    public  QueryVo originalModelAttribute(QueryVo vo){
        System.out.println("原始数据 ：    " + vo);
        vo.setDate(new Date());
        return vo;
    }*/


    /*--------------------------------------------------------------------------------------------------------------------------------------------------------*/

    /**
     * 第三种方式
     */

    /*@RequestMapping(value = "/modelAttribute_03")
    public String actualModelAttribute(@ModelAttribute(value = "vo") QueryVo vo){  //从容器中获取QueryVo
        System.out.println("实际获取的数据 ：  "+  vo);
        return "anno";
    }

    *//**
     *
     * @param vo  接受原始数据 vo
     * @param map  新的容器保存更改好的数据
     *//*
    @ModelAttribute
    public void originalModelAttribute(QueryVo vo  , Map<String  , QueryVo > map){  // 单独使用一个map 保存数据
        System.out.println("原始数据为 ：  "+  vo);
        vo.setDate(new Date());
        map.put("vo" , vo);
    }*/



    /*--------------------------------------------------------------------------------------------------------------------------------------------------------*/


    /**
     * 往requestScope中存取数值(存入 model 中即往 request 中存数值)
     * @param model
     * @return
     */
    @RequestMapping(value = "/testSessionAttribute.do")
    public String testSessionAttribute(Model model){
        model.addAttribute("msg" ,  "测试往model中存入数据 并保存在SessionScope 中");
        return "anno";
    }



    /**
     * 从 request 作用域取值
     */
    @RequestMapping(value = "/testGetSessionValue.do")
    public String getSessionAttributeValue(ModelMap modelMap){
        Object msg = modelMap.get("msg");
        System.out.println("从request中获取到：  " + msg);   // 需要使用@SessionAttribute 保存一下
        return"anno";
    }

    /**
     * 清除 Session域中 的数值
     */

    @RequestMapping(value = "testClearSession.do")
    public String testSessionCompleted(SessionStatus sessionStatus){
        sessionStatus.setComplete();  //清除session 作用域中的数值
        return "anno";
    }


























}
