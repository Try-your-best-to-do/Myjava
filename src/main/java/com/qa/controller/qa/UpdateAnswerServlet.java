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
            //获取问题和
            String answer = request.getParameter("answer");
            String Sid = request.getParameter("id");
            int id = Integer.parseInt(Sid);

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
