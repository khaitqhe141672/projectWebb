/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.BrandDao;
import Dao.CategoryDao;
import Dao.ColorDao;
import Dao.MaterialDao;
import Dao.ProductDao;
import Dao.SizeDao;
import Entity.Brand;
import Entity.Category;
import Entity.Color;
import Entity.Material;
import Entity.Product;
import Entity.Size;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "FilterServlet", urlPatterns = {"/filter"})
public class FilterServlet extends HttpServlet {

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
            List<Product> lsProduct = new ArrayList<>();
            List<Brand> lsBrand =  new BrandDao().getAll();
            List<Category> lsCategory =  new CategoryDao().getAll();
            List<Color> lsColor =  new ColorDao().getAll();
            List<Size> lsSize =  new SizeDao().getAll();
            List<Material> lsMaterial =  new MaterialDao().getAll();
            
            int id= Integer.parseInt(request.getParameter("id"));
            int type = Integer.parseInt(request.getParameter("type"));
            if(type == 1){
                lsProduct = new ProductDao().filterByBrand(id);
            }else{
                lsProduct = new ProductDao().filterByMaterial(id);
            }
            
            request.setAttribute("lsProduct",lsProduct);
            request.setAttribute("lsCategory",lsCategory);
            request.setAttribute("lsBrand",lsBrand);
            request.setAttribute("lsColor",lsColor);
            request.setAttribute("lsSize",lsSize);
            request.setAttribute("lsMaterial",lsMaterial);
            
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
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
