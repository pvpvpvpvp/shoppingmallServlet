<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        	 	<c:set value="<%=request.getContextPath() %>" var="contextPath" />
		        <a class="navbar-brand" href="${contextPath }/home.jsp">HOME</a>
		        <a class="navbar-brand" href="${contextPath }/product/cartListAll.action">cart</a>
		      </div>
		      <div>
		      	<ul class="navbar-nav mr-auto">
		      		<c:choose>
		      			<c:when test="${empty sessionId }">
		      				<li class="nav-item">
		      					<a class="nav-link" href="${contextPath }/login/loginview/loginPage.jsp">로그인</a>
		      				</li>
		      				<li class="nav-item">
		      					<a class="nav-link" href="${contextPath }/login/loginview/joinPage.jsp">회원가입</a>
		      				</li>
		      			</c:when>
		      			<c:otherwise>
		      				<li style="padding-top: 7px; color: white;" >
		      					${sessionId } 님
		      				</li>
		      				<li class="nav-item">
		      					<a class="nav-link" href="${contextPath }/login/loginview/logoutProc.jsp">로그아웃</a>
		      				</li>
		      				<li class="nav-item">
		      					<a class="nav-link" href="${contextPath }/login/loginview/updatePage.jsp">회원수정</a>
		      				</li>
		      			</c:otherwise>
		      		</c:choose>
		      	</ul>	
		      </div>
		      <div>
		      	<ul class="navbar-nav mr-auto">
		      		<li class="nav-item"><a class="nav-link" href="${contextPath }/product/selectAll.action"> 상품 목록 </a></li>
		      		<li class="nav-item"><a class="nav-link" href="${contextPath }/product/productview/addProductPage.jsp"> 상품 추가 </a></li>
		      		<li class="nav-item"><a class="nav-link" href="${contextPath }/#"> 상품 삭제 </a></li>
		      	</ul>
		      </div>
        </div>
    </nav>
</body>
</html>