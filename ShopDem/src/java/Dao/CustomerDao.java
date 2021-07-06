/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Brand;
import Entity.Customer;
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
public class CustomerDao implements IMethod<Customer>{

    @Override
    public List<Customer> getAll() {
       String query = "select * from Customer ";
        List<Customer> ls = new ArrayList<>();
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer p = Customer.builder()
                        .id(rs.getInt(1))
                        .customerName(rs.getString(2))
                        .productId(rs.getInt(3))
                        .sizeId(rs.getInt(4))
                        .note(rs.getString(5))
                        .build();
                ls.add(p);
            }
            return ls;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Customer getOne(int id) {
       String query = "select * from Customer where id=? ";
       
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer p = Customer.builder()
                        .id(rs.getInt(1))
                        .customerName(rs.getString(2))
                        .productId(rs.getInt(3))
                        .sizeId(rs.getInt(4))
                        .note(rs.getString(5))
                        .build();
                return p;
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(Customer obj) {
       String query = "Insert into Customer Values(?,?,?,?)";
        int check = 0;
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, obj.getCustomerName());
            ps.setObject(2, obj.getProductId());
            ps.setObject(3, obj.getSizeId());
            ps.setObject(4, obj.getNote());
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thi no se bao loi
        }
        return check > 0;
    }

    @Override
    public boolean update(int id, Customer obj) {
         String query = "UPDATE Color SET "
                + "Name= ?,"
                + "Product_ID=?,  "
                + "Size_ID=? , "
                + "Note=?  "
                + "WHERE ID = ?";
        int check = 0;
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, obj.getCustomerName());
            ps.setObject(2, obj.getProductId());
            ps.setObject(3, obj.getSizeId());
            ps.setObject(4, obj.getNote());
            ps.setObject(5, id);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thi no se bao loi
        }
        return check > 0;
    }

    @Override
    public boolean remove(int id) {
       String query = "delete from Customer where ID = ?";
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
        Customer c = Customer.builder()
                .customerName("dssd")
                .note("ds")
                .sizeId(4)
                .productId(2)
                .build();
        CustomerDao cd = new CustomerDao();
        System.out.println(cd.update(2, c));
    }
}
