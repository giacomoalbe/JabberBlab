<%-- 
    Document   : Film
    Created on : 2-lug-2015, 11.08.33
    Author     : Andrea
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.json.simple.JSONObject"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Guarda che bei film!</h1>
        
        
<div class="film_container">
    <script>
         $.ajax({
             url: "Other/film.json",
             dataType: "json",
         })
         .done(function(data) {
            console.log(data);
            funzioneChe(data);
         });
         
         var funzioneChe = function(data) {
             var items = [];
             items.push("<table>")
             $.each(data.films, function(index, val) {
                items.push( "<tr id='" + index + "'>" 
                + "<td style = 'width : 600px; border : solid 1px;'>" 
                + "<h3> Titolo: " + val.titolo + "</h3>"
                + "<h5> ID Genere: " + val.id_genere + "</h5>"
                + "<h5> Url Trailer: " + val.url_trailer + "</h5>"
                + "<h5> Durata: " + val.durata + "</h5>"
                + "<h5> Trama: " + val.trama + "</h5>"
                + "</td> <td style = 'border : solid 1px;'> "
                + "<img src=" + val.uri_locandina + " alt="+ val.titolo + " width='400' height='500'>  </td></tr>" );
             });
             items.push("</table>")
             $( "<ul/>", {
                "class": "film_list",
                html: items.join( "" )
              }).appendTo( "body" );
         }

    </script> 

    </div>
        
    </body>
</html>
