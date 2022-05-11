<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="col-md-6">
		<a href="/upload/${product.fileName }">
			<img src="/upload/${product.fileName }" width='150' height="50">
		</a>
		<h4>${product.proName }</h4>
		<p>${product.description }</p>
		<p>
			<b>상품 코드 :</b> <span class="badge badge-danger"> ${product.proId } </span>
		</p>
		<p>
			<b>제조자 :</b> <span> ${product.manufacturer } </span>
		</p>
		<p>
			<b>재고 수량 :</b> <span> ${product.noOfStock } </span>
		</p>
		<p>
			<b>분류 :</b> <span> ${product.category } </span>
		</p>
		<h5>${product.unitPrice }원</h5>
		<form action="/product/cartAdd.action?proId=${product.proId }" name="addForm" method="POST" >
			<a href="#" class="btn btn-info" onclick="addToCart()">상품 주문 &raquo;</a>
			<a href="/product/cartListAll.action" class="btn btn-warning">장바구니 &raquo;</a>
			<a href="<%=request.getContextPath() %>/product/selectAll.action" class="btn btn-secondary">상품 목록&raquo;</a>
		</form>
	</div>
</body>
<script type="text/javascript">
	function addToCart(){
		if(confirm("상품을 장바구니에 추가하시겠습니까?")){
			document.addForm.submit();
		} else { document.addForm.reset();}
	}
</script>
</html>