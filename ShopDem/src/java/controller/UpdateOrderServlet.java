/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.OrderDao;
import Dao.OrderDetailDao;
import Dao.ProductDao;
import Entity.OrderDetail;
import Entity.Product;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tran Quang Khai
 */
@WebServlet(name = "UpdateOrderServlet", urlPatterns = {"/update-order"})
public class UpdateOrderServlet extends HttpServlet {

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
            int status = Integer.parseInt(request.getParameter("cbo"));
            OrderDao dao = new OrderDao();
            ProductDao pdao = new ProductDao();
            List<OrderDetail> ls = new OrderDetailDao().getOneAccount(id);
            int sumQuantity = 0;
            if (status == 3) {
                for (OrderDetail o : ls) {
                    int quantity = o.getQuantity();
                    int proID = o.getProductId();
                    Product p = new ProductDao().getOne(proID);
                    sumQuantity = p.getQuantity() - quantity;
                    dao.updateStatus(id, status);
                    pdao.updateQuantity(p.getId(), sumQuantity);
                }
            } else {
                dao.updateStatus(id, status);
            }
            response.sendRedirect("manager-order");
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
