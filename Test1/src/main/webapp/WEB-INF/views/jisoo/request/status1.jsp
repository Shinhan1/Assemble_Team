<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/assemble.io/${mi_assemblename}/header"></c:import>
<!DOCTYPE html>
<html>
<head>

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<!------ Include the above in your HEAD tag ---------->
<link rel="stylesheet" type="text/css" href="/resources/assets/css/hancss/clicklist.css">  	<!-- css 파일 경로  -->
<link rel="stylesheet" type="text/css" href="/resources/assets/css/chat_css.css">  	<!-- css 파일 경로  -->


<meta charset="UTF-8">

<title>status0.div</title>
<style type="text/css">
#board {
	padding: 20px;
	border: 2px solid #F2F2F2;
	background-color: white;
	margin-bottom: 30px;
	border: 1px solid #CCCCCC;
	/* #F2F2F2; */
}

#a, #b {
	border-bottom: 1px solid #CCCCCC;
}

#f {
	margin-top: 10px;
}

#retext {
	width: 91%;
	border: 1px solid #CCCCCC;
}

#re {
	background-color: white;
	border: none;
	border: 1px solid #CCCCCC;
	margin-right: 1%;
}

.lh{
	width: 22px;
	margin-left: 1.5%;
}

#more{
	width: 22px;
}

.submit{
	margin-left: 2%;
}


#boarddate {
	margin-left: 80%;
}

.submit {
	margin-left: 2%;
}

#boarddate{
	margin-left: 80%;
}
#d1{
	width: 70%;
}
.d2{
	margin-left: 82%;
}

.menubtn{
	border: none;
	background-color: white;
	border: 1px solid #CCCCCC;
}

/* 댓글 */
#s0{
	border: 1px solid #CCCCCC;
	font-size: 14px;
}

#s1 {
	border-bottom: 1px solid #CCCCCC;
	background-color: #F2F2F2;
	padding: 0.6%;

}

#s1a {
	display: inline;
	float: left;
	margin-right: 66%;

}
#s2{
	padding: 1%;
}

/* 요청 */
#btn-group {margin: 0;}
#btn-group {margin: 0;}
#btnra, #btnrb, #btnrc,
#btnia, #btnib, #btnic, 
#btnea, #btneb, #btnec {
 border: none;
  color: white;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  width: 70px;
  height: 25px;
  float: left;
}

#btnia, #btnea, #btnrb, #btneb, #btnrc, #btnic{
 background-color: #EAEAEA;
}

#btnra {
  background-color: red; 
}

#btnib {
  background-color: green; ;
  
}

