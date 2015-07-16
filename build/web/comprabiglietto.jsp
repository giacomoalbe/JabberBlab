<%-- COMPRA BIGLIETTO --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.json.simple.JSONObject"%>

<!DOCTYPE html>
<html>
    <head>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:import url="head.jsp"></c:import>
        <title>Compra biglietto</title>
    </head>
    <body class="normalbody">
        <c:import url="header.jsp"></c:import>
        <div class="row">
            <div class="col-md-6 col-xs-12">
                <center>
                    <h3>Titolo film scelto</h3>
                <button class="btn btn-default btnsceltaspettacolo">Sala 1 - Ore 21:00</button><button class="btn btn-default btnsceltaspettacolo">Sala 1 - Ore 21:00</button><button class="btn btn-default btnsceltaspettacolo">Sala 1 - Ore 21:00</button><br>
                <button class="btn btn-default btnsceltaspettacolo">Sala 1 - Ore 21:00</button><button class="btn btn-default btnsceltaspettacolo">Sala 1 - Ore 21:00</button>
                <div class="mappasala"></div>
                </center>
            <div class="spazio"><br></div>
            </div>
            <div class="col-md-6 col-xs-12">
                <center>
                    <br><p><b>Per ogni posto selezionato, indicare il tipo di biglietto che si desidera comprare.<br>
                        Per gli ingressi ridotti, verrà rischiesto un documento all'ingresso</b></p><br>
                        <div class="scelta_tipo_biglietto_container">
                            <table class="table scelta_tipo_biglietto">
                                <tr>
                                    <td><b>Posto</b></td>
                                    <td class="radio_scelta"><b>Intero</b></td>
                                    <td class="radio_scelta"><b>Ridotto (< 11 anni)</b></td>
                                    <td class="radio_scelta"><b>Universitari</b></td>
                                </tr>
                                <tr>
                                    <td>Posto 1</td>
                                    <td class="radio_scelta"><input type='radio' value='intero' checked='checked'/></td>
                                    <td class="radio_scelta"><input type='radio' value='rid_bambini'/></td>
                                    <td class="radio_scelta"><input type='radio' value='rid_uni'/></td>
                                </tr>                   
                            </table>
                        </div>
                </center>
            </div>
        </div>
        
        <c:import url="footer.jsp"></c:import>
        
        
    </body>
</html>