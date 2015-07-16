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
            
            <h3>Form Login</h3>
            
        <form action="" method="POST" name="log_form">
            Nome utente: </br>
            <input type="text" name="username"> </br>
            Email: </br>
            <input type="email" name="email"></br>
            Password </br>
            <input type="password" name="password"></br>
            <input type="submit" value="Submit"></br>
        </form>
        </div>
        
          <div class="container_reg">
        <form action="AddUserServlet" method="POST" name="reg_form">
            
            <h3>Form Registrazione</h3>
            
            Nome utente: </br>
            <input type="text" name="username"> </br>
            Email: </br>
            <input type="email" name="email"></br>
            Password </br>
            <input type="password" name="password"></br>
            <input type="submit" value="Submit"></br>
        </form>
        </div>
        <br>
        
        <form action="ShowUser" method="GET" name="show_usr">    
            <input type="submit" value="Vedi i registrati"></br>
        </form>
        
       
        
        
        
    </center>
    </body>
</html>
