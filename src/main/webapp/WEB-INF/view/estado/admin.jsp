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
                url: '/estado/delete/' + id,
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
            "sAjaxSource": "/estado/lista",
            "sAjaxDataProp": "",
            "aoColumns": [
                { "mData": "idEstadoPk" },
                { "mData": "nombreEstado" },
                { "mData": "tipoEstado.nombreTipoEstado" },
                {
                    "mData": "idEstadoPk",
                    "mRender": function (dato) {
                        return "<a class='various fancybox.ajax' href='/estado/update/" + dato + "'>Editar</a>";
                    }
                },
                {
                    "mData": "idEstadoPk",
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
                                    if ($(this).val() != '') {
                                        table.api().column(i)
                                                .search('^' + $(this).val() + '$', true, false)
                                                .draw();
                                    } else {
                                        table.api().column(i)
                                                .search($(this).val())
                                                .draw();
                                    }
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
<div class="row">
    <div class="medium-3 columns">
        <a class="various fancybox.ajax" href="<c:url value="/estado/create"/>">Nuevo Estado</a>
    </div>
    <div class="medium-10 columns">
        <h1>Estados</h1>

        <div data-alert="" class="alert-box success radius" id="mess-success" style="display: none;"></div>

        <div class="bg-error" id="mess-errors" style="display: none;"></div>
        <form:form action="" method="GET">
            <table id="example">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Tipo de Estado</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
                </tfoot>
                <tbody>
                </tbody>
            </table>

        </form:form>
    </div>
</div>

<%@ include file="../footer.jsp" %>