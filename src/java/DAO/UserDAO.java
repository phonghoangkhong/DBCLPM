/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.JDBCConnection;
import Encrypted.EncryptedPassword;
import java.sql.Connection;
import Models.User;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Le Trong Nghia
 * Date 20/02/2020
 */
public class UserDAO {
    /**
     * 
     * @param user
     * @return boolean
     * check dang ky 
     */
    public boolean register(User user){
        if(checkUsername(user.getUsername())){
            Connection con = JDBCConnection.getConnection();
            String query = "INSERT INTO [p2].[dbo].[User](username, password, trangThai) VALUES(?, ?, ?)";
            PreparedStatement ps;
            try{
                ps = (PreparedStatement) con.prepareStatement(query);
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                ps.setBoolean(3, user.getTrangThai());
                ps.executeUpdate();
                con.close();
                return true;
            }
            catch(SQLException ex){
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
        return false;
    }
    /**
     * 
     * @param username
     *  @return boolean
     * check Username
     */
    public boolean checkUsername(String username){
        Connection con = JDBCConnection.getConnection();
        String query = "SELECT * FROM [p2].[dbo].[User] WHERE username = '" + username + "'";
        PreparedStatement ps;
        try{
            ps = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                con.close();
                return false;
            }
            con.close();
            return true;
        }
        catch(SQLException ex){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    /**
     * 
     * @param username
     * @param password
     * @return boolean
     * check thong tin dang nhap
     */
    
    public  User login(String username, String password){
        Connection con = JDBCConnection.getConnection();
        if(!"admin".equals(username) && !"admin".equals(password)){
            try {
                password=EncryptedPassword.sha1(password);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String query = "SELECT * FROM [p2].[dbo].[User] WHERE username = '" + username + "' AND password = '" + password + "'";
        PreparedStatement ps;
        try{
            ps = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                user.setTrangThai(rs.getBoolean("trangThai"));
                con.close();
                return user;
            }
        }
        catch(SQLException ex){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /**
     * 
     * @param user
     * @return  boolean
     * 
     */
    public boolean edit(User user){
        Connection con = JDBCConnection.getConnection();
        String query = "UPDATE [p2].[dbo].[User] SET password = ?, trangThai = ? WHERE username = ?";
        PreparedStatement ps;
        try{
            ps = (PreparedStatement) con.prepareStatement(query);
            ps.setString(3, user.getUsername());
            ps.setString(1, user.getPassword());
            ps.setBoolean(2, user.getTrangThai());
            ps.executeUpdate();
            con.close();
            return true;
        }
        catch(SQLException ex){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
  
}