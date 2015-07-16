package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_0028Brune_0029_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"style.css\" rel=\"stylesheet\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <center>\n");
      out.write("        <h1>Ciao ciccio, dai loggati</h1>\n");
      out.write("        <div class=\"container_log\">\n");
      out.write("            \n");
      out.write("            <h3>Form Login</h3>\n");
      out.write("            \n");
      out.write("        <form action=\"LoginServlet\" method=\"POST\" name=\"log_form\">\n");
      out.write("            Nome utente: </br>\n");
      out.write("            <input type=\"text\" name=\"username\"> </br>\n");
      out.write("            Email: </br>\n");
      out.write("            <input type=\"email\" name=\"email\"></br>\n");
      out.write("            Password </br>\n");
      out.write("            <input type=\"password\" name=\"password\"></br>\n");
      out.write("            <input type=\"submit\" value=\"Submit\"></br>\n");
      out.write("        </form>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("          <div class=\"container_reg\">\n");
      out.write("        <form action=\"AddUserServlet\" method=\"POST\" name=\"reg_form\">\n");
      out.write("            \n");
      out.write("            <h3>Form Registrazione</h3>\n");
      out.write("            \n");
      out.write("            Nome utente: </br>\n");
      out.write("            <input type=\"text\" name=\"username\"> </br>\n");
      out.write("            Email: </br>\n");
      out.write("            <input type=\"email\" name=\"email\"></br>\n");
      out.write("            Password </br>\n");
      out.write("            <input type=\"password\" name=\"password\"></br>\n");
      out.write("            <input type=\"submit\" value=\"Submit\"></br>\n");
      out.write("        </form>\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        \n");
      out.write("        <form action=\"ShowUser\" method=\"GET\" name=\"show_usr\">    \n");
      out.write("            <input type=\"submit\" value=\"Vedi i registrati\"></br>\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("       \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </center>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
