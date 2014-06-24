<%--
  Created by IntelliJ IDEA.
  User: cristobalortiz
  Date: 21-06-14
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script>
    var url = window.location.pathname;
    // Will only work if string in href matches with location
    console.log('url: '+url);
    $('.nav a').filter(function() {
        return this.pathname == url;
    }).parent().addClass('active');
</script>
</body>
</html>
