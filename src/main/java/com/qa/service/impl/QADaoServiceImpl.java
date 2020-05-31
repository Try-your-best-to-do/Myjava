package com.qa.service.impl;

import com.qa.dao.QADao;
import com.qa.dao.impl.QADaoImpl;
import com.qa.pojo.QA;
import com.qa.service.QADaoService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QADaoServiceImpl implements QADaoService {
    QADao qaDao = new QADaoImpl();

    public boolean saveQuestion(String question) {
        int flag = 0;
        try {
            QA qa = new QA();
            qa.setQuestion(question);
            flag = qaDao.qaSave(qa);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (flag==1){
            return true;
        }else {
            return false;
        }
    }

    public boolean saveAnswer(Integer id, String Answer) {
        int flag = 0;
        try {
            flag = qaDao.updateAnswer(id, Answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (flag==1){
            return true;
        }else {
            return false;
        }
    }


    public List<QA> findAll() {
        List<QA> qas = new ArrayList<QA>();
        try {
            qas = qaDao.findAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return qas;
    }

    public List<QA> findByName(String question) {
        List<QA> qas = new ArrayList<QA>();
        String q = "%" + question + "%";
        try {
            qas = qaDao.findByName(q);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return qas;
    }
}
