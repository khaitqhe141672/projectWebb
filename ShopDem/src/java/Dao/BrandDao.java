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
public class BrandDao implements IMethod<Brand>  {

    @Override
    public List<Brand> getAll() {
        String query = "select * from Brand ";
        List<Brand> ls = new ArrayList<>();
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Brand p = Brand.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .status(rs.getInt(3))
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
    public Brand getOne(int id) {
       String query = "Select * from Brand where id = ?";
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();//sau khi thuc hien cau ps been tren thi no se gan lai vao rs
            while (rs.next()) {
                Brand p = Brand.builder()
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
    public boolean add(Brand obj) {
        String query = "insert into Brand Values(?,?)";
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
    public boolean update(int id, Brand obj) {
         String query = "UPDATE Brand set "
                + "Name= ?,"
                + "Status= ? "
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
       String query = "delete from Brand where id = ?";
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
        Brand b =  Brand.builder()
                .name("ac")
                .status(3)
                .build();
        BrandDao bd = new BrandDao();
        System.out.println(bd.remove(3));
    }
}
