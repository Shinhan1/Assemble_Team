<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>white.jsp</title>
</head> 
<body>
	<h2>글쓰기 폼</h2>
	<form action="writeOk">
		<h2>카테고리 번호</h2>
		<input type="text" name="cgNum" id="cgNum" />
		
		<h2>그룹 번호</h2>
		<input type="text" name="grNum" id="grNum" />
		
		<h2>멤버번호</h2>
		<input type="text" name="memNum" id="memNum" />
		<h2>글내용</h2>
		<input type="text" name="contents" id="contents" />
		<input type="submit" value="등록" />
	</form>

</body>
</html>