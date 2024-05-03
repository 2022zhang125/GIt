package com.hbsfdxwlxy.competition.mapper;

import com.hbsfdxwlxy.competition.pojo.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 主要是对Dept部门进行操作而写的接口类
 * @author BelieveSun
 * @since 1.0
 * @version 1.0
 */
public interface DMSDeptMapper extends DMSMapper{
    /**
     * 部门添加操作
     * @param dept 待添加的部门
     * @return 返回成功条数
     */
    int addDept(@Param("dept") Dept dept);

    /**
     * 依照deptno删除对应部门
     * @param deptno 部门编号
     * @return 成功条数
     */
    int deleteByDeptno(String deptno);

    /**
     * 根据deptno对部门进行更新操作
     * @param dept 待更新部门
     * @return 成功条数
     */
    int updateDeptByDeptno(@Param("dept")Dept dept);

    /**
     * 获取所有的部门列表
     * @return 返回List数组中保存着所有的Dept信息
     */
    List<Dept> selectDeptAll();

    /**
     * 通过deptno去查询对应的部门信息
     * @param deptno 部门编号
     * @return 部门
     */
    Dept selectDeptByDeptno(String deptno);
}
