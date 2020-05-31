package com.qa.test;

import com.qa.pojo.User;
import com.qa.service.UserDaoService;
import com.qa.service.impl.UserDaoServiceImpl;
import org.junit.Test;

public class TestUserService {
    UserDaoService userDaoService = new UserDaoServiceImpl();

    @Test
    public void TestLogin(){
        User user = userDaoService.login("于文华","123");
        if (user!=null){
            System.out.println("用户:"+user.getUsername()+"   登陆成功");
        }else{
            System.out.println("登录失败");
        }

    }

    @Test
    public void TestRegister(){
        if (userDaoService.register("张三","666")){
            System.out.println("注册成功");
        }else{
            System.out.println("注册失败");
        }
    }


    @Test
    public void TestDelete(){
        if (userDaoService.deleteUserById(5)){
            System.out.println("注销成功");
        }else{
            System.out.println("注销失败");
        }
    }

    @Test
    public void TestUpdate(){
        if (userDaoService.updateUsername(6,"王家卫")){
            System.out.println("修改用户名成功");
        }
    }


    @Test
    public void TestUpdatePassword(){
        if (userDaoService.updatePwd(6,"Jack")){
            System.out.println("修改密码成功");
        }else {
            System.out.println("修改失败");
        }
    }
}
