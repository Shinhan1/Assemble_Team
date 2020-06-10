<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>changeGroupName</title>
</head>
<body>
	<form action="changeGroupNameOk" method="post">
	
		<h2>변경할 그룹의 카테고리 번호</h2>
		<input type="text" name="cgNum" id="grNum" />
	
		<h2>변경할 그룹의 번호</h2>
		<input type="text" name="grNum" id="grNum" />
		
		<h2>변경하려는 그룹 이름</h2>
		<input type="text" name="grName" id="grName" />
		<input type="submit" value="변경" />
		
	</form>
</body>
</html>