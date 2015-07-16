<%-- PAGINA UTENTE --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:import url="head.jsp"></c:import>
        <title>JB - Profilo utente</title>
    </head>
    <body class="normalbody">
        <c:import url="header.jsp"></c:import>
        <div class="box_utente">
            <div class="row">
                <div class="col-md-7 col-xs-12">
                    <div class="inner_utente">
                        <center>
                            <h3>Film visti</h3><br>
                            <div class="filmvisti_container">
                            <table id="filmvisti" class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Titolo</th>
                                        <th>Sala</th>
                                        <th>Giorno</th>
                                        <th>Orario</th>
                                        <th>€</th>
                                        <th>Status</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <td><button class="btn btn-warning btn-xs" id="status_film"><span class="glyphicon glyphicon-facetime-video" title="film_prenotato"></span></button></td>
                                    </tr>
                                    <tr>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td><button class="btn btn-warning btn-xs" id="status_film"><span class="glyphicon glyphicon-facetime-video" title="film_prenotato"></span></button></td>
                                    </tr>
                                    <tr>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <td><button class="btn btn-warning btn-xs" id="status_film"><span class="glyphicon glyphicon-facetime-video" title="film_prenotato"></span></button></td>
                                    </tr>
                                    <tr>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td><button class="btn btn-success btn-xs" id="status_film"><span class="glyphicon glyphicon-facetime-video" title="film_visto"></span></button></td>
                                    </tr>  
                                </tbody>
                            </table>
                            </div>     
                    </center>
                    </div>
                </div>
                <div class="col-md-5 col-xs-12">
                    <div class="statisticheutente_container">
                        <div class="row statistiche_utente">
                            <div class="col-md-4 col-xs-4 statistiche_utente_col1">
                                <img class="img_statisticheutente" src="imgs/filmvisti.jpg"/>
                                <h3>Film visti</h3>
                                <p>dati</p>
                            </div>
                            <div class="col-md-4 col-xs-4 statistiche_utente_col2">
                                <img class="img_statisticheutente" src="imgs/oretotali.jpg"/>
                                <h3>Ore totali</h3>
                                <p>dati</p>
                            </div>
                            <div class="col-md-4 col-xs-4 statistiche_utente_col3">
                                <img class="img_statisticheutente" src="imgs/credito.jpg"/>
                                <h3>Credito</h3>
                                <p>dati</p>
                            </div>
                        </div>
                        <div class="spazio"><br></div>
                        <div class="infoutente_container"> 
                            <p><b>Nome: </b>Chiara</p>
                            <p><b>Cognome: </b>Dalpiaz</p>
                            <p><b>Email: </b>chiara.dalpiaz@hotmail.it</p>
                            <p><b>Password: </b>pollo</p>
                            <hr class="divisore_info">
                            <p><b>Carta di Credito</b></p>
                            <p><b>Codice: </b>1234 1234 1234 1234</p>
                            <p><b>Scadenza: </b>02/20</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <c:import url="footer.jsp"></c:import>
    </body>
</html>
