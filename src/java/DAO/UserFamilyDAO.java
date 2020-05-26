/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author User
 */
import Connection.JDBCConnection;
import Models.Info;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class UserFamilyDAO {
     public boolean add(Info info){
        Connection con = JDBCConnection.getConnection();
        String query = "INSERT INTO [Project_DBCLPM].[dbo].[UserFamily] (mainMember, name,  soCMND, ngaySinh, danToc, gioiTinh)" + 
                " VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement ps;
        try{
            ps = (PreparedStatement) con.prepareStatement(query);
            ps.setString(1, info.getUsername());
            ps.setString(2, info.getTen());
            ps.setString(3, info.getSoCMND());
            ps.setString(4, info.getNgaySinh());
            ps.setString(5, info.getDanToc());         
            ps.setBoolean(6, info.getGioiTinh());
            
                    
                    
            System.out.println(info.getGioiTinh());
                  
            ps.executeUpdate();
            con.close();
            return true;
        }
        catch(SQLException ex){
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<Info> get(String username){
        Connection con = JDBCConnection.getConnection();
        String query = "SELECT * FROM [Project_DBCLPM].[dbo].[UserFamily] WHERE mainMember='" + username + "'"; 
        PreparedStatement ps;
        try{
            ps = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ArrayList<Info> list=new ArrayList<>();
            while(rs.next()){
                Info info = new Info();
                info.setUsername(username);
                info.setTen(rs.getString("name"));
               
               
                info.setSoCMND(rs.getString("soCMND"));
                info.setNgaySinh(rs.getString("ngaySinh"));
                info.setDanToc(rs.getString("danToc"));
                info.setGioiTinh(rs.getBoolean("gioiTinh"));                            
                list.add(info);
            }
                con.close();
                return list;
        }
        catch(SQLException ex){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean update(Info info){
        Connection con = JDBCConnection.getConnection();
        String query = "UPDATE [Project_DBCLPM].[dbo].[UserFamily] SET name = ?, ngaySinh = ?, danToc = ?, gioiTinh = ?"
                + " WHERE mainMember = ? and soCMND = ?";
        PreparedStatement ps;
        try{
            ps = (PreparedStatement) con.prepareStatement(query);        
            ps.setString(1, info.getTen());
            ps.setString(6, info.getSoCMND());          
            ps.setString(2, info.getNgaySinh());
            ps.setString(3, info.getDanToc());
            ps.setBoolean(4, info.getGioiTinh());            
            ps.setString(5,info.getUsername());
            ps.executeUpdate();
            con.close();
            return true;
        }
        catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    

    
    
}
