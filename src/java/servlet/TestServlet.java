/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import db.DBManager;
import dbUtils.SalaManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andrea
 */
public class TestServlet extends HttpServlet {

    private static boolean inizializza = false;
    
    private List<String> listaFilm = new ArrayList();
    private List<String> listaSale = new ArrayList();
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Carichiamo la pagina con i form per vedere la situazione dei film 
        if (inizializza) {
            try {
                
                System.out.println("Inizializzato");
                DBManager.creaSpettacoli();
                inizializza = false;
                
            } catch (SQLException ex) {
                
                Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Errore in creaSpettacoli: " + ex.toString());
                
            }
        } 
        
        listaFilm = DBManager.getAll("film", "titolo");
        listaSale = DBManager.getAll("sala", "id_sala");
        
        request.setAttribute("lista_film", listaFilm);
        request.setAttribute("lista_sale", listaSale);
        
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/form_film.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String film = request.getParameter("film");
        String sala = request.getParameter("sala");
        
        System.out.println("Entra almeno qui!");
        
        List<String> listaSpettacoli = DBManager.getFilmPerSala(film, sala);
        
        for (int i = 0; i < listaSpettacoli.size(); i++) {
            System.out.println(listaSpettacoli.get(i));
        }
        
        request.setAttribute("lista_spettacoli", listaSpettacoli);
        
        // Valori per popolare le select
        request.setAttribute("lista_film", this.listaFilm);
        request.setAttribute("lista_sale", this.listaSale);
        request.setAttribute("current_film", film);
        request.setAttribute("current_sala", sala);
        
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/form_film.jsp");
        rd.forward(request, response);
              
    }

}
