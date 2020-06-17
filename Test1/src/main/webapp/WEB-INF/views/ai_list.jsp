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
			<th>비밀번호</th>
			<th>이메일</th>
			<th>권한</th>
			<th>Date</th>
			<th>이름</th>
		</tr>
		
		<c:forEach var="i" items="${list }">
		<%-- <tr>
			<td>${i.mi_assembleName }</td>
			<td>${i.mi_memberNo }</td>
			<td>${i.mi_memID }</td>
			<td>${i.mi_regdate }</td>
		</tr> --%>
		<tr>
			<td>${i.mi_assembleName }</td>
			<td>${i.mi_memberNo }</td>
			<td>${i.mi_memID }</td>
			<td>${i.mi_memPw }</td>
			<td>${i.mi_memEmail }</td>
			<td>${i.mi_admin }</td>
			<td>${i.mi_regdate }</td>
			<td>${i.mi_memName }</td>
		</tr>
		
		
		</c:forEach>
	</table>
	
	
	
	
	
	<a href="../assemble/login">
 		<input type="button" value="LOGIN" />
 	</a>
	
	<a href="../assemble/signup">
 		<input type="button" value="SINU UP" />
 	</a>

</body>
</html>