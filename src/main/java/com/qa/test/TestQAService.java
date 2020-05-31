package com.qa.test;

import com.qa.pojo.QA;
import com.qa.service.QADaoService;
import com.qa.service.impl.QADaoServiceImpl;
import org.junit.Test;

import java.util.List;

public class TestQAService {
    QADaoService qaDaoService = new QADaoServiceImpl();

    @Test
    public void TestFindAll(){
        List<QA> qas = qaDaoService.findAll();
        for (QA qa :qas){
            System.out.println(qa);
        }
    }

    @Test
    public void TestFindByName(){
        List<QA> qas = qaDaoService.findByName("有");
        for (QA qa :qas){
            System.out.println(qa);
        }
    }

    @Test
    public void TestSaveQuestion(){
        if (qaDaoService.saveQuestion("地球美丽吗？")){
            System.out.println("保存成功");
        }
    }

    @Test
    public void TestSaveAnswer(){
        if (qaDaoService.saveAnswer(8,"是的，非常美丽")){
            System.out.println("保存成功");
        }
    }
}
