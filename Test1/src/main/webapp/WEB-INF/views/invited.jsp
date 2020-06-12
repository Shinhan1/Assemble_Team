<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>invited</title>

<link type="text/css" rel="stylesheet" href="/resources/info/css/invited.css" />

<script type="text/javascript" src="/resources/info/js/jquery.slim.min.js"></script>
<link type="text/css" rel="stylesheet" href="/resources/info/css/bootstrap.min.css" />
<script type="text/javascript" src="/resources/info/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#invi').click(function(){
			
			/* console.log(email); */
			$.ajax({
				/* beforeSend: function(){
					loadingBarStart();
				}, */
				type:"post",
				url : "<c:url value='/invitedOk'/>",
				data : "invited=" + $("#memEmail").val() + "&ran=" + $("#ran").val(),
				
				success : function(data){
					
					alert("초대 완료!");
					document.frm.action="/assemble.io/<c:out value='${mi_assemblename}' />/home?memberno=<c:out value='${memberno}' />";
					document.frm.submit();
				},
				error: function(data){
					
					alert("에러가 발생했습니다.");
					return false;
				}
			})
			
		});
		
		
	});
</script>
</head>
<body>
<div class="contents">
	<div class="form-invitation">
		<div class="title">
			<h2 class="mb-0 font-weight-bold">초대하기</h2>
		</div>
		<div class="invitation-form">
			
			<form action="invitedOk" method="POST" name="frm" >
				  <div class="form-group row">
				    <label for="colFormLabel" class="col-sm-2 col-form-label">이메일 주소 (필수)</label>
				    <div class="col-sm-10">
				      <input type="email" class="form-control" id="memEmail" placeholder="이메일 주소" name="mi_mememail" required>
				    </div>
				  </div>
				  
				  <div class="form-group row">
				    <label for="colFormLabel" class="col-sm-2 col-form-label">추가 정보</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="memTeam" placeholder="소속부서">
				      <input type="text" class="form-control" id="memGrade" placeholder="직급">
				      <input type="text" class="form-control" id="memPhone" placeholder="휴대폰 번호">
				    </div>
				  </div>
				  
				<button class="btn btn-lg btn-info btn-block" type="button" id="invi">초대하기</button>
				  
			</form>

		</div>
	</div>
</div>
<input type="hidden" name="ran" id="ran" value="<c:out value='${ran }' />" />

</body>
</html>