package com.qa.dao;

import com.qa.pojo.User;
import org.apache.ibatis.annotations.*;

import java.io.IOException;
import java.util.List;

public interface UserDao {
    /*
     * 查询所有
     * */
    @Select(value = "select * from user")
    List<User> findAll() throws IOException;

    /*
     * 插入数据
     * */
    @Insert(value = "insert into user(username,password)values(#{username},#{password})")
    int userSave(User user) throws IOException;

    /*
     * 更新用户名,注入两个参数需要@Param指定
     * */
    @Update(value = "Update user set username = #{username} where id = #{id}")
    int updateUsername(@Param("id")Integer id,@Param("username")String username) throws IOException;

    /*
     * 更新密码,注入两个参数需要@Param指定
     * */
    @Update(value = "Update user set password = #{password} where id = #{id}")
    int updatePassword(@Param("id")Integer id,@Param("password")String password) throws IOException;


    /*
     * 删除数据
     * */
    @Delete(value = "delete  from user where id = #{id}")
    int userDelete(Integer id) throws IOException;


    /*
     * 查询用户总数
     * */

    @Select(value = "select count(*) from user")
    int countUser() throws IOException;

    /*
     * 模糊查询
     * */
    @Select(value = "select * from user where username like #{username}")
    List<User> findByName(String name) throws IOException;
}
