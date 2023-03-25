<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>My Cart</h1>
	<table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th>Name</th>
			<th>Price</th>
			<th></th>
		</tr>
		<c:forEach var="product" items="${sessionScope.cartProducts}">
			<tr>
				<td>${product.name }</td>
				<td>${product.price }</td>
				<td><a
					href="${pageContext.request.contextPath }/cart?&action=remove&id=${product.id }">Remove</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<c:if test="${sessionScope.cartPrice>0 }">
	Total price: ${sessionScope.cartPrice}
	<br />
	<a href="${pageContext.request.contextPath }/orders?&action=buy">Confirm
		Order</a>
	</td>
	</c:if>

	<br />
	<a href="${pageContext.request.contextPath }/products">Continue
		Shopping</a>
	<br />
	<br />
	<a href="${pageContext.request.contextPath }/">Home</a>
	<br />
</body>




</html>