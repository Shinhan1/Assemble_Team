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
	<%-- /assemble.io/avengers/home?memberno=<c:out value='${memberno }' /> --%>
	<h2>어셈블명 : <c:out value="${mi_assembleName }" /></h2>
	<form action="/loginOk" method="POST">
		<input type="text" name="mi_memID" id="mi_memID" /> <br />
		<input type="text" name="mi_memPw" id="mi_memPw" /> <br />
		<input type="submit" value="로그인" />
	</form>
	<input type="hidden" name="mi_assembleName" id="mi_assembleName" value="<c:out value='${mi_assembleName }' />" />

</body>
</html>