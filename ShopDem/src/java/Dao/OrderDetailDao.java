/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Cart;
import Entity.OrderDetail;
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
public class OrderDetailDao implements IMethod<OrderDetail> {

    @Override
    public List<OrderDetail> getAll() {
        String query = "select * from OrderDetail ";
        List<OrderDetail> ls = new ArrayList<>();
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {//chuan bi cho cta thuc hien cau lenh query 
            ResultSet rs = ps.executeQuery();//sau khi thuc hien cau ps been tren thi no se gan lai vao rs
            while (rs.next()) {//rs.next laf next tung hang ngang cua bang
                OrderDetail p = OrderDetail.builder()
                        .id(rs.getInt(1))
                        .orderId(rs.getInt(2))
                        .productId(rs.getInt(3))
                        .productName(rs.getString(4))
                        .productPrice(rs.getDouble(5))
                        .quantity(rs.getInt(6))
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
    public OrderDetail getOne(int id) {
        String query = "select * from OrderDetail where Order_ID=?";

        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL

                PreparedStatement ps = con.prepareStatement(query)) {//chuan bi cho cta thuc hien cau lenh query 
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();//sau khi thuc hien cau ps been tren thi no se gan lai vao rs
            while (rs.next()) {//rs.next laf next tung hang ngang cua bang
                OrderDetail p = OrderDetail.builder()
                        .id(rs.getInt(1))
                        .orderId(rs.getInt(2))
                        .productId(rs.getInt(3))
                        .productName(rs.getString(4))
                        .productPrice(rs.getDouble(5))
                        .quantity(rs.getInt(6))
                        .build();
                return p;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thif nos se bao loi
        }
        return null;
    }

    @Override
    public boolean add(OrderDetail obj) {
//        String query = "Insert into OrderDetail Values (?,?,?,?,?)";
//        int check = 0;
//        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
//                PreparedStatement ps = con.prepareStatement(query)) {
//
//            ps.setObject(1, obj.getProductId());
//            ps.setObject(2, obj.getPrice());
//            ps.setObject(3, obj.getQuantity());
//            ps.setObject(4, obj.getOrderId());
//
//            check = ps.executeUpdate();
//        } catch (SQLException ex) {
//            ex.printStackTrace();//sai j thi no se bao loi
//        }
//        return check > 0;
        return true;
    }

    @Override
    public boolean update(int id, OrderDetail obj) {
//        String query = "update OrderDetail set Product_ID = ?, Order_ID = ? , price = ?, quantity = ? where Id= ? ";
//        int check = 0;
//        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
//                PreparedStatement ps = con.prepareStatement(query)) {
//            ps.setObject(5, id);
//            ps.setObject(1, obj.getProductId());
//            ps.setObject(2, obj.getPrice());
//            ps.setObject(3, obj.getQuantity());
//            ps.setObject(4, obj.getOrderId());
//
//            check = ps.executeUpdate();
//        } catch (SQLException ex) {
//            ex.printStackTrace();//sai j thi no se bao loi
//        }
//        return check > 0;
        return true;
    }

    @Override
    public boolean remove(int id) {
        String query = "delete from OrderDetail where id = ?";
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

    public boolean addOrderDetails(List<Cart> listCart, int orderId) {
        String query = "INSERT INTO OrderDetail VALUES(?,?,?,?,?)";

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            for (Cart c : listCart) {
                ps.setObject(1, orderId);
                ps.setObject(2, c.getId());
                ps.setObject(3, c.getName());
                ps.setObject(4, c.getPrice());
                ps.setObject(5, c.getQuantily());
                // add nhiều lần trong 1 laanf 
                ps.addBatch();
            }

            ps.executeBatch();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
//        List<Cart> listCart = new ArrayList<>();
//        Cart c = Cart.builder().id(2).build();
//        listCart.add(c);
//        OrderDetail o = OrderDetail.builder()
//                .orderId(9)
//                .build();
//        boolean a = new OrderDetailDao().addOrderDetails(listCart,9);
//        if(a){
//            System.out.println("dsdsd");
//        } else {
//            OrderDao b = new OrderDao();
//            boolean w = b.remove(1);
//        }

        List<OrderDetail> ls = new OrderDetailDao().getOneAccount(12);
        ls.forEach(System.out::print);
    }

    public List<OrderDetail> getProductPerPage(int pageIndex, int numberProduct) {
        String sql = "SELECT * FROM OrderDetail ORDER BY Order_ID OFFSET ? ROWS FETCH NEXT ? ROW ONLY";

        List<OrderDetail> ls = new ArrayList<>();
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(sql)) {//chuan bi cho cta thuc hien cau lenh query 
            ps.setObject(1, pageIndex);
            ps.setObject(2, numberProduct);
            ResultSet rs = ps.executeQuery();//sau khi thuc hien cau ps been tren thi no se gan lai vao rs
            while (rs.next()) {//rs.next laf next tung hang ngang cua bang
                OrderDetail p = OrderDetail.builder()
                        .id(rs.getInt(1))
                        .orderId(rs.getInt(2))
                        .productId(rs.getInt(3))
                        .productName(rs.getString(4))
                        .productPrice(rs.getDouble(5))
                        .quantity(rs.getInt(6))
                        .build();
                ls.add(p);
            }
            return ls;
        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thif nos se bao loi
        }
        return null;
    }
    
    public List<OrderDetail> getOneAccount(int id) {
        String query = "select * from OrderDetail WHERE Order_ID = ?";
        List<OrderDetail> ls = new ArrayList<>();
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {//chuan bi cho cta thuc hien cau lenh query 
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();//sau khi thuc hien cau ps been tren thi no se gan lai vao rs
            while (rs.next()) {//rs.next laf next tung hang ngang cua bang
                OrderDetail p = OrderDetail.builder()
                        .id(rs.getInt(1))
                        .orderId(rs.getInt(2))
                        .productId(rs.getInt(3))
                        .productName(rs.getString(4))
                        .productPrice(rs.getDouble(5))
                        .quantity(rs.getInt(6))
                        .build();
                ls.add(p);
            }
            return ls;
        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thif nos se bao loi
        }
        return null;
    }

}
