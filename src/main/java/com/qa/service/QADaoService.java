package com.qa.service;

import com.qa.pojo.QA;
import java.util.List;

public interface QADaoService {

    //保存问题
    public boolean saveQuestion(String question);

    //保存答案
    public boolean saveAnswer(Integer id,String Answer);

    //查询所有问答
    public List<QA> findAll();

    //模糊查询问答
    public List<QA> findByName(String question);



}
