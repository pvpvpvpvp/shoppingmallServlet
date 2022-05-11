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
	<div class="container">
		<div class="row" align="center">
			<c:forEach var="product" items="${products }">
				<div class="col-md-4">
					<a href="/upload/${product.fileName }">
						<img src="/upload/${product.fileName }" width='150' height="50">
					</a>
					<h3>${product.proName }</h3>
					<p>${product.description }</p>
					<p>${product.unitPrice }</p>
					<p>
						<a href="<%=request.getContextPath() %>/product/select.action?proId=${product.proId }" 
							class="btn btn-secondary" role="button">
						상세정보 &raquo;
						</a>
					</p>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>