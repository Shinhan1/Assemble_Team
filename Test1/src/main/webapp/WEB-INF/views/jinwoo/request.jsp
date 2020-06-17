<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/assets/css/chat_css.css">     <!-- css 파일 경로  -->
<script type="text/javascript">
$(function() {
	$('#rebtn1').click(function(){
		$("#rebtn1").css('background-color','#3DB7CC');
		$("#rebtn2").css('background-color','#D4F4FA');
		$("#rebtn3").css('background-color','#D4F4FA');
		$("#rebtn4").css('background-color','#D4F4FA');
		
	});
	
	$('#rebtn2').click(function(){
		$("#rebtn1").css('background-color','#D4F4FA');
		$("#rebtn2").css('background-color','#3DB7CC');
		$("#rebtn3").css('background-color','#D4F4FA');
		$("#rebtn4").css('background-color','#D4F4FA');
		
	});
	
	$('#rebtn3').click(function(){
		$("#rebtn1").css('background-color','#D4F4FA');
		$("#rebtn2").css('background-color','#D4F4FA');
		$("#rebtn3").css('background-color','#3DB7CC');
		$("#rebtn4").css('background-color','#D4F4FA');
		
	});
	
	$('#rebtn4').click(function(){
		$("#rebtn1").css('background-color','#D4F4FA');
		$("#rebtn2").css('background-color','#D4F4FA');
		$("#rebtn3").css('background-color','#D4F4FA');
		$("#rebtn4").css('background-color','#3DB7CC');
		
	});

});

	$(function(){
		
		$("#statusAll").click(function(){
			var groupno = $("#groupno").val();
			document.location.href = "groupReqList?groupno="+groupno;
		});

		$("#status0").click(function(){
			var groupno = $("#groupno").val();
			var status = 0;
			document.location.href = "groupReqStatus?groupno="+groupno+"&status="+status;
		});
		
		$("#status1").click(function(){
			var groupno = $("#groupno").val();
			var status = 1;
			document.location.href = "groupReqStatus?groupno="+groupno+"&status="+status;
		});
		
		$("#status2").click(function(){
			var groupno = $("#groupno").val();
			var status = 2;
			document.location.href = "groupReqStatus?groupno="+groupno+"&status="+status;
		});
		
		
	});

</script> 

<style type="text/css">
 .rebtn-group .rebutton {
  background-color: #D4F4FA; /* Green */
  border: 1px solid #B2EBF4;
  color: white;
  text-align: center;
  text-decoration: none;
  font-size: 16px;
  cursor: pointer;
  
}

.rebtn-group .rebutton:not(:last-child) {
  border-right: none; /* Prevent double borders */
}

.rebtn-group .rebutton:hover {
  background-color: #3DB7CC;
  border: 1px solid #3DB7CC;
}

.rebtn-group {
	 text-align: center;
	 width: 100%; height: 40px;
}	

.rebutton {
	width: 70px;
	height: 100%;
} 
</style>
</head>
<body>
	<div style="width: 100%; height: 100%; display: none;" id="tab6" >
		<div class="rebtn-group">
			<input type="button" class="rebutton" id="statusAll" value="전체" />
			<input type="button" class="rebutton" id="status0" value="요청" />
			<input type="button" class="rebutton" id="status1" value="진행" />
			<input type="button" class="rebutton" id="status2" value="완료" />
		</div>
		
		
		
	
	
	</div>

</body>
</html>