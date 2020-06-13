<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>new_profile</title>

<link type="text/css" rel="stylesheet" href="/resources/info/css/new_profile.css" />

<link type="text/css" rel="stylesheet" href="/resources/info/css/bootstrap.min.css" />
<script type="text/javascript" src="/resources/info/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="/resources/info/js/jquery.slim.min.js"></script> 

<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    var readURL = function(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#proImg').attr('src', e.target.result).width(500);
            }
    
            reader.readAsDataURL(input.files[0]);
        }
    }   

    $("#memProfileImg").on('change', function(){
        readURL(this);
    });
    
    
    $('#bt').click(function(){
    	
    	alert("회원가입이 완료되었습니다.");
	    document.frm.action="/signup/new_profile";
	    document.frm.submit();
    	
    });
    
    
});
</script>
<style type="text/css">
#proImg{
   margin-top: 1rem;
   display: block;
   margin: 0 auto;
   max-width: 230px;
   height: 230px;
   margin-bottom: 1rem;
}
</style>

</head>
<body>

<div class="container">
	<div class="row">
		<div class="col-sm-10 col-md-8 col-lg-6 mx-auto">
			<div class="card card-signin my-5">
				<div class="card-body">
					<h5 class="card-title text-center">Assemble Name</h5>
					
						
					<form action="signup/new_profile" class="form-signin" method="POST" name="frm" enctype="multipart/form-data" >
						<div class="memProfileImg">
							<div class="form-img">
								<!--===== 클릭시 사진올라갈 부분  ============= -->							
								<label for="memProfileImg" ><img src="/resources/info/images/profile.png" alt="proImg" id="proImg" width="230px" height="230px"  /></label> 
								<input type="file" id="memProfileImg" accept="image/*" name="ms_memprofileimg" >
							
							</div>
						</div>
						<div class="profile">
							<h5>나의 프로필</h5>
							<p>정보를 입력해주세요</p>
						</div>
						
						<div class="form-label-group">
							<label for="memTeam">소속부서</label>
							<input type="text" name="ms_memteam" class="form-control" id="memTeam" />
						</div>
						<div class="form-label-group">
							<label for="memGrade">직급</label>
							<input type="text" name="ms_memgrade" class="form-control" id="memGrade" />
						</div>
						<div class="form-label-group">
							<label for="memPhone">휴대폰 번호</label>
							<input type="text" name="ms_memphone" class="form-control" id="memPhone" />
						</div>
						
						<hr class="my-4">
			            
			              <div class="custom-control custom-checkbox mb-3">
				              <button class="btn btn-lg btn-info btn-block text-uppercase" type="button" id="bt">프로필 작성 완료</button>			                
			              </div>
					</form>
				</div>
				
			</div>
		</div>
	</div>

</div>

</body>
</html>