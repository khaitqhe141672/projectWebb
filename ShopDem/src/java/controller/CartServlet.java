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
 * @author Admin
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {

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
            int pId = Integer.parseInt(request.getParameter("id"));
            Product p = new ProductDao().getOne(pId);

            HttpSession session = request.getSession();
            List<Cart> lsCart = (List<Cart>) session.getAttribute("lsCart");
            if (lsCart == null) {
                //chua ton tai gio hang
                lsCart = new ArrayList<>();
                lsCart.add(Cart.builder()
                        .id(p.getId())
                        .name(p.getName())
                        .price(p.getPrice())
                        .quantily(1)
                        .imgName(p.getImgName())
                        .build()
                );
            } else {
                //da ton tai gio hang
                boolean check = true;
                for (Cart c : lsCart) {
                    if (c.getId() == pId) {//check xem hio hang da co chua co r thi +theem 1
                        c.setQuantily(c.getQuantily() + 1);
                        check = false;
                        break;
                    }
                }
                if(check){
                    lsCart.add(Cart.builder()
                            .id(p.getId())
                            .name(p.getName())
                            .price(p.getPrice())
                            .quantily(1)
                            .imgName(p.getImgName())
                            .build()
                    );          
                }
            }
            //tinh tong so lùog san pham trong gio hang
            int number = 0;
            double totalMoney =0;
            for(Cart c: lsCart){
                number += c.getQuantily();
                totalMoney += c.getPrice() * c.getQuantily();
            }
          
            session.setAttribute("totalMoney",totalMoney);
            session.setAttribute("totalProduct",number);
            session.setAttribute("lsCart", lsCart);
            response.sendRedirect("products");
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
