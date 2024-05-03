package com.hbsfdxwlxy.competition.service.impl;

import com.hbsfdxwlxy.competition.pojo.Dept;
import com.hbsfdxwlxy.competition.pojo.User;
import com.hbsfdxwlxy.competition.service.DMSService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * 作为代理接口类，该类去实现我们的业务逻辑接口,使其他两个一致对外
 * @author BelieveSun
 * @version 1.0
 * @since 1.0
 */
public class DMSServiceImpl implements DMSService {
    @Override
    public Boolean login(String username) {
        return false;
    }

    @Override
    public Boolean register(User user) {
        return false;
    }

    @Override
    public void exit(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    public List<Dept> doList() {
        return null;
    }

    @Override
    public Boolean doAdd(Dept dept) {
        return false;
    }

    @Override
    public Boolean doDel(String deptno) {
        return false;
    }

    @Override
    public Boolean doEdit(Dept dept) {
        return false;
    }

    @Override
    public Dept doDetail(String deptno) {
        return null;
    }
}
