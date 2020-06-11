package com.qa.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.qa.service.UserDaoService;
import com.qa.service.impl.UserDaoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResetUsernameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            //获取用户名和id
            String username = request.getParameter("username");
            String Sid = request.getParameter("id");
            int id = Integer.parseInt(Sid);
            //调用service方法，进行用户匹配
            UserDaoService userService = new UserDaoServiceImpl();
            boolean flag = userService.updateUsername(id,username);
            response.getWriter().write(String.valueOf(flag));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
