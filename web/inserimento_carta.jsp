<%-- ISERIMENTO DATI CARTA.JSP --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:import url="head.jsp"></c:import>
        <title>JB - Inserimento carta di credito</title>
    </head>
    <body class="formbody">
    <div class="sfondo">
    <c:import url="header_form.jsp"></c:import>
        
        <div class="col-md-4 col-md-offset-4 col-xs-10 col-xs-offset-1">
            <div  id="form_inseriscicc">
                <center>
                    <h3>Inserisci dati Carta di Credito</h3>
                    <p>I dati inseriti, relativi a una nuova carta di credito, verranno salvati e resi disponibili per il prossimo acquisto.</p>
                </center>
            <form data-toggle="validator"> 
            <div class="form-group">
               <label for="nome_cc">Nominativo proprietario</label>
               <input type="text" class="form-control" id="nome_cc" placeholder="Nominativo" required>
            </div>
            <div class="form-group">
                <label for="numero_cc">Numero carta</label>
                <input type="text" class="form-control" id="numero_cc" minlength="16" maxlength="16" placeholder="Numero carta (16 cifre)" required>
            </div>
            
            <div class="form-group row">
            <div class="col-md-8 col-xs-8">
                <label for="scadenza">Scadenza</label>
                <input type="text" class="form-control" id="scadenza" pattern="\d{2}/\d{2}" placeholder="mm/aa" required>
                
            </div>              
               
            <div class="col-md-4 col-xs-4 ">
                <label for="cvv">CVV</label>
                <input type="text" class="form-control" id="cvv" maxlength="3" placeholder="CVV" required>
            </div>
            </div>
            
            <button id="paga_post_inserimento" type="submit" class="btn btn-default btn-block">Paga</button>
       </form>
    </div>
            <br>
        <center>
            <a class="ritorna" href="home.jsp"><span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>Ritorna al sito</a>
        </center>
    </div>
    </div>
    </body>
</html>
