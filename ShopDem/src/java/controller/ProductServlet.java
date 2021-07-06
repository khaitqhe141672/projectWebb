/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.BrandDao;
import Dao.MaterialDao;
import Dao.ProductDao;
import Entity.Brand;
import Entity.Material;
import Entity.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/products"})
public class ProductServlet extends HttpServlet {

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

            ProductDao pd = new ProductDao();

            int numberProduct = 8; // cho nhận mỗi trang hiển thị là 8sp
            int totalProduct = pd.countTotalProduct(); // tổng số lượng sản phẩm có được trong bảng
            int totalPage = (totalProduct % numberProduct == 0) ? totalProduct / numberProduct : totalProduct / numberProduct + 1;
            // tìm được tổng số lượng page mà mình có được
            List<Integer> lsPage = new ArrayList<>();
            // for này có chức năng hiển thị list page
            for (int i = 1; i <= totalPage; ++i) {
                lsPage.add(i);
            }
            // hiển thị sản phẩm trong 1 trang mà người dùng vừa yêu cầu
            List<Product> lsProduct = pd.getProductPerPage((page * numberProduct - numberProduct), numberProduct);
            List<Product> lsTop = new ProductDao().getTop();
            request.setAttribute("page", page);
            request.setAttribute("lsTop", lsTop);
            lsTop.forEach(System.out::println);
            request.setAttribute("lsPage", lsPage);
            request.setAttribute("lsProduct", lsProduct);
            List<Brand> lsBrand = new BrandDao().getAll();
            List<Material> lsMaterial = new MaterialDao().getAll();
            request.setAttribute("lsBrand", lsBrand);
            request.setAttribute("lsMaterial", lsMaterial);
            request.getRequestDispatcher("index.jsp").forward(request, response);// cau lenh day du lieu ve trang index.jsp

        } catch (IOException | ServletException ex) {

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
