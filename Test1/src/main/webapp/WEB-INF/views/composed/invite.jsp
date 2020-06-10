<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>inviteMember.jsp</title>
</head>
<body>
	<h2>inviteMember.jsp</h2>
	<form action="inviteOk">
		<h2>초대할 카테고리번호</h2>
		<input type="text" name="cgNum" id="cgNum" />
		
		<h2>초대할 그룹번호</h2>
		<input type="text" name="grNum" id="grNum" />

		<h2>초대할 멤버번호</h2>
		<input type="text" name="memNum" id="memNum" />
		
		<input type="submit" value="초대" />
	</form>
</body>
</html>