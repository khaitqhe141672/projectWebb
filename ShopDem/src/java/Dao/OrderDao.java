/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Order;
import JDBC.SQLServerConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderDao implements IMethod<Order> {

    @Override
    public List<Order> getAll() {
        String query = "select * from Orders ";
        List<Order> ls = new ArrayList<>();
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {//chuan bi cho cta thuc hien cau lenh query 
            ResultSet rs = ps.executeQuery();//sau khi thuc hien cau ps been tren thi no se gan lai vao rs
            while (rs.next()) {//rs.next laf next tung hang ngang cua bang
                Order p = Order.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .mobile(rs.getString(3))
                        .address(rs.getString(4))
                        .total(rs.getDouble(5))
                        .note(rs.getString(6))
                        .accountId(rs.getInt(7))
                        .createDate(rs.getString(8))
                        .status(rs.getInt(9))
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
    public Order getOne(int id) {
        String query = "select * from Orders where id= ? ";

        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {//chuan bi cho cta thuc hien cau lenh query 
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();//sau khi thuc hien cau ps been tren thi no se gan lai vao rs
            while (rs.next()) {//rs.next laf next tung hang ngang cua bang
                Order p = Order.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .mobile(rs.getString(3))
                        .address(rs.getString(4))
                        .total(rs.getDouble(5))
                        .note(rs.getString(6))
                        .accountId(rs.getInt(7))
                        .createDate(rs.getString(8))
                        .status(rs.getInt(9))
                        .build();
                return p;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thif nos se bao loi
        }
        return null;
    }

    @Override
    public boolean add(Order obj) {
        return true;
    }

    @Override
    public boolean update(int id, Order obj) {
        String query = "update Orders set orderDate = ? , requireddate = ?, shipdate = ?, customerid = ? , comment = ? where Id= ? ";
        int check = 0;
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(8, id);
            ps.setObject(1, obj.getName());
            ps.setObject(2, obj.getMobile());
            ps.setObject(3, obj.getAddress());
            ps.setObject(4, obj.getTotal());
            ps.setObject(5, obj.getNote());
            ps.setObject(6, obj.getAccountId());
            ps.setObject(7, obj.getCreateDate());
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thi no se bao loi
        }
        return check > 0;
    }

    @Override
    public boolean remove(int id) {
        String query = "delete from Orders where id = ?";
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

    public int addOrder(Order obj) {
        String query = "INSERT INTO Orders(Name, Mobile, Address, Total_money, Note, Account_ID, Status)"
                + " VALUES (?,?,?,?,?,?,?)";
        int check = 0;
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setObject(1, obj.getName());
            ps.setObject(2, obj.getMobile());
            ps.setObject(3, obj.getAddress());
            ps.setObject(4, obj.getTotal());
            ps.setObject(5, obj.getNote());
            ps.setObject(6, obj.getAccountId());
            ps.setObject(7, obj.getStatus());
            check = ps.executeUpdate();
            if (check > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean updateStatus(int id, int status) {
        String query = "update Orders set status = ? where Id= ? ";
        int check = 0;
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, status);
            ps.setObject(2, id);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thi no se bao loi
        }
        return check > 0;
    }

    public boolean updateQuantity(int id, int quantity) {
        String query = "update Orders set quantity = ? where Id= ? ";
        int check = 0;
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, quantity);
            ps.setObject(2, id);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thi no se bao loi
        }
        return check > 0;
    }

    public List<Order> search(int status) {
        String query = "select * from Orders WHERE status = ?";
        List<Order> ls = new ArrayList<>();
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {//chuan bi cho cta thuc hien cau lenh query 
            ps.setObject(1, status);
            ResultSet rs = ps.executeQuery();//sau khi thuc hien cau ps been tren thi no se gan lai vao rs
            while (rs.next()) {//rs.next laf next tung hang ngang cua bang
                Order p = Order.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .mobile(rs.getString(3))
                        .address(rs.getString(4))
                        .total(rs.getDouble(5))
                        .note(rs.getString(6))
                        .accountId(rs.getInt(7))
                        .createDate(rs.getString(8))
                        .status(rs.getInt(9))
                        .build();
                ls.add(p);
            }
            return ls;
        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thif nos se bao loi
        }
        return null;
    }
    
    public int countTotalSuccess() {
        return search(3).size();
    }

    public int countTotalProduct() {
        return getAll().size();
    }
    
    public int countTotalWait() {
        return search(1).size();
    }
    
    public int countTotalCancel() {
        return search(4).size();
    }

    public List<Order> getProductPerPage(int pageIndex, int numberProduct) {
        String sql = "SELECT * FROM Orders ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROW ONLY";

        List<Order> ls = new ArrayList<>();
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(sql)) {//chuan bi cho cta thuc hien cau lenh query 
            ps.setObject(1, pageIndex);
            ps.setObject(2, numberProduct);
            ResultSet rs = ps.executeQuery();//sau khi thuc hien cau ps been tren thi no se gan lai vao rs
            while (rs.next()) {//rs.next laf next tung hang ngang cua bang
                Order p = Order.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .mobile(rs.getString(3))
                        .address(rs.getString(4))
                        .total(rs.getDouble(5))
                        .note(rs.getString(6))
                        .accountId(rs.getInt(7))
                        .createDate(rs.getString(8))
                        .status(rs.getInt(9))
                        .build();
                ls.add(p);
            }
            return ls;
        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thif nos se bao loi
        }
        return null;
    }

    public List<Order> getOneAccount(int id) {
        String query = "select * from Orders WHERE Account_ID = ?";
        List<Order> ls = new ArrayList<>();
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {//chuan bi cho cta thuc hien cau lenh query 
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();//sau khi thuc hien cau ps been tren thi no se gan lai vao rs
            while (rs.next()) {//rs.next laf next tung hang ngang cua bang
                Order p = Order.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .mobile(rs.getString(3))
                        .address(rs.getString(4))
                        .total(rs.getDouble(5))
                        .note(rs.getString(6))
                        .accountId(rs.getInt(7))
                        .createDate(rs.getString(8))
                        .status(rs.getInt(9))
                        .build();
                ls.add(p);
            }
            return ls;
        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thif nos se bao loi
        }
        return null;
    }

    public static void main(String[] args) {
//        Order a = Order.builder()
//                .name("khai")
//                .mobile("0921282198")
//                .address("hanoi")
//                .total(100)
//                .note("0")
//                .accountId(1)
//                .status(1)
//                .build();
       OrderDao c = new OrderDao();
//        c.addOrder(a);
//        System.out.println(c);

        System.out.println(c.countTotalWait());

    }
}
