package com.qa.controller.qa;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qa.pojo.QA;
import com.qa.service.QADaoService;
import com.qa.service.impl.QADaoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SubmitQuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            //获取问题和
            String question = request.getParameter("question");

            QADaoService qaDaoService = new QADaoServiceImpl();
            boolean flag = qaDaoService.saveQuestion(question);
            response.getWriter().write(String.valueOf(flag));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
