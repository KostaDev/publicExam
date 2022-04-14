<%@ page import="com.project.exam.domain.User"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/include/head.jsp"/>
<title>home</title>
</head>

<body>
<div>
</div>
${sessionScope.login-user}
<br>
${sessionScope.login-user.username}
<br>
${login-user}
<br>
${login-user.username}
<h3>Logged user: ${session.scopelogin-user} </h3> 
<a href="/exam/application/city"> City page
</a>
<a href="/exam/application/manufacturer"> manufacturer page
</a>

</body>
</html>