<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin_signup</title>
<link type="text/css" rel="stylesheet" href="/resources/info/css/admin_signup.css" />

<script type="text/javascript" src="/resources/info/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery.slim.min.js"></script>
  
<link type="text/css" rel="stylesheet" href="/resources/info/css/bootstrap.min.css" />
<script type="text/javascript" src="/resources/info/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/info/js/jquery-3.4.1.min.js"></script> 


<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#code-btn').click(function(){
		/* console.log(email); */
		$.ajax({
			type:"post",
			url : "<c:url value='/sendMail'/>",
			data : "mi_memEmail=" + $("#inputEmail").val() + "&ran=" + $("#ran").val(),
			//data: "userEmail="+encodeURIComponent($('#mi_memEmail').val()),
			/* encodeURIComponent
			예를들어, http://a.com?name=egoing&job=programmer 에서 &job=programmer
			중 '&'는 하나의 파라미터가 끝나고 다음 파라미터가 온다는 의미이다.
			그런데 다음과 같이 job의 값에 &가 포함된다면 시스템은 job의 값을 제대로 인식할수 없게 된다. */
			success : function(data){
				alert("사용가능한 이메일입니다. 인증번호를 입력해주세요.");
			},
			error: function(data){
				alert("에러가 발생했습니다.");
				return false;
			}
		})
		
	});
	
	$('#re-code').click(function(){
/* 		console.log(email); */
		$.ajax({
			
			type:"post",
			url:"<c:url value='/emailAuth'/>",
			data:"authCode=" + $('#inputCode').val() + "&ran=" + $("#ran").val(),
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
	
	// 어셈블이름 중복확인
	$('#assemble-btn').click(function(){
		console.log("어셈블이름")
		
	});
	
	// 인증코드  발송
	/* $('#code-btn').click(function(){
		console.log("인증코드");
		
	}); */
	
	// 인증코드 확인
	/* $('#re-code').click(function(){
		console.log("인증확인");
		
	}); */
	
	$('.btn-block').click(function(){
		 
		// 어셈블 공백 확인
		if($("#assemblename").val() == ""){ alert("어셈블 이름을 입력해주세요"); $("#inputName").focus(); return false; }		
		
		// 이메일 공백확인
		else if($("#inputEmail").val() == ""){ alert("이메일을 입력해주세요"); $("#inputEmail").focus(); return false; }
	
		// 인증코드 공백 확인
		else if($("#inputCode").val() == ""){ alert("인증코드를 입력해주세요"); $("#inputCode").focus(); return false; }
		
		//아이디 공백 확인 
		else if($("#inputId").val() == ""){ alert("아이디를 입력해주세요"); $("#inputId").focus(); return false; }
		
		// 비밀번호 확인
		else if($("#inputPassword").val() != $("#confirmPassword").val()){
			alert("비밀번호가 상이합니다"); 
			$("#inputPassword").val(""); $("#confirmPassword").val("");
			$("#inputPassword").focus(); return false;	
		}	

		
		// 체크박스 여부
  		if(!$('#customCheck1').is(":checked")){
  			console.log("체크안됨");
			alert("약관에 동의해주세요"); 
			$("#customeCheck1").focus(); 
			return false; 
		} else {
			console.log("체크됨");
		}
		
		/* else if (!$("input:checked[id='customeCheck1']").is(":checked")){ 
			alert("약관에 동의해주세요"); $("#customeCheck1").focus(); return false; } */
		
		document.frm.submit();
			
	});
	
	
	
});

</script>

</head>
<body>

<body>
  <div class="container">
    <div class="row">
      <div class="col-sm-10 col-md-8 col-lg-6 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">Sign up</h5>
            <form class="form-signin" action="signupOk" method="POST" name="frm" >
              <div class="form-label-group">
              	<div class="form-name">
              		<p>어셈블 정보</p>
              	</div>
		                <input type="text" name="mi_assembleName" id="assembleName" class="form-control" placeholder="Assemble Name" required autofocus>
		                
		                <input type="button" class="btn btn-light btn-xs" id="assemble-btn" value="중복확인" />
              </div>

              <div class="form-label-group">
              	<div class="form-name">	
              		<p>이메일 인증</p>
              	</div>
		                <input type="email" name="mi_memEmail" id="inputEmail" class="form-control" placeholder="Email address" required>
		                
		                <input type="button" class="btn btn-light btn-xs" value="코드 발송" id="code-btn" />          
		                <input type="text" name="authCode" id="inputCode" class="form-control" placeholder="인증코드" required>
		               
		                <input type="button" class="btn btn-light btn-xs" value="인증 확인" id="re-code"/>    
                
              </div>
              
              <div class="form-label-group">
              	<div class="form-name">
              		<p>아이디 만들기</p>
              	</div>
		                <input type="text" id="inputId" name="mi_memID" class="form-control" placeholder="Id" required/>
		                <!-- <label for="inputId">Id</label> -->
		                <input type="password" id="inputPassword" name="mi_memPw" class="form-control" placeholder="Password" required>
		                <!-- <label for="inputPassword">Password</label> -->
		                <input type="password" id="confirmPassword" class="form-control" placeholder="Password (confirm)" required>
		                <!--  <label for="confirmPassword">Confirm Password</label> -->
		                <input type="text" id="inputName" name="mi_memName" class="form-control" placeholder="Name" required>
              </div>

              <hr class="my-4">
              <div class="custom-control custom-checkbox mb-3">
              	
	                <input type="checkbox" class="custom-control-input" id="customCheck1" required>
	                
	                <label class="custom-control-label" for="customCheck1">
	                <!-- terms.jsp 새창띄우기============================ -->
	                	<a href="terms" target="_blank" onClick="window.open(this.href, '', 'width=550, height=450, left=300,top=300'); return false;">약관동의(필수)</a></label>
	              </div>
	              <button class="btn btn-lg btn-info btn-block text-uppercase" type="button" >개설하기</button>
             
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  <input type="hidden" name="ran" id="ran" value="${ran }" />
</body>

</body>
</html>