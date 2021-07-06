/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.ProductDao;
import Entity.Account;
import Entity.Product;
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
@WebServlet(name = "ManagerProductServlet", urlPatterns = {"/manager-product"})
public class ManagerProductServlet extends HttpServlet {

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

            HttpSession session = request.getSession();
            Account account = (Account) session.getAttribute("account");
            if (account == null) {
                response.sendRedirect("login.jsp");
            } else {
                String pageStr = request.getParameter("page");
                int page = 1;

                if (pageStr != null) {
                    page = Integer.parseInt(pageStr);
                }

                ProductDao pd = new ProductDao();

                int numberProduct = 6;
                int totalProduct = pd.countTotalProduct();
                int totalPage = (totalProduct % numberProduct == 0) ? totalProduct / numberProduct : totalProduct / numberProduct + 1;

                List<Integer> lsPage = new ArrayList<>();
                for (int i = 1; i <= totalPage; ++i) {
                    lsPage.add(i);
                }

                List<Product> lsProduct = pd.getProductPerPage((page * numberProduct - numberProduct), numberProduct);

                request.setAttribute("page", page);
                request.setAttribute("lsPage", lsPage);
                request.setAttribute("lsProduct", lsProduct);
                request.getRequestDispatcher("manager-product.jsp").forward(request, response);
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
