<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informazioni sui Film e Spettacoli</title>
    </head>
    <body>
        <form action = "TestServlet" method= "POST">
            <table>
                <tr>
                    <td>Seleziona il film</td>
                    <td>
                        <select name = "film">
                            <option value = "">Tutti</option>
                            <c:forEach var = "film" items= "${lista_film}">
                                <option value = "${film}" <c:out value = "${film == current_film ? 'selected' : ''}"/>><c:out value = "${film}"/></option>     
                            </c:forEach>
                        </select>
                    <td>
                </tr>
                <tr>
                    <td>Seleziona la sala</td>
                    <td>
                        <select name = "sala">
                            <option value = "" >Tutte</option>
                            <c:forEach var = "sala" items = "${lista_sale}">
                                <option value = "${sala}" <c:out value = "${sala == current_sala ? 'selected' : ''}"/> ><c:out value = "${sala}"/></option>
                            </c:forEach>
                        </select>
                    </td>   
                </tr>
                <tr>
                    <td><input type = "submit" value = "Cerca"/></td>
                </tr>
             </table>
        </form>
                            
        <c:if test = "${empty lista_spettacoli}">
            <h1>Non sono presenti spettacoli per ${current_film} nella sala ${current_sala}!</h1>
        </c:if> 
    
        <ul>
            <c:forEach var = "spettacolo" items = "${lista_spettacoli}">
                <li><c:out value= "${spettacolo}"/></li>
            </c:forEach>
        </ul>
    </body>
</html>
