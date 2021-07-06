/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Images;
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
public class ImagesDao implements IMethod<Images>{

    @Override
    public List<Images> getAll() {
       String query = "select * from Image ";
        List<Images> ls = new ArrayList<>();
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Images r = Images.builder()
                        .id(rs.getInt(1))
                        .productId(rs.getInt(2))
                        .imageName(rs.getString(3))
                        .build();
                ls.add(r);
            }
            return ls;
        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thif nos se bao loi
        }
        return null;
    }

    @Override
    public Images getOne(int id) {
        String query = "select * from Images where id = ? ";

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Images r = Images.builder()
                        .id(rs.getInt(1))
                        .productId(rs.getInt(2))
                        .imageName(rs.getString(3))
                        .build();
                return r;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thif nos se bao loi
        }
        return null;
    }

    @Override
    public boolean add(Images obj) {
        String query = "Insert into Images Values (?,?)";
        int check = 0;
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {

            ps.setObject(1, obj.getProductId());
            ps.setObject(2, obj.getImageName());

            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thi no se bao loi
        }
        return check > 0;
    }

    @Override
    public boolean update(int id, Images obj) {
        String query = "update Images set product_id = ? , imageName = ? where Id= ? ";
        int check = 0;
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(3, id);
            ps.setObject(1, obj.getProductId());
            ps.setObject(2, obj.getImageName());

            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thi no se bao loi
        }
        return check > 0;
    }

    @Override
    public boolean remove(int id) {
        String query = "delete from images where id = ?";
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
    public List<Images> getAllImage(int id) {
        String query = "select * from image where Product_ID =?";
        List<Images> ls = new ArrayList<>();
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Images r = Images.builder()
                        .id(rs.getInt(1))
                        .productId(rs.getInt(2))
                        .imageName(rs.getString(3))
                        .build();
                ls.add(r);
            }
            return ls;
        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thif nos se bao loi
        }
        return null;
    }
    public static void main(String[] args) {
        Images i = Images.builder()
                .imageName("dscds")
                .productId(1)
                .build();
        ImagesDao id = new ImagesDao();
        System.out.println(id.update(2, i));
    }
}
