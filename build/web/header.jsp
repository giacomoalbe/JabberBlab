<!--<center>
 <div class="logo"><a href="home.jsp"><img src="imgs/jabberblab.jpg"/></a></div>
</center>-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="row navbar">
    <div class="col-xs-3 col-sm-3 col-md-3"><a class="menu-item_logo" href="home.jsp"><img class="logo" src="imgs/prova_logo3.png"/></a></div>
    <div class="col-xs-3 col-sm-offset-3 col-sm-2 col-md-offset-3 col-md-2"><a class="menu-item" href="prezzi.jsp">Prezzi</a></div>
    <div class="col-xs-3 col-sm-2 col-md-2"><a class="menu-item" href="contatti.jsp">Contatti</a></div>
    <div class="col-xs-2 col-sm-2 col-md-2">
    <c:choose>
        <c:when test="${cookie.containsKey('user')}">
            <a class="menu-item" href="pg_utente.jsp" style="color:#6fc0ed;"><c:out value = "Ciao, ${fn:split(cookie['user'].value, ' ')[0]}!"> </c:out></a>
        </c:when> 
        <c:otherwise>
            <a class="menu-item" href="login.jsp">Accedi</a>
        </c:otherwise>
    </c:choose> 
    </div>
 </div>