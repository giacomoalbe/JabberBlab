/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.User;
import db.DBManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUserServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, Exception {
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
           
            DBManager manager = new DBManager();
            User user = new User();
            user = manager.addUser(firstname, lastname, email, password);
            out.println(user);
            if(user != null){
            Cookie loginCookie = new Cookie("user",user.getFirstname() + " " + user.getLastname());
            //setting cookie to expiry in 1 hour
            loginCookie.setMaxAge(3600);
            response.addCookie(loginCookie);
            response.sendRedirect("home.jsp");
        }
        else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("registrazione.jsp");
            out.println("<font color = 'red'> Errore: email già inserita! Ti vuoi registrare due volte? Ma che pollo! </font>");
            rd.include(request, response);
        }
            
            /*
            STAMPAGGIO UTENTI
            
            List<User> UtentiNow = manager.getUtente();
            
            for ( int i = UtentiNow.size() ; i >= 0 ; i-- )
            {
            User s = UtentiNow.get(i) ;
            out.println(UtentiNow.get(i).printUser());
            }
            
            if(UtentiNow.isEmpty()){
                out.println("la lista vuota <br>");
            }else{
            out.println("non è vuota e ovviamente te li ho fatti vedere, no? <br>");
            }*/
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AddUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AddUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
