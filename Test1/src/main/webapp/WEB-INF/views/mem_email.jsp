<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mem_email</title>
<link type="text/css" rel="stylesheet" href="/resources/info/css/mem_email.css" />

<link type="text/css" rel="stylesheet" href="/resources/info/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="/resources/info/css/bootstrap.min.css" />
<head>
<meta charset="UTF-8">
<title>mem_email</title>
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
							<h2 class="card-title">Assemble Name</h2>
							<h3>어셈블에 초대되셨습니다.</h3>
							<p>이 초대를 수락하시려면 아래의 링크를 클릭해 어셈블 계정을 만들어주세요.</p>
						</div>
						
						<div class="form-group">						
							<!-- <input type="text" name="" class="form-control" id="code" value="어셈블주소" readonly/> -->
							<a href="/assemble.io/<c:out value='${mi_assemblename}' />/login/<c:out value='${ran}' />/a">
								http://localhost:9090/assemble.io/<c:out value="${mi_assemblename}" />/login/<c:out value="${ran}" />/a
							</a>
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