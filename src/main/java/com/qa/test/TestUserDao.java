package com.qa.test;

import com.qa.dao.UserDao;
import com.qa.dao.impl.UserDaoImpl;
import com.qa.pojo.User;


import java.io.IOException;
import java.util.List;

public class TestUserDao {
    UserDao userDao = new UserDaoImpl();

    /*
    * 测试查询所有用户
    * */
@org.junit.Test
    public void testFindAll(){
    try {
        List<User> users = userDao.findAll();
        for (User user:users
             ) {
            System.out.println(user);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    /*
    * 测试模糊查询用户
    * */
    @org.junit.Test
    public void testFindByName(){
        try {
            List<User> users = userDao.findByName("%我%");
            for (User user:users
            ) {
                System.out.println(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    * 测试保存用户
    * */
    @org.junit.Test
    public void testSaveUser(){
        try {
            User user = new User();
            user.setUsername("轻轻地");
            user.setPassword("66666666");
            int flag = userDao.userSave(user);
            if (flag==1){
                System.out.println("成功保存");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    * 测试删除用户
    * */
    @org.junit.Test
    public void testDelete(){
        try {
            int flag = userDao.userDelete(4);
            if (flag==1){
                System.out.println("成功删除");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    * 测试更新密码
    * */
    @org.junit.Test
    public void testUpdatePassword() {
        try {
            int flag = userDao.updatePassword(4, "45665455");
            if (flag == 1) {
                System.out.println("成功修改");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
