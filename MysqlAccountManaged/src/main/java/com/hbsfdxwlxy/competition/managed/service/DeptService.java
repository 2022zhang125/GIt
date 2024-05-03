package com.hbsfdxwlxy.competition.managed.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface DeptService extends ManagedService{
    // 部门操作
    // create
    void doAdd(HttpServletRequest request, HttpServletResponse response);

    // delete
    void doDel(HttpServletRequest request, HttpServletResponse response);

    // update
    void doEdit(HttpServletRequest request, HttpServletResponse response);

    // select
    void doDetail(HttpServletRequest request, HttpServletResponse response);

    // selectAll
    void doList(HttpServletRequest request, HttpServletResponse response);
}
