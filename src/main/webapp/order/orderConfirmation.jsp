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

	<div class="container col-8 alert alert-info">
		<div class="text-center">영수증</div>
		<div class="row justify-content-between">
			<div class="col-4" align="left">
				<strong>배송 주소</strong>
				<br>이름 : ${name }
				<br>우편번호 :
				<br>주소 :
			</div>
			<div class="col-4" align="right">
				<p><em>배송일 :${shippingDate }</em></p>
			</div>
			
		</div>
	</div>
	
	<div class="container">
		<div style="padding-top: 50px">
			<table class="table table-hover">
				<tr>
					<th>상품</th><th>가격</th><th>수량</th><th>소개</th>
				</tr>
				<c:forEach var="cartList" items="${cartList }">
					<tr>
						<td>${cartList.proId }-${cartList.proName }</td>
						<td>${cartList.unitPrice }</td>
						<td>${cartList.quantity }</td>
						<td>${cartList.quantity*cartList.unitPrice } </td>
					</tr>
					<c:set value="${sum+cartList.quantity*cartList.unitPrice }" var="sum"/>
				</c:forEach>
				
				<tr><th></th><th></th><th>총액</th><th>${sum }원</th></tr>
			</table>
		</div>
		<a class="nav-link" href="/order/thankCustomer.action"> 결제 </a>
	</div>
	
	
	
	
</body>
</html>