/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import JDBC.SQLServerConnection;
import Entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import utils.RandomString;

/**
 *
 * @author Shado
 */
public class AccountDao {

    /**
     * Authentication information user input login
     *
     * @param email
     * @param password
     * @return object Account
     */
    public Account login(String email, String password) {
        String query = "SELECT * FROM Account WHERE Email = ? and Password = ?";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, email);
            ps.setObject(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Account account = Account.builder()
                        .id(rs.getInt(1))
                        .password(rs.getString(2))
                        .email(rs.getString(3))
                        .accountDetailId(rs.getInt(4))
                        .roleId(rs.getInt(5))
                        .status(rs.getInt(6))
                        .createDate(rs.getString(7))
                        .activeCode(rs.getString(8))
                        .build();
                return account;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public boolean isCheckDuplicateEmail(String email) {
        String query = "SELECT * FROM Account WHERE Email = ?";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
    
    public boolean isCheckDuplicateActiveCode(String activeCode) {
        String query = "SELECT * FROM Account WHERE Active_Code = ?";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, activeCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String query = "SELECT * FROM Account";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account account = Account.builder()
                        .id(rs.getInt(1))
                        .password(rs.getString(2))
                        .email(rs.getString(3))
                        .accountDetailId(rs.getInt(4))
                        .roleId(rs.getInt(5))
                        .status(rs.getInt(6))
                        .createDate(rs.getString(7))
                        .activeCode(rs.getString(8))
                        .build();
                list.add(account);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Account getOneAccount(String email) {
        String query = "SELECT * FROM Account WHERE Email =?";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account account = Account.builder()
                        .id(rs.getInt(1))
                        .password(rs.getString(2))
                        .email(rs.getString(3))
                        .accountDetailId(rs.getInt(4))
                        .roleId(rs.getInt(5))
                        .status(rs.getInt(6))
                        .createDate(rs.getString(7))
                        .activeCode(rs.getString(8))
                        .build();
                return account;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean addAccount(Account account) {
        int isCheck = 0;
        String query = "INSERT INTO Account(Email, Password, account_detailid, role_id, status, Active_Code) VALUES(?, ?, ?, ?, ?, ?)";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, account.getEmail());
            ps.setString(2, account.getPassword());
            ps.setInt(3, account.getAccountDetailId());
            ps.setInt(4, account.getRoleId());
            ps.setInt(5, account.getStatus());
            ps.setString(6, account.getActiveCode());
            isCheck = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return isCheck > 0;
    }

    public boolean updatePassword(String newPassword, String email) {
        int isCheck = 0;
        String query = "UPDATE Account set Password = ? WHERE Email = ?";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, newPassword);
            ps.setString(2, email);
            isCheck = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return isCheck > 0;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM account WHERE id = ?";
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

    public boolean update(int status, int id) {
        String sql = "UPDATE account SET status = ?"
                + " WHERE id = ?";
        int check = 0;
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, status);
            ps.setObject(2, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public int countTotalAccount() {
        return getAllAccount().size();
    }

    public List<Account> getAccountPerPage(int pageIndex, int numberProduct) {
        List<Account> ls = new ArrayList<>();
        String sql = "SELECT * FROM Account ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROW ONLY";

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, pageIndex);
            ps.setObject(2, numberProduct);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account account = Account.builder()
                        .id(rs.getInt(1))
                        .password(rs.getString(2))
                        .email(rs.getString(3))
                        .accountDetailId(rs.getInt(4))
                        .roleId(rs.getInt(5))
                        .status(rs.getInt(6))
                        .createDate(rs.getString(7))
                        .build();
                ls.add(account);
            }
            return ls;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public List<Account> search(int status) {
        List<Account> list = new ArrayList<>();
        String query = "SELECT * FROM Account WHERE role_id = ?";
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, status);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account account = Account.builder()
                        .id(rs.getInt(1))
                        .password(rs.getString(2))
                        .email(rs.getString(3))
                        .accountDetailId(rs.getInt(4))
                        .roleId(rs.getInt(5))
                        .status(rs.getInt(6))
                        .createDate(rs.getString(7))
                        .build();
                list.add(account);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public boolean updateActiveCode(int status, String acvtiveCode) {
        String sql = "UPDATE account SET status = ?"
                + " WHERE Active_Code = ?";
        int check = 0;
        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, status);
            ps.setObject(2, acvtiveCode);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    public static void main(String[] args) {
        AccountDao a = new AccountDao();
        System.out.println(a.updateActiveCode(2, "saBBGV"));
    }
 
}
