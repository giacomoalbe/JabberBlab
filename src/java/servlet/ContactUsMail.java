/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static servicies.SendMailTLS.sendEmail;

/**
 *
 * @author Andrea
 */
public class ContactUsMail extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String nome = request.getParameter("contactus_nome");
            String email = request.getParameter("contactus_email");
            String msg = request.getParameter("contactus_mess");
            
            String redirecting = "jabberblabcinema@gmail.com";
            String mergeContent = 
                    "---------------------------------------\nRICHIESTA INFORMAZIONE\n---------------------------------------\n" +
                    "Richiedente: " + nome
                    + "\nMessaggio: " + msg +"\n\nRispondere a: " + email +"";
            String subject = "Richiesta info - "+ nome +"";
            sendEmail(redirecting,subject,mergeContent);
            
            String ciao = "ciao schifo";
            
            String risp = "Grazie per averci contattato!";
                    
                    
                    request.setAttribute("resp", risp);
                    RequestDispatcher disp = request.getRequestDispatcher("/contatti.jsp");
                    disp.forward(request, response);
                    
            //response.sendRedirect("home.jsp" + risp);
           
            
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
        processRequest(request, response);
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
        processRequest(request, response);
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
