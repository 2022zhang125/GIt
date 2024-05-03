package com.hbsfdxwlxy.competition.service.impl;

import com.hbsfdxwlxy.competition.mapper.DMSMapper;
import com.hbsfdxwlxy.competition.mapper.DMSUserMapper;
import com.hbsfdxwlxy.competition.pojo.User;
import com.hbsfdxwlxy.competition.utils.SqlSessionUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * 用户实现类，去实现了我们的代理接口
 * @author BelieveSun
 * @version 1.0
 * @since 1.0
 */
public class DMSUserServiceImpl extends DMSServiceImpl{
    DMSUserMapper userMapper = SqlSessionUtil.openSession().getMapper(DMSUserMapper.class);

    /**
     * 用户登录
     * @param username 用户名
     * @return 是否登录成功
     */
    public Boolean login(String username) {
        Boolean flag = false;

        User selectUserByName = userMapper.selectUserByName(username);
        if (selectUserByName != null) {
            flag = true;
        }
        return flag;
    }

    /**
     * 用户注册
     * @param user 用户对象
     * @return 是否注册成功
     */
    @Override
    public Boolean register(User user) {
        Boolean flag = false;
        int count = userMapper.insertUser(user);
        if (count == 1) {
            flag = true;
        }
        return flag;
    }

    /**
     * 用户退出，销毁Session对象
     * @param request http请求
     * @param response http相应
     * @throws IOException
     */
    public void exit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null & session.getAttribute("user") != null) {
            // 用户退出登录，让session中的User对象被销毁掉
            session.removeAttribute("user"); // 会调用其ValueUnBound方法让count--
            session.invalidate();
            response.getWriter().print("<h1>退出成功</h1>");
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }
    }
}
