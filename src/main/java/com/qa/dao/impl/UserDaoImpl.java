package com.qa.dao.impl;

import com.qa.dao.UserDao;
import com.qa.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDaoImpl implements UserDao {

    /*
     * 基于注解的mybatis使用
     * */
    private InputStream in;
    private SqlSession session ;
    private UserDao userDao ;

    public void init() throws IOException {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory =  new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession(true);//参数为true表示自动提交
        //4.使用SQLSession创建dao接口的代理对象
        userDao = session.getMapper(UserDao.class);

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
    public List<User> findAll() throws IOException {
        init();
        List<User> users = userDao.findAll();
        close();
        return users;
    }

    /*
     * 插入数据
     * */
    public int userSave(User user) throws IOException {
        init();
        int flag = userDao.userSave(user);
        close();
        return flag;
    }

    /*
     * 更新用户名
     * */
    public int updateUsername(Integer id,String username) throws IOException {
        init();
        int flag = userDao.updateUsername(id,username);
        close();
        return flag;
    }

    /*
     * 更新密码
     * */
    public int updatePassword(Integer id,String password) throws IOException {
        init();
        int flag = userDao.updatePassword(id,password);
        close();
        return flag;
    }



    /*
    * 删除用户
    * */
    public int userDelete(Integer id) throws IOException {
        init();
        int flag = userDao.userDelete(id);
        close();
        return flag;
    }

    /*
    * 查询用户总数
    * */
    public int countUser() throws IOException {
        init();
        int quantity = userDao.countUser();
        close();
        return quantity;
    }

    /*
    * 根据名字模糊查询
    * */
    public List<User> findByName(String name) throws IOException {
        init();
        List<User> users = userDao.findByName(name);
        close();
        return users;
    }
}
