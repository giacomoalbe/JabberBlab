package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class pg_005famministratore_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_import_url_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_import_url_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_import_url_nobody.release();
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        \r\n");
      out.write("        ");
      if (_jspx_meth_c_import_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("        <title>JB - Amministratore</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body class=\"normalbody\">\r\n");
      out.write("        ");
      if (_jspx_meth_c_import_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("        <div class=\"box_amministratore\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-4 col-xs-12\">\r\n");
      out.write("                    <div class=\"inner_amministratore\">\r\n");
      out.write("                        <center>\r\n");
      out.write("                            <h3>Incassi</h3><br>\r\n");
      out.write("                            <div class=\"incassi_container\">\r\n");
      out.write("                            <table id=\"incassi\" class=\"table table-striped table-responsive\">\r\n");
      out.write("                                <thead>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <th>Titolo</th>\r\n");
      out.write("                                        <th>Spettacolo</th>\r\n");
      out.write("                                        <th>Biglietti</th>\r\n");
      out.write("                                        <th>€</th>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                </thead>\r\n");
      out.write("                                <tbody>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <td>Alla ricerca di Nemo</td>\r\n");
      out.write("                                        <td>Sala 1 - 16 luglio - 21:00</td>\r\n");
      out.write("                                        <td>34/50</td>\r\n");
      out.write("                                        <td>xx</td>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <td>bu</td>\r\n");
      out.write("                                        <td>bu</td>\r\n");
      out.write("                                        <td>bu</td>\r\n");
      out.write("                                        <td>bu</td>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <td>Ciao</td>\r\n");
      out.write("                                        <td>Ciao</td>\r\n");
      out.write("                                        <td>Ciao</td>\r\n");
      out.write("                                        <td>Ciao</td>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <td>bu</td>\r\n");
      out.write("                                        <td>bu</td>\r\n");
      out.write("                                        <td>bu</td>\r\n");
      out.write("                                        <td>bu</td>\r\n");
      out.write("                                    </tr>  \r\n");
      out.write("                                </tbody>\r\n");
      out.write("                            </table>\r\n");
      out.write("                            </div>     \r\n");
      out.write("                    </center>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"spazio\"><br></div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-4 col-xs-12\">\r\n");
      out.write("                    <div class=\"inner_amministratore\">\r\n");
      out.write("                        <center><h3>Programmazione</h3><br>\r\n");
      out.write("                            <div class=\"programmazione_container\">\r\n");
      out.write("                            <table id=\"programmazione\" class=\"table table-striped table-responsive\">\r\n");
      out.write("                                <thead>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <th>Titolo</th>\r\n");
      out.write("                                        <th>Spettacolo</th>\r\n");
      out.write("                                        <th># Posti</th>\r\n");
      out.write("                                        <th>Dettagli</th>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                </thead>\r\n");
      out.write("                                <tbody>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <td>Ciao</td>\r\n");
      out.write("                                        <td>Ciao</td>\r\n");
      out.write("                                        <td>Ciao</td>\r\n");
      out.write("                                        <td><center><button class=\"btn btn-info btn-xs\" id=\"esamina_spettacolo\"><span class=\"glyphicon glyphicon-search\"></span></button></center></td>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <td>bu</td>\r\n");
      out.write("                                        <td>bu</td>\r\n");
      out.write("                                        <td>bu</td>\r\n");
      out.write("                                        <td><center><button class=\"btn btn-info btn-xs\" id=\"esamina_spettacolo\"><span class=\"glyphicon glyphicon-search\"></span></button></center></td>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <td>Ciao</td>\r\n");
      out.write("                                        <td>Ciao</td>\r\n");
      out.write("                                        <td>Ciao</td>\r\n");
      out.write("                                        <td><center><button class=\"btn btn-info btn-xs\" id=\"esamina_spettacolo\"><span class=\"glyphicon glyphicon-search\"></span></button></center></td>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <td>bu</td>\r\n");
      out.write("                                        <td>bu</td>\r\n");
      out.write("                                        <td>bu</td>\r\n");
      out.write("                                        <td><center><button class=\"btn btn-info btn-xs\" id=\"esamina_spettacolo\"><span class=\"glyphicon glyphicon-search\"></span></button></center></td>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                </tbody>\r\n");
      out.write("                            </table>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </center>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"spazio\"><br></div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-4 col-xs-12\">\r\n");
      out.write("                    <div class=\"inner_amministratore\">\r\n");
      out.write("                        <center><h3>Clienti top</h3><br>\r\n");
      out.write("                            <div class=\"clientitop_container\">\r\n");
      out.write("                            <table id=\"clientitop\" class=\"table table-striped table-responsive\">\r\n");
      out.write("                                <thead>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <th>Nome</th>\r\n");
      out.write("                                        <th>Cognome</th>\r\n");
      out.write("                                        <th># Film</th>\r\n");
      out.write("                                        <th>€</th>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                </thead>\r\n");
      out.write("                                <tbody>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <td>Ciao</td>\r\n");
      out.write("                                        <td>Ciao</td>\r\n");
      out.write("                                        <td>Ciao</td>\r\n");
      out.write("                                        <td>Ciao</td>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <td>bu</td>\r\n");
      out.write("                                        <td>bu</td>\r\n");
      out.write("                                        <td>bu</td>\r\n");
      out.write("                                        <td>bu</td>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <td>Ciao</td>\r\n");
      out.write("                                        <td>Ciao</td>\r\n");
      out.write("                                        <td>Ciao</td>\r\n");
      out.write("                                        <td>Ciao</td>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <td>bu</td>\r\n");
      out.write("                                        <td>bu</td>\r\n");
      out.write("                                        <td>bu</td>\r\n");
      out.write("                                        <td>bu</td>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                </tbody>\r\n");
      out.write("                            </table>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </center>\r\n");
      out.write("                    </div>                \r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        ");
      if (_jspx_meth_c_import_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("<div id=\"spettacoloutenti_modal\" class=\"modal fade\">\r\n");
      out.write("    <div class=\"modal-dialog\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("                <div><button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button><h3 class=\"modal-title\">TITOLO FILM - SPETTACOLO</h3></div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\">\r\n");
      out.write("                <div class=\"container-fluid\">\r\n");
      out.write("                    <table id=\"spettacoloutenti\" class=\"table table-striped\">\r\n");
      out.write("                                <thead>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <th>Nome</th>\r\n");
      out.write("                                        <th>Cognome</th>\r\n");
      out.write("                                        <th># Posti</th>\r\n");
      out.write("                                        <th>Elimina</th>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                </thead>\r\n");
      out.write("                                <tbody>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <td>Chiara</td>\r\n");
      out.write("                                        <td>Dalpiaz</td>\r\n");
      out.write("                                        <td>2</td>\r\n");
      out.write("                                        <td><button class=\"btn btn-danger btn-xs\" id=\"elimina_spettacoloutente\"><span class=\"glyphicon glyphicon-trash\"></span></button></td>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <td>Monica</td>\r\n");
      out.write("                                        <td>Pedron</td>\r\n");
      out.write("                                        <td>3</td>\r\n");
      out.write("                                        <td><button class=\"btn btn-danger btn-xs\" id=\"elimina_spettacoloutente\"><span class=\"glyphicon glyphicon-trash\"></span></button></td>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <td>Giacomo</td>\r\n");
      out.write("                                        <td>Alberini</td>\r\n");
      out.write("                                        <td>4</td>\r\n");
      out.write("                                        <td><button class=\"btn btn-danger btn-xs\" id=\"elimina_spettacoloutente\"><span class=\"glyphicon glyphicon-trash\"></span></button></td>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <td>Andrea</td>\r\n");
      out.write("                                        <td>Brunelli</td>\r\n");
      out.write("                                        <td>1</td>\r\n");
      out.write("                                        <td><button class=\"btn btn-danger btn-xs\" id=\"elimina_spettacoloutente\"><span class=\"glyphicon glyphicon-trash\"></span></button></td>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                </tbody>\r\n");
      out.write("                            </table>\r\n");
      out.write("                    </div>   \r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>");
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

  private boolean _jspx_meth_c_import_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_import_0 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _jspx_tagPool_c_import_url_nobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    _jspx_th_c_import_0.setPageContext(_jspx_page_context);
    _jspx_th_c_import_0.setParent(null);
    _jspx_th_c_import_0.setUrl("head.jsp");
    int[] _jspx_push_body_count_c_import_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_import_0 = _jspx_th_c_import_0.doStartTag();
      if (_jspx_th_c_import_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_import_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_import_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_import_0.doFinally();
      _jspx_tagPool_c_import_url_nobody.reuse(_jspx_th_c_import_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_import_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_import_1 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _jspx_tagPool_c_import_url_nobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    _jspx_th_c_import_1.setPageContext(_jspx_page_context);
    _jspx_th_c_import_1.setParent(null);
    _jspx_th_c_import_1.setUrl("header.jsp");
    int[] _jspx_push_body_count_c_import_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_import_1 = _jspx_th_c_import_1.doStartTag();
      if (_jspx_th_c_import_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_import_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_import_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_import_1.doFinally();
      _jspx_tagPool_c_import_url_nobody.reuse(_jspx_th_c_import_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_import_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_import_2 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _jspx_tagPool_c_import_url_nobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    _jspx_th_c_import_2.setPageContext(_jspx_page_context);
    _jspx_th_c_import_2.setParent(null);
    _jspx_th_c_import_2.setUrl("footer.jsp");
    int[] _jspx_push_body_count_c_import_2 = new int[] { 0 };
    try {
      int _jspx_eval_c_import_2 = _jspx_th_c_import_2.doStartTag();
      if (_jspx_th_c_import_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_import_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_import_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_import_2.doFinally();
      _jspx_tagPool_c_import_url_nobody.reuse(_jspx_th_c_import_2);
    }
    return false;
  }
}
