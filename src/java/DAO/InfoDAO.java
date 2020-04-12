/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Connection.JDBCConnection;
import Models.Info;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SA Nice
 */
public class InfoDAO {
    public boolean add(Info info){
        Connection con = JDBCConnection.getConnection();
        String query = "INSERT INTO [Project_DBCLPM].[dbo].[Info] (username, ten, soDT, diaChi, soCMND, ngaySinh, danToc, gioiTinh, maTinh, mucLuong, hinhThuc, trangThai)" + 
                " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps;
        try{
            ps = (PreparedStatement) con.prepareStatement(query);
            ps.setString(1, info.getUsername());
            ps.setString(2, info.getTen());
            ps.setString(3, info.getSoDT());
            ps.setString(4, info.getDiaChi());
            ps.setString(5, info.getSoCMND());
            ps.setString(6, info.getNgaySinh());
            ps.setString(7, info.getDanToc());
            ps.setBoolean(8, info.getGioiTinh());
            ps.setString(9, info.getMaTinh());
            ps.setInt(10, info.getMucLuong());
            ps.setBoolean(11, info.getHinhThuc());
            ps.setBoolean(12, info.getTrangThai());
            ps.executeUpdate();
            con.close();
            return true;
        }
        catch(SQLException ex){
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Info get(String username){
        Connection con = JDBCConnection.getConnection();
        String query = "SELECT * FROM [Project_DBCLPM].[dbo].[Info] WHERE username='" + username + "'"; 
        PreparedStatement ps;
        try{
            ps = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Info info = new Info();
                info.setUsername(username);
                info.setTen(rs.getString("ten"));
                info.setSoDT(rs.getString("soDT"));
                info.setDiaChi(rs.getString("diaChi"));
                info.setSoCMND(rs.getString("soCMND"));
                info.setNgaySinh(rs.getString("ngaySinh"));
                info.setDanToc(rs.getString("danToc"));
                info.setGioiTinh(rs.getBoolean("gioiTinh"));
                info.setMaTinh(rs.getString("maTinh"));
                info.setMucLuong(rs.getInt("mucLuong"));
                info.setHinhThuc(rs.getBoolean("hinhThuc"));
                info.setTrangThai(rs.getBoolean("trangThai"));
               
                con.close();
                return info;
            }
        }
        catch(SQLException ex){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean update(Info info){
        Connection con = JDBCConnection.getConnection();
        String query = "UPDATE [Project_DBCLPM].[dbo].[Info] SET ten = ?, soDT = ?, diaChi = ?, soCMND = ?, ngaySinh = ?, danToc = ?, gioiTinh = ?"
                + ",maTinh = ?, mucLuong = ?, hinhThuc = ?, trangThai = ? WHERE username = ?";
        PreparedStatement ps;
        try{
            ps = (PreparedStatement) con.prepareStatement(query);

            ps.setString(1, info.getTen());
            ps.setString(2, info.getSoDT());
            ps.setString(3, info.getDiaChi());
            ps.setString(4, info.getSoCMND());
            ps.setString(5, info.getNgaySinh());
            ps.setString(6, info.getDanToc());
            ps.setBoolean(7, info.getGioiTinh());
            ps.setString(8, info.getMaTinh());
            ps.setInt(9, info.getMucLuong());
            ps.setBoolean(10, info.getHinhThuc());
            ps.setBoolean(11, info.getTrangThai());
            ps.setString(12,info.getUsername());
            ps.executeUpdate();
            con.close();
            return true;
        }
        catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void delete(String username){
        Connection con = JDBCConnection.getConnection();
        String query = "DELETE FROM [Project_DBCLPM].[dbo].[Info] WHERE username = ?";
        PreparedStatement ps;
        try{
            ps = (PreparedStatement) con.prepareStatement(query);
            ps.setString(1, username);
            ps.executeUpdate();
            con.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
