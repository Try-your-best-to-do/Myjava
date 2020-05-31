package com.qa.service;

import com.qa.pojo.User;


public interface UserDaoService {

    //登录接口
    public User login(String username,String password);

    //注册接口
    public boolean register(String username,String password);

    //根据ID删除user
    public boolean deleteUserById(Integer delId);

    //修改用户名
    public boolean updateUsername(int id,String username);

    //根据userId修改密码
    public boolean updatePwd(int id, String pwd);
}
