<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/assemble.io/${mi_assemblename}/header"></c:import>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>wall.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
     //bookmark click 시 변경
     function imgchange(){
    	 var img = document.getElementById('bk');
    	 if(img.src.match("before")){
    		 img.src = "/resources/assets/img/bookmark_after.png";
    		 
    		 /* location.href="/addBookmark"; */
    	 }
    	 
     }    
     
     //댓글달기
     $(function(){
	     $(".submit").click(function(){
	        
	       // console.log(this.parentNode.childNodes);
	        
	        var bno = this.parentNode.childNodes[1].value;
	        var groupno = this.parentNode.childNodes[3].value;
	        var categoryno = this.parentNode.childNodes[5].value;
	        var recontents = this.parentNode.childNodes[7].value;

	        document.location.href = "insertComment?bno="+bno+"&groupno="+groupno+"&categoryno="+categoryno+"&contents="+recontents;
	     });

		//option 펼치기
		//option 클래스 밑 a태그 클릭시
/* 		$(".option>a").click(function() {
			console.log(this.parentNode.childNodes);

			$(this).next("ul").toggleClass("hide");

		}); */
		$('.option .sub').hide(); //처음에는 안보이게
		$('.option').click(function(){
			$('.option .sub').toggle();
		});
		
		

	});

	/* $(function(){        
	  $(".btn").click(function(){
	     
	     
	      $(".bno").each(function(index){         
	        var bno = $(this).val();
	        console.log(bno);         
	     });
	     
	      document.frm.action = "selectBoard";
	     document.frm.submit();
	  }); 
	   

	  
	  
	  //좋아요
	/*       $("#likeb").click(function(){
		  document.frm.action = "/like.do";
		  document.frm.submit();
	  }); */
</script>
<style type="text/css">
#main{
	width: 50%;
    height: 100%;
    position: absolute;
/*     background: white; */
    margin-top: 7%;
    margin-bottom: 5%;
    margin-left: 25%;
    marg
	}
	
#info{
	border: 2px solid #F2F2F2; 
	background-color: pink;
	margin-bottom : 15px;	
	padding-bottom : 0px;
}
#select{
	background-color: white;
}

#insert{
	height: 100%;
	border: 1px solid #CCCCCC;
	margin-bottom: 30px;
}

#board{
	padding: 20px;
	border: 2px solid #F2F2F2; 
	background-color: white;
	margin-bottom : 30px;
	border: 1px solid #CCCCCC;
/* #F2F2F2; */
}
#a{
	border-bottom : 1px solid #CCCCCC;
}
#d{
margin-top : 10px;
}


#retext{
	width: 91%;
	border : 1px solid #CCCCCC;
}
#re{
	background-color: white;
	border: none;
	border: 1px solid #CCCCCC;
	margin-right: 1%;
}
#notice{
	width: 22px;
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

#boarddate{
	margin-left: 80%;
}
#c1{
	width: 70%;
	display: inline;
	float: left; 
}
#c2{
	margin-left: 82%;
}

.menubtn{
	border: none;
	background-color: white;
	border: 1px solid #CCCCCC;
}


/* .option a{cusor:pointer;}
.option .hide{display:none;} */

</style>
</head>
<body>
	<form name="frm" method="get">
		<div id="main">
			<div id="info">	
					<h2>${groupname }</h2>
					<h5>${mastername }( ${masterid} ) 외 몇명</h5> 
			<div id="select">
				<h3>전체 멤버 사진 파일 일정 노트 요청</h3>
				<h5>애는 각각 누르면 div id=section에 가져오기!</h5>
			</div>
		</div>


			<div id="section">	

				<div id="insert">
					<h3>글쓰기 일정 요청 투표</h3>
					<h3>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Placeat est quia molestiae ullam quibusdam omnis quasi harum beatae voluptas magnam sed eligendi rerum error asperiores tenetur ab officiis exercitationem aliquam.</h3>
				</div>

				<c:forEach var="b" items="${thirdlist }">
					<div id="board">
						<div id="z">
							<c:if test="${b.boardnotice == 1}">
								<img src="/resources/assets/img/star.png" alt="공지글"  id="notice"/>
								 <b> 공지글</b>
							</c:if>
					</div>
						<div id="a">
							<!-- 프사 추가 하려면 Groupboard_MemberinfoDTO에 프사 추가, MAPPER에 추가하기 -->
							<h4>${b.mi_memname } ( ${b.mi_memid } )</h4>
							<h5 id="boarddate">${b.boarddate }</h5>
						</div>

						<div id="b">
							<h4>${b.boardcontents }</h4>
							
							<c:if test="${b.filename != null }">
								<h5>파일명 : ${b.filename }</h5>
							</c:if>
							
							<c:if test="${b.requestboolean == 1 }">
								<c:if test="${b.reqstatus == 0}">
								 	<h5>요청</h5>
								</c:if>
								<c:if test="${b.reqstatus ==1 }">
									<h5>진행</h5>
								</c:if>
								<c:if test="${b.reqstatus ==2 }">
									<h5>완료</h5>
								</c:if>
								<%-- <h5>요청진행상태 : ${b.reqstatus }</h5> --%>	
							</c:if>
							
							<h5>좋아요 : ${b.boardlike }</h5>
							<h5>싫어요 : ${b.boardhate }</h5>
							
						</div>	
						<div id="c">
							<div id="c1">
								<input type="button" value="댓글" id="re" />
							
								<img src="/resources/assets/img/like.png" class="lh">
								
								<img src="/resources/assets/img/hate.png" class="lh">
					
								<img src="/resources/assets/img/bookmark_before.png" id="bk" class="lh" onclick="imgchange()"/>																			
							</div>
							<div id="c2">
								<ul class="option">
									<li><img src="/resources/assets/img/more.png" id="more" />
										<ul class="sub">
											<!-- 공지글 일시는 공지취소 -->
											<button class="menubtn"><li>공지등록</li></button>
											<!-- 세션과 작성자 일치시 -->
											<button class="menubtn"><li>수정하기</li></button>
											<button class="menubtn"><li>삭제하기</li></button>
										</ul>
									</li>
								</ul>
							</div>
						</div>

						<div id="d">
							<input type="hidden" name="bno" value="${b.bno }"/>
							<input type="hidden" name="groupno" value="${b.groupno }"/>
							<input type="hidden" name="categoryno" value="${b.categoryno }"/>
							<input type="text" name="" id="retext" placeholder=" 댓글을 입력하세요" />
							<input type="button" value="등록" class="submit"/>
						</div>
					</div>
				</c:forEach>
			</div> <!-- section end -->
		</div>
	</form>
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