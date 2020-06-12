<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
</head>
<body>
	<script type="text/javascript">
		alert("로그인 되셨습니다.");
		location.href="/assemble.io/<c:out value="${mi_assemblename }" />/home?memberno=<c:out value='${memberno }' />";
				
	</script>
	
</body>
</html>