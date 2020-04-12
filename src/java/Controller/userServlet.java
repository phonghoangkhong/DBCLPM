/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Commons.Commons;
import DAO.UserDAO;
import Models.User;
import java.io.IOException;
import Encrypted.EncryptedPassword;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SA Nice
 */
public class userServlet extends HttpServlet{
    UserDAO userDAO = new UserDAO();
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String typeSubmit = req.getParameter("submit");
        HttpSession session = req.getSession();
        if(typeSubmit.equals("login")){
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            if(!Commons.checkUsername(username)){
                session.setAttribute("errorLogin", "Username or password in correct!");
                resp.sendRedirect("firstPage"); 
            }
            else if(Commons.checkPassword(password) && !password.equals("admin")){
                session.setAttribute("errorLogin", "Username or password in correct!");
                resp.sendRedirect("firstPage");
            }
            else{
                User user = userDAO.login(username, password);  
                if(user != null){
                    session.setAttribute("user", user);
                    resp.sendRedirect("home");
                }
                else{
                    session.setAttribute("errorLogin", "Username or password in correct!");
                    resp.sendRedirect("firstPage"); 
                }
            }
        }
        else if(typeSubmit.equals("register")){
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String repassword = req.getParameter("repassword");
            
            if(!Commons.checkUsername(username)){
                session.setAttribute("errorRegister", "Username don't have special character ");
                resp.sendRedirect("firstPage"); 
            }
            else if(username.length() < 6){
                session.setAttribute("errorRegister", "Username have at least 6 characters");
                resp.sendRedirect("firstPage"); 
            }
            else if(!password.equals(repassword)){
                session.setAttribute("errorRegister", "Password and Repeat password not same");    
                resp.sendRedirect("firstPage");  
            }
            else if(Commons.checkPassword(password))
            {
                session.setAttribute("errorRegister", "Password have at least 8 characters, contains at least one digit, contains at least one lower alpha char and one upper alpha char, contains at least one char within a set of special chars, does not contain space,tab");    
                resp.sendRedirect("firstPage");  
            }
            else{
                try {
                    password=EncryptedPassword.sha1(password);
                } catch (NoSuchAlgorithmException ex) {
                    System.out.println("Khong ma hoa duoc");
                }
                User user = new User(username, password, false);
                if(userDAO.register(user)){
                    session.setAttribute("message", "Register success!");
                    resp.sendRedirect("firstPage");
                }
                else{
                    session.setAttribute("errorRegister", "This account already exists!");
                    resp.sendRedirect("firstPage");
                }
            }
        }
        else if(typeSubmit.equals("logout")){
            session.setAttribute("user", null);
            resp.sendRedirect("home");
        }
    }
}
