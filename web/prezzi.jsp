<%-- PREZZI.JSP --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:import url="head.jsp"></c:import>
        <title>JB - Prezzi</title>
    </head>
    <body class="normalbody">
        <c:import url="header.jsp"></c:import>
        <br>
        <div class="row">
            <div class="col-md-6 col-md-offset-3 col-xs-10 col-xs-offset-1 col-sm-10 col-xs-offset-1 fondobianco">
                <center><h3>Prezzi</h3></center>
                <table class="table prezzi">
                    <tr>
                        <th></th>
                        <th>Prezzo</th>
                    </tr>
                    <tr>
                        <th>Intero</th>
                        <td>6,00€</td>
                    </tr>
                    <tr>
                        <th>Bambini fino a 11 anni</th>
                        <td>3,00€</td>
                    </tr>
                    <tr>
                        <th>Universitari</th>
                        <td>4,00€</td>
                    </tr>
                </table>
                
            </div>   
        </div>
        <c:import url="footer.jsp"></c:import>
    </body>
</html>
