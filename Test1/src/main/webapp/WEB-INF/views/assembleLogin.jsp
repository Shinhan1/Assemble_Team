<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>assembleLogin.jsp</title>
</head>
<body>
	<h2>어셈블명 : <c:out value="${ai_assembleName }" /></h2>
	<form action="main" method="POST">
		<input type="text" name="ai_memID" id="ai_memID" /> <br />
		<input type="text" name="ai_memPw" id="ai_memPw" /> <br />
		<input type="submit" value="로그인" />
	</form>
	<input type="hidden" name="ai_assembleName" id="ai_assembleName" value="<c:out value='${ai_assembleName }' />" />

</body>
</html>