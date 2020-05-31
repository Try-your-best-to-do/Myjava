package com.qa.test;

import com.qa.dao.QADao;
import com.qa.dao.impl.QADaoImpl;
import com.qa.pojo.QA;
import java.io.IOException;
import java.util.List;

public class TestQADao {
    QADao qaDao = new QADaoImpl();

        /*
        * 测试查询所有
        * */
    @org.junit.Test
    public void testFindAll(){
        try {
            List<QA> qas = qaDao.findAll();
            for (QA qa:qas
            ) {
                System.out.println(qa);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    * 测试模糊查询
    * */
    @org.junit.Test
    public void testFindByName(){
        try {
            List<QA> qas = qaDao.findByName("%会%");
            for (QA qa:qas
            ) {
                System.out.println(qa);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*
    * 测试保存问题和答案
    * */
    @org.junit.Test
    public void testSaveQA(){
        try {
            QA qa = new QA();
            qa.setAnswer("大海");
            qa.setQuestion("你是？");
            int flag = qaDao.qaSave(qa);
            if (flag==1){
                System.out.println("成功保存");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    * 测试删除问题和答案
    * */
    @org.junit.Test
    public void testDelete(){
        try {
            int flag = qaDao.qaDelete(7);
            if (flag==1){
                System.out.println("成功删除");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*
    * 测试更新问题
    * */
    @org.junit.Test
    public void testUpdateQuestion(){
        try {
            int flag = qaDao.updateQuestion(6,"地球有多大？");
            if (flag==1){
                System.out.println("成功修改");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    * 测试更新答案
    * */
    @org.junit.Test
    public void testUpdateAnswer(){
        try {
            int flag = qaDao.updateAnswer(6,"很大很大");
            if (flag==1){
                System.out.println("成功修改");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
