<%-- RIEPILOGO PAGAMENTO --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.json.simple.JSONObject"%>

<!DOCTYPE html>
<html>
    <head>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:import url="head.jsp"></c:import>
        <title>Riepilogo</title>
    </head>
    <body class="normalbody">
        <c:import url="header.jsp"></c:import>
        <div class="row">
            <div class="col-md-6 col-md-offset-3 col-xs-12 riepilogo_container">
                <center>
                    <h3>Riepilogo prenotazione</h3>
                    <p><b>Titolo film</b></p>
                    <p><b>Sala</b></p>
                    <p><b>Orario</b></p>
                    <div class="tabella_riepilogo_container">
                            <table class="table riepilogo_tabella">
                                <tr>
                                    <td><b>Tipo biglietto</b></td>
                                    <td><b>Quantità</b></td>
                                    <td><b>Prezzo</b></td>
                                    <td><b>Totale</b></td>
                                </tr>
                                <tr>
                                    <td>Intero</td>
                                    <td>INSERIRE QUANTITA DA BEAN</td>
                                    <td>6,00 €</td>
                                    <td>PREZZO X QUANTITA DA BEAN €</td>
                                </tr>
                                <tr>
                                    <td>Ridotto (< 11 anni)</td>
                                    <td>INSERIRE QUANTITA DA BEAN</td>
                                    <td>3,00 €</td>
                                    <td>PREZZO X QUANTITA DA BEAN €</td>
                                </tr>
                                <tr>
                                    <td>Ridotto (Universitari)</td>
                                    <td>INSERIRE QUANTITA DA BEAN</td>
                                    <td>4,00 €</td>
                                    <td>PREZZO X QUANTITA DA BEAN €</td>
                                </tr>
                            </table>
                        <!-- INSERIRE DA SERVLET SE C'è DEL CREDITO DISPONIBILE E SOTTRARLO AL TOTALE -->
                        <h3>TOTALE prezzo totale da bean</h3>
                        <br>
                        <div class="cc_riepilogo_container">
                            <form>
                                <button type="submit" name="pagaconcc" value="NUMEROCC" class="btn btn-default btn-block">Nominativo - 1234 1234 1234 1234</button>
                                <br>
                            </form>
                            <a role="button" class="ritorna btn btn-info btn-block" href="inserimento_carta.jsp"><span class="glyphicon glyphicon-plus"></span> <b>Aggiungi nuova carta</b></a>
                            <br>
                        </div>
                        </div>
                </center>
            </div>
            
        </div>
        <div class="spazio"><br></div>
        <c:import url="footer.jsp"></c:import>       
    </body>
</html>