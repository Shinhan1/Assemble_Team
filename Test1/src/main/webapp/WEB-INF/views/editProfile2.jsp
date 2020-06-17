<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/assemble.io/${mi_assemblename}/header"></c:import>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"> -->
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
        crossorigin="anonymous">       
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>

<link type="text/css" rel="stylesheet" href="/resources/info/css/editProfile2.css">

<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    var readURL = function(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('.avatar').attr('src', e.target.result);
            }
    
            reader.readAsDataURL(input.files[0]);
        }
    }   

    $("#file-input").on('change', function(){
        readURL(this);
    });
    
});
</script>
<style type="text/css">
body{background-color: none;}
.main {
	width: 50%;
	height: 100%;
	position: absolute;
	margin-top: 5%;
	margin-bottom: 5%;
	margin-left: 25%;
}
.contents {
	background-color: white;
	border: 1px solid #CCCCCC;
	margin: 0;
	padding: 0;
	clear: none;
}
.modal-header{background-color: #fcfcfc;}

</style>
</head>
<body>
<div class="main">
	<div class="contents">

			<div class="card-body">
				<div class="card-profile">
					<div class="card-title">
						<h3 class="card-title-name"><b> :User Name 프로필관리</b></h3>
						<div><h4> :Email</h4></div>		
					</div>
				</div>
					
						
				<hr />
				<button data-toggle="modal" data-target="#squarespaceModal" class="btn btn-link center-block">비밀번호 변경</button>
				
					<!-- =========================== modal ================================= -->		
				
				<!-- line modal -->
				<div class="modal fade" id="squarespaceModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
				  	<div class="modal-dialog">
						<div class="modal-content">
						<div class="modal-header">
							<h3 class="modal-title" id="lineModalLabel">비밀번호 변경 *</h3>
							<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
						</div>
						<div class="modal-body">
							
				            <!-- content goes here -->
							<form>
				              <div class="form-group">
				                <label for="exampleInputPassword1">Password</label>
				                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" required>
				              </div>
				              <button type="submit" class="btn btn-default">변경</button>
				            </form>
				
						</div>
						
		<div class="modal-footer">
			<div class="btn-group btn-group-justified" role="group" aria-label="group button">
				<div class="btn-group" role="group">
					<button type="button" class="btn btn-default" data-dismiss="modal"  role="button">Close</button>
				</div>
			
			</div>
		</div>
						
						</div>
					</div>
				</div>
				
				<!-- =========================== modal ================================= -->	
				
							<div class="image-upload">
								<label for="file-input">
									<!--input:file img -->
									<i class="fa fa-camera" aria-hidden="true" ></i>
								    <img src="resources/info/images/businessman.png" alt="avatar" class="avatar" width="180px" height="180px"/>
								 </label>							
								 <input class="text-center center-block file-upload" id="file-input" type="file" accept="image/*" capture="camera"/>
							</div>
							
							
							<div class="edit-form">
								<form action="">
									<div class="form-label-group">
									     <label for="inputAssemble" class="form-label">이름</label>
									     <input type="text" id="inputName" class="form-control" placeholder="이름" name="memName" required > 
								    </div> 
									    
									<div class="form-label-group">
									     <label for="inputTeam" class="form-label">소속</label>
									     <input type="text" id="inputTeam" class="form-control" placeholder="소속" name="memTeam" required > 
								    </div> 
									    
									<div class="form-label-group">
									     <label for="inputGrade" class="form-label">직급</label>
									     <input type="text" id="inputGrade" class="form-control" placeholder="직급" name="memGrade" required > 
								    </div>
										     
									<div class="form-label-group">
									     <label for="inputPhone" class="form-label">휴대폰 번호</label>
									     <input type="text" id="inputPhone" class="form-control" placeholder="휴대폰 번호" name="memPhone" required > 
								    </div> 
								
								<br />
									<button class="btn btn-lg btn-block" type="submit">확인</button>    
								</form>  
										    
							</div>		<!-- edit-form end -->
				
			</div><!-- card body end  -->
			
	
	</div>
</div>

</body>
</html>