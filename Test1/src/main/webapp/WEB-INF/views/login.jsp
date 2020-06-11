<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link type="text/css" rel="stylesheet" href="/resources/info/css/login.css"></link>

<script type="text/javascript" src="/resources/info/js/jquery.slim.min.js"></script>
<link type="text/css" rel="stylesheet" href="/resources/info/css/bootstrap.min.css" />
<script type="text/javascript" src="/resources/info/js/bootstrap.bundle.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"> 
<script type="text/javascript" src="/resources/info/js/jquery-3.4.1.min.js"></script> 
<script type="text/javascript" src="/resources/info/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet" href="/resources/info/css/bootstrap.min.css" />

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
                			<!-- login.jsp -->
          <a class="nav-link" href="#">로그인</a>
        </li>
        <li class="nav-item">
                			<!-- admin_signup.jsp -->
          <a class="nav-link" href="#">어셈블 개설</a>
        </li>
        
      </ul>
    </div>
  </div>
</nav>

<!-- 로그인폼 ================================================== -->
<div class="main-container">
	<div class="sign-container">
		   <form class="form-signin" action="loginOk" method="POST"> 
			   <div class="text-center mb-4"> 
			   <img class="mb-4" src="/resources/info/images/logo.png" alt="logo" width="72" height="72">
				   <h2 class="h2 mb-3 font-weight-bold">로그인</h2>
			   </div> 
				
			    <div class="form-label-group">
				     <input type="text" id="inputId" class="form-control" placeholder="아이디" name="mi_memID" required autofocus> 
				     <label for="inputId">ID</label>
			    </div> 
			   <div class="form-label-group">
			       <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="mi_memPw" required> 
			       <label for="inputPassword">Password</label> 
			   </div>  		
			    
			    <button class="btn btn-lg btn-info btn-block" type="submit">로그인</button>
			     <p class="mt-5 mb-3 text-muted text-center">&copy; 2020</p> 
			</form>
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