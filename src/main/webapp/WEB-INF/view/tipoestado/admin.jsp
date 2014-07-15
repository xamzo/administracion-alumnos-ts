<%@page session="true" %>
<%@ include file="../header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!-- JQuery CSS -->

<link href="<c:url value="/resources/fancybox/source/jquery.fancybox.css" />" rel="stylesheet">

<script type="text/javascript" src="<c:url value="/resources/fancybox/source/jquery.fancybox.pack.js" />"></script>

<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css">

<script type="text/javascript" src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>


<script type="text/javascript">
    var table;
    function a_onClick(id) {
        if (confirm('Esta Seguro de eliminar este item?')) {
            $.ajax({
                url: '/tipoestado/delete/' + id,
                type: 'DELETE',
                success: function (res) {
                    if (res.status == "SUCCESS") {
                        table.api().ajax.reload();
                        $('#mess-success').html(res.result).fadeIn().animate({opacity: 1.0}, 5000).fadeOut('slow');
                    } else {
                        $('#mess-error').html(res.result).fadeIn().animate({opacity: 1.0}, 5000).fadeOut('slow');
                    }

                }
            });
        }
    }
</script>
<script>
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
<script>
    function refresh() {
        table = $('#example').dataTable({
            "language": {
                "url": "<c:url value="/resources/spanish.json" />"
            },
            "sAjaxSource": "/tipoestado/lista",
            "sAjaxDataProp": "",
            "aoColumns": [
                { "mData": "idTipoEstadoPk" },
                { "mData": "nombreTipoEstado" },
                {
                    "mData": "idTipoEstadoPk",
                    "mRender": function (dato) {
                        return "<a class='various fancybox.ajax' href='/tipoestado/update/" + dato + "'>Editar</a>";
                    }
                },
                {
                    "mData": "idTipoEstadoPk",
                    "mRender": function (dato) {
                        return "<a href='#' onclick='js:a_onClick(" + dato + ")'>Eliminar</a>";
                    }
                }
            ],
            "initComplete": function () {
                $("#example tfoot th").each(function (i) {
                    if (i < ($("#example tfoot th").size() - 2)) {
                        var select = $('<select><option value=""></option></select>')
                                .appendTo($(this).empty())
                                .on('change', function () {
                                    table.api().column(i)
                                            .search('^' + $(this).val() + '$', true, false)
                                            .draw();
                                });
                        table.api().column(i).data().unique().sort().each(function (d, j) {
                            select.append('<option value="' + d + '">' + d + '</option>')
                        });
                    }
                })
            }
        });


    }

    $(document).ready(function () {
        refresh();
    });
</script>
<div class="container">
    <h1>Tipo estado</h1>

    <p class="bg-success" id="mess-success" style="display: none;"></p>

    <p class="bg-error" id="mess-errors" style="display: none;"></p>
    <a class="various fancybox.ajax" href="<c:url value="/tipoestado/create"/>">Nuevo Tipo Estado</a>
    <form:form action="" method="GET">


        <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
            <thead>
            <th>Id</th>
            <th>Nombre</th>
            <th></th>
            <th></th>
            </thead>
            <tfoot>
            <tr>
                <th>id</th>
                <th>Nombre</th>
                <th></th>
                <th></th>
            </tr>
            </tfoot>
            <tbody>

            </tbody>
        </table>

    </form:form>
</div>

<%@ include file="../footer.jsp" %>