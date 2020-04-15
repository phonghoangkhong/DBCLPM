/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.InfoDAO;
import DAO.UserDAO;
import Models.Info;
import Models.User;
import Commons.Commons;
import DAO.UserFamilyDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Le Trong Nghia
 * Date 20/02/2020
 * Xu ly thong tin khai bao
 * Edit by: Khong Hoang Phong
 * Date: 14/03/2020
 * Sua su kien nop voi ho gia dinh
 */

public class infoServlet extends HttpServlet{
    UserDAO userDAO = new UserDAO();
    InfoDAO infoDAO = new InfoDAO();
    UserFamilyDAO userFamily=new UserFamilyDAO();
    void checkValidate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        HttpSession session = req.getSession();
        String ten = Commons.fixName(req.getParameter("ten"));
        String soDT = req.getParameter("soDT").trim();
        String diaChi = req.getParameter("diaChi").trim();
        String soCMND = req.getParameter("soCMND").trim();
        String ngaySinh = req.getParameter("ngaySinh").trim();
        String danToc = req.getParameter("danToc").trim();
        String maTinh = req.getParameter("maTinh").trim();
        int mucLuong = Integer.parseInt(req.getParameter("mucLuong"));
        if(ten.length() == 0){
            session.setAttribute("error", "Họ tên không được trống");
            resp.sendRedirect("home"); 
        }
        else if(soDT.length()!= 0 && !Commons.checkSoDT(soDT.trim())){
            session.setAttribute("error", "Số điện thoại không hợp lệ");
            resp.sendRedirect("home"); 
        }
        else if(diaChi.length() == 0){
            session.setAttribute("error", "Địa chỉ trống");
            resp.sendRedirect("home"); 
        }
        else if(!Commons.checkSoCMND(soCMND.trim())){
            session.setAttribute("error", "Số CMND không hợp lệ");
            resp.sendRedirect("home"); 
        }
        else if(ngaySinh.length() == 0){
            session.setAttribute("error", "Ngày sinh trống");
            resp.sendRedirect("home");
        }
        else if(danToc.length() == 0){
            session.setAttribute("error", "Dân tộc không được trống");
            resp.sendRedirect("home"); 
        }
        else if(!Commons.checkSo(maTinh.trim())){
            session.setAttribute("error", "Mã tỉnh không hợp lệ");
            resp.sendRedirect("home"); 
        }
        else if(mucLuong < 0 || mucLuong > 100000000){
            session.setAttribute("error", "Lương từ 0 đồng đến 100.000.000 đồng");
            resp.sendRedirect("home"); 
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String typeSubmit = req.getParameter("submit");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        String username = user.getUsername();
        System.out.println(req.getParameter("ten"));
        String ten = Commons.fixName(req.getParameter("ten"));
        String soDT = req.getParameter("soDT").trim();
        String diaChi = req.getParameter("diaChi").trim();
        String soCMND = req.getParameter("soCMND").trim();
        String ngaySinh = req.getParameter("ngaySinh").trim();
        String danToc = req.getParameter("danToc").trim();
        boolean gioiTinh = (req.getParameter("gioiTinh").equals("0"));
        String maTinh = req.getParameter("maTinh").trim();
        int mucLuong = Integer.parseInt(req.getParameter("mucLuong"));
        boolean hinhThuc = (req.getParameter("hinhThuc").equals("0"));
                    
        if(typeSubmit.equals("add")){
            session.setAttribute("error", null);
            checkValidate(req, resp);
            if(session.getAttribute("error") == null){
                Info info = new Info(username, ten, soDT, diaChi, soCMND, ngaySinh, danToc, gioiTinh, maTinh,mucLuong, hinhThuc, false);
                boolean check = infoDAO.add(info);
                boolean check2 = false;
              
                
                user.setTrangThai(true);
                if(check == true){
                    check2 = userDAO.edit(user);
                    if(check2 == false){
                        infoDAO.delete(username);
                    }
                }
                if(check == true && check2 == true){
                    if(hinhThuc==true)
                    {
                        
                        session.setAttribute("info", info);
                         resp.sendRedirect("table");
                         }
                    }else{
                    session.setAttribute("info", info);
                    resp.sendRedirect("caculation");
                }
                }
                else{
                    session.setAttribute("error", "Cập nhật thông tin thất bại");
                    resp.sendRedirect("home");
                }
            }
        
        else if(typeSubmit.equals("update")){
            session.setAttribute("error", null);
            checkValidate(req, resp);
            if(session.getAttribute("error") == null){
                Info info = new Info(username, ten, soDT, diaChi, soCMND, ngaySinh, danToc, gioiTinh, maTinh,mucLuong, hinhThuc, false);
                boolean check = infoDAO.update(info);
                boolean check3= userFamily.update(info);
                if(check3==false) userFamily.add(info);
                if(check == true){
                    session.setAttribute("info", info);
                    if(hinhThuc==true){
                         resp.sendRedirect("table");
                          
                    }else{
                    resp.sendRedirect("caculation");
                   
                    }
                }
                else{
                    session.setAttribute("error", "Cập nhật thông tin thất bại");
                    resp.sendRedirect("home");
                }
            }
        }
    }
    
}
