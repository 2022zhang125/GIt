package com.hbsfdxwlxy.competition.managed.dao;

import com.hbsfdxwlxy.competition.managed.pojo.Dept;

/**
 * 该Dao的接口类，主要用于解决，部门表的CRUD操作
 */
public interface DeptDao {
    // 增加部门操作

    /**
     * 增加部门用户
     * @param dept 待增加的部门类
     * @return 成功条数
     */
    public int addDept(Dept dept);

}
