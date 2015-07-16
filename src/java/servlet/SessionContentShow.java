/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andrea
 */
public class SessionContentShow extends HttpServlet {
@Override
public void doGet(HttpServletRequest request,
   HttpServletResponse response)
   throws ServletException, IOException {

     HttpSession session = request.getSession();
     
     List<String> previousItems =  (List<String>) session.getAttribute("previousItems");
     if (previousItems == null) {
       previousItems = new ArrayList();
       session.setAttribute("previousItems",previousItems);
       String newItem = request.getParameter("newItem");
PrintWriter out = response.getWriter();

synchronized(previousItems) {
   if (newItem != null) {
      previousItems.add(newItem);
   }
   if (previousItems.isEmpty()) {
      out.println("<I>No items</I>");
   } else {
      out.println("<UL>");
      for(int i=0; i<previousItems.size(); i++) {
        out.println("<LI>" + (String)previousItems.get(i));
      }
   out.println("</UL>");
   out.println("Per ordinare ancora, click <A HREF=\"" +
   response.encodeUrl("sessionprova.jsp") +
   "\">here</A>");
   }
} out.println("</BODY></HTML>");}
}   
}
