<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
	<% 
		String greeting ="Welcome to Conan's HOME"; 
		String tagline ="내 이름은 코난, 탐정이죠.";
	%>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3"><%=greeting %></h1>
		</div>
	</div>
	<main role="main">
		<div class="container" >
			<div class="text">
				<h3><%=tagline %></h3>
			</div>
		</div>
	</main>
</body>
</html>