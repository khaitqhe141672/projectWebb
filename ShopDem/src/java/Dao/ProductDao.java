/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Product;
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
public class ProductDao implements IMethod<Product> {

    @Override
    public List<Product> getAll() {

        String query = "select * from Product ";
        List<Product> ls = new ArrayList<>();
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {//chuan bi cho cta thuc hien cau lenh query 
            ResultSet rs = ps.executeQuery();//sau khi thuc hien cau ps been tren thi no se gan lai vao rs
            while (rs.next()) {//rs.next laf next tung hang ngang cua bang
                Product p = Product.builder()
                        .id(rs.getInt(1))
                        .brandID(rs.getInt(2))
                        .categoryID(rs.getInt(3))
                        .colorID(rs.getInt(4))
                        .sizeID(rs.getInt(5))
                        .materialID(rs.getInt(6))
                        .name(rs.getString(7))
                        .price(rs.getDouble(8))
                        .quantity(rs.getInt(9))
                        .imgName(rs.getString(11))
                        .description(rs.getString(10))
                        .note(rs.getString(12))
                        .status(rs.getInt(13))
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
    public Product getOne(int id) {
        String query = "select * from Product where ID = ?";

        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();//sau khi thuc hien cau ps been tren thi no se gan lai vao rs
            while (rs.next()) {
                Product p = Product.builder()
                        .id(rs.getInt(1))
                        .brandID(rs.getInt(2))
                        .categoryID(rs.getInt(3))
                        .colorID(rs.getInt(4))
                        .sizeID(rs.getInt(5))
                        .materialID(rs.getInt(6))
                        .name(rs.getString(7))
                        .price(rs.getDouble(8))
                        .quantity(rs.getInt(9))
                        .imgName(rs.getString(11))
                        .description(rs.getString(10))
                        .note(rs.getString(12))
                        .status(rs.getInt(13))
                        .build();
                return p;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thi no se bao loi
        }

        return null;

    }

    @Override
    public boolean add(Product obj) {
        String query = "Insert into Product Values(?,?,?,?,?,?,?,?,?,?,?,?)";
        int check = 0;
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, obj.getBrandID());
            ps.setObject(2, obj.getCategoryID());
            ps.setObject(3, obj.getColorID());
            ps.setObject(4, obj.getSizeID());
            ps.setObject(5, obj.getMaterialID());
            ps.setObject(6, obj.getName());
            ps.setObject(7, obj.getPrice());
            ps.setObject(8, obj.getQuantity());
            ps.setObject(9, obj.getImgName());
            ps.setObject(10, obj.getDescription());
            ps.setObject(11, obj.getNote());
            ps.setObject(12, obj.getStatus());
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thi no se bao loi
        }
        return check > 0;

    }

    @Override
    public boolean update(int id, Product obj) {
        String query = "UPDATE Product set Brand_ID=?,"
                + "Category_ID= ?,"
                + "Color_ID= ?,"
                + "Size_ID= ?,"
                + "Material_ID= ?,"
                + "Name= ?,"
                + "Price= ?,"
                + "Quantity= ?,"
                + "Image= ?,"
                + "Description= ?,"
                + "Note= ?,"
                + "Status= ? WHERE ID = ?";
        int check = 0;
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(13, id);
            ps.setObject(1, obj.getBrandID());
            ps.setObject(2, obj.getCategoryID());
            ps.setObject(3, obj.getColorID());
            ps.setObject(4, obj.getSizeID());
            ps.setObject(5, obj.getMaterialID());
            ps.setObject(6, obj.getName());
            ps.setObject(7, obj.getPrice());
            ps.setObject(8, obj.getQuantity());
            ps.setObject(9, obj.getImgName());
            ps.setObject(10, obj.getDescription());
            ps.setObject(11, obj.getNote());
            ps.setObject(12, obj.getStatus());
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thi no se bao loi
        }
        return check > 0;
    }

