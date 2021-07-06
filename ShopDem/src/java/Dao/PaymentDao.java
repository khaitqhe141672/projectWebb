/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.OrderDetail;
import Entity.Payment;
import JDBC.SQLServerConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class PaymentDao implements IMethod<Payment>{

    @Override
    public List<Payment> getAll() {
        String query = "select * from Payment ";
        List<Payment> ls = new ArrayList<>();
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {//chuan bi cho cta thuc hien cau lenh query 
            ResultSet rs = ps.executeQuery();//sau khi thuc hien cau ps been tren thi no se gan lai vao rs
            while (rs.next()) {//rs.next laf next tung hang ngang cua bang
                Payment p = Payment.builder()
                        .customerId(rs.getInt(1))
                        .checkNumber(rs.getString(2))
                        .paymentDate(rs.getString(3))
                        .amount(rs.getDouble(4))
                        .build();
                ls.add(p);
            }
            return ls;
        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thif nos se bao loi
        }
        return null;
    }

    @Override
    public Payment getOne(int id) {
        String query = "select * from Payment where id =? ";
        
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {//chuan bi cho cta thuc hien cau lenh query 
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();//sau khi thuc hien cau ps been tren thi no se gan lai vao rs
            while (rs.next()) {//rs.next laf next tung hang ngang cua bang
                Payment p = Payment.builder()
                        .customerId(rs.getInt(1))
                        .checkNumber(rs.getString(2))
                        .paymentDate(rs.getString(3))
                        .amount(rs.getDouble(4))
                        
                        .build();
                return p;
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thif nos se bao loi
        }
        return null;
    }

    @Override
    public boolean add(Payment obj) {
        String query = "Insert into Payment Values (?,?,?,?)";
        int check = 0;
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {

            ps.setObject(1, obj.getCustomerId());
            ps.setObject(2, obj.getCheckNumber());
            ps.setObject(3, obj.getPaymentDate());
            ps.setObject(4, obj.getAmount());

            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thi no se bao loi
        }
        return check > 0;
    }

    @Override
    public boolean update(int id, Payment obj) {
        String query = "update Payment set  checknumber = ?, paymentdate = ?, amount = ? where customerId= ? ";
        int check = 0;
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(4, id);
            ps.setObject(1, obj.getCheckNumber());
            ps.setObject(2, obj.getPaymentDate());
            ps.setObject(3, obj.getAmount());
            
            
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thi no se bao loi
        }
        return check > 0;
    }

    @Override
    public boolean remove(int id) {
         String query = "delete from Payment where CustomerID = ?";
        int check = 0;
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thi no se bao loi
        }
        return check > 0;
    }
    
    public static void main(String[] args) {
        PaymentDao p = new PaymentDao();
        Payment a = Payment.builder()
//                .customerId(1)
                .checkNumber("00")
                .paymentDate("2000/12/12")
                .amount(10)
                .build();
        System.out.println(p.remove(1));
    }
    
}
