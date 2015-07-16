<%-- CONTATTI.JSP --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:import url="head.jsp"></c:import>
        <title>JB - Contatti</title>
    </head>
    <body class="normalbody">
        <c:import url="header.jsp"></c:import>
        
        <div class="row">
            <div class="col-md-3 col-md-offset-2 col-xs-10 col-xs-offset-1 dovesiamo"> <!--mancano misure tablet-->
                
                <h3>Dove siamo</h3>
                <center>
                    <iframe width="400" height="280" frameborder="0" src="http://www.bing.com/maps/embed/viewer.aspx?v=3&cp=46.424305~11.155004&lvl=15&w=400&h=280&sty=h&typ=d&pp=JabberBlab~Via%20Roen%2032%2C%20Ronzone~46.424305~11.155004&ps=&dir=0&mkt=it-it&src=O365&form=BMEMJS"></iframe>
                </center>
                <br>
                <p><b>JabberBlab Cinema</b><br>
                    Via Roen 32<br>
                    38010 Ronzone (TN)<br>
                Tel: 123456789
                </p>
            </div>
          
            <div class="col-md-3 col-md-offset-2 col-xs-10 col-xs-offset-1">
                <h3>Contattaci</h3>
                <form class="contattaci" action = "ContactUsMail" method="GET" id="contactus">
                    <div class="form-group">
                        <div>
                            <input type="text" class="form-control" name="contactus_nome" placeholder="Nome" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <input type="email" class="form-control" name="contactus_email" placeholder="Email" required>                        
                    </div>
                    <div class="form-group">
                        <textarea class="form-control col-md-12 col-xs-12" rows="6" name="contactus_mess" placeholder="Messaggio" required></textarea>
                    </div>
                    <br>
                    <button type="submit" id="sub_contactus" class="btn btn-default btn-block" value="invia">Invia</button>                
                    
                    <h3 style="color:green;"> <c:out value = '${resp}'> </c:out> </h3>
                </form>
                
                
            </div>
        </div>
        <c:import url="footer.jsp"></c:import>
    </body>
</html>
