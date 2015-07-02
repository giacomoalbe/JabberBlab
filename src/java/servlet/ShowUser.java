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
import java.io.*;
import static java.lang.System.out;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andrea
 */
public class ShowUser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        
        response.setContentType("text/html;charset=UTF-8");
        
     
    try (PrintWriter out = response.getWriter()) {
        String returnUserServlet = ShowUserTable();
        out.println(returnUserServlet);
    }
       
    
    }
 
            
     public String ShowUser() throws SQLException{
            
        
            DBManager manager = new DBManager();
            String userReturn = null;
            List<User> UtentiNow = manager.getUtente();
          
            int i = 0;
            while(i<UtentiNow.size())
            {
            User s = UtentiNow.get(i);
            userReturn += "Utente " + i + " : " + UtentiNow.get(i).printUser();
            i++;
            }
            out.println(userReturn);
            if(UtentiNow.isEmpty()){
                out.println("la lista vuota <br>");
            }else{
            out.println("non è vuota e ovviamente te li ho fatti vedere, no? <br>");
            }
            
            
            
            return userReturn;
     }
     
     public String ShowUserTable() throws SQLException{
            
        
            DBManager manager = new DBManager();
            String userReturn = "";
            List<User> UtentiNow = manager.getUtente();
            userReturn += "<table name='usertable' border = '1px solid'>";
            int i = 0;
            while(i<UtentiNow.size())
            {
            User s = UtentiNow.get(i);
            userReturn +=UtentiNow.get(i).printUserTable();
            i++;
            }
            userReturn += "</table>";
            out.println(userReturn);
            if(UtentiNow.isEmpty()){
                out.println("la lista vuota <br>");
            }else{
            out.println("non è vuota e ovviamente te li ho fatti vedere, no? <br>");
            }

            return userReturn;
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
            Logger.getLogger(ShowUser.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ShowUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
