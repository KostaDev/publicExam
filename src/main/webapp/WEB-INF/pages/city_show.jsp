<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page isELIgnored="false"%>
<%@ page import="com.project.exam.domain.User"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/include/head.jsp"></jsp:include>
<title>City</title>
<%
	Long zip =Long.parseLong( request.getParameter("zip_code"));
	pageContext.setAttribute("zip", zip);
	String cityName = request.getParameter("city_name");
	pageContext.setAttribute("city", cityName);
	
	
%>
</head>
<body>
<main class="container text-center">
	<h2>City page</h2>
	<div class="container justify-content-center">
		<form action="/exam/application/city/add" method="post">
			<div class="row input-field col s12 m12 l12">
				<input id="zip_code" name="zip_code" type="number" readonly="readonly"
					 value="${zip}"> <label for="zip_code">Zip
					Code:</label>
			</div>
			<div class="row input-field col s12 m12 l12">
				<input id="city_name" name="city_name" type="text"
					 value="${city}"> <label for="city_name">City
					name:</label>
			</div>
			<div>
				<jsp:include page="/include/errorList.jsp"></jsp:include>
				<jsp:include page="/include/successList.jsp"></jsp:include>
			</div>
			
			<div class="row">
				<div class="col s12 center">
					<button class="btn theme-foreground" type="submit" name="action">
						Edit city</button>
				</div>
			</div>
		</form>
	</div>
	
</main>
</body>
</html>