<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ai.jsp</title>
</head>
<body>
	<h2>ai.jsp</h2>
	<table>
		<tr>
			<th>어셈블 이름</th>
			<th>멤버 번호</th>
			<th>멤버 아이디</th>
			<th>멤버 비밀번호</th>
			<th>멤버 이메일</th>
			<th>방장 권한</th>
			<th>Date</th>
		</tr>
		
		<c:forEach var="i" items="${list }">
		<tr>
			<td>${i.ai_assembleName }</td>
			<td>${i.ai_memberNo }</td>
			<td>${i.ai_memID }</td>
			<td>${i.ai_memPw }</td>
			<td>${i.ai_memEmail }</td>
			<td>${i.ai_admin }</td>
			<td>${i.ai_regdate }</td>
		</tr>
		</c:forEach>
	</table>
	
	<a href="../ass/signup">
 		<input type="button" value="SINU UP" />
 	</a>

</body>
</html>