package com.qa.controller.qa;

import com.alibaba.fastjson.JSON;
import com.qa.pojo.QA;
import com.qa.service.QADaoService;
import com.qa.service.impl.QADaoServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FindAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            QADaoService qaDaoService = new QADaoServiceImpl();
            List<QA> qas = qaDaoService.findAll();
            String qasString = JSON.toJSONString(qas);
            response.getWriter().write(qasString);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
