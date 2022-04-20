<%@ page import="com.project.exam.domain.User"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/include/head.jsp"/>
<title>home</title>

<%
	User logedUser = (User) request.getSession().getAttribute("login-user");
	pageContext.setAttribute("logedUser", logedUser.getFirstname());
%>
</head>

<body>

<h3>Logged user: ${logedUser} </h3> 
<a href="/exam/application/city"> City page
</a>
<br>
<a href="/exam/application/manufacturer"> manufacturer page
</a>

</body>
</html>