/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.ProductDao;
import Entity.Cart;
import Entity.Product;
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
@WebServlet(name = "UpdateCartServlet", urlPatterns = {"/update"})
public class UpdateCartServlet extends HttpServlet {

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
            int id = Integer.parseInt(request.getParameter("id"));
            int flag = Integer.parseInt(request.getParameter("flag"));
            Product p = new ProductDao().getOne(id);

            HttpSession session = request.getSession();
            List<Cart> lsCart = (List<Cart>) session.getAttribute("lsCart");
            for (Cart c : lsCart) {
                if (c.getId() == id) {
                    if (flag == 1) {
                        c.setQuantily(c.getQuantily() - 1);
                        if (c.getQuantily() == 0) {
                            lsCart.remove(c);
                            break;
                        }
                    } else {
                        if (c.getQuantily() > p.getQuantity()) {
                            break;
                        } else {
                            c.setQuantily(c.getQuantily() + 1);
                            break;
                        }  
                    }
                }
            }
            int number = 0;
            int total = 0;
            for (Cart c : lsCart) {
                number += c.getQuantily();
                total += c.getQuantily() * c.getPrice();
            }
            session.setAttribute("totalMoney", total);
            session.setAttribute("totalProduct", number);
            session.setAttribute("lsCart", lsCart);
            response.sendRedirect("cart.jsp");
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
