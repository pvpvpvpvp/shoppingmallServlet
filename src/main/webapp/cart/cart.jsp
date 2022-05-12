<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<table width='100%'>
				<tr>
					<td align="left"><a href="/product/cartDeleteAll.action" class="btn btn-danger">삭제하기</a></td>
					<td align="right"><a href="/product/shoppingInfo.action" class="btn btn-success">주문하기</a></td>
				</tr>
			</table>
		</div>
	</div>
	<div class="container">
		<div style="padding-top: 50px">
			<table class="table table-hover">
				<tr>
					<th>상품</th><th>가격</th><th>수량</th><th>소개</th><th>비고</th>
				</tr>
				<c:forEach var="cartList" items="${cartList }">
					<tr>
						<td>${cartList.proId }-${cartList.proName }</td>
						<td>${cartList.unitPrice }</td>
						<td>${cartList.quantity }</td>
						<td>${cartList.quantity*cartList.unitPrice } </td>
						<td><a href="/product/cartDelete.action?proId=${cartList.proId }" class="badge badge-danger">삭제</a></td>
					</tr>
					<c:set value="${sum+cartList.quantity*cartList.unitPrice }" var="sum"/>
				</c:forEach>
				
				<tr><th></th><th></th><th>총액</th><th>${sum }</th></tr>
			</table>
			<a href="#" class="btn btn-secondary">&laquo; 쇼핑 계속하기</a>
		</div>
	</div>
	
	
</body>
</html>