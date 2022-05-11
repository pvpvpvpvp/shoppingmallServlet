<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="cartList" items="${cartList }">
		<div class="col-md-4">
			<a href="/upload/${cartList.fileName }">
				<img src="/upload/${cartList.fileName }" width='150' height="50">
			</a>
			<h3>${cartList.proName }</h3>
			<p>${cartList.description }</p>
			<p>가격 : ${cartList.unitPrice }</p>
			<p>수량 : ${cartList.quantity }</p>
		</div>
	</c:forEach>
</body>
</html>