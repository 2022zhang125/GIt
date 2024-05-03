package com.hbsfdxwlxy.managed.mapper;

import com.hbsfdxwlxy.managed.pojo.User;

import java.util.List;

/**
 * 主要是控制项目的用户添加
 */
public interface UserMapper {
    /**
     * 向数据库中添加用户
     * @param user 待添加的用户对象
     * @return 返回成功条数
     */
    int insert(User user);
}
