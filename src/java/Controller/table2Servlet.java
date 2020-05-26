/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Commons.Commons;
import DAO.InfoDAO;
import DAO.UserFamilyDAO;
import Models.Info;
import Models.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
public class table2Servlet  extends HttpServlet{
     InfoDAO info=new InfoDAO(); 
    UserFamilyDAO userFamilyDAO=new UserFamilyDAO();
       void checkValidate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        HttpSession session = req.getSession();
        String ten = Commons.fixName(req.getParameter("ten"));      
        String soCMND = req.getParameter("soCMND").trim();
        String ngaySinh = req.getParameter("ngaySinh").trim();
        String danToc = req.getParameter("danToc").trim();
    boolean gioiTinh = (req.getParameter("gioiTinh").equals("0"));
        
        if(ten.length() == 0){
            session.setAttribute("error", "Họ tên không được trống");
            resp.sendRedirect("table"); 
        }
        
     
        else if(!Commons.checkSoCMND(soCMND.trim())){
            session.setAttribute("error", "Số CMND không hợp lệ");
            resp.sendRedirect("table"); 
        }
        else if(ngaySinh.length() == 0){
            session.setAttribute("error", "Ngày sinh trống");
            resp.sendRedirect("table");
        }
        else if(danToc.length() == 0){
            session.setAttribute("error", "Dân tộc không được trống");
            resp.sendRedirect("table"); 
        }
        
    }
        @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     String typeSubmit = req.getParameter("submit");
        HttpSession session = req.getSession();
       
        User user = (User) session.getAttribute("user");
        String username = user.getUsername();
        String ten = Commons.fixName(req.getParameter("ten"));     
       String soCMND = req.getParameter("soCMND").trim();
        String ngaySinh = req.getParameter("ngaySinh").trim();
        String danToc = req.getParameter("danToc").trim();
        String gioiTinh2=req.getParameter("gioiTinh").trim();
            System.out.println(gioiTinh2);
        boolean gioiTinh = (req.getParameter("gioiTinh").equals("0"));
            System.out.println(gioiTinh);
            session.setAttribute("error", null);
          
         
            checkValidate(req, resp);
            if(session.getAttribute("error") == null){
                Info info = new Info(username, ten, soCMND, ngaySinh, danToc, gioiTinh);
                System.out.println(info);
                boolean check = userFamilyDAO.add(info);
                if(check == true){
                  
                 
                    resp.sendRedirect("table");
                }
                else{
                    session.setAttribute("error", "Thêm thành viên thất bại");
                    resp.sendRedirect("table");
                }
            }
        }  
        
       
      
    }
   

