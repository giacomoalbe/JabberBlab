/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andrea
 */
public class ShowSession extends HttpServlet {
   public void doGet(HttpServletRequest request, HttpServletResponse
      response)
      throws ServletException, IOException {
      response.setContentType("text/html");
      HttpSession session = request.getSession();
      String heading;
      Integer accessCount =(Integer)session.getAttribute("accessCount");
      if (accessCount == null) {
         accessCount = new Integer(0);
         heading = "Welcome, Newcomer";
      } else {
         heading = "Welcome Back";
         accessCount =new Integer(accessCount.intValue() + 1);
}
      String title = "session";
      session.setAttribute("accessCount", accessCount);
      PrintWriter out = response.getWriter();
      out.println("<HTML><TITLE>"+ title + "</TITLE>" +
               "<BODY BGCOLOR=\"#FDF5E6\">\n" +
               "<H1 ALIGN=\"CENTER\">" + heading + "</H1>\n" +
               "<H2>Information on Your Session:</H2>\n" +
               "<TABLE BORDER=1 ALIGN=\"CENTER\">\n" +
               "<TR BGCOLOR=\"#FFAD00\">\n" +
               " <TH>Info Type<TH>Value\n" +
               "<TR>\n" +   " <TD>ID\n" +
               " <TD>" + session.getId() + "\n" +  "<TR>\n" +
               " <TD>Creation Time\n" +
               " <TD>" +   new Date(session.getCreationTime()) + "\n" +
               "<TR>\n" + " <TD>Time of Last Access\n" +
               " <TD>" + session.getLastAccessedTime() + "\n" +
               "<TR>\n" +
               " <TD>Number of Previous Accesses\n" +
               " <TD>" + accessCount + "\n" +
               "</TABLE>\n" +   "</BODY></HTML>");
   }
}