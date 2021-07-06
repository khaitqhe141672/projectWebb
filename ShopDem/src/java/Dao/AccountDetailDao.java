/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import JDBC.SQLServerConnection;
import Entity.AccountDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Shado
 */
public class AccountDetailDao {

    public ArrayList<AccountDetail> getAllAccountDetail() {
        ArrayList<AccountDetail> ls = new ArrayList<>();
        String sql = "SELECT * FROM AccountDetail";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AccountDetail accountDetail = AccountDetail.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .mobile(rs.getString(3))
                        .address(rs.getString(4))
                        .gender(rs.getInt(5))
                        .build();
                ls.add(accountDetail);
            }
            return ls;
        } catch (Exception e) {
        }
        return null;
    }

    public AccountDetail getOneAccountDetail(int id) {
        String query = "SELECT * FROM AccountDetail WHERE Id = ?";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                AccountDetail accountDetail = AccountDetail.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .mobile(rs.getString(3))
                        .address(rs.getString(4))
                        .gender(rs.getInt(5))
                        .build();
                return accountDetail;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public int addAccountDetail(AccountDetail accountDetail) {
        String query = "INSERT INTO AccountDetail(Name, mobile,Address, Gender ) VALUES(?, ?, ?, ?)";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, accountDetail.getName());
            ps.setString(2, accountDetail.getMobile());
            ps.setString(3, accountDetail.getAddress());
            ps.setInt(4, accountDetail.getGender());
            int isCheck = ps.executeUpdate();
            if (isCheck > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public boolean update(AccountDetail accountDetail, int id) {
        String sql = "UPDATE AccountDetail SET Name= ?, Mobile= ?, Gender= ?, Address= ? WHERE ID= ?";
        int check = 0;
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, accountDetail.getName());
            ps.setObject(2, accountDetail.getMobile());
            ps.setObject(3, accountDetail.getGender());
            ps.setObject(4, accountDetail.getAddress());
            ps.setObject(5, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM AccountDetail WHERE id = ?";
        int check = 0;
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
