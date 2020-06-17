<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/assemble.io/${mi_assembleName}/header"></c:import>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"> -->
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
        crossorigin="anonymous">  
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>

<link type="text/css" rel="stylesheet" href="/resources/info/css/myPage2.css">


<style type="text/css">
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
</style>
</head>
<body>
<div class="main">
	<div class="contents">

            <div class="col gedf-main">
                <div class="card gedf-card">
                 
                    <div class="card-body">
                    	<div class="card-pfrofile">
	                       <div class="card-title">
								<h3 class="card-title-name"> :User Name</h3>

								<div class="user">
									<label name="guest_member" class="member-badge user-profile-card__badge">방장/멤버 표시</label>
								</div>

								<div><h4> :Email</h4></div>
																
	                       </div>
	                    </div>
			<hr />
						<div class="card-detail">
							<div class="card-action">
								<a href="#">		<!-- 프로필수정 페이지 -->
									<i class="ico ico-profile_edit" aria-hidden="true"><svg width="36" height="36" viewBox="0 0 36 36">
									<g fill="none" fill-rule="evenodd"><path d="M4 0h36v36H4z"></path>
									<circle cx="18" cy="18" r="17.5" fill="#FFF" stroke="#E2E2E3"></circle>
									<path fill="#4778D9" d="M24.776 14.136l-1.419 1.419-2.912-2.912 1.419-1.419a.749.749 0 0 1 .55-.224c.218 0 .402.075.551.224l1.811 1.81c.15.15.224.334.224.551a.749.749 0 0 1-.224.551zM11 22.088l8.605-8.605 2.912 2.912L13.912 25H11v-2.912z">
									</path></g></svg></i>
								</a>
							</div>
						
						
							<div class="card-profile-image">
									<!-- background-image: url("프로필이미지 주소") -->
								<span class="profile-image" style="background-image: url(resources/info/images/businessman.png); width: 160px; height: 160px;"></span>
							</div>
							
							<div class="profile-detail">
								<table class="detail">
									<tbody>
										<tr>
											<th>소속</th>
											<td>:memTeam</td>
										</tr>
										<tr>
											<th>직급</th>
											<td>:memGrade</td>
										</tr>
										<tr>
											<th>전화</th>
											<td>:memPhone</td>
										</tr>
									</tbody>
							
								</table>
							</div>
							
						</div>	<!-- detail end -->
			
                    </div>
                </div>
                
            </div>
<!-- ================ profile end ========================= -->

                <div class="tap">
					<a href="#" class="link"><i class="fa fa-sticky-note-o"></i> 내 글</a>
                    <a href="#" class="link"><i class="fa fa-gittip"></i> 좋아요한 글</a>
					<a href="#" class="link"><i class="fa fa-address-book-o"></i> 참여중인 그룹</a>
                </div>
                
<!-- =============================================================== -->
                <div class="contetns">
                



				</div>
<!-- =================================================================== -->

        </div>
   

</div>
</body>
</html>