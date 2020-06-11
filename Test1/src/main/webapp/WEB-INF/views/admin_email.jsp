<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<link type="text/css" rel="stylesheet" href="/resources/info/css/admin_email.css" />

<link type="text/css" rel="stylesheet" href="/resources/info/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="/resources/info/css/bootstrap.min.css" />
<head>
<meta charset="UTF-8">
<title>admin_email</title>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-sm-10 col-md-8 col-lg-6 mx-auto">
			<div class="card card-signin my-5">
				<div class="card-body">
					<div class="form">
					
						<div class="form-group">
							<img src="/resources/info/images/assemble.png" alt="assemble" />
						</div>
						
						<div class="form-group">
							<h1 class="card-title">이메일 인증코드</h1>
							<p>어셈블에 가입하신것을 환영합니다. 아래의 인증코드를 입력하시면 가입이 정상적으로 완료됩니다.</p>
						</div>
						
						<div class="form-group">						
							<input type="text" name="" class="form-control" id="code" value="<c:out value='${authCode }' />" readonly/>
						</div>
						
						<hr />
						<div class="form-group">
							<p>본 메일은 발신 전용이며, 문의에 대한 회신은 처리되지 않습니다.</p>
						</div>
					</div>
					
				</div>
			</div>
			
		</div>
	</div>
</div>

</body>
</html>