    @Override
    public boolean remove(int id) {
        String query = "delete from Product where id = ?";
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

    public List<Product> filterByBrand(int id) {

        String query = "select * from Product where Brand_ID =?";
        List<Product> ls = new ArrayList<>();
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {//chuan bi cho cta thuc hien cau lenh query
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();//sau khi thuc hien cau ps been tren thi no se gan lai vao rs

            while (rs.next()) {//rs.next laf next tung hang ngang cua bang
                Product p = Product.builder()
                        .id(rs.getInt(1))
                        .brandID(rs.getInt(2))
                        .categoryID(rs.getInt(3))
                        .colorID(rs.getInt(4))
                        .sizeID(rs.getInt(5))
                        .materialID(rs.getInt(6))
                        .name(rs.getString(7))
                        .price(rs.getDouble(8))
                        .quantity(rs.getInt(9))
                        .imgName(rs.getString(11))
                        .description(rs.getString(10))
                        .note(rs.getString(12))
                        .status(rs.getInt(13))
                        .build();
                ls.add(p);

            }
            return ls;

        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thif nos se bao loi
        }

        return null;
    }

    public List<Product> filterByColor(int id) {

        String query = "select * from Product where Color_ID =?";
        List<Product> ls = new ArrayList<>();
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {//chuan bi cho cta thuc hien cau lenh query
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();//sau khi thuc hien cau ps been tren thi no se gan lai vao rs

            while (rs.next()) {//rs.next laf next tung hang ngang cua bang
                Product p = Product.builder()
                        .id(rs.getInt(1))
                        .brandID(rs.getInt(2))
                        .categoryID(rs.getInt(3))
                        .colorID(rs.getInt(4))
                        .sizeID(rs.getInt(5))
                        .materialID(rs.getInt(6))
                        .name(rs.getString(7))
                        .price(rs.getDouble(8))
                        .quantity(rs.getInt(9))
                        .imgName(rs.getString(11))
                        .description(rs.getString(10))
                        .note(rs.getString(12))
                        .status(rs.getInt(13))
                        .build();
                ls.add(p);

            }
            return ls;

        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thif nos se bao loi
        }

        return null;
    }

    public List<Product> filterBySize(int id) {

        String query = "select * from Product where Size_ID =?";
        List<Product> ls = new ArrayList<>();
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {//chuan bi cho cta thuc hien cau lenh query
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();//sau khi thuc hien cau ps been tren thi no se gan lai vao rs

            while (rs.next()) {//rs.next laf next tung hang ngang cua bang
                Product p = Product.builder()
                        .id(rs.getInt(1))
                        .brandID(rs.getInt(2))
                        .categoryID(rs.getInt(3))
                        .colorID(rs.getInt(4))
                        .sizeID(rs.getInt(5))
                        .materialID(rs.getInt(6))
                        .name(rs.getString(7))
                        .price(rs.getDouble(8))
                        .quantity(rs.getInt(9))
                        .imgName(rs.getString(11))
                        .description(rs.getString(10))
                        .note(rs.getString(12))
                        .status(rs.getInt(13))
                        .build();
                ls.add(p);

            }
            return ls;

        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thif nos se bao loi
        }

        return null;
    }

    public List<Product> filterByMaterial(int id) {

        String query = "select * from Product where Material_ID =?";
        List<Product> ls = new ArrayList<>();
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {//chuan bi cho cta thuc hien cau lenh query
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();//sau khi thuc hien cau ps been tren thi no se gan lai vao rs

            while (rs.next()) {//rs.next laf next tung hang ngang cua bang
                Product p = Product.builder()
                        .id(rs.getInt(1))
                        .brandID(rs.getInt(2))
                        .categoryID(rs.getInt(3))
                        .colorID(rs.getInt(4))
                        .sizeID(rs.getInt(5))
                        .materialID(rs.getInt(6))
                        .name(rs.getString(7))
                        .price(rs.getDouble(8))
                        .quantity(rs.getInt(9))
                        .imgName(rs.getString(11))
                        .description(rs.getString(10))
                        .note(rs.getString(12))
                        .status(rs.getInt(13))
                        .build();
                ls.add(p);

            }
            return ls;

        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thif nos se bao loi
        }

        return null;
    }

    public List<Product> searchByName(String text) {

        String query = "select * from Product where name LIKE ? ";
        List<Product> ls = new ArrayList<>();
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {//chuan bi cho cta thuc hien cau lenh query 
            ps.setString(1, "%" + text + "%");

            ResultSet rs = ps.executeQuery();//sau khi thuc hien cau ps been tren thi no se gan lai vao rs
            while (rs.next()) {//rs.next laf next tung hang ngang cua bang
                Product p = Product.builder()
                        .id(rs.getInt(1))
                        .brandID(rs.getInt(2))
                        .categoryID(rs.getInt(3))
                        .colorID(rs.getInt(4))
                        .sizeID(rs.getInt(5))
                        .materialID(rs.getInt(6))
                        .name(rs.getString(7))
                        .price(rs.getDouble(8))
                        .quantity(rs.getInt(9))
                        .imgName(rs.getString(11))
                        .description(rs.getString(10))
                        .note(rs.getString(12))
                        .status(rs.getInt(13))
                        .build();
                ls.add(p);

            }
            return ls;

        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thif nos se bao loi
        }
        return null;
    }

    public int countTotalProduct() {
        return getAll().size();
    }

    public List<Product> getProductPerPage(int pageIndex, int numberProduct) {
        String sql = "SELECT * FROM product ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROW ONLY";
        List<Product> ls = new ArrayList<>();
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, pageIndex);
            ps.setObject(2, numberProduct);
            ResultSet rs = ps.executeQuery();//sau khi thuc hien cau ps been tren thi no se gan lai vao rs
            while (rs.next()) {//rs.next laf next tung hang ngang cua bang
                Product p = Product.builder()
                        .id(rs.getInt(1))
                        .brandID(rs.getInt(2))
                        .categoryID(rs.getInt(3))
                        .colorID(rs.getInt(4))
                        .sizeID(rs.getInt(5))
                        .materialID(rs.getInt(6))
                        .name(rs.getString(7))
                        .price(rs.getDouble(8))
                        .quantity(rs.getInt(9))
                        .imgName(rs.getString(11))
                        .description(rs.getString(10))
                        .note(rs.getString(12))
                        .status(rs.getInt(13))
                        .build();
                ls.add(p);

            }
            return ls;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean updateDetails(int id, int quantity, double price, int status) {
        String query = "UPDATE Product set Price= ?, Quantity= ?, Status= ? WHERE ID = ?";
        int check = 0;
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, price);
            ps.setObject(2, quantity);
            ps.setObject(3, status);
            ps.setObject(4, id);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thi no se bao loi
        }
        return check > 0;
    }

    public List<Product> search(int status) {

        String query = "select * from Product  WHERE status= ?";
        List<Product> ls = new ArrayList<>();
        try (Connection con = SQLServerConnection.getConnection();//mk se ket noi vs databse ben SQL
                PreparedStatement ps = con.prepareStatement(query)) {//chuan bi cho cta thuc hien cau lenh query 
            ps.setObject(1, status);
            ResultSet rs = ps.executeQuery();//sau khi thuc hien cau ps been tren thi no se gan lai vao rs
            while (rs.next()) {//rs.next laf next tung hang ngang cua bang
                Product p = Product.builder()
                        .id(rs.getInt(1))
                        .brandID(rs.getInt(2))
                        .categoryID(rs.getInt(3))
                        .colorID(rs.getInt(4))
                        .sizeID(rs.getInt(5))
                        .materialID(rs.getInt(6))
                        .name(rs.getString(7))
                        .price(rs.getDouble(8))
                        .quantity(rs.getInt(9))
                        .imgName(rs.getString(11))
                        .description(rs.getString(10))
                        .note(rs.getString(12))
                        .status(rs.getInt(13))
                        .build();
                ls.add(p);

            }
            return ls;

        } catch (SQLException ex) {
            ex.printStackTrace();//sai j thif nos se bao loi
        }

        return null;
    }

    public boolean updateQuantity(int id, int quantity) {
        String query = "UPDATE Product set Quantity= ? WHERE ID = ?";
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

    public int countTotalProductEnough() {
        return search(1).size();
    }

    public int countTotalProductOver() {
        return search(3).size();
    }

    public List<Product> getTop() {
        
        List<Product> ls = new ArrayList<>();
        String sql = "select top(3) * from Product";
        
        try(Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Product p = Product.builder()
                        .id(rs.getInt(1))
                        .brandID(rs.getInt(2))
                        .categoryID(rs.getInt(3))
                        .colorID(rs.getInt(4))
                        .sizeID(rs.getInt(5))
                        .materialID(rs.getInt(6))
                        .name(rs.getString(7))
                        .price(rs.getDouble(8))
                        .quantity(rs.getInt(9))
                        .imgName(rs.getString(11))
                        .description(rs.getString(10))
                        .note(rs.getString(12))
                        .status(rs.getInt(13))
                        .build();
                ls.add(p);
            }
            return ls;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<Product> ls = new ProductDao().getAll();
        ls.forEach(System.out::print);

    }
}
