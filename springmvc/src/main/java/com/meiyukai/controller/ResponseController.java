package com.meiyukai.controller;

import com.alibaba.fastjson.JSONObject;
import com.meiyukai.domain.User;
import com.meiyukai.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/response")
@ResponseBody
public class ResponseController {

    @Resource(name = "userService")
    private UserService userService;
    /**
     * 向前端页面传递数据
     * @return
     */
    @RequestMapping(value = "/getUser.do")
    public ModelAndView firstPage(){
        ModelAndView mav  =  new ModelAndView();
        User user = userService.findUserById(2);
        mav.addObject("user" , user);
        mav.setViewName("success");
        return mav;
    }


    /**
     * 使用 jackson 的相关jar 包自动封装成 user bean
     * @param user
     * @return
     */
    @RequestMapping(value = "/modify.do")
    @ResponseBody
    public String modifyUser(@RequestBody  User user){
        System.out.println("进入  modify  中 。。。。 ");
        System.out.println("从前端获取到的user ：  " + user);
        String resonse_json = JSONObject.toJSONString("modify_sucess ! ");
        return resonse_json;
    }


    @RequestMapping(value="test_redirect.do")
    public  void void_redirect(HttpServletResponse response , HttpServletRequest request , Model model) throws Exception{
//        model.addAttribute("msg" ,  "测试重定向");
        request.getSession().setAttribute("msg" , "测试重定向_sessionScope");
        response.sendRedirect(request.getContextPath()+"/jsp/success.jsp");
    }

    @RequestMapping(value="test_requestDispatcher.do")
    public void void_requestDispatcher(HttpServletRequest request , HttpServletResponse response , Model model) throws Exception{
//        model.addAttribute("msg" , "测试请求转发");
//        request.getServletContext().setAttribute("msg" ,  "测试请求转发_servletContext"); //作用范围最大的
//        request.setAttribute("msg" , "测试请求转发_requestScope");
        request.getSession().setAttribute("msg" ,  "测试请求转发_SessionScope");
        request.getRequestDispatcher("/jsp/success.jsp").forward(request , response);
    }



    /**
     * 向页面输入信息
     */

    @RequestMapping(value = "/testWrite.do")
    public void write2Page(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("<h2>测试向页面输入html语句</h2>");
    }


    /**
     * 使用关键字 forward 和 redirect 实现请求转发和重定向
     */

    @RequestMapping(value = "/keyword_forward.do")
    public String testKeyword_forward(){
        return "forward:getUser.do";
    }


    @RequestMapping(value = "/keyword_redirect.do")
    public String testKeyword_redirect(){
        return"redirect:getUser.do";
    }


    /**
     * 在页面上响应json 格式的数据
     * 在浏览器的地址栏中直接输入 项目名+response/responseJsonData
     * 就能看到 json 数据 但是前提是 要先导入三个包 jackson-databind/core/annotations
     * @return
     */

    @RequestMapping(value = "/responseUser.do")
    public User User(){
        return userService.findUserById(1);
    }

























}
