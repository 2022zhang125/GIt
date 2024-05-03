package com.hbsfdxwlxy.competition.service;

import com.hbsfdxwlxy.competition.mapper.DeptMapper;
import com.hbsfdxwlxy.competition.pojo.Dept;
import com.hbsfdxwlxy.competition.service.ManagedService;
import com.hbsfdxwlxy.competition.utils.SqlSessionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/dept/main")
public class DeptMainService extends ManagedService {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 控制事务
        try (SqlSession sqlSession = SqlSessionUtil.openSession()) {
            String path = (String) request.getAttribute("ServletPath");
            deptno = request.getParameter("deptno");
            dname = request.getParameter("dname");
            loc = request.getParameter("loc");
            id = Long.valueOf(request.getParameter("id"));

            if("/dept/list".equals(path)) {
                doList(request, response);
            } else if("/dept/add".equals(path)){
                doAdd(request, response);
            } else if("/dept/delete".equals(path)){
                doDel(request, response);
            } else if("/dept/edit".equals(path)){
                doEdit(request, response);
            } else if("/dept/detail".equals(path)){
                doDetail(request, response);
            }
            sqlSession.commit();
            SqlSessionUtil.close(sqlSession);
        }
    }

    private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String f = request.getParameter("f");

        Dept dept = deptMapper.doDetail(deptno);
        if (dept != null) {
            request.setAttribute("dept",dept);
        }
        if("d".equals(f)){
            request.getRequestDispatcher("/detail.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("/edit.jsp").forward(request, response);
        }
    }

    private void doEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Dept dept = new Dept(id, deptno, dname, loc);
        int i = deptMapper.doEdit(dept);
        if (i == 1) {
            response.sendRedirect(request.getContextPath()+"/dept/list");
        }else{
            response.getWriter().print("<h1>编辑错误</h1>");
            response.sendRedirect(request.getContextPath()+"/edit.jsp");
        }
    }

    private void doDel(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 获取请求中的部门编号参数
        String deptno = request.getParameter("deptno");
        // 调用部门删除方法
        int count = deptMapper.deleteDept(Long.parseLong(deptno));
        if (count == 1) {
            response.sendRedirect(request.getContextPath()+"/dept/list");
        }else{
            response.getWriter().print("<h1>删除错误</h1>");
            response.sendRedirect(request.getContextPath()+"/dept/list");
        }
    }

    /**
     * 增加部门
     * @return 成功条数
     */
    private void doAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Dept dept = new Dept(null,deptno,dname,loc);
        int count = deptMapper.addDept(dept);
        if (count == 1) {
            response.sendRedirect(request.getContextPath()+"/dept/list");
        }else{
            response.getWriter().print("<h1>新增错误</h1>");
            response.sendRedirect(request.getContextPath()+"/add.jsp");
        }
    }

    private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List <Dept> deptList = deptMapper.selectDeptAll();
        // 将deptList存到Request域中进行转发操作，在List.jsp页面进行展示操作
        request.setAttribute("deptList",deptList);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }
}

