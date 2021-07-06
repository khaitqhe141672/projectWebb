/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.BrandDao;
import Dao.ColorDao;
import Dao.MaterialDao;
import Dao.ProductDao;
import Dao.SizeDao;
import Entity.Brand;
import Entity.Color;
import Entity.Material;
import Entity.Product;
import Entity.Size;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
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
@WebServlet(name = "SortServlet", urlPatterns = {"/sort"})
public class SortServlet extends HttpServlet {

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
            List<Product> lsProducts = new ProductDao().getAll();
            List<Brand> lsBrands = new BrandDao().getAll();
            List<Size> lsSize = new SizeDao().getAll();
            List<Color> lsColor = new ColorDao().getAll();
            List<Material> lsMaterial = new MaterialDao().getAll();
            
            int type =Integer.parseInt(request.getParameter("type"));
            if(type== 3){
               lsProducts.sort(Comparator.comparing(Product::getPrice));
            }else{
                lsProducts.sort(Comparator.comparing(Product::getPrice).reversed());
            }
            // set attribute
            request.setAttribute("lsProduct", lsProducts);    // neu k set attribute k hien gi
            request.setAttribute("lsBrand", lsBrands);    // neu k set attribute k hien gi
            request.setAttribute("lsColor", lsColor);    // neu k set attribute k hien gi
            request.setAttribute("lsMaterial", lsMaterial);    // neu k set attribute k hien gi
            request.setAttribute("lsSize", lsSize);    // neu k set attribute k hien gi
            request.getRequestDispatcher("index.jsp").forward(request, response);// cau lenh day du lieu ve trang index.jsp
        } catch (Exception e) {
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
