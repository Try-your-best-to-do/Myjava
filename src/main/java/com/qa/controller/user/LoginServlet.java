package com.qa.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.qa.pojo.User;
import com.qa.service.UserDaoService;
import com.qa.service.impl.UserDaoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            //获取用户名和密码
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            //调用service方法，进行用户匹配
            System.out.println(username+"  "+password);
            UserDaoService userService = new UserDaoServiceImpl();
            User user = userService.login(username,password);
            // 转换为json字符串
            String userStr = JSONObject.toJSONString(user);
            response.getWriter().write(userStr);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
