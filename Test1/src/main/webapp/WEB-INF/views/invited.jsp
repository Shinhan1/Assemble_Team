<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/assemble.io/${mi_assemblename}/header"></c:import>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>invited</title>
<script type="text/javascript" src="/resources/info/js/jquery.slim.min.js"></script>
<!-- <link type="text/css" rel="stylesheet" href="/resources/info/css/bootstrap.min.css" /> -->
<script type="text/javascript" src="/resources/info/js/bootstrap.bundle.min.js"></script>

<style type="text/css">
body  {
	background: #F2F2F2;
}
.main {
   width: 50%;
   height: 100%;
   position: absolute;
   margin-top: 5%;
   margin-bottom: 5%;
   margin-left: 25%;
   clear: none;
   background-color: none;
}
.contents{
    border: 1px solid #CCCCCC;
   padding: 0;
   margin: 0;
   background-color: none;
}
.form-invitation{
   width: 100%;
   padding: 10px;
   background-color: white;
}
.invitation{
   min-height: calc(50vh);
   margin: 0 auto;
   padding: 0;
   clear: none;
}
.title {
   margin: 10px 0 20px;
    padding-bottom: 10px;
    border-bottom: 2px solid #7a7a7a;
    color: #383838;
    font-size: 1.5rem;
    line-height: 1.25;
    vertical-align: middle;
    clear: none;
}

.invitation-form {
   width: 100%;
   margin-top: 2rem;
   vertical-align: middle;
   clear: none;
   display: inline-block;

}
.form-group row{display: inline-block;}
#adr, #info {
   width: 100px;
   clear: none;
   margin-left: 200px;
}
.invitation-form input {
   margin-bottom: 1rem;
   width:450px;
   clear: none;
   margin-left: 300px;
}
.invitation-form button {
   border-radius: 2rem;
   margin-top: 3rem;
   margin-bottom: 3rem;
   vertical-align: middle;
   width: 350px;
   margin: 0 auto;
   clear: none;
   background-color: #1596aa;  
   color: white;
}


</style>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		var check = "N";
		$("#memEmail").keyup(function(){
	        $.ajax({
	        	type:"post",
	        	/* url : "assemble.io/<c:out value='${mi_assemblename}' />/login/<c:out value='${ran}' />/a", */
	        	url : "<c:url value='/emailck'/>",
	        	data : "mi_mememail=" + $("#memEmail").val(),
	        	success : function(data) {
	        		if(data == 1) {
	        			$("#duplicate").show();
	        			$("#duplicate").css('color', 'red');
	        			$("#duplicate").text("이미 사용중인 아이디입니다.");
	        			check="N";
	        		}else if(data == 0 && $("#inputId").val() != ""){
	        			$("#duplicate").show();
	        			$("#duplicate").css('color', 'green');
	        			$("#duplicate").text("사용 가능한 아이디입니다.");
	        			check="Y";
	        		}else {
	        			$("#duplicate").hide();
	        			check="N"
	        		}
	        	}
	        	
	        })
			
	    });
		
		$('#invi').click(function(){
			
			/* console.log(email); */
			$.ajax({
				/* beforeSend: function(){
					loadingBarStart();
				}, */
				type:"post",
				url : "<c:url value='/invitedOk'/>",
				data : "invited=" + $("#memEmail").val() + "&ran=" + $("#ran").val(),
				
				success : function(data){
					
					alert("초대 완료!");
					document.frm.action="/assemble.io/<c:out value='${mi_assemblename}' />/home?memberno=<c:out value='${memberno}' />";
					document.frm.submit();
				},
				error: function(data){
					
					alert("에러가 발생했습니다.");
					return false;
				}
			})
			
		});
		
		
	});
</script>
</head>
<body>

<body>
<div class="main" style="z-index: -2">
<div class="contents">
   <div class="form-invitation">
      <div class="title">
         <h2 class="font-weight-bold"><b>초대하기</b></h2>
      </div>
      
      <div class="invitation-form">
         <form action="invitedOk" method="POST" name="frm">
         
              <div class="form-group row">
               
                <label for="colFormLabel" class=" col-form-label" id="adr">이메일 주소 <br>&nbsp;(필수)</label>
                  <input type="email" class="form-control" id="memEmail" name="mi_mememail" placeholder="이메일 주소" required />
                  <span id="duplicate">
			             
			      </span>
             
           <br/>
               <button class="btn btn-lg btn-block" type="button" id="invi">초대하기</button>
        
              </div>

         </form>

      </div>
   </div>
</div>

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
</body>
</html>