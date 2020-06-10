<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>find_assemble</title>
<link type="text/css" rel="stylesheet" href="/resources/info/css/find_assemble.css"></link>

<script type="text/javascript" src="/resources/info/js/jquery.slim.min.js"></script>
<link type="text/css" rel="stylesheet" href="/resources/info/css/bootstrap.min.css" />
<script type="text/javascript" src="/resources/info/js/bootstrap.bundle.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"> 
<script type="text/javascript" src="/resources/js/jquery-3.4.1.min.js"></script> 
<script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet" href="/resources/css/bootstrap.min.css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#findAssembleName').click(function(){
		
		/* console.log(email); */
		$.ajax({
			type:"post",
			url : "<c:url value='/send_findassemble'/>",
			data : "mi_memEmail=" + $("#inputEmail").val(),
			//data: "userEmail="+encodeURIComponent($('#mi_memEmail').val()),
			/* encodeURIComponent
			예를들어, http://a.com?name=egoing&job=programmer 에서 &job=programmer
			중 '&'는 하나의 파라미터가 끝나고 다음 파라미터가 온다는 의미이다.
			그런데 다음과 같이 job의 값에 &가 포함된다면 시스템은 job의 값을 제대로 인식할수 없게 된다. */
			success : function(data){
				alert("입력하신 이메일 "+$('#inputEmail').val()+"로 참여 중인 아지트 목록이 발송되었습니다. 메일을 확인해주세요!");
				document.frm.action="main";
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
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
  <div class="container">
    <a class="navbar-brand" href="#"> <img src="/resources/info/images/logo.png" width="40" height="40" alt="logo" /> Assemble</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item active">
          <a class="nav-link" href="#">Home
                <span class="sr-only">(current)</span>
              </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">로그인</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">어셈블 개설</a>
        </li>
        
      </ul>
    </div>
  </div>
</nav>


<!-- 로그인폼
  ================================================== -->
<div class="main-container">
	<div class="sign-container">
		   <form class="form-signin" method="POST" name="frm"> 
			   <div class="text-center mb-4"> 
			   <img class="mb-4" src="/resources/info/images/logo.png" alt="logo" width="72" height="72">
				   <h2 class="h2 mb-3 font-weight-bold">어셈블 이름을 잊어버리셨나요?</h2>
				   <p>어셈블에 가입했던 이메일을 입력해주세요. <br /> 해당 이메일로 참여 중인 어셈블 목록을 보내드립니다.</p>
			   </div> 
				
			    <div class="form-label-group">
				     <input type="text" id="inputEmail" class="form-control" placeholder="Email Address" required autofocus> 
				     <label for="inputEmail">Email Address</label>
			    </div> 
					    
			    <button class="btn btn-lg btn-info btn-block" type="button" id="findAssembleName">어셈블 목록 찾기</button>
			     <p class="mt-5 mb-3 text-muted text-center">&copy; 2020</p> 
			</form>
	</div>
</div>
<!--   ================================================== 로그인 폼 -->


<!-- footer ================================================== -->
<div class="footer-bottom">
	<div class="footer-container">
		<div class="footer-row">
				<div class="copyright-text">
					<p>CopyRight © 2020 Digital All Rights Reserved</p>
					<img src="/resources/images/assemble.png" width="150" alt="assemble" />
				</div>
		</div>
	</div>
</div> 

</body>
</html>