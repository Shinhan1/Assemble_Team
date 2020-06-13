<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mem_signup</title>

<link type="text/css" rel="stylesheet" href="/resources/info/css/mem_signup.css" />

<script type="text/javascript" src="/resources/info/js/bootstrap.bundle.min.js"></script>
<!-- <script type="text/javascript" src="/resources/info/js/jquery.slim.min.js"></script> -->
  
<link type="text/css" rel="stylesheet" href="/resources/info/css/bootstrap.min.css" />
<script type="text/javascript" src="/resources/info/js/bootstrap.min.js"></script>
<!-- <script type="text/javascript" src="/resources/info/js/jquery-3.4.1.min.js"></script>  -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var check = "N";
	$("#inputId").keyup(function(){
        $.ajax({
        	type:"post",
        	/* url : "assemble.io/<c:out value='${mi_assemblename}' />/login/<c:out value='${ran}' />/a", */
        	url : "<c:url value='duplicateId'/>",
        	data : "mi_memid=" + $("#inputId").val(),
        	success : function(data) {
        		if(data == 1) {
        			$("#duplication").show();
        			$("#duplication").css('color', 'red');
        			$("#duplication").text("이미 사용중인 아이디입니다.");
        			check="N";
        		}else if(data == 0 && $("#inputId").val() != ""){
        			$("#duplication").show();
        			$("#duplication").css('color', 'green');
        			$("#duplication").text("사용 가능한 아이디입니다.");
        			check="Y";
        		}else {
        			$("#duplication").hide();
        			check="N"
        		}
        	}
        	
        })
		
    });
	
	
	
	
	$('.btn-block').click(function(){
 
		//아이디 공백 확인 
		if($("#inputId").val() == ""){ alert("아이디를 입력해주세요"); $("#inputId").focus(); return false; }
		

		// 비밀번호 확인
		if($("#inputPassword").val() != $("#confirmPassword").val()){
			alert("비밀번호가 상이합니다"); 
			$("#inputPassword").val(""); $("#confirmPassword").val("");
			$("#inputPassword").focus(); return false;	
		}

			
		// 체크박스 여부
		/* if(!$("#customeCheck1").is(":checked")){
			alert("약관에 동의해주세요"); $("#customeCheck1").focus(); return; }
		else if(("#customeCheck1").is(":checked")){
			alert("checked");
		} */
		
		if(!$("#customCheck1").is(":checked")){
			console.log("체크안됨");
			alert("약관에 동의해주세요");
		    $("#customeCheck1").focus();
		    return false;
		}else {
			console.log("체크됨");
		}
		
		if(check == "N") {
			alert("아이디를 변경해주세요.");
			return false;
		}
		
		document.frm.action="../../../../membersignup";
		document.frm.submit();

		
	});

});

</script>

</head>
<body>

<div class="container">
	<div class="row">
		<div class="col-sm-10 col-md-8 col-lg-6 mx-auto">
			<div class="card card-signin my-5">
				<div class="card-body">
					<div class="memProfileImg">
							<img src="/resources/info/images/letter.png" alt="letter" id="letter"/>
					</div>
					<h5 class="card-title text-center">Assemble Name</h5>
					
					<form class="form-signin" method="POST" name="frm">			
		           <div class="form-label-group">
		              	<div class="form-name">
		              		<p>초대받은 이메일</p>
		              	</div>
				            <input type="email" id="inputEmail" name="mi_mememail" class="form-control" 
				            value="http://localhost:9090/assemble.io/<c:out value='${mi_assemblename}' />/login/<c:out value='${ran}' />/a" readonly/>
						 </div>
						 
				<div class="form-label-group">
	              	<div class="form-name">
	              		<p>아이디 만들기</p>
	              	</div>
			             <input type="text" id="inputId" name="mi_memid" class="form-control" placeholder="Id" required/>
			             <span id="duplication">
			             
			             </span>
			             <input type="password" id="inputPassword" name="mi_mempw" class="form-control" placeholder="Password" required>
			           	<input type="password" id="confirmPassword" class="form-control" placeholder="confirm Password" required>    
			           	<input type="text" id="inputName" name="mi_memname" class="form-control" placeholder="Name" required>    
               </div>
		
		              <hr class="my-4">
		              <div class="custom-control custom-checkbox mb-3">
		              	
			                <input type="checkbox" class="custom-control-input" id="customCheck1" required>
			                <label class="custom-control-label" for="customCheck1">
			            <!-- terms.jsp 새창띄우기============================ -->
			                	<a href="/terms" target="_blank" onClick="window.open(this.href, '', 'width=550, height=450, left=300,top=300'); return false;">약관동의(필수)</a></label>
			              </div>
			              <button class="btn btn-lg btn-info btn-block text-uppercase" type="button">가입하기</button>
		             
		            </form>
          		</div>
				
			</div>
		</div>
	</div>

</div>

</body>
</html>