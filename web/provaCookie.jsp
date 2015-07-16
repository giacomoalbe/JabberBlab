<%-- PROVACOOKIE.JSP --%>

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
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h3 class="modal-title">TITOLO FILM</h3>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-4 col-xs-12 film_modal_col1">
                            <center><img class="modal_copertina" src="imgs/prove/film_prova5.jpg"/></center><br>
                            <b>Titolo: </b> Ciao<br>
                            <b>Genere: </b> Ciao<br>
                            <b>Durata: </b> 120min<br>
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.<br>
                            <a target="_blank" href="https://www.youtube.com/"><b>Trailer YouTube</b></a>
                        </div>
                        <div class="col-md-4 col-xs-12 film_modal_col2">
                            
                            <div style="background-color: #333333; color: #FFFFFF; padding: 0.5em;">Sala 1 - Ore 17.45</div>
                            <br>
                            <div style="background-color: #333333; color: #FFFFFF; padding: 0.5em;">Sala 1 - Ore 20.00</div>
                        </div>
                        <div class="col-md-4 col-xs-12 film_modal_col3">
                            <center><img src="imgs/esempiosala.JPG"/></center><br>
                            <button class="btn btn btn-success btn-block" action="chooseticket">Compra un biglietto! <span class="glyphicon glyphicon glyphicon-arrow-right"></span></button>
                        </div>
                    </div>   
                </div>
            </div>
        </div>
    </div>
</div>