package com.hbsfdxwlxy.competition.mapper;

import com.hbsfdxwlxy.competition.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * 添加用户
     * @param user 待添加用户
     * @return 返回成功条数
     */
    int insertUser(User user);

    /**
     * 向数据库中插入数据
     * @param username 用户名
     * @param password 密码
     * @return 如果有该对象则返回对象，如果没有则返回NULL
     */
    User selectUser(@Param("username") String username, @Param("password") String password);

    /**
     * 查询用户是否存在于数据库中
     * @param name 用户名
     * @return true为在，false为不在
     */
    Boolean selectName(String name);
}