#btnec {
  background-color: gray; 
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
//요청 상태 변화
$(function() {
	var r1 = $('.req');
	var r2 = $('.ing');
	var r3 = $('.end');

	//요청버튼
	$(".req").click(function() {
		var bnoa = this.parentNode.childNodes[1].value + "a";
		var bno = this.parentNode.childNodes[1].value;
		var groupno = this.parentNode.childNodes[3].value;
		
		
		console.log(bno);
		console.log(groupno);
		console.log(status);
		
		//console.log(this.parentNode.childNodes);
		
		this.parentNode.childNodes[7].style.backgroundColor = "red";
		this.parentNode.childNodes[9].style.backgroundColor = "#EAEAEA";
		this.parentNode.childNodes[11].style.backgroundColor = "#EAEAEA";
		
		$.ajax({
			url : "/assemble.io/{mi_assemblename}/updateStatus",
			type : 'POST',
			data : {"bno": bno, "groupno": groupno, "status" : 0},
			dataType: "json",

			success: function(req){
					console.log("sucess view");	
					console.log(req);
			},
			error: function(req){
				console.log("error view");
				console.log(req);
			}

		});//ajax end

	});//.req click end	
	//진행버튼
	$(".ing").click(function() {
		var bnoa = this.parentNode.childNodes[1].value + "a";
		var bno = this.parentNode.childNodes[1].value;
		var groupno = this.parentNode.childNodes[3].value;
		var status = this.parentNode.childNodes[5].value;
		console.log("진행");
		console.log(bnoa);

		this.parentNode.childNodes[7].style.backgroundColor = "#EAEAEA";
		this.parentNode.childNodes[9].style.backgroundColor = "green";
		this.parentNode.childNodes[11].style.backgroundColor = "#EAEAEA";
		
		$.ajax({
			url : "/assemble.io/{mi_assemblename}/updateStatus",
			type : 'POST',
			data : {"bno": bno, "groupno": groupno, "status" : 1},
			dataType: "json",

			success: function(req){
					console.log("sucess view");	
					console.log(req);
			},
			error: function(req){
				console.log("error view");
				console.log(req);
			}

		});//ajax end
	});//.ing click end	
	//종료 버튼
	$(".end").click(function() {
		var bnoa = this.parentNode.childNodes[1].value + "a";
		var bno = this.parentNode.childNodes[1].value;
		var groupno = this.parentNode.childNodes[3].value;
		var status = this.parentNode.childNodes[5].value;
		console.log("종료");
		console.log(bnoa);

		this.parentNode.childNodes[7].style.backgroundColor = "#EAEAEA";
		this.parentNode.childNodes[9].style.backgroundColor = "#EAEAEA";
		this.parentNode.childNodes[11].style.backgroundColor = "gray";
		
		$.ajax({
			url : "/assemble.io/{mi_assemblename}/updateStatus",
			type : 'POST',
			data : {"bno": bno, "groupno": groupno, "status" : 2},
			dataType: "json",

			success: function(req){
					console.log("sucess view");	
					console.log(req);
			},
			error: function(req){
				console.log("error view");
				console.log(req);
			}

		});//ajax end
	
	});//.end click end	
});//function end 
</script>
</head>
<body>
	
	<div class="div0" style="z-index: -2">
		<section class="bookmarks-page">
			<header class="page-header bookmarks-page__header">
			
				<h2 class="page-header__title">
					<span>요청</span>											<!-- div 제목  -->
					<span class="page-header__total-count"></span>				<!-- 게시물보이는 갯수 -->
				</h2>
				
				<div class="page-header__info">
				
					<div class="page__options bookmarks-page__options">
						
						<div class="page__options mentions-page__options">
							<a href="/myRequest"><button class="option-button1" >모든상태</button></a>
							<a href="/myReqStatus?status=0"><input type="button" value="요청" class="option-button2" /></a>
							<a href="/myReqStatus?status=1"><input type="button" value="진행" class="option-button3" autofocus="autofocus"/></a>
							<a href="/myReqStatus?status=2"><input type="button" value="완료" class="option-button4"/></a>
						</div>
	
					</div>
				
				
					<form class="search-field bookmarks-page__search">
						<fieldset>
							<legend class="screen-out">요청 검색</legend>
							<input type="text" class="search-field__input" autocomplete="off" autocapitalize="off" name="q" title="검색어 입력" placeholder="요청 검색" value="">
							
							<button class="search-field__search-button" type="submit">
								<i class="ico ico-search" aria-hidden="true">
									<svg width="16px" height="16px" viewBox="0 0 15 14" version="1.1">
										<g id="search" stroke="none" fill="#565A5F" fill-rule="evenodd">
											<path d="M9.9603736,10.3329493 C8.91643607,11.0870077 7.60676898,11.5357143 6.18487913,11.5357143 C2.77379116,11.5357143 0.00855799453,8.95335668 0.00855799453,5.76785714 C0.00855799453,2.5823576 2.77379116,0 6.18487913,0 C9.5959671,0 12.3612003,2.5823576 12.3612003,5.76785714 C12.3612003,7.09571193 11.8807175,8.31876567 11.0732587,9.29366358 L15,12.9607143 L13.8871149,14 L9.9603736,10.3329493 Z M6.18487913,10.3214286 C8.87784331,10.3214286 11.0609221,8.2827252 11.0609221,5.76785714 C11.0609221,3.25298909 8.87784331,1.21428571 6.18487913,1.21428571 C3.49191494,1.21428571 1.30883613,3.25298909 1.30883613,5.76785714 C1.30883613,8.2827252 3.49191494,10.3214286 6.18487913,10.3214286 Z"></path>
										</g>
									</svg>
								</i>
	<!-- 						<span class="ir-pm">검색</span> -->
							</button>
							
							
						</fieldset>
					</form>
					
				</div>
			</header>
			
			
			<div class="scroll-container scroll-container--window undefined" tabindex="-1" id="diva">
				<div class="bookmarks-page__list-wrap">
					<div class="sdf active">
					<c:forEach var="b" items="${statuslist}">
							
						<c:if test="${b.reqstatus==1}">
						<div id="board">
							<div id="a">
								<a href="/assemble.io/${mi_assemblename}/g/${b.groupno }/wall"><h4>${b.groupname }</h4></a>
							</div>
			
							<div id="b">
								<%-- <h3>${tl.mi_assemblename }</h3> --%>
								<h4>${b.mi_memname }(${b.mi_memid } )</h4>
								<h5 id="boarddate">${b.boarddate }</h5>
							</div>
							<div id="c">
									<h4><b>담당자 : ${b.responseid }</b></h4>
								<h4>${b.boardcontents }</h4>
									<c:if test="${b.reqstatus ==1 }">
											<div class="btn-group" style="float: right;" id="${b.bno }a">
								 				<input type="hidden" name="req_bno" value="${b.bno}"/> 
										 		<input type="hidden" name="req_groupno" value="${b.groupno}"/> 
										 		<input type="hidden" name="req_reqstatus" value="${b.reqstatus}"/>  
							
												<input type="button" value="요청" id="btnrb" class="req"/>
												<input type="button" value="진행" id="btnib" class="ing"/>
												<input type="button" value="완료" id="btneb" class="end"/>
												
											</div>
										</c:if>
											
											<%-- <h5>요청진행상태 : ${b.reqstatus }</h5> --%>	
	
										
										<c:if test="${b.filename != null }">
											<h4>파일명 : ${b.filename }</h4>
										</c:if>
							</div>
			
							<div id="d">
				
								<div id="d1">
									<input type="hidden" name="bno" value="${b.bno}"/>
									<input type="hidden" name="groupno" value="${b.groupno}"/>
									<%-- <input type="hidden" name="memberno" value=${b.memberno }/>  --%>
									<input type="button" value="댓글" class="re" />
									
									<img src="/resources/assets/img/like.png" class="lh">
									<img src="/resources/assets/img/hate.png" class="lh">
									<img src="/resources/assets/img/bookmark_before.png" id="bk" class="lh" onclick="imgchange()"/>
								</div>
								
							</div>
			
									<!-- 공지글 일시는 공지취소 -->
							
							<div class="e" id="${b.bno }">
								<!-- 댓글 div -->
							</div>
			
							<div id="f">
								<input type="hidden" name="bno" value="${b.bno }" /> 
								<input type="hidden" name="groupno" value="${b.groupno }" /> 
								<%-- <input type="hidden" name="memberno" value=${b.memberno }/>  --%>
								<input type="text" name="" id="retext" placeholder=" 댓글을 입력하세요" /> 
								<input type="button" value="등록" class="submit" />
							</div>
						</div>
					</c:if>
									
			</c:forEach>								
					</div>
					
				</div>
			</div>
			
			<div class="paginated-list-footer">
			
				<div class="no-content-placeholder no-content-placeholder--visible" id="contents">
					<i class="ico ico-blank" aria-hidden="true">
						<svg width="120px" height="120px" viewBox="0 0 120 120" version="1.1">
							<g id="blank" stroke="none" stroke-width="1" fill="#F5F5F5" fill-rule="evenodd">
								<!-- 이미지 경로~  -->
								<path d="M60,120 L60,120 C26.862915,120 0,93.137085 0,60 C0,26.862915 26.862915,0 60,0 C93.137085,0 120,26.862915 120,60 C120,93.137085 93.137085,120 60,120 L60,120 L60,120 Z M60,111 L60,111 C88.1665222,111 111,88.1665222 111,60 C111,31.8334778 88.1665222,9 60,9 C31.8334778,9 9,31.8334778 9,60 C9,88.1665222 31.8334778,111 60,111 L60,111 L60,111 Z M43.5,54 C47.6421356,54 51,50.6421356 51,46.5 C51,42.3578644 47.6421356,39 43.5,39 C39.3578644,39 36,42.3578644 36,46.5 C36,50.6421356 39.3578644,54 43.5,54 L43.5,54 Z M76.5,54 C80.6421356,54 84,50.6421356 84,46.5 C84,42.3578644 80.6421356,39 76.5,39 C72.3578644,39 69,42.3578644 69,46.5 C69,50.6421356 72.3578644,54 76.5,54 L76.5,54 Z M31.5,74 C31.5,71.790861 33.3000391,70 35.5081293,70 L84.4918707,70 C86.7054994,70 88.5,71.7953562 88.5,74 C88.5,76.209139 86.6999609,78 84.4918707,78 L35.5081293,78 C33.2945006,78 31.5,76.2046438 31.5,74 L31.5,74 Z"></path>
							</g>
						</svg>
					</i>
					<p class="no-content-placeholder__message">요청 받은 게시물이 없습니다.</p>
				</div>
				
				<!-- 게시물이 생기면 이걸로 바꾸기~~ css 바꾸기~~ --> 
				<div class="paginated-list-footer__no-more-label" id="nocontents">
					<span>더 이상 없음</span>
				</div>
				
			</div>
			
		</section>
	</div>

	
<!-- js -->
<script type="text/javascript">
	
	$(document).ready(function () {

		// 게시물이 생기면 footer의 div가 바뀌어야 함.
		//$(this).attr('no-content-placeholder no-content-placeholder--visible','paginated-list-footer__no-more-label');			
		
		if($(".sdf").hasClass("active")) {
			$("#contents").hide();						/* div 숨기기~  */
			$("#nocontents").show();
		} else {
			$("#contents").show();						/* div 보이기~  */
			$("#nocontents").hide();
		}
		
	});
	
</script> 
<script src="/resources/assets/js/jquery.js"></script>
<script src="/resources/assets/js/jquery-1.8.3.min.js"></script>
<script src="/resources/assets/js/bootstrap.min.js"></script>
<script class="include" type="text/javascript"
	src="/resources/assets/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="/resources/assets/js/jquery.scrollTo.min.js"></script>

<!--     common script for all pages -->
<script src="/resources/assets/js/common-scripts.js"></script>	
	
</body>
</html>