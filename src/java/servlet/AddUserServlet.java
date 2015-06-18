/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.User;
import db.DBManager;
import db.DBManagerStandard;
import db.JDBCExample;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUserServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            // Ora lo inserisco in un database
           
            out.println("Arrivato nella servlet <br>");
            
            //DBManagerStandard manager = new DBManagerStandard();
            
            JDBCExample manager = new JDBCExample();
            
            //Connection conn = manager.getConnection();
            out.println("Arrivato dopo la connessione <br>");
            String vediamo = null;
            
            out.println("registro " + username + "<br>");
            
            vediamo = manager.addUser(username, email, password);
            out.println(vediamo);
            
            List<User> UtentiNow = manager.getUtente();
            
            for ( int i = UtentiNow.size() ; i >= 0 ; i-- )
            {
            User s = UtentiNow.get(i) ;
            System.out.println( "Utente " + i + " is " + s + " <br>" ) ;
            }
            
            if(UtentiNow.isEmpty()){
                out.println("la lista vuota <br>");
            }else{
            out.println("non è vuota e ovviamente te li ho fatti vedere, no? <br>");
            }
            
            
            out.println("Abbiamo creato un DBManager e funziona! <br>");
            
            
            /*try {
            if (conn!=null) {
                out.println("connessione chiusa");
                conn.close();
            }
            } catch (SQLException e) {
                System.out.println("Chiusura della connessione in Servlet");
            }*/
            
            /*try {
                manager.addUser(username, password);
            } catch (SQLException e) {
                System.out.println("Errore in ServletAddUser: " + e.toString());
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
        }
    }

}
