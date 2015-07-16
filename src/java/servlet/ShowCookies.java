/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
/** Creates a table of the cookies associated with the current page. */
public class ShowCookies extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
                 throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "Active Cookies";
    out.println("<HTML><HEAD><TITLE>" +title+ "</TITLE></HEAD>" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
                "<TABLE BORDER=1 ALIGN=\"CENTER\">\n" +
                "<TR BGCOLOR=\"#FFAD00\">\n" +
                "  <TH>Cookie Name\n" + "  <TH>Cookie Value");
                Cookie[] cookies = request.getCookies();
    Cookie cookie;
    for(int i=0; i<cookies.length; i++) {
      cookie = cookies[i];
      out.println("<TR>\n" +
                  "  <TD>" + cookie.getName() + "\n" +
                  "  <TD>" + cookie.getValue());
}
    out.println("</TABLE></BODY></HTML>");
  }
}