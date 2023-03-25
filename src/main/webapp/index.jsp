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

<c:if test="${sessionScope.username==null}">
<jsp:forward page="views/login.jsp"></jsp:forward>
</c:if>


<jsp:forward page="views/home.jsp"></jsp:forward>


</body>
</html>