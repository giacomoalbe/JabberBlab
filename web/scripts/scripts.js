

$(document).ready(function(){
    
    var films = [];
    $.ajax({
             url: "Other/film.json",
             dataType: "json"
         })
         .done(function(data) {
            console.log(data);
            ImgLoader(data);
            
            films = data.films;
         });
         
         
         
            var ImgLoader = function(data) {
                var items = [];

                $.each(data.films, function(index, val) {
                   items.push( "<div class='col-md-2 col-xs-6 film_home_div'><button type='button' class='film_home_btn' id='" + index + "'>" 
                   + "<img class='img-responsive img_film_home_copertina' src='" + val.uri_locandina + "'/></button></div>");
                });



                $( "<div/>", {
                   "class": "row film_home",
                   html: items.join( "" )
                 }).appendTo( ".film_home_append" );
                 $(".img_film_home_copertina").on('mouseover', sfumaOverFunct);
                 $(".img_film_home_copertina").on('mouseleave', sfumaLeaveFunct);
                 $('.film_home_btn').on('click', modalFunct);


            };

    var sfumaOverFunct = function(){
        $(".img_film_home_copertina").addClass("biancoenero");
            $(this).removeClass("biancoenero");        
    };
    
    var sfumaLeaveFunct = function(){
        $(".img_film_home_copertina").removeClass("biancoenero");
    };
    
    var modalRiempimento = function(id,callback){
        var itemheader = [];
        var itembody = [];
        console.log(id);
        
        $.each(films, function(index, val) {
        
        
    if (val.id_film == id) {
        console.log("entra nell'each");
        itemheader.push( "<button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button><h3 class='modal-title'>" + val.titolo + "</h3>" );
        itembody.push("<div class='col-md-4 col-xs-12 film_modal_col1'><center> "
                        + "<img class = 'modal_copertina' src = '" + val.uri_locandina + "'/></center> <br> "
                        + "<b>Titolo: </b>" + val.titolo + "<br>"
                        + "<b>Genere: </b>" + val.id_genere + "<br>"
                        + "<b>Durata: </b>" + val.durata + " min<br>"
                        + val.trama  + "<br>"
                        + "<a target='_blank' href='" + val.url_trailer + "'> <b>Trailer YouTube</b> </a> </div>"
                        + "<div class='col-md-4 col-xs-12 film_modal_col2'>"
                        + "<div class='div_spettacolo'>Spettacolo" + "</div>" /*mancano spettacoli*/
                        +"</div>"
                        + "<div class='col-md-4 col-xs-12 film_modal_col3'>"
                        + "<center>SALA</center><br>"
                        + "<button class='btn btn btn-success btn-block'>Compra un biglietto! <span class='glyphicon glyphicon glyphicon-arrow-right'></span></button>"
                        +"</div>"
                        );
            }
        });
        $('.modal-header').empty();
         $( "<div/>", {
                "class": "inner_modal-header",
                html: itemheader.join( "" )
              }).appendTo( ".modal-header" );
        $('.container-fluid').empty();
         $( "<div/>", {
                "class": "row",
                html: itembody.join( "" )
              }).appendTo( ".container-fluid" );
              
        callback();
    }
    var showModalCb = function() {
        $("#film_modal").modal('show');
    }
    var modalFunct = function() {
        
        var id_film = $(this).attr("id");
        modalRiempimento(id_film, showModalCb);
    }
    
    var DOM_tabelle = {
        "info": false,
        "dom": '<"pull-left"f><"pull-right"l>tp'
    }
    
    $('#incassi').DataTable(DOM_tabelle);
    
    $('#programmazione').DataTable(DOM_tabelle);
    
    $('#clientitop').DataTable(DOM_tabelle);
    
    $('#filmvisti').DataTable(DOM_tabelle);
    
    $('#spettacoloutenti').DataTable(DOM_tabelle);
    
    $("#esamina_spettacolo").click(function(){
       $("#spettacoloutenti_modal").modal('show'); 
    });
});