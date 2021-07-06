/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.OrderDao;
import Dao.OrderDetailDao;
import Entity.Account;
import Entity.Cart;
import Entity.Order;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CheckoutServlet", urlPatterns = {"/check-out"})
public class CheckoutServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String name = request.getParameter("name").trim();
            String phone = request.getParameter("mobile").trim();
            String address = request.getParameter("address").trim();
            String note = request.getParameter("note").trim();
            
            HttpSession session = request.getSession();
            Account ac =  (Account) session.getAttribute("account");
            List<Cart> lsOrder = (List<Cart>) session.getAttribute("lsCart");
            double total = (double) session.getAttribute("totalMoney");
            Order order = Order.builder()
                    .name(name)
                    .mobile(phone)
                    .address(address)
                    .total((double) session.getAttribute("totalMoney"))
                    .note(note)
                    .accountId(ac.getId())
                    .status(1)
                    .build();
            int orderId = new OrderDao().addOrder(order);
            if (orderId > 0) {
                OrderDetailDao odd = new OrderDetailDao();
                boolean result = odd.addOrderDetails((List<Cart>) session.getAttribute("lsCart"), orderId);
                if (result) {
                    session.removeAttribute("lsCart");
                    session.removeAttribute("totalProduct");
                    session.removeAttribute("totalMoney");
                    response.sendRedirect("thanks.jsp");
                } else {
                    new OrderDao().remove(orderId);
                    response.sendRedirect("checkout.jsp");
                }
            } else {
                response.sendRedirect("checkout.jsp");
            }
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
