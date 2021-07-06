/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.AccountDao;
import Dao.AccountDetailDao;
import Entity.Account;
import Entity.AccountDetail;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.JavaMailDemo;
import utils.RandomString;
import utils.StringUtil;

/**
 *
 * @author Admin
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/Register"})
public class RegisterServlet extends HttpServlet {

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
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String passwordc = request.getParameter("passwordc");
            String name = request.getParameter("name");
            String mobile = request.getParameter("mobile");
            String address = request.getParameter("address");
            int gender = Integer.parseInt(request.getParameter("gender"));
            int b = 0;
            if (!StringUtil.isEmail(email)) {
                request.setAttribute("mess", "Sai định dạng email");
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            } else {
                AccountDao ad = new AccountDao();
                if (ad.isCheckDuplicateEmail(email)) {
                    request.setAttribute("mess", "Email đã tồn tại");
                    request.getRequestDispatcher("Register.jsp").forward(request, response);
                } else {
                    if (StringUtil.validatePasswordConfirm(password, passwordc)) {
                        AccountDetail ade = AccountDetail.builder()
                                .name(name)
                                .address(address)
                                .mobile(mobile)
                                .gender(gender)
                                .build();
                        b = new AccountDetailDao().addAccountDetail(ade);
                        if (b > 0) {
                            RandomString r = new RandomString();
                            Account c = Account.builder().email(email)
                                    .password(password)
                                    .accountDetailId(b)
                                    .roleId(2)
                                    .status(1)
                                    .activeCode(r.generateRandomString())
                                    .build();
                            if (new AccountDao().addAccount(c)) {
                                String toEmail = c.getEmail();
                                String subject = "Mã code xác nhận của bạn";
                                String text = c.getActiveCode();
                                new JavaMailDemo().sentEmail(toEmail, subject, text);
                                request.getRequestDispatcher("confirmAccount.jsp").forward(request, response);
                            }
                        }

                    } else {
                        request.setAttribute("mess", "Mật khẩu ko đúng định dạng");
                        request.getRequestDispatcher("Register.jsp").forward(request, response);
                    }
                }
            }
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
