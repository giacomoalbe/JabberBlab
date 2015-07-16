<%-- RECUPERO_PASSWORD.JSP--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:import url="head.jsp"></c:import>
        <title>JB - Recupero password</title>
    </head>
    <body class="formbody">
        <div class="sfondo">
        <c:import url="header_form.jsp"></c:import>
        <div class="col-md-6 col-md-offset-3 col-xs-10 col-xs-offset-1">
            <div id="form_recuperopass">
                <center>    
                    <h3>Recupero password via mail</h3>
            <br>
            <p>Inserire la mail utilizzata al momento della registrazione. Vi verrà inviata una mail contenente la password.</p>
            <br>
            </center>
            <form method="GET" action="RecuperoPassword" > 
            <div class="form-group row">
                <div class="col-md-9 col-xs-8">
                <input type="email" name="email" class="form-control" id="email_utente" placeholder="Email" required>
                </div>
                <div class="col-md-2 col-md-offset-1 col-xs-2 col-xs-offset-1">
                    <button type="submit" class="btn btn-default invio_mail_pass">Invia</button>
                </div>
            </div>
            </form>
                </div>
            <br>
        <center>
            <a class="ritorna" href="home.jsp"><span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>Ritorna al sito</a>
        </center>
    </div>
    </div>
    </body>
</html>
