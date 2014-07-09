<%@page session="true" %>
<%@ include file="../header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- JQuery CSS -->
<link href="<c:url value="/resources/fancybox/source/jquery.fancybox.css" />" rel="stylesheet">
<script type="text/javascript" src="<c:url value="/resources/fancybox/lib/jquery-1.10.1.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/fancybox/source/jquery.fancybox.pack.js" />"></script>
<script type="text/javascript">
    $.ajax({
        url: '/tipoestado/lista',
        dataType: 'json',
        type: 'GET',
        success: function (data, textStatus, jqXHR) {
            // since we are using jQuery, you don't need to parse response
            drawTable(data);
        }
    });
    function drawTable(data) {
        $("#gridTipoEstado tr").remove();
        for (var i = 0; i < data.length; i++) {
            drawRow(data[i]);
        }
    }
    function drawRow(rowData) {
        var row = $("<tr />")
        $("#gridTipoEstado").append(row); //this will append tr element to table... keep its reference for a while since we will add cels into it
        row.append($("<td>" + rowData.idTipoEstadoPk + "</td>"));
        row.append($("<td>" + rowData.nombreTipoEstado + "</td>"));
        row.append($("<td><a class=\"various fancybox.ajax\" href='/tipoestado/update/" + rowData.idTipoEstadoPk + "'>Editar</a></td>"));
        row.append($("<td><a class=\"eliminar\" href=\"#\"  onClick=\"a_onClick(" + rowData.idTipoEstadoPk + ")\">Eliminar</a></td>"));
    }

</script>
<script type="text/javascript">
    function a_onClick(id) {
        if (confirm('Esta Seguro de eliminar este item?')) {
            $.ajax({
                url: '/tipoestado/delete/' + id,
                type: 'DELETE',
                success: function (res) {
                    if (res.status == "SUCCESS") {
                        parent.$.fancybox.close();
                        {
                            $.ajax({
                                url: '/tipoestado/lista',
                                dataType: 'json',
                                type: 'GET',
                                success: function (data, textStatus, jqXHR) {
                                    // since we are using jQuery, you don't need to parse response
                                    drawTable(data);
                                }
                            });
                        }
                        $('#mess-success').html(res.result).fadeIn().animate({opacity: 1.0}, 5000).fadeOut('slow');
                    } else {
                        $('#mess-error').html(res.result).fadeIn().animate({opacity: 1.0}, 5000).fadeOut('slow');
                    }

                }
            });
        }
    }
</script>
<script type="text/javascript">
    $(".various").fancybox({
        maxWidth: 800,
        type: 'ajax',
        maxHeight: 600,
        fitToView: false,
        width: '70%',
        height: '70%',
        autoSize: false,
        closeClick: false,
        openEffect: 'fade',
        closeEffect: 'fade'
    });
</script>
<div class="container">
    <h1>Tipo estado</h1>

    <p class="bg-success" id="mess-success" style="display: none;"></p>

    <p class="bg-error" id="mess-errors" style="display: none;"></p>
    <a class="various fancybox.ajax" href="<c:url value="/tipoestado/create"/>">Nuevo Tipo Estado</a>
    <table id="gridTipoEstado" class="table table-borderer">
        <thead>
        <th>Id</th>
        <th>Nombre</th>
        </thead>
    </table>
</div>

<%@ include file="../footer.jsp" %>