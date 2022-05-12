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
		<form action="/order/shippingInsert.action" class="form-horizontal" method="post">
			<div class="form-group row">
				<label class="col-sm-2">이름</label>
				<div class="col-sm-3">
					<input name="name" class="form-control"  type="text">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">배송일</label>
				<div class="col-sm-3">
					<input name="shippingDate" class="form-control" type="text">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10">
					<a href="#" class="btn btn-secondary" role="btn">이전</a>
					<input type="submit" class="btn btn-primary" value="등록">
					<a href="#" class="btn btn-secondary" role="btn">취소</a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>