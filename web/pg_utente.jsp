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
                            <table id="filmvisti" class="table table-striped table-responsive">
                                <thead>
                                    <tr>
                                        <th>Titolo</th>
                                        <th>Sala</th>
                                        <th>Quando</th>
                                        <th>Posti</th>
                                        <th>€</th>
                                        <!--<th>Stato</th>-->
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Alla ricerca di nemo</td>
                                        <td>Sala 1</td>
                                        <td>16 luglio - 21:00</td>
                                        <td>4</td>
                                        <td>8€</td>
                                        <!--<td><button class="btn btn-warning btn-xs" id="status_film"><span class="glyphicon glyphicon-facetime-video" title="film_prenotato"></span></button></td>-->
                                    </tr>
                                    <tr>
                                        <td>La spada nella roccia</td>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <!--<td><button class="btn btn-warning btn-xs" id="status_film"><span class="glyphicon glyphicon-facetime-video" title="film_prenotato"></span></button></td>-->
                                    </tr>
                                    <tr>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <!--<td><button class="btn btn-warning btn-xs" id="status_film"><span class="glyphicon glyphicon-facetime-video" title="film_prenotato"></span></button></td>-->
                                    </tr>
                                    <tr>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <!--<td><button class="btn btn-success btn-xs" id="status_film"><span class="glyphicon glyphicon-facetime-video" title="film_visto"></span></button></td>-->
                                    </tr>  
                                </tbody>
                            </table>
                            </div>
                    </center>
                    </div>
                    <div class="spazio"><br></div>
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
                    </div>
                        <div class="spazio"><br></div>
                        <div class="infoutente_container"> 
                            <p><b>Nome: </b>Chiara</p>
                            <p><b>Cognome: </b>Dalpiaz</p>
                            <p><b>Email: </b>chiara.dalpiaz@hotmail.it</p>
                            <p><b>Password: </b>palla</p>
                            <hr class="divisore_info">
                            <p><b>Carte di Credito</b></p>
                            <p>Nominativo - 1234 1234 1234 1234 - Scadenza: mm/aa</p>
                            <p>Nominativo - 1234 1234 1234 1234 - Scadenza: mm/aa</p>
                        </div>
                    </div>
               
            </div>
        </div>
        <c:import url="footer.jsp"></c:import>
    </body>
</html>
