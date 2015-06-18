<%-- 
    Document   : login.jsp
    Created on : 4-giu-2015, 16.02.36
    Author     : Andrea
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>Ciao ciccio, dai loggati</h1>
        <div class="container_log">
        <form action="servlet" method="POST" name="LoginServlet">
            Nome utente: </br>
            <input type="text" name="nome_utente"> </br>
            Email: </br>
            <input type="email" name="email"></br>
            Password </br>
            <input type="password" name="password"></br>
            <input type="submit" value="Submit"></br>
        </form>
        </div>
        
          <div class="container_reg">
        <form action="servlet" method="POST" name="DBManager">
            Nome utente: </br>
            <input type="text" name="nome_utente"> </br>
            Email: </br>
            <input type="email" name="email"></br>
            Password </br>
            <input type="password" name="password"></br>
            <input type="submit" value="Submit"></br>
        </form>
        </div>
        <a href="loggati.jsp">Vedi i loggati</a>
    </center>
    </body>
</html>
