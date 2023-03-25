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
<h1>Hi ${sessionScope.username} welcome to shopping cart </h1>
<br/>
<br/>
<a href="${pageContext.request.contextPath }/products">Products</a>
<br/>
<br>
 <a href="${pageContext.request.contextPath }/cart">My Cart</a>
<br/>
<br/>
 <a href="${pageContext.request.contextPath }/orders">My Orders</a>
<br/>
<br/>

<br/>
 <a href="${pageContext.request.contextPath }/logout">logout</a>
<br/>
</body>
</html>