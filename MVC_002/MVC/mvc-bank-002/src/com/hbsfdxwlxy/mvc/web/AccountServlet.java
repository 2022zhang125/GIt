package com.hbsfdxwlxy.mvc.web;

import com.hbsfdxwlxy.mvc.exceptions.AppErrorException;
import com.hbsfdxwlxy.mvc.exceptions.MoneyNotEnoughException;
import com.hbsfdxwlxy.mvc.exceptions.NullAccountException;
import com.hbsfdxwlxy.mvc.service.AccountService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author BelieveSun
 * @version 1.0
 * @since 1.0
 *
 * 主要是作为MVC中的C，也就是控制模块，去调用View和Model
 */
@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取前端数据
        String fromActno = request.getParameter("fromAct");
        String toActno = request.getParameter("toAct");
        double money = Double.parseDouble(request.getParameter("money"));
        AccountService service = new AccountService();
        try {
            // 转账
            service.transfer(fromActno, toActno, money);
            // 转账成功
            response.sendRedirect("success.jsp");
            // 页面展示
        } catch (MoneyNotEnoughException e) {
            response.sendRedirect("moneyerror.jsp");
        } catch (AppErrorException e) {
            response.sendRedirect("apperror.jsp");
        } catch (NullAccountException e) {
            response.sendRedirect("nopersion.jsp");
        }
    }
}
