<%@page session="true"%>
<%@ include file="header.jsp"%>


<h1>${mensaje}</h1>


<form id="formulario" method="post" action="/upload-document" enctype="multipart/form-data">
    <input type="text" name="name"/>
    <input type="file" name="file" value="Seleccionar Archivo.."/>

</form>
 <button value="subir" onclick="uploadJqueryForm();">Subir Ajax</button>
<script>

    function uploadJqueryForm(){
        $("#formulario").ajaxForm({
            success:function(data) {
                alert(data);
            },
            dataType:"text"
        }).submit();
    }

</script>

<%@ include file="footer.jsp"%>