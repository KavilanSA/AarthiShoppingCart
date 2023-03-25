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
	Your orders:

	<c:forEach var="order" items="${sessionScope.orderList}">
		<br />
  Order id : ${order.orderId}
  <br />
		<c:forEach var="product" items="${order.productList}">
			<tr>
				<td>${product.name }</td>
				<td>${product.price }</td>
			</tr>
			<br/>
		</c:forEach>

	</c:forEach>
	<br />
	<a href="${pageContext.request.contextPath }/products">Continue
		Shopping</a>
	<br />
	<br />
	<a href="${pageContext.request.contextPath }/">Home</a>
	<br />
</body>
</html>