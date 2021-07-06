/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.AccountDao;
import Dao.OrderDao;
import Entity.Account;
import Entity.Order;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tran Quang Khai
 */
@WebServlet(name = "ManagerAccountServlet", urlPatterns = {"/manager-account"})
public class ManagerAccountServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {

            String pageStr = request.getParameter("page");
            int page = 1;

            if (pageStr != null) {
                page = Integer.parseInt(pageStr);
            }
            HttpSession session = request.getSession();
            Account account = (Account) session.getAttribute("account");

            if (account == null) {
                response.sendRedirect("login.jsp");
            } else {
                AccountDao ac = new AccountDao();
                int numberProduct = 4;
                int totalProduct = ac.countTotalAccount();
                int totalPage = (totalProduct % numberProduct == 0) ? totalProduct / numberProduct : totalProduct / numberProduct + 1;
                List<Integer> lsPage = new ArrayList<>();
                for (int i = 1; i <= totalPage; ++i) {
                    lsPage.add(i);
                }
                List<Account> ls = ac.getAccountPerPage((page * numberProduct - numberProduct), numberProduct);
                request.setAttribute("listAccount", ls);
                request.setAttribute("page", page);
                request.setAttribute("lsPage", lsPage);
                request.getRequestDispatcher("admin-account.jsp").forward(request, response);
            }

        } catch (NumberFormatException e) {
            response.sendRedirect("error.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
