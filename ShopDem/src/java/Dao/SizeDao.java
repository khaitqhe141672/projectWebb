/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Payment;
import Entity.Size;
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
public class SizeDao implements IMethod<Size>{

    @Override
    public List<Size> getAll() {
       String query = "select * from Size ";
        List<Size> ls = new ArrayList<>();
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {//chuan bi cho cta thuc hien cau lenh query 
            ResultSet rs = ps.executeQuery();//sau khi thuc hien cau ps been tren thi no se gan lai vao rs
            while (rs.next()) {//rs.next laf next tung hang ngang cua bang
                Size p = Size.builder()
                        .id(rs.getInt(1))
                        .size(rs.getString(2))
                        .note(rs.getString(3))
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
    public Size getOne(int id) {
        String query = "select * from Size where id=?";
        
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {//chuan bi cho cta thuc hien cau lenh query 
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();//sau khi thuc hien cau ps been tren thi no se gan lai vao rs
            
            while (rs.next()) {//rs.next laf next tung hang ngang cua bang
                Size p = Size.builder()
                        .id(rs.getInt(1))
                        .size(rs.getString(2))
                        .note(rs.getString(3))
                        .build();
                return p;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thif nos se bao loi
        }
        return null;
    }

    @Override
    public boolean add(Size obj) {
        String query = "Insert into Size Values (?,?)";
        int check = 0;
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {

            ps.setObject(1, obj.getSize());
            ps.setObject(2, obj.getNote());
            

            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thi no se bao loi
        }
        return check > 0;
    }

    @Override
    public boolean update(int id, Size obj) {
        String query = "update Size set size = ?, note = ? where Id= ? ";
        int check = 0;
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(3, id);
            ps.setObject(1, obj.getSize());
            ps.setObject(2, obj.getNote());
            
            
            
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thi no se bao loi
        }
        return check > 0;
    }

    @Override
    public boolean remove(int id) {
         String query = "delete from Size where id = ?";
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
    
    
}
