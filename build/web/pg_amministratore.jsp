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
                            <table id="incassi" class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Titolo</th>
                                        <th>Spettacolo</th>
                                        <th># Biglietti</th>
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
                <div class="col-md-4 col-xs-12">
                    <div class="inner_amministratore">
                        <center><h3>Programmazione</h3><br>
                            <div class="programmazione_container">
                            <table id="programmazione" class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Titolo</th>
                                        <th>Spettacolo</th>
                                        <th># Posti</th>
                                        <th>X</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <td><button class="btn btn-danger btn-xs" id="elimina_spettacolo"><span class="glyphicon glyphicon-trash"></span></button></td>
                                    </tr>
                                    <tr>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td><button class="btn btn-danger btn-xs" id="elimina_spettacolo"><span class="glyphicon glyphicon-trash"></span></button></td>
                                    </tr>
                                    <tr>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <td><button class="btn btn-danger btn-xs" id="elimina_spettacolo"><span class="glyphicon glyphicon-trash"></span></button></td>
                                    </tr>
                                    <tr>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td><button class="btn btn-danger btn-xs" id="elimina_spettacolo"><span class="glyphicon glyphicon-trash"></span></button></td>
                                    </tr>
                                </tbody>
                            </table>
                            </div>
                        </center>
                    </div>
                </div>
                <div class="col-md-4 col-xs-12">
                    <div class="inner_amministratore">
                        <center><h3>Clienti top</h3><br>
                            <div class="clientitop_container">
                            <table id="clientitop" class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Nome</th>
                                        <th># Film</th>
                                        <th>€</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                    </tr>
                                    <tr>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td>bu</td>
                                    </tr>
                                    <tr>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                    </tr>
                                    <tr>
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
