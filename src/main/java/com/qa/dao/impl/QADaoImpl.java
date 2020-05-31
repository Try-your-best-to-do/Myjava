package com.qa.dao.impl;

import com.qa.dao.QADao;
import com.qa.pojo.QA;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class QADaoImpl implements QADao {
    /*
     * 基于注解的mybatis使用
     * */
    private InputStream in;
    private SqlSession session ;
    private QADao QADao ;

    public void init() throws IOException {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory =  new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession(true);//参数为true表示自动提交
        //4.使用SQLSession创建dao接口的代理对象
        QADao =  session.getMapper(QADao.class);

    }
    public void close() throws IOException {
/*        //提交事务
        session.commit();*/
        //6.释放资源
        session.close();
        in.close();
    }

    /*
     * 查询所有
     * */
    public List<QA> findAll() throws IOException {
        init();
        List<QA> qas = QADao.findAll();
        close();
        return qas;
    }


    /*
    * 根据问题模糊查询
    * */
    public List<QA> findByName(String questionName) throws IOException {
        init();
        List<QA> qas = QADao.findByName(questionName);
        close();
        return qas;
    }

    public int qaSave(QA qa) throws IOException {
        init();
        int flag = QADao.qaSave(qa);
        close();
        return flag;
    }

    public int updateQuestion(Integer id, String question) throws IOException {
        init();
        int flag = QADao.updateQuestion(id,question);
        close();
        return flag;
    }

    public int updateAnswer(Integer id, String answer) throws IOException {
        init();
        int flag = QADao.updateAnswer(id,answer);
        close();
        return flag;
    }

    public int qaDelete(Integer id) throws IOException {
        init();
        int flag = QADao.qaDelete(id);
        close();
        return flag;
    }
}
