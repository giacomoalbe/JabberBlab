<%--  PAGINA AMMINISTRATORE --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:import url="head.jsp"></c:import>
        <title>JB - Amministratore</title>
    </head>
    <body class="normalbody">
        <c:import url="header.jsp"></c:import>
        <div class="box_amministratore">
            <div class="row">
                <div class="col-md-4 col-xs-12">
                    <div class="inner_amministratore">
                        <center>
                            <h3>Incassi</h3><br>
                            <div class="incassi_container">
                            <table id="incassi" class="table table-striped table-responsive">
                                <thead>
                                    <tr>
                                        <th>Titolo</th>
                                        <th>Spettacolo</th>
                                        <th>Biglietti</th>
                                        <th>€</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Alla ricerca di Nemo</td>
                                        <td>Sala 1 - 16 luglio - 21:00</td>
                                        <td>34/50</td>
                                        <td>xx</td>
                                    </tr>
                                    <tr>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td>bu</td>
                                    </tr>
                                    <tr>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                    </tr>
                                    <tr>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td>bu</td>
                                    </tr>  
                                </tbody>
                            </table>
                            </div>     
                    </center>
                    </div>
                    <div class="spazio"><br></div>
                </div>
                <div class="col-md-4 col-xs-12">
                    <div class="inner_amministratore">
                        <center><h3>Programmazione</h3><br>
                            <div class="programmazione_container">
                            <table id="programmazione" class="table table-striped table-responsive">
                                <thead>
                                    <tr>
                                        <th>Titolo</th>
                                        <th>Spettacolo</th>
                                        <th>Posti</th>
                                        <th>Dettagli</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <td><center><button class="btn btn-info btn-xs" id="esamina_spettacolo"><span class="glyphicon glyphicon-search"></span></button></center></td>
                                    </tr>
                                    <tr>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td><center><button class="btn btn-info btn-xs" id="esamina_spettacolo"><span class="glyphicon glyphicon-search"></span></button></center></td>
                                    </tr>
                                    <tr>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <td><center><button class="btn btn-info btn-xs" id="esamina_spettacolo"><span class="glyphicon glyphicon-search"></span></button></center></td>
                                    </tr>
                                    <tr>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td><center><button class="btn btn-info btn-xs" id="esamina_spettacolo"><span class="glyphicon glyphicon-search"></span></button></center></td>
                                    </tr>
                                </tbody>
                            </table>
                            </div>
                        </center>
                    </div>
                    <div class="spazio"><br></div>
                </div>
                <div class="col-md-4 col-xs-12">
                    <div class="inner_amministratore">
                        <center><h3>Clienti top</h3><br>
                            <div class="clientitop_container">
                            <table id="clientitop" class="table table-striped table-responsive">
                                <thead>
                                    <tr>
                                        <th>Nome</th>
                                        <th>Cognome</th>
                                        <th># Film</th>
                                        <th>€</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                    </tr>
                                    <tr>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td>bu</td>
                                    </tr>
                                    <tr>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                    </tr>
                                    <tr>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td>bu</td>
                                    </tr>
                                </tbody>
                            </table>
                            </div>
                        </center>
                    </div>                
                </div>
            </div>
        </div>
        <c:import url="footer.jsp"></c:import>
    </body>
</html>

<div id="spettacoloutenti_modal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <div><button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button><h3 class="modal-title">TITOLO FILM - SPETTACOLO</h3></div>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <table id="spettacoloutenti" class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Nome</th>
                                        <th>Cognome</th>
                                        <th># Posti</th>
                                        <th>Elimina</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Chiara</td>
                                        <td>Dalpiaz</td>
                                        <td>2</td>
                                        <td><button class="btn btn-danger btn-xs" id="elimina_spettacoloutente"><span class="glyphicon glyphicon-trash"></span></button></td>
                                    </tr>
                                    <tr>
                                        <td>Monica</td>
                                        <td>Pedron</td>
                                        <td>3</td>
                                        <td><button class="btn btn-danger btn-xs" id="elimina_spettacoloutente"><span class="glyphicon glyphicon-trash"></span></button></td>
                                    </tr>
                                    <tr>
                                        <td>Giacomo</td>
                                        <td>Alberini</td>
                                        <td>4</td>
                                        <td><button class="btn btn-danger btn-xs" id="elimina_spettacoloutente"><span class="glyphicon glyphicon-trash"></span></button></td>
                                    </tr>
                                    <tr>
                                        <td>Andrea</td>
                                        <td>Brunelli</td>
                                        <td>1</td>
                                        <td><button class="btn btn-danger btn-xs" id="elimina_spettacoloutente"><span class="glyphicon glyphicon-trash"></span></button></td>
                                    </tr>
                                </tbody>
                            </table>
                    </div>   
                </div>
            </div>
        </div>
    </div>
</div>