package com.qa.controller.qa;

import com.alibaba.fastjson.JSONObject;
import com.qa.service.QADaoService;
import com.qa.service.impl.QADaoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateAnswerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            // 允许跨域访问的域名：若有端口需写全（协议+域名+端口），若没有端口末尾不用加'/'
            response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080/");

            // 允许前端带认证cookie：启用此项后，上面的域名不能为'*'，必须指定具体的域名，否则浏览器会提示
            response.setHeader("Access-Control-Allow-Credentials", "true");

            // 提示OPTIONS预检时，后端需要设置的两个常用自定义头
            response.setHeader("Access-Control-Allow-Headers", "Content-Type,X-Requested-With");
            //获取问题和
            String jsonString = request.getParameter("myData");
            JSONObject qaObject = JSONObject.parseObject(jsonString);
            int id = qaObject.getInteger("id");
            String answer = qaObject.getString("answer");

            QADaoService qaDaoService = new QADaoServiceImpl();
            boolean flag = qaDaoService.saveAnswer(id,answer);
            response.getWriter().write(String.valueOf(flag));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
