package com.qa.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.qa.service.UserDaoService;
import com.qa.service.impl.UserDaoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResetPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            // 允许跨域访问的域名：若有端口需写全（协议+域名+端口），若没有端口末尾不用加'/'
            response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080/");

            // 允许前端带认证cookie：启用此项后，上面的域名不能为'*'，必须指定具体的域名，否则浏览器会提示
            response.setHeader("Access-Control-Allow-Credentials", "true");

            // 提示OPTIONS预检时，后端需要设置的两个常用自定义头
            response.setHeader("Access-Control-Allow-Headers", "Content-Type,X-Requested-With");
            //获取用户id和密码
            String jsonString = request.getParameter("myData");
            JSONObject userObject = JSONObject.parseObject(jsonString);
            int id = userObject.getInteger("id");
            String password = userObject.getString("password");
            //调用service方法，进行用户匹配
            UserDaoService userService = new UserDaoServiceImpl();
            boolean flag = userService.updatePwd(id,password);
            response.getWriter().write(String.valueOf(flag));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
