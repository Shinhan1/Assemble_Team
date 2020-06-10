<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>groups.jsp</title>
</head>
<body>
	<h2>그룹 전체 보기</h2>
	<c:forEach var="i" items="${list }">
		<table>
			<tr>
				<th>카테고리번호</th>
				<th>그룹번호</th>
				<th>그룹이름</th>
				<th>그룹을 만든 멤버번호</th>
			</tr>
			<tr>
				<td>${i.categoryno }</td>
				<td>${i.groupno }</td>
				<td>${i.groupname }</td>
				<td>${i.memberno }</td>
			</tr>
		</table>
	
	</c:forEach>

</body>
</html>