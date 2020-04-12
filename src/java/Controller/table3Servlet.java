/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Commons.Commons;
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
public class table3Servlet extends HttpServlet {
    
      @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {  
          HttpSession session = req.getSession();
          ArrayList<Info> list=new ArrayList<>();
          list= (ArrayList<Info>)session.getAttribute("table");
          
          resp.sendRedirect("caculation");
              
       
      
    }
    
    
}
