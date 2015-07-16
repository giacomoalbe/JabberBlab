<%-- REGISTRAZIONE.JSP --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:import url="head.jsp"></c:import>
        <title>JB - Registrati</title>
    </head>
    <body class="formbody">
        <c:import url="header_form.jsp"></c:import>
        <div class="col-md-4 col-md-offset-4 col-xs-10 col-xs-offset-1">
            <div id="form_registrazione">
                <center>
                <h3>Registrazione</h3>
                </center>
                <br>
        
                <form data-toggle="validator" action="AddUserServlet" > 
           <!-- <div class="form-group">
                <label for="nome_utente">Nome</label>
                <input type="text" class="form-control" id="nome_utente" placeholder="Nome" required>
            </div>
            <div class="form-group">
                <label for="cognome_utente">Cognome</label>
                <input type="text" class="form-control" id="cognome_utente" placeholder="Cognome" required>
            </div> -->
           <div class="form-group">
                <label for="username">Username</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="Username" required>
            </div> 
            <div class="form-group">
                <label for="email_utente">Indirizzo E-mail</label>
                <input type="email" class="form-control" id="email_utente" name="email" placeholder="E-mail" required>
            </div>
            <div class="form-group">
                
            <label for="inputPassword" class="control-label">Password</label>

            <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
            <br>
            <input type="password" class="form-control" id="inputPasswordConfirm" data-match="#password" data-match-error="Whoops, these don't match" placeholder="Conferma la password" required>
            <div class="help-block with-errors"></div>
            </div>
            <button type="submit" class="btn btn-success reg_completa"><b>Registrati</b></button>                  
        </form>
            </div>
            <br>
        <center>
            <a class="ritorna" href="home.jsp"><span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>Ritorna al sito</a>
        </center>
    </div>
    </body>
</html>
