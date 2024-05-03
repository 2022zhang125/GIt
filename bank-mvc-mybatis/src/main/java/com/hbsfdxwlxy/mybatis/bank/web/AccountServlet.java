package com.hbsfdxwlxy.mybatis.bank.web;

import com.hbsfdxwlxy.mybatis.bank.dao.AccountDao;
import com.hbsfdxwlxy.mybatis.bank.exceptions.MoneyNotEnoughException;
import com.hbsfdxwlxy.mybatis.bank.exceptions.TransferErrorException;
import com.hbsfdxwlxy.mybatis.bank.service.AccountService;
import com.hbsfdxwlxy.mybatis.bank.service.impl.AccountServiceImpl;
import com.hbsfdxwlxy.mybatis.bank.utils.SqlSessionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * MVC架构中的C，主要起到控制其他部件的作用
 * @author BelieveSun
 * @version 1.0
 * @since 1.0
 */
@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取前端表单时数据
        String fromActno = request.getParameter("fromActno");
        String toActno = request.getParameter("toActno");
        Double money = (Double) Double.parseDouble(request.getParameter("money"));

        try {
            // 业务逻辑层代码
            // 调用transfer(fromActno,toActno,money)
            AccountDao mapper = SqlSessionUtil.openSession().getMapper(AccountDao.class);
            AccountService accountService = new AccountServiceImpl();
            accountService.transfer(fromActno,toActno,money);
            // view展示
            response.sendRedirect(request.getContextPath() + "/success.html");
        } catch (MoneyNotEnoughException e) {
            // 钱不够
            response.sendRedirect(request.getContextPath() + "/MoneyNotEnoughError.html");
        } catch (TransferErrorException e) {
            // 转账失败
            response.sendRedirect(request.getContextPath() + "/TransferError.html");
        }
    }
}
