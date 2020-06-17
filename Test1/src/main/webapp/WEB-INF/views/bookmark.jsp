<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/assemble.io/${mi_assemblename}/header"></c:import>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
<script type="text/javascript">
//bookmark click 시 변경
var cnt = 1;
    
    $(function(){
	     $(".lh").click(function(){
	    	console.log(this.src.split("/")[6]);
	  /*   	 img1.src = "/resources/assets/img/bookmark_before.png";
	    	 img1.src = "/resources/assets/img/bookmark_after.png"; */
	    	 var bno = this.parentNode.childNodes[1].value;
	    	 var groupno = this.parentNode.childNodes[3].value;
	    	 var writerid = this.parentNode.childNodes[5].value;
	     if(this.src.split("/")[6].split(".")[0].split(".")[0] == "bookmark_before"){
			  this.src = "/resources/assets/img/bookmark_before.png";
	  		 $.ajax({
		    	url: "/bookmarkinsert",
		    	type: 'POST',
		    	data: {"bno": bno, "groupno" : groupno ,"memberno" : ${memberno},"mark_memno" : writerid },
		    	dataType: "json",
		    	
		    	success: function(){
		    		console.log("성공");	
		    	}		
		 					    	
			}); 	 
	    	 
	    	 
	     }else{
	    	 this.src = "/resources/assets/img/bookmark_after.png";
	    	 
	    	 $.ajax({
			    	url: "/bookmarkdelete",
			    	type: 'POST',
			    	data: {"bno": bno,"memberno" : ${memberno}},
			    	dataType: "json",
			    	
			    	success: function(){
			    		console.log("성공");			
			    	}		
			 
			}); 	 
	     }
	 });
	});
//댓글달기
$(function() {
     $(".submit").click(function(){
	        	
	        console.log(this.parentNode.childNodes);
	        
	         var bno = this.parentNode.childNodes[1].value;
	        var groupno = this.parentNode.childNodes[3].value;
	        var recontents = this.parentNode.childNodes[5].value;
	        /* var categoryno = this.parentNode.childNodes[5].value; */
	        document.location.href = "insertCommentatHome?bno="+bno+"&groupno="+groupno+"&contents="+recontents; 
	     });
	
});
//댓글 보이기	
/* $(document).ready(function(){ */
$(function(){
	$(".re").click(function(){
		
		
		var bno = this.parentNode.childNodes[1].value;
	    var groupno = this.parentNode.childNodes[3].value;
	    $.ajax({
			    	url: "/assemble.io/{mi_assemblename}/selectRecomment1",
			    	type: 'POST',
			    	data: {"bno": bno, "groupno" : groupno},
			    	dataType: "json",
			    	
			    	success: function(recomment1){
			    		console.log("success view");
			    		console.log(recomment1);
			    			//document.getElementById("#"+bno).childNodes.length;
			    			
			    		 if(document.getElementById(bno).childElementCount==0){ 
				    		for(var i=0; i<recomment1.length; i++){
								var retext = 
									'<div id="s0">'
										+'<div id="s1">'
											+'<div id="s1a">'+recomment1[i].reid+"님이 쓴 댓글"+'</div>'
											+'<div id="s1b">'+recomment1[i].redate+'</div>'+
										'</div>' //s1 end
										+'<div id="s2">'+recomment1[i].recontents+'</div>'+ //s2 end
									'<div>';									
						    	$(retext).appendTo("#"+bno);			
						    		
				    		}//for end
						    		 //댓글0개일때
							    	if(recomment1.length==0){
							    		var retext = 
											'<div id="s0">'
												+'<div id="s1">' + "현재 댓글이 없습니다." +'</div>' //s1 end
											'<div>';
						    				 $(retext).appendTo("#"+bno);		
							    	}//if end 
			    		 }else{
			    		 $("#" +bno).empty();
			    		
			    		} 	
			    	}		
		 	}); //ajax end
		});  	
}); //function end
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

<style type="text/css">
input:focus {
  outline: none;
}
#main {
	width: 50%;
	height: 100%;
	position: absolute;
	/*     background: white; */
	margin-top: 5%;
	margin-bottom: 5%;
	margin-left: 25%;
}
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
</head>
<body>
<div id="main" style="z-index: -2">
		<br />
		<h3>북마크</h3>

		<c:forEach var="b" items="${selectBookmark }">
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
					<c:if test="${b.requestboolean==1 }">
						<h4><b>담당자 : ${b.responseid }</b></h4>
					</c:if>
					<h4>${b.boardcontents }</h4>
							
							<c:if test="${b.requestboolean == 1 }">
								<c:if test="${b.reqstatus == 0}">
								 	<div class="btn-group" style="float: right;" id="${b.bno }a">
								 		<input type="hidden" name="req_bno" value="${b.bno}"/> 
								 		<input type="hidden" name="req_groupno" value="${b.groupno}"/> 
								 		<input type="hidden" name="req_reqstatus" value="${b.reqstatus}"/> 
								
										<input type="button" value="요청" id="btnra" class="req"/>
										<input type="button" value="진행" id="btnia" class="ing"/>
										<input type="button" value="완료" id="btnea" class="end"/>
									</div> 
								</c:if>
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
								<c:if test="${b.reqstatus ==2 }">
									<div class="btn-group" style="float: right;" id="${b.bno }a">
										<input type="hidden" name="req_bno" value="${b.bno}"/> 
								 		<input type="hidden" name="req_groupno" value="${b.groupno}"/> 
								 		<input type="hidden" name="req_reqstatus" value="${b.reqstatus}"/> 
					
										<input type="button" value="요청" id="btnrc" class="req"/>
										<input type="button" value="진행" id="btnic" class="ing"/>
										<input type="button" value="완료" id="btnec" class="end"/>
									</div>
								</c:if>
								<%-- <h5>요청진행상태 : ${b.reqstatus }</h5> --%>	
							</c:if>
							
							<c:if test="${b.filename != null }">
								<h4>파일명 : ${b.filename }</h4>
							</c:if>
				</div>

				<div id="d">
	
					<div id="d1">
						<input type="hidden" name="bno" value="${b.bno}"/>
						<input type="hidden" name="groupno" value="${b.groupno}"/>
						<input type="hidden" name="memberid" value="${b.mi_memid}"/>
						<input type="button" value="댓글" class="re" />

						<img src="/resources/assets/img/bookmark_after.png" id="bk" class="lh" onclick="imgchange()"/>
					</div>
					
				</div>
					<%-- <div class="d2" >
						<input type="hidden" name="bno" value="${b.bno }"/>
						<input type="hidden" name="groupno" value="${b.groupno}"/>
						<input type="button" class="option2"/>
						<!-- <input type="button" value="more" class="option" onclick="optiontest()"/> -->
						<!-- <button class="option">
							<img src="/resources/assets/img/more.png" id="more" />
						</button> -->
						<div id="${b.bno }d" class="sub2">
							<ul>
								<li>
									<input type="hidden" name="bno" value="${b.bno }"/>
									<input type="hidden" name="groupno" value="${b.groupno}"/>
									<input type="button" value="이 글 숨기기" class="hide"/>
								</li>
							</ul>
						</div>
					</div> --%>



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