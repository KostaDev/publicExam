<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/include/head.jsp"></jsp:include>
<title>City</title>
</head>
<body>
<main class="container text-center">
	<h2>City page</h2>
	<div class="container justify-content-center">
		<form action="/exam/application/city/add">
			<div class="row input-field col s12 m12 l12">
				<input id="zip_code" name="zip_code" type="number"
					autofocus="autofocus"> <label for="zip_code">Zip
					Code:</label>
			</div>
			<div class="row input-field col s12 m12 l12">
				<input id="city_name" name="city_name" type="text"
					autofocus="autofocus"> <label for="city_name">City
					name:</label>
			</div>
			<div>
				<jsp:include page="/include/errorList.jsp"></jsp:include>
				<jsp:include page="/include/successList.jsp"></jsp:include>
			</div>
			
			<div class="row">
				<div class="col s12 center">
					<button class="btn theme-foreground" type="submit" name="action">
						Add new City</button>
				</div>
			</div>
		</form>
	</div>
	<div class="row">
		<div class="col s12">
			<table class="responsive-table">
				<thead>
					<tr>
						<th>Zip Code</th>
						<th>City name</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="city" items="${cities}">
						<tr>
							<td>${city.zipCode}</td>
							<td>${city.name}</td>
							<td>

								<form method="get"
									action="/exam/application/city/show">
									<input name="zip_code" type="hidden" value="${city.zipCode}">
									<input  name="city_name" type="hidden" value="${city.name}">
									<button type="submit"
										class="btn-flat theme-foreground-light-text tooltipped"
										data-tooltip="Show more">
										<i class="material-icons">open_in_new</i>
									</button>
								</form>
								<form method="post"
									action="/exam/application/city/delete" >
									<input name="zip_code" type="hidden" value="${city.zipCode}">
									<button
										class="btn-flat red theme-foreground-light-text tooltipped"
										type="submit" data-tooltip="Delete">
										<i class="material-icons">delete</i>
									</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</main>
</body>
</html>