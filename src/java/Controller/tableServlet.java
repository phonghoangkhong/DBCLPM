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
 * @author SA Nice
 */
public class tableServlet extends HttpServlet{
    InfoDAO info=new InfoDAO(); 
    UserFamilyDAO userFamilyDAO=new UserFamilyDAO();
     
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
        
        HttpSession session = req.getSession();
        String typeSubmit = req.getParameter("submit");
        User user = (User) session.getAttribute("user"); 
          Info info3=(Info)session.getAttribute("info");
        if(user != null){
            session.setAttribute("id", "table");
             
            ArrayList<Info> list=new ArrayList<>();
            list = userFamilyDAO.get(user.getUsername());
            System.out.println(list.size());
                    
            if(user.getTrangThai()== true){           
                 if(list.size()==0){
                Info info2=info.get(user.getUsername());
                 boolean b=userFamilyDAO.add(info2);
                     System.out.println(b);
                          
                    list.add(info2);
                  
                 }
                session.setAttribute("table", list);
                session.setAttribute("info", info3);
            }
            req.getRequestDispatcher("JSP/table.jsp").forward(req, resp);
        }
        else{
            resp.sendRedirect("firstPage");
        }
         
    }
    
}
