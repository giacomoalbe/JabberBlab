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
                <div class="comprabiglietto_col1">
                <center>
                    <p class="titolo_film_scelto"><b>Titolo film scelto</b></p>
                    <div class="bottoni_spettacolo_riga1"><button class="btn btn-default btnsceltaspettacolo">Sala 1 - Ore 21:00</button><button class="btn btn-default btnsceltaspettacolo">Sala 1 - Ore 21:00</button><button class="btn btn-default btnsceltaspettacolo">Sala 1 - Ore 21:00</button></div>
                    <div class="bottoni_spettacolo_riga2"><button class="btn btn-default btnsceltaspettacolo">Sala 1 - Ore 21:00</button><button class="btn btn-default btnsceltaspettacolo">Sala 1 - Ore 21:00</button></div>
                    <div class="sala_interattiva">
                        <!-- INSERIRE LA MAPPA DELLA SALA SU CUI SCEGLIERE I POSTI IN BASE ALLO SPETTACOLO SCELTO -->
                    </div>
                </center>
                    </div>
                <div class="spazio"><br></div>
            </div>
            <div class="col-md-6 col-xs-12">
                <div class="comprabiglietto_col2">
                <center>
                    <p><b>Per ogni posto selezionato, indicare il tipo di biglietto che si desidera comprare.<br>
                        Per gli ingressi ridotti (minori di 11 anni e universitari), verrà rischiesto un documento all'ingresso.</b></p><br>
                        <div class="scelta_tipo_biglietto_container">
                            <table class="table scelta_tipo_biglietto">
                                <tr>
                                    <td><b>Posto</b></td>
                                    <td class="radio_scelta"><b>Intero</b></td>
                                    <td class="radio_scelta"><b>Ridotto</b></td>
                                    <td class="radio_scelta"><b>Universitari</b></td>
                                </tr>
                                <!--<tr>
                                    <td>Posto 1</td>
                                    <td class="radio_scelta"><input type='radio' value='intero' checked='checked'/></td>
                                    <td class="radio_scelta"><input type='radio' value='rid_bambini'/></td>
                                    <td class="radio_scelta"><input type='radio' value='rid_uni'/></td>
                                </tr>   RIGHE DELLA TABELLA, NE AGGIUNGO UNA PER OGNI POSTO SELEZIONATO INCREMENTANDO IL NUMERO DEL POSTO  -->                   
                            </table>
                        </div>
                        <form>
                            <button type="submit" class="btn btn-success btn-lg procedi_pagamento">Procedi con il pagamento <span class='glyphicon glyphicon glyphicon-arrow-right'></span></button>
                        </form>
                </center>
                    </div>
            </div>
                
        </div>
        <c:import url="footer.jsp"></c:import>
        
        
    </body>
</html>