<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ page isELIgnored = "false" %>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/include/head.jsp"></jsp:include>
<title>City</title>
</head>
<body>
	<h2>City page</h2>
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
								  action="<c:url value="/user/orders/${order.id}"/>">
								<button type="submit" class="btn-flat theme-foreground-light-text tooltipped"
										data-tooltip="Show more">
									<i class="material-icons">open_in_new</i>
								</button>
							</form>
							<form method="post" action="<c:url value="/user/orders/delete" />">
								<input name="order_id" type="hidden" value="${city.zipCode}">
								<button class="btn-flat red theme-foreground-light-text tooltipped" type="submit"
									data-tooltip="Delete">
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
</body>
</html>