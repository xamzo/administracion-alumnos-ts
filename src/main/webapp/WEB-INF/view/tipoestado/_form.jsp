<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%--
  Created by IntelliJ IDEA.
  User: w7600PC
  Date: 03/07/2014
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="application/javascript">
    $(document).ready(function () {
        $('#formTipoEstado').submit(function (event) {
            var nombreTipoEstado = $('#nombreTipoEstado').val();
            var json = { "nombreTipoEstado": nombreTipoEstado};
            $.ajax({
                url: $("#formTipoEstado").attr("action"),
                data: JSON.stringify(json),
                type: "POST",
                success: function (data) {
                    if (data.status == "SUCCESS") {
                        table.api().ajax.reload();
                        parent.$.fancybox.close();
                        $('#mess-success').html(data.result).fadeIn().animate({opacity: 1.0}, 5000).fadeOut('slow');
                    } else {
                        var errorInfo = "";

                        for (i = 0; i < data.result.length; i++) {
                            //  alert('#' + data.result[i].field + '.errors');
                            $('#nombreTipoEstado.errors').append(data.result[i].code);
                            $('#nombreTipoEstado.errors').show();

                            errorInfo += "<br>" + (i + 1) + ". " + data.result[i].code;
                        }
                        $('#mess-errors-form').html(errorInfo).fadeIn().animate({opacity: 1.0}, 5000).fadeOut('slow');
                    }
                },
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Accept", "application/json");
                    xhr.setRequestHeader("Content-Type", "application/json");
                    // alert("before send");
                }
            });
            event.preventDefault();
        });

    });
</script>
<p class="bg-error" id="mess-errors-form" style="display: none;"></p>
<form:form id="formTipoEstado" method="post" class="form-horizontal" role="form" modelAttribute="tipoEstado">

    <div class="form-group">
        <form:label path="nombreTipoEstado" class="col-sm-2 control-label">Nombre</form:label>
        <div class="col-sm-6">
            <form:input path="nombreTipoEstado"/>
            <span id="nombreTipoEstado.errors" style="display: none;"></span>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-6">
            <input type="submit" class="btn btn-primary" value="Guardar">
        </div>
    </div>
</form:form>
