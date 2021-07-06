/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Material;
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

public class MaterialDao implements IMethod<Material>{

    @Override
    public List<Material> getAll() {
      String query = "select * from Material ";
        List<Material> ls = new ArrayList<>();
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Material p = Material.builder()
                        .id(rs.getInt(1))
                        .material(rs.getString(2))
                        .note(rs.getString(3))
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
    public Material getOne(int id) {
        String query = "select * from Material where id=? ";
       
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Material p = Material.builder()
                        .id(rs.getInt(1))
                        .material(rs.getString(2))
                        .note(rs.getString(3))
                        .build();
                return p;
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(Material obj) {
        String query = "Insert into Material Values(?,?)";
        int check = 0;
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, obj.getMaterial());
            ps.setObject(2, obj.getNote());
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thi no se bao loi
        }
        return check > 0;
    }

    @Override
    public boolean update(int id, Material obj) {
         String query = "UPDATE Material SET "
                + "Material= ?, Note = ? "
                + "WHERE ID = ?";
        int check = 0;
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, obj.getMaterial());
            ps.setObject(2, obj.getNote());
            ps.setObject(3, id);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thi no se bao loi
        }
        return check > 0;
    }

    @Override
    public boolean remove(int id) {
         String query = "delete from Material where ID = ?";
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
//    public static void main(String[] args) {
//        Material c = Material.builder()
//                .material("dssd")
//                .build();
//        MaterialDao cd = new MaterialDao();
//        System.out.println(cd.remove(1));
//    }
}
