/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.InfoDAO;
import Models.Info;
import Models.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SA Nice
 */
public class homeServlet extends HttpServlet{
    InfoDAO infoDAO = new InfoDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user != null){
            session.setAttribute("id", "home");
            if(user.getTrangThai() == true){
                Info info = infoDAO.get(user.getUsername());
                session.setAttribute("info", info);
            }
            req.getRequestDispatcher("JSP/home.jsp").forward(req, resp);
        }
        else{
            resp.sendRedirect("firstPage");
        }
    }
    
}
