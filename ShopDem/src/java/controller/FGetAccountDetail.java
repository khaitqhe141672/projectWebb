/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.AccountDetailDao;
import Entity.Account;
import Entity.AccountDetail;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Shado
 */
@WebFilter(filterName = "GetAccountDetail", urlPatterns = {"/checkout.jsp", "/user-index.jsp" , "/admin-index.jsp", "/admin-account.jsp"})
public class FGetAccountDetail implements Filter {

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");
        AccountDetail accountDetail = null;

        if (account == null) {
            resp.sendRedirect("login.jsp");
        } else {
            accountDetail = new AccountDetailDao().getOneAccountDetail(account.getAccountDetailId());
        }

        session.setAttribute("accountDetailInfo", accountDetail);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

}
