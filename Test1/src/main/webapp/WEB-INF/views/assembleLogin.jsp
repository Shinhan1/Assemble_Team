<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>assembleLogin</title>
<link type="text/css" rel="stylesheet" href="/resources/info/css/login.css"></link>

<!-- <script type="text/javascript" src="/resources/info/js/jquery.slim.min.js"></script> -->
<link type="text/css" rel="stylesheet" href="/resources/info/css/bootstrap.min.css" />
<script type="text/javascript" src="/resources/info/js/bootstrap.bundle.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"> 
<script type="text/javascript" src="/resources/info/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet" href="/resources/info/css/bootstrap.min.css" />
<script type="text/javascript">
	$(function(){
		var assemblename = "<c:out value='${mi_assemblename}' />";
		var memid = "<c:out value='${mi_memid}' />";
		var match = <c:out value='${passmatch}' />
		
		if(assemblename != "" && memid != "" && match == true) {
			$("#assembleName_session").css("display", "block");
			$("#sessionlogin").click(function(){
				document.frm.action="<c:url value='/sessionlogin' />";
				document.frm.method="post";
				document.frm.submit();
			});
				
			
		}else {
			$("#assembleName_session").css("display", "none");
		}
		
		
	});

</script>

</head>
<body>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
  <div class="container">
    <a class="navbar-brand" href="/main"> <img src="/resources/info/images/logo.png" width="40" height="40" alt="logo" /> Assemble</a>
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

<!-- 로그인폼 ================================================== -->
<div class="main-container">
	<div class="sign-container">
		   <form class="form-signin" action="login" method="POST"> 
			   <div class="text-center mb-4"> 
			   <img class="mb-4" src="/resources/info/images/logo.png" alt="logo" width="72" height="72">
				   <h2 class="h2 mb-3 font-weight-bold">로그인</h2>
			   </div> 
				
			    <div class="form-label-group">
				     <input type="text" id="inputAssemble" class="form-control" placeholder="어셈블 이름" name="mi_assemblename" required autofocus> 
				     <label for="inputAssemble">Assemble Name</label>
			    </div> 
			   <!--  <div class="form-label-group">
				     <input type="text" id="inputId" class="form-control" placeholder="아이디" name="memId" required autofocus> 
				     <label for="inputId">ID</label>
			    </div> 
			   <div class="form-label-group">
			       <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="memPw" required> 
			       <label for="inputPassword">Password</label> 
			   </div>   -->		
			    
			    <button class="btn btn-lg btn-info btn-block" type="submit">로그인</button>
			</form>
			
			<form name="frm">
			    <div style="display:none" id="assembleName_session" >
			    	<span>${mi_assemblename }</span>
			    	<input type="button" id="sessionlogin" value="로그인" onclick="location.href='/login?mi_assemblename=${mi_assemblename}'" />
			    	<input type="hidden" name="id" />
			    	<input type="hidden" name="pw" />
			    </div>
			</form>
			     <p class="mt-5 mb-3 text-muted text-center">&copy; 2020</p> 
	</div>
</div>
<!--   ================================================== 로그인 폼 end -->



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