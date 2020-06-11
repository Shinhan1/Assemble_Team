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
<title>find_email</title>
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
							<h1 class="card-title">참여 중인 어셈블 목록</h1>
							<p> <!-- 이메일주소 --> 계정으로 참여 중인 아지트 목록입니다.</p>
						</div>
						
						<!-- 어셈블 목록 -->
						<div class="form-group">	
							<div class="form-group-row" style="text-align: center">
								<c:forEach var="i" items="${attendList}" >
									<h3><c:out value="${i.mi_assembleName}" /></h3>
								</c:forEach>
							</div>
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