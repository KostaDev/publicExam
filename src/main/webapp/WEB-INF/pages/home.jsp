<%@ page import="com.project.exam.domain.User"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/include/head.jsp"/>
<title>home</title>
<c:set var="loggedUser" value="${sessionScope.login-user}"/>
</head>

<body>

<h3>Logged user: ${loggedUser} </h3> 
<a href="/exam/application/city"> City page
</a>
<a href="/exam/application/manufacturer"> manufacturer page
</a>

</body>
</html>