<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link type="text/css" rel="stylesheet" href="/resources/info/css/newPassword.css"></link>

<script type="text/javascript" src="/resources/info/js/jquery.slim.min.js"></script>
<link type="text/css" rel="stylesheet" href="/resources/info/css/bootstrap.min.css" />
<script type="text/javascript" src="/resources/info/js/bootstrap.bundle.min.js"></script>

<script type="text/javascript" src="/resources/info/js/jquery-3.4.1.min.js"></script> 
<script type="text/javascript" src="/resources/info/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet" href="/resources/info/css/bootstrap.min.css" />


<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#pwbtn').click(function(){

		//비밀번호 공백 확인 
		if($("#inputPassword").val() == ""){ alert("비밀번호를 입력해주세요"); $("#inputPassword").focus(); return false; }
		
		// 비밀번호 확인
		else if($("#inputPassword").val() != $("#inputrePassword").val()){
			alert("비밀번호가 상이합니다"); 
			$("#inputPassword").val(""); $("#inputrePassword").val("");
			$("#inputPassword").focus(); return false;	
		}
		
		alert("비밀번호가 변경되었습니다.");
		document.frm.action="/changesuccess";
		document.frm.submit();
		
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
          <a class="nav-link" href="/main">Home
                <span class="sr-only">(current)</span>
              </a>
        </li>
        <li class="nav-item">
                			<!-- login.jsp -->
          <a class="nav-link" href="/assembleLogin">로그인</a>
        </li>
        <li class="nav-item">
                			<!-- admin_signup.jsp -->
          <a class="nav-link" href="/signup">어셈블 개설</a>
        </li>
        
      </ul>
    </div>
  </div>
</nav>

<%-- <%
	String mi_assemblename = request.getParameter("mi_assemblename");
	String mi_mememail = request.getParameter("mi_mememail");
%> --%>

<!-- 로그인폼 ================================================== -->
<div class="main-container">
	<div class="sign-container">
		   <form class="form-signin" method="POST" name="frm">  
		   		<input type="hidden" name="mi_assemblename" value="${mi_assemblename }" />
		   		<input type="hidden" name="mi_mememail" value="${mi_mememail }" />
		   		
			   <div class="text-center mb-2"> 
				   <h2 class="h2 mb-3" style="color: #19a3b8">새로운 비밀번호를 설정해주세요</h2>
			   </div> 
			   <div class="test-center mb-3" id="pinfo"><p>비밀번호는 최소 5~20자로 입력해주세요.<br/>개인정보를 안전하게 보호하세요!</p></div>
				
			   <div class="form-label-group">
			       <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="mi_mempw" required> 
			       <label for="inputPassword">새로운 비밀번호</label> 
			   </div>  	
			   
			   <div class="form-label-group">
			       <input type="password" id="inputrePassword" class="form-control" placeholder="Password(confirm)" name="mi_mempwck" required> 
			       <label for="inputrePassword">새로운 비밀번호 확인</label> 
			   </div>  	
			   
			  
			    
			    <button class="btn btn-lg btn-info btn-block" id="pwbtn">새로운 비밀번호 저장하기</button>
			
			     <p class="mt-5 mb-3 text-muted text-center">&copy; 2020</p> 

			</form>
	</div>
</div>
<!--   ================================================== 폼 end -->



<!-- footer ================================================== -->
<div class="footer-bottom">
	<div class="footer-container">
		<div class="footer-row">
				<div class="copyright-text">
					<p>CopyRight © 2020 Digital All Rights Reserved</p>
					<img src="/resources/info/images/assemble.png" width="150" alt="assemble" />
				</div>
		</div>
	</div>
</div> 


</body>
</html>