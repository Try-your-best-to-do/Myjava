package com.qa.dao;

import com.qa.pojo.QA;
import com.qa.pojo.User;
import org.apache.ibatis.annotations.*;

import java.io.IOException;
import java.util.List;

public interface QADao {
    /*
    * 查询所有
    * */
    @Select(value = "select * from qa ")
    List<QA> findAll() throws IOException;

    /*
    * 模糊查询
    * */
    @Select(value = "select * from qa where question like #{questionName}")
    List<QA> findByName(String questionName) throws IOException;

    /*
     * 插入数据
     * */
    @Insert(value = "insert into qa(question,answer)values(#{question},#{answer})")
    int qaSave(QA qa) throws IOException;

    /*
     * 更新问题
     * */
    @Update(value = "Update qa set question = #{question} where id = #{id}")
    int updateQuestion(@Param("id")Integer id, @Param("question")String question) throws IOException;

    /*
     * 更新密码,注入两个参数需要@Param指定
     * */
    @Update(value = "Update qa set answer = #{answer} where id = #{id}")
    int updateAnswer(@Param("id")Integer id,@Param("answer")String answer) throws IOException;


    /*
     * 删除数据
     * */
    @Delete(value = "delete  from qa where id = #{id}")
    int qaDelete(Integer id) throws IOException;


}
