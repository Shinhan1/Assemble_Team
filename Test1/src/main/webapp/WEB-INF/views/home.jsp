<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%-- <%@include file="include/header.jsp" %>  --%>
<c:import url="/assemble.io/avengers/header"></c:import>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home.jsp</title>
<style type="text/css">
#main{
	width: 50%;
    height: 100%;
    position: absolute;
/*     background: white; */
    margin-top: 70px;
    margin-left: 25%;
	}
	
#board{
	padding: 20px;
	border: 2px solid #F2F2F2; 
	background-color: white;
	margin-bottom : 30px;
	border: 1px solid #CCCCCC;
/* #F2F2F2; */
}

#a, #b{
border-bottom : 1px solid #CCCCCC;
}

#e{
margin-top : 10px;
}

#retext{
	width: 100%;
	border : 1px solid #CCCCCC;
}
#re{
	background-color: white;
	border: none;
	border: 1px solid #CCCCCC;
	margin-right: 1%;
}

.lh{
	width: 22px;
}
#hate{
	margin-left: 1.5%;
}
 #bk{
	margin-left: 77%;	
}
#more{
	margin-left: 1.5%;
}

</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
//bookmark click 시 변경
function imgchange(){
	 var img = document.getElementById('bk');
	 if(img.src.match("before")){
		 img.src = "/resources/assets/img/bookmark_after.png";
	 }
	 
}
</script>
</head>
<body>
 	<div id="main">
 	<br />
      	<h3>나의 소식 피드</h3>
		
		<c:forEach var="tl" items="${mainlist }">
		 <div id="board">
			<div id="a"><h4>${tl.groupno }(그룹명)</h4></div>
						 	
		 	<div id="b">
		 		<h4>${tl.memberno }아이디(이름)</h4>
		 		<h5>${tl.boarddate }게시일</h5>
		 	</div>
		 	<div id="c">
		 		<h4>${tl.boardcontents } </h4>

				<h5>좋아요 : ${tl.boardlike }</h5>
				<h5>싫어요 : ${tl.boardhate }</h5>
				<h5>요청인지 : ${tl.requestboolean }</h5>
			</div>
				
			<div id="d">
				<input type="button" value="댓글" id="re" />
				
				<img src="/resources/assets/img/like.png" id="like" class="lh">
							<!-- <h5 id="count"></h5> -->							
				<img src="/resources/assets/img/hate.png" id="hate" class="lh">
				
				<img src="/resources/assets/img/bookmark_before.png" id="bk" class="lh" onclick="imgchange()"/>

				<img src="/resources/assets/img/more.png" id="more" class="lh" />
			</div>
				
			<div id="e">
				<input type="text" name="" id="retext" placeholder=" 댓글을 입력하세요" />
			</div>
		</div>
		</c:forEach>
	</div>
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