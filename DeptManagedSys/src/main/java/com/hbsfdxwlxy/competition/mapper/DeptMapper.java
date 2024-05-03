package com.hbsfdxwlxy.competition.mapper;

import com.hbsfdxwlxy.competition.pojo.Dept;
import com.hbsfdxwlxy.competition.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {
    List<Dept> selectDeptAll();
    int addDept(@Param("dept") Dept dept);
    int deleteDept(@Param("deptno") Long deptno);
    int doEdit(@Param("dept") Dept dept);
    Dept doDetail(String deptno);
}
