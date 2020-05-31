package com.qa.service.impl;

import com.qa.dao.UserDao;
import com.qa.dao.impl.UserDaoImpl;
import com.qa.pojo.User;
import com.qa.service.UserDaoService;

import java.io.IOException;
import java.util.List;

public class UserDaoServiceImpl implements UserDaoService {
    private UserDao userDao = new UserDaoImpl();

    //登录
    public User login(String username, String password) {
        try {
            List<User> users = userDao.findAll();
            for (User user:users
                 ) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                    return user;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //注册
    public boolean register(String username, String password) {
        try {
            List<User> users = userDao.findAll();
            for (User user:users
            ) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                    return false;
                }
            }
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            int flag = userDao.userSave(user);
            if (flag == 1){
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    //注销用户
    public boolean deleteUserById(Integer delId) {
        try {
            int flag = userDao.userDelete(delId);
            if (flag == 1){
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateUsername(int id,String username) {
        try {
            int flag = userDao.updateUsername(id,username);
            if (flag == 1){
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updatePwd(int id, String password) {
        try {
            int flag = userDao.updateUsername(id,password);
            if (flag == 1){
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
