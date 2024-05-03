package com.hbsfdxwlxy.competition.mapper;

import com.hbsfdxwlxy.competition.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 该接口用于实现用户的操作
 * @author BelieveSun
 * @version 1.0
 * @since 1.0
 */
public interface DMSUserMapper extends DMSMapper{
    /**
     * 新增用户
     * @param user 待增加用户对象
     * @return 成功条数
     */
    int insertUser(@Param("user") User user);

    /**
     * 按照名字进行删除操作
     * @param username 用户名
     * @return 成功条数
     */
    int deleteUserByName(String username);

    /**
     * 更新用户数据
     * @param user 待更新用户对象
     * @return 成功条数
     */
    int updateUser(User user);

    /**
     * 查询所有用户对象
     * @return List集合中，包含所有用户对象
     */
    List<User> selectUserAll();


    /**
     * 通过用户名来查找对应的用户对象
     * @param username 用户名
     * @return 用户对象
     */
    User selectUserByName(String username);
}
