<%-- LOGIN.JSP --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:import url="head.jsp"></c:import>
        <title>JB - Login</title>
    </head>
    <body class="formbody">
        <div class="sfondo">
    <c:import url="header_form.jsp"></c:import>
    <div class="col-md-4 col-md-offset-4 col-sm-8 col-sm-offset-2 col-xs-8 col-xs-offset-2">
        <div id="form_login">
        <form action="LoginServlet" method="GET">   
            <div class="form-group">
                <label for="email_utente">Indirizzo E-mail</label>
                <input type="email" class="form-control" id="email_utente" name="email_utente" placeholder="Email">
            </div>
            <div class="form-group">
                <label for="password">Password</label><a href="recupero_password.jsp" class="pass_dimenticata">Password dimenticata?</a>
                <input type="password" class="form-control" id="password" name="password" placeholder="Password">
            </div>
            <div class="form-group row">
                <div class="checkbox col-md-4">
                    <label>
                        <input type="checkbox" id="ricordami">Ricordami
                    </label>
                </div>
                <div class="col-md-4 col-md-offset-4">
                    <button type="submit" id="sub_login" class="btn btn-default"><b>Login</b></button>            
                </div>
            </div>
            </form>
        
        <a href="registrazione.jsp" class="btn btn-success btn-block registrazione" role="button"><b>Registrati</b></a>
        </div>
        <br>
        <center>
            <a class="ritorna" href="home.jsp"><span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>Ritorna al sito</a>
        </center>        
        
    </div>
    </div>
    </body>
</html>
