package com.palmer.demo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: xuechengju
 * @Date: Created in 2017/7/17, at 下午3:44
 * @Modified by:
 * @Description:
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping("/process")
    public void processSession(HttpServletRequest request, HttpServletResponse response){
        try {
            HttpSession session = request.getSession();
            session.setAttribute("account", 1);
            String sessionId = session.getId();
            if(session.isNew()){
                response.getWriter().print("session创建成功，session的id是："+sessionId);
            } else{
                response.getWriter().print("服务器已经存在该session了，session的id是："+sessionId);
            }
            session.setMaxInactiveInterval(30*60);//单位为妙

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
