<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>invite.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#invi').click(function(){
			var email = $('#invited').val();
			/* console.log(email); */
			$.ajax({
				/* beforeSend: function(){
					loadingBarStart();
				}, */
				type:"post",
				url : "<c:url value='/invitedOk'/>",
				data : "invited=" + $("#invited").val(),
				//data: "userEmail="+encodeURIComponent($('#mi_memEmail').val()),
				/* encodeURIComponent
				예를들어, http://a.com?name=egoing&job=programmer 에서 &job=programmer
				중 '&'는 하나의 파라미터가 끝나고 다음 파라미터가 온다는 의미이다.
				그런데 다음과 같이 job의 값에 &가 포함된다면 시스템은 job의 값을 제대로 인식할수 없게 된다. */
				success : function(data){
					console.log(email);
					alert("초대 완료!");
				},
				error: function(data){
					console.log(email);
					alert("에러가 발생했습니다.");
					return false;
				}
			})
			
		});
		
		
	});
</script>
</head>
<body>
	<h2>invited.jsp</h2>
	<form action="invitedOk" method="POST">
		<input type="text" name="invited" id="invited" placeholder="이메일 입력" /><br />
		<input type="text" name="id" id="id" placeholder="ID지정" /><br />
		<input type="text" name="name" id="name" placeholder="이름" /><br />
		<input type="text" name="group" id="group" placeholder="소속" /><br />
		<input type="text" name="tel" id="tel" placeholder="전화번호" /><br />
		<input type="button" name="invi" id="invi" value="초대하기" />
	</form>
	
</body>
</html>