<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%--
  Created by IntelliJ IDEA.
  User: w7600PC
  Date: 03/07/2014
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script>
    function uploadJqueryForm() {
        $("#formEstado").ajaxForm({
            success: function (datos) {
                var data = JSON.parse(datos);
                if (data.status == "SUCCESS") {
                    table.api().ajax.reload();
                    parent.$.fancybox.close();
                    $('#mess-success').html(data.result).fadeIn().animate({opacity: 1.0}, 5000).fadeOut('slow');
                } else {
                    var errorInfo = "";

                    for (i = 0; i < data.result.length; i++) {
                        errorInfo += "<br>" + (i + 1) + ". " + data.result[i].code;
                    }
                    $('#mess-errors-form').html(errorInfo).fadeIn().animate({opacity: 1.0}, 5000).fadeOut('slow');
                }
            },
            dataType: "text"
        }).submit();
    }
</script>
<p class="bg-error" id="mess-errors-form" style="display: none;"></p>
<form:form id="formEstado" method="post" onsubmit='return false;' class="form-horizontal" role="form"
           modelAttribute="estado" data-abide="">
    <div class="large-4 columns">
        <div class="name-field">
            <form:label path="nombreEstado">Nombre
                <small>*</small>

                <form:input path="nombreEstado" required="true"/>
            </form:label>
            <small class="error">Debe Ingresar el nombre del estado</small>
        </div>
    </div>
    <div class="large-4 columns">
        <div class="name-field">
            <form:label path="tipoEstado.idTipoEstadoPk" class="col-sm-2 control-label">Tipo de Estado
                <small>*</small>
                <form:select path="tipoEstado.idTipoEstadoPk" required="true">
                    <form:option value="0" label="Seleccione"/>
                    <form:options items="${listaTipoEstado}" itemLabel="nombreTipoEstado" itemValue="idTipoEstadoPk"/>
                </form:select>
            </form:label>
            <small class="error">Debe Seleccionar un Tipo de Estado.</small>
        </div>
    </div>

    <button class="medium button green" onclick="uploadJqueryForm();">Guardar</button>

</form:form>
