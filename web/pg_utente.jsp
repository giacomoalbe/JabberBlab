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
                                        <td><button class="btn btn-warning btn-xs" id="status_film"><span class="glyphicon glyphicon-facetime-video"></span></button></td>
                                    </tr>
                                    <tr>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td><button class="btn btn-warning btn-xs" id="status_film"><span class="glyphicon glyphicon-facetime-video"></span></button></td>
                                    </tr>
                                    <tr>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <td>Ciao</td>
                                        <td><button class="btn btn-warning btn-xs" id="status_film"><span class="glyphicon glyphicon-facetime-video"></span></button></td>
                                    </tr>
                                    <tr>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td>bu</td>
                                        <td><button class="btn btn-success btn-xs" id="status_film"><span class="glyphicon glyphicon-facetime-video"></span></button></td>
                                    </tr>  
                                </tbody>
                            </table>
                            </div>     
                    </center>
                    </div>
                </div>
                <div class="col-md-5 col-xs-12">
                    
                </div>
                <div class="col-md-5 col-md-offset-7 col-xs-12">
                                  
                </div>
            </div>
        </div>
        <c:import url="footer.jsp"></c:import>
    </body>
</html>
