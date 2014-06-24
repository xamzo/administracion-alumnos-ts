<%--
  Created by IntelliJ IDEA.
  User: cristobalortiz
  Date: 16-06-14
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ include file="header.jsp"%>

<h1>Title : ${title}</h1>
<h1>Message : ${message}</h1>
<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h2>Welcome : ${pageContext.request.userPrincipal.name}
        | <a href="<c:url value="/j_spring_security_logout" />" > Logout</a></h2>
</c:if>

<%@ include file="footer.jsp"%>