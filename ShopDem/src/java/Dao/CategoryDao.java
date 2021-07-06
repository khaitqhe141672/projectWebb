/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Brand;
import Entity.Category;
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
public class CategoryDao implements  IMethod<Category>{

    @Override
    public List<Category> getAll() {
        String query = "select * from Category ";
        List<Category> ls = new ArrayList<>();
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {//chuan bi cho cta thuc hien cau lenh query 
            ResultSet rs = ps.executeQuery();//sau khi thuc hien cau ps been tren thi no se gan lai vao rs
            while (rs.next()) {//rs.next laf next tung hang ngang cua bang
                Category p = Category.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .status(rs.getInt(3))
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
    public Category getOne(int id) {
       String query = "Select * from Category where id=? ";
       
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();//sau khi thuc hien cau ps been tren thi no se gan lai vao rs
            while (rs.next()) {
                Category p = Category.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .status(rs.getInt(3))
                        .build();
                return p;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thi no se bao loi
        }
        return null;
    }

    @Override
    public boolean add(Category obj) {
       String query = "Insert into Category Values(?,?)";
        int check = 0;
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, obj.getName());
            ps.setObject(2, obj.getStatus());
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thi no se bao loi
        }
        return check > 0;
    }

    @Override
    public boolean update(int id, Category obj) {
        String query = "UPDATE Category SET "
                + "Name= ?,"
                + "Status=?  "
                + "WHERE ID = ?";
        int check = 0;
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, obj.getName());
            ps.setObject(2, obj.getStatus());
            ps.setObject(3, id);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thi no se bao loi
        }
        return check > 0;
    }

    @Override
    public boolean remove(int id) {
         String query = "delete from Category where id = ?";
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
        List<Category>  pd= new CategoryDao().getAll();
        pd.forEach(System.out::println);
        //cach add
//        Category p = Category.builder()
//                .name("Đệm lò xo")
//                .status(1)
//                .build();
        CategoryDao c= new CategoryDao();
//        c.add(p);
//-Cach update
//    Category p = Category.builder()
//            .name("Đệm cao su")
//            .status(2)
//            .build();
//    c.update(1, p);
//cach xoa
//        c.remove(1);


    }
}
