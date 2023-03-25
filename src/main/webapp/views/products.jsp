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
	<table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>inStock</th>
			<th></th>
		</tr>
		<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.id }</td>
				<td>${product.name }</td>
				<td>${product.price }</td>
				<td>${product.quantity}</td>
				<td><a href="${pageContext.request.contextPath}/cart?&action=add&product_id=${product.id }">AddToCart</a></td>
			</tr>
		</c:forEach>
	</table>

<br/>
 <a href="${pageContext.request.contextPath }/cart">Go To Cart</a>
<br/>	

<br/>
 <a href="${pageContext.request.contextPath }/views/home.jsp">Home</a>
<br/>	
	
</body>
</html>