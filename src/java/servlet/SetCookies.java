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
import java.sql.SQLException;
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
import java.io.*;   
import javax.servlet.*; 
import javax.servlet.http.*;
/** Sets six cookies: three that apply only to the current session
 * (regardless of how long that session lasts) and three that persist for an hour
 * (regardless of whether the browser is restarted).
 */
public class SetCookies extends HttpServlet {
  public void doGet(HttpServletRequest request,
       HttpServletResponse response)
               throws ServletException, IOException {
    int i = 0;
     // Default maxAge is -1, indicating cookie applies only to current browsing session.
     //Cookie cookie = new Cookie("Session-Cookie-" + i, "Cookie-Value-S" + i);
        Cookie cookie = new Cookie("Session-Cookie-" + i, "Cookie-Values-S" + "Elemento salavato 2");
       cookie.setMaxAge(-1);
      response.addCookie(cookie);
      //cookie = new Cookie("Persistent-Cookie-" + i,"Cookie-Value-P" + i);
      // Cookie is valid for an hour, regardless of whether
      // user quits browser, reboots computer, or whatever.
      cookie.setMaxAge(3600);
      response.addCookie(cookie);
    
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "Setting Cookies";
   /*out.println ("<HTML><HEAD><TITLE>" +title+ "</TITLE></HEAD>" +
       "<BODY BGCOLOR=\"#FDF5E6\">\n" +"<H1 ALIGN=\"CENTER\">"
      + title + "</H1>\n There are six cookies associated with this page.\n" + "</BODY></HTML>");*/
    out.println("cookie settato correttamente");
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
   

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

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
