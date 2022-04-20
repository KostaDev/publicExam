<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/include/head.jsp"></jsp:include>
<title>Manufacturer</title>
</head>
<body>
<main class="container text-center">
	<h2>Manufacturer Page</h2>
	<div class="container justify-content-center">
		<form action="/exam/application/manufacturer/add" method="post">
			<div class="row input-field col s12 m12 l12">
				<input id="manufacturer_id" name="manufacturer_id" type="number"
					autofocus="autofocus"> <label for="manufacturer_id">Manufacturer id:</label>
			</div>
			<div class="row input-field col s12 m12 l12">
				<input id="tax_id" name="tax_id" type="text"
					autofocus="autofocus"> <label for="tax_id">Tax Id:</label>
			</div>
			<div class="row input-field col s12 m12 l12">
				<input id="adress" name="adress" type="text"
					autofocus="autofocus"> <label for="city_name">Adress:</label>
			</div>
			
  			<div class="row input-field col s12 m12 l12">  				
				<select id="city" name="city">
					<c:forEach var="c" items="${cities}">
						<option value="${c.zipCode}">${c.name} - ${c.zipCode} </option>
					</c:forEach>				    
				  </select>
				  <label for="city">City:</label>
			</div>
			
			<div>
				<jsp:include page="/include/errorList.jsp"></jsp:include>
				<jsp:include page="/include/successList.jsp"></jsp:include>
			</div>
			
			<div class="row">
				<div class="col s12 center">
					<button class="btn theme-foreground" type="submit" name="action">
						Add</button>
				</div>
			</div>
		</form>
	</div>
	<div class="row">
		<div class="col s12">
			<table class="responsive-table">
				<thead>
					<tr>
						<th>Manufacturer id</th>
						<th>Tax Id</th>
						<th>Adress</th>
						<th>City</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="manufacturer" items="${manufacturers}">
						<tr>
							<td>${manufacturer.manufacturerId}</td>
							<td>${manufacturer.taxId}</td>
							<td>${manufacturer.adress}</td>
							<td>${manufacturer.city.name}</td>
							<td>

								<form method="get"
									action="/exam/application/manufacturer/show">
									<input name="zip_code" type="hidden" value="${city.zipCode}">
									<input  name="city_name" type="hidden" value="${city.name}">
									<button type="submit"
										class="btn-flat theme-foreground-light-text tooltipped"
										data-tooltip="Show more">
										<i class="material-icons">open_in_new</i>
									</button>
								</form>
								<form method="post"
									action="/exam/application/manufacturer/delete" >
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
<jsp:include page="/include/materializeSelect.jsp"/>
<jsp:include page="/include/materializeTooltip.jsp"/>
</body>
</html>