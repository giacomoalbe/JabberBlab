<%-- HOME.JSP --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.json.simple.JSONObject"%>

<!DOCTYPE html>
<html>
    <head>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:import url="head.jsp"></c:import>
        <title>Jabberblab</title>
    </head>
    <body class="normalbody">
        <c:import url="header.jsp"></c:import>
        <div class="film_home_append"></div>
        
        <c:import url="footer.jsp"></c:import>
        
        
    </body>
</html>

<div id="film_modal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
               
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <div class="row"></div>
                    </div>   
                </div>
            </div>
        </div>
    </div>
</div>