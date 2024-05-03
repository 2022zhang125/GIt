package com.hbsfdxwlxy.competition.servlet;

import com.hbsfdxwlxy.competition.bean.Dept;
import com.hbsfdxwlxy.competition.utils.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet({"/dept/list","/dept/add","/dept/delete","/dept/edit","/dept/detail"})
public class DeptServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if("/dept/list".equals(servletPath)) {
            doList(request, response);
        }else if("/dept/add".equals(servletPath)){
            doAdd(request, response);
        }else if("/dept/delete".equals(servletPath)){
            doDel(request, response);
        }else if("/dept/edit".equals(servletPath)){
            doEdit(request, response);
        }else if("/dept/detail".equals(servletPath)){
            doDetail(request, response);
        }
    }

    private void doAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
        Connection conn = null;
        PreparedStatement ps = null;
        int i = 0;
        conn = DBUtil.getConnection();
        String sql = "insert into t_dept(deptno,dname,loc) values(?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,deptno);
            ps.setString(2,dname);
            ps.setString(3,loc);
            i = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(conn,ps,null);
        }
        if (i == 1) {
            response.sendRedirect(request.getContextPath()+"/dept/list");
        }else{
            response.getWriter().print("<h1>新增错误</h1>");
            response.sendRedirect(request.getContextPath()+"/add.jsp");
        }
    }

    private void doDel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String deptno = request.getParameter("deptno");
        Connection conn = null;
        PreparedStatement ps = null;
        int i = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "delete from t_dept where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,deptno);
            i = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn,ps,null);
        }
        if (i == 1) {
            response.sendRedirect(request.getContextPath()+"/dept/list");
        }else{
            response.getWriter().print("<h1>删除错误</h1>");
            response.sendRedirect(request.getContextPath()+"/dept/list");
        }
    }

    private void doEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement ps =null;
        conn = DBUtil.getConnection();
        String dname = request.getParameter("editName");
        String loc = request.getParameter("editLoc");
        String deptno = request.getParameter("deptno");
        String sql = "UPDATE t_dept SET dname = ?, loc = ? WHERE deptno = ?";
        int i = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,dname);
            ps.setString(2,loc);
            ps.setString(3,deptno);
            i = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn,ps,null);
        }
        // 重定向到dept/list页面，可以用Result的返回值若返回值为1时执行重定向，else定向到error的页面
        if (i == 1) {
            response.sendRedirect(request.getContextPath()+"/dept/list");
        }else{
            response.getWriter().print("<h1>编辑错误</h1>");
            response.sendRedirect(request.getContextPath()+"/edit.jsp");
        }
    }

    private void doDetail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String f = request.getParameter("f");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = DBUtil.getConnection();
        // 根据编号来查找对应的信息
        String sql = "select deptno,dname,loc from t_dept where deptno = ?";
        String deptno = request.getParameter("deptno");
        Dept dept = new Dept();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,deptno);
            rs = ps.executeQuery();
            if (rs.next()) {
                // 查询成功了,跳转到detail.JSP去做展示
                dept.setDeptno(deptno);
                dept.setDname(rs.getString("dname"));
                dept.setLoc(rs.getString("loc"));
                request.setAttribute("dept",dept);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn,ps,rs);
        }

        if("d".equals(f)){
            request.getRequestDispatcher("/detail.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("/edit.jsp").forward(request, response);
        }
    }

    private void doList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = DBUtil.getConnection();
        Dept dept = null;
        ArrayList<Dept> deptList = new ArrayList<>();
        String sql = "select deptno,dname,loc from t_dept";
        int i = 0;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                dept = new Dept();
                String deptno = rs.getString("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                // 封装为一个对象
                dept.setDeptno(deptno);
                dept.setDname(dname);
                dept.setLoc(loc);
                // 将对象存进deptList中
                deptList.add(dept);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            DBUtil.close(conn,ps,rs);
        }
        // 进行转发操作
            request.setAttribute("deptList",deptList);
        // 转发的时候是不需要加项目名的！！！！，将Servlet查询的Dept经过转发机制给list.jsp
            request.getRequestDispatcher("/list.jsp").forward(request, response);
    }
}
