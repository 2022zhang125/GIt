package com.hbsfdxwlxy.competition.managed.dao;

import com.hbsfdxwlxy.competition.managed.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    User selectUser(User user);
    int insertUser(User user);
}
