package com.hbsfdxwlxy.competition.web;

import com.hbsfdxwlxy.competition.pojo.Dept;
import com.hbsfdxwlxy.competition.pojo.User;
import com.hbsfdxwlxy.competition.service.DMSService;
import com.hbsfdxwlxy.competition.service.impl.DMSDeptServiceImpl;
import com.hbsfdxwlxy.competition.service.impl.DMSUserServiceImpl;
import com.hbsfdxwlxy.competition.utils.SqlSessionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

/**
 * 将所有的请求统一的发到这里进行处理，调用，以及最后的页面转发
 * @author BelieveSun
 * @version 1.0
 * @since 1.0
 */
@WebServlet({"/user/register","/user/exit","/user/login","/dept/list","/dept/add","/dept/delete","/dept/detail","/dept/edit"})
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        String originalPath = request.getRequestURI(); // 获取原始路径
        SqlSession sqlSession = SqlSessionUtil.openSession();

        // 获取用户信息和部门信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");

        if (path.startsWith("/user")) {
            // 如果路径以 "/user" 开头，则分发到 UserServlet
            DMSService userService = new DMSUserServiceImpl();
            if ("/user/login".equals(path)) {
                Boolean login = userService.login(username);
                if(login){
                    // 登录成功
                    System.out.println("登录成功");
                    // 创建session信息
                    HttpSession session = request.getSession(); // 如果有就不创建，如果没有就创建
                    User user = new User(username,password);
                    // 将登录成功的对象放入session域中
                    session.setAttribute("user",user); // 此时会启动User的HttpSessionBindingListener中的ValueBound方法让count++
                    response.sendRedirect(request.getContextPath()+"/dept/list");
                }else{
                    // 登录失败
                    response.sendRedirect(request.getContextPath()+"/error.jsp");
                }
            }else if("/user/register".equals(path)){
                User user = new User(username,password);
                Boolean register = userService.register(user);
                if(register){
                    // 注册成功，跳转到登录界面
                    response.sendRedirect(request.getContextPath()+"/success.jsp");
                }else{
                    // 重定向error页面
                    response.sendRedirect(request.getContextPath()+"/error.jsp");
                }
            }else if("/user/exit".equals(path)){
                userService.exit(request,response);
            }
        } else if (path.startsWith("/dept")) {
            // 如果路径以 "/dept" 开头，则分发到 DeptServlet
            DMSDeptServiceImpl deptService = new DMSDeptServiceImpl();
            if ("/dept/list".equals(path)) {
                List<Dept> deptList = deptService.doList();
                request.setAttribute("deptList",deptList);
                request.getRequestDispatcher("/list.jsp").forward(request, response);
            }else if("/dept/add".equals(path)){
                Dept dept = new Dept(deptno,dname,loc);
                Boolean doAdd = deptService.doAdd(dept);
                if(doAdd){
                    response.sendRedirect(request.getContextPath()+"/dept/list");
                }else{
                    response.getWriter().print("<h1>新增错误</h1>");
                    response.sendRedirect(request.getContextPath()+"/add.jsp");
                }
            }else if("/dept/delete".equals(path)){
                Boolean doDel = deptService.doDel(deptno);
                if(doDel){
                    response.sendRedirect(request.getContextPath()+"/dept/list");
                }else{
                    response.getWriter().print("<h1>删除错误</h1>");
                    response.sendRedirect(request.getContextPath()+"/dept/list");
                }
            }else if("/dept/detail".equals(path)){
                Dept dept = deptService.doDetail(deptno);
                request.setAttribute("dept",dept);
                String f = request.getParameter("f");
                if("d".equals(f)){
                    request.getRequestDispatcher("/detail.jsp").forward(request, response);
                }else{
                    request.getRequestDispatcher("/edit.jsp").forward(request, response);
                }
            }else if("/dept/edit".equals(path)){
                Dept dept = new Dept(deptno,request.getParameter("editName"),request.getParameter("editLoc"));
                Boolean doEdit = deptService.doEdit(dept);
                if(doEdit){
                    response.sendRedirect(request.getContextPath()+"/dept/list");
                }else{
                    response.getWriter().print("<h1>编辑错误</h1>");
                    response.sendRedirect(request.getContextPath()+"/edit.jsp");
                }
            }
        } else {
            // 如果路径既不是 "/user" 也不是 "/dept"，返回 404 错误
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }
}
