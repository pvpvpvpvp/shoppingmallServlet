<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
    <nav class="navbar navbar-expand navbar-dark bg-dark">
        <div class="container">
        	 <div class="navbar-header">
		        <a class="navbar-brand" href="<%=request.getContextPath() %>/home.jsp">HOME</a>
		        <a class="navbar-brand" href="<%=request.getContextPath() %>/product/selectAll.action">Products</a>
		        <a class="navbar-brand" href="<%=request.getContextPath() %>/product/productview/addProductPage.jsp">addProduct</a>
		        <a class="navbar-brand" href="<%=request.getContextPath() %>/product/cartListAll.action">cart</a>
		      </div>
        </div>
    </nav>
</body>
</html>