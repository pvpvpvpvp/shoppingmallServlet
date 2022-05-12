<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2 class="alert alert-danger">주문해 주셔서 감사합니다.!</h2>
		<p> 주문은 ${shippingDate }에 배송될 예정입니다.
		<p> 주문번호 : ${cartId }
		<p> 이름 : ${name }
	</div>
	<div class="container">
		<a class="nav-link" href="/product/selectAll.action"> 상품 목록 </a>
	</div>
</body>
</html>