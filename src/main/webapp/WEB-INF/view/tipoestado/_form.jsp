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
                        $('#mess-success').html(data.result).fadeIn().animate({opacity: 1.0}, 5000).fadeOut('slow');
                    } else {
                        $('#mess-error').html(data.result).fadeIn().animate({opacity: 1.0}, 5000).fadeOut('slow');
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

<form:form id="formTipoEstado" method="post" modelAttribute="tipoEstado">

    <table>
        <tr>
            <td><form:label path="nombreTipoEstado">Nombre</form:label></td>
            <td><form:input path="nombreTipoEstado"/></td>
            <td><form:errors path="nombreTipoEstado"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <!-- <button value="Guardar">Guardar</button> -->
                <input type="submit" class="btn btn-primary" value="Guardar">
            </td>
        </tr>
    </table>

</form:form>
