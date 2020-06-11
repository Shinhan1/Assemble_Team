<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signup.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#cf').click(function(){
			var email = $('#mi_memEmail').val();
			/* console.log(email); */
			$.ajax({
				/* beforeSend: function(){
					loadingBarStart();
				}, */
				type:"post",
				url : "<c:url value='/sendMail'/>",
				data : "mi_memEmail=" + $("#mi_memEmail").val() + "&ran=" + $("#ran").val(),
				//data: "userEmail="+encodeURIComponent($('#mi_memEmail').val()),
				/* encodeURIComponent
				예를들어, http://a.com?name=egoing&job=programmer 에서 &job=programmer
				중 '&'는 하나의 파라미터가 끝나고 다음 파라미터가 온다는 의미이다.
				그런데 다음과 같이 job의 값에 &가 포함된다면 시스템은 job의 값을 제대로 인식할수 없게 된다. */
				success : function(data){
					console.log(email);
					alert("사용가능한 이메일입니다. 인증번호를 입력해주세요.");
				},
				error: function(data){
					console.log(email);
					alert("에러가 발생했습니다.");
					return false;
				}
			})
			
		});
		
		$('#cfCk').click(function(){
			var email = $('#mi_memEmail').val();
			console.log(email);
			$.ajax({
				/* beforeSend: function(){
					loadingBarStart();
					}, */
				
				type:"post",
				url:"<c:url value='/emailAuth'/>",
				data:"authCode=" + $('#authCode').val() + "&ran=" + $("#ran").val(),
				success:function(data){
				if(data=="complete"){
					alert("인증이 완료되었습니다.");
				}else if(data == "false"){
					alert("인증번호를 잘못 입력하셨습니다.")
				}
				},
				complete: function(){
					/* loadingBarEnd(); */
					console.log("완료");
				},
				error:function(data){
					alert("에러가 발생했습니다.");
				}
				});
			
		});
		
		
		
		
		
	});
</script>
</head>
<body>
	<h2>어셈블 개설</h2>
	<form action="signupOk" method="POST" name="frm">
		<input type="text" name="mi_assembleName" id="mi_assembleName" placeholder="어셈블명 및 URL" /><br />
		<input type="text" name="mi_memEmail" id="mi_memEmail" placeholder="email" />
		<input type="button" value="인증코드 발송" id="cf" /><br />
		<input type="text" name="authCode" id="authCode" placeholder="인증번호" />
		<input type="button" value="인증 확인" id="cfCk" /><br />
		<input type="text" name="mi_memID" id="memID" placeholder="아이디" /><br />
		<input type="text" name="mi_memPw" id="mi_memPw" placeholder="비밀번호" /><br />
		<input type="text" name="pwCk" id="pwCk" placeholder="비밀번호 확인" /><br />
		<input type="text" name="mi_memName" id="mi_memName" placeholder="이름입력" /><br />
		<input type="submit" value="어셈블 개설하기" /><br />
	</form>
	<input type="hidden" name="ran" id="ran" value="<c:out value='${ran }' />" />
	

</body>
</html>