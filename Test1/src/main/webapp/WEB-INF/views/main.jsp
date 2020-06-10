<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Assemble main</title>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<link type="text/css" rel="stylesheet" href="/resources/info/css/bootstrap.min.css" />

<link type="text/css" rel="stylesheet" href="/resources/info/css/main.css">

</head>
<body>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
  <div class="container">
    <a class="navbar-brand" href="#"><img src="/resources/info/images/logo.png" width="40" height="40" alt="logo" /> Assemble</a>
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
          <a class="nav-link" href="#img1">로그인</a>
        </li>
        <li class="nav-item">
           		<!-- admin_signup.jsp -->
          <a class="nav-link" href="#img1">어셈블 개설</a>
        </li>

      </ul>
    </div>
  </div>
</nav>

<header>
  <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
      <!-- Slide One - Set the background image for this slide in the line below -->
      <div class="carousel-item active" style="background-image: url('/resources/info/images/meeting.jpg')">
        <div class="carousel-caption d-none d-md-block">
          <h2 class="display-4">효과적인 팀워크</h2>
          <p class="lead">협업툴 어셈블</p>
        </div>
      </div>
      <!-- Slide Two - Set the background image for this slide in the line below -->
      <div class="carousel-item" style="background-image: url('/resources/info/images/business.jpg')">
        <div class="carousel-caption d-none d-md-block">
          <h2 class="display-4">가벼워진 업무</h2>
          <p class="lead">협업툴 어셈블</p>
        </div>
      </div>
      <!-- Slide Three - Set the background image for this slide in the line below -->
      <div class="carousel-item" style="background-image: url('/resources/info/images/brooke-cagle.jpg')">
        <div class="carousel-caption d-none d-md-block">
          <h2 class="display-4">업무 커뮤니케이션</h2>
          <p class="lead">어셈블에서 업무 생산성을 높여보세요</p>
        </div>
      </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
  </div>
</header>

<!-- Page Content -->
<section class="py-5">
  <div class="container">
    <h1 class="display-4">Assemble</h1>
    <p class="lead">어셈블은 조직 내의 오픈 커뮤니케이션에 최적화된 업무용 커뮤니케이션 플랫폼입니다.</p>
  </div>
</section>


<!-- 어셈블개설 ==================================================-->
<div class="container login-container">
            <div class="row">
                <div class="col-md-6 login-form-1">
                		<div class="images">
                            <img src="/resources/info/images/businessman.png" alt="b" id="img1" />   
                        </div>      
                        
       <!-- ======== 관리자 ============ -->                 
                        <div class="form-group">
                            <h2><strong>안녕하세요,</strong></h2>
                        </div>
                        <div class="form-group">
                            <h5>어셈블을 회사/팀에 도입하려는 관리자신가요?</h5>
                            <p>어셈블을 개설한 뒤 함께 일할 동료들을 초대해보세요. <br />
									누구나 쉽게 업무 정보를 공유하고 함께 논의할 수 있습니다.</p>
                        </div>
                        <div class="form-group">
               					  <!-- admin_signup.jsp -->          
                            <a href="/signup"><input type="button" class="btnSubmit" value="개설하기" /></a>
                        </div>      
                </div>
                
       <!-- ======== 멤버 ============ -->                 
                <div class="col-md-6 login-form-2">
                		<div class="images">
                        	<img src="/resources/info/images/group.png" alt="g" id="img2" />
                        </div>
                   
                        <div class="form-group">
                            <h2><strong>함께해요,</strong></h2>
                        </div>
                        <div class="form-group">
                            <h5>어셈블 초대를 받은 멤버신가요?</h5>
                            <p>관리자가 보낸 이메일 초대장을 통해 아지트 참여를 완료해야 로그인할 수 있습니다. <br /> 
                            		만약 로그인할 어셈블이 기억나지 않는다면 참여중인 어셈블을 찾아보세요.</p>
                        </div>
                        <div class="form-group">
                                         <!-- login.jsp -->
                            <a href="/assembleLogin"><input type="button" class="btnSubmit" value="로그인하기" /></a>
                                         <!-- find_assemble.jsp -->
                            <a href="/find_assemble"><input type="button" class="btnSubmit" value="참여중인 어셈블 찾기" /></a>
                        </div>
                                         
                </div>
            </div>
        </div>
      
        
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