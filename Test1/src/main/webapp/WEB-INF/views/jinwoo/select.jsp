<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {

	
	$('#selbtn1').click(function(){
		$("#tab1").css('display','block');
		$("#tab2").css('display','none');
		$("#tab3").css('display','none');
		$("#tab4").css('display','none');
		$("#tab5").css('display','none');
		$("#tab6").css('display','none');
		
	 	$("#boarddis").css('display','block'); 
		
		$("#selbtn1").css('border-bottom','3px solid #B2EBF4');
		$("#selbtn2").css('border-bottom','none');
		$("#selbtn3").css('border-bottom','none');
		$("#selbtn4").css('border-bottom','none');
		$("#selbtn5").css('border-bottom','none');
		$("#selbtn6").css('border-bottom','none');
		
		
		});
	
	$('#selbtn2').click(function(){
		$("#tab1").css('display','none');
		$("#tab2").css('display','block');
		$("#tab3").css('display','none');
		$("#tab4").css('display','none');
		$("#tab5").css('display','none');
		$("#tab6").css('display','none');
		
		 $("#boarddis").css('display','none'); 

		$("#selbtn1").css('border-bottom','none');
		$("#selbtn2").css('border-bottom','3px solid #B2EBF4');
		$("#selbtn3").css('border-bottom','none');
		$("#selbtn4").css('border-bottom','none');
		$("#selbtn5").css('border-bottom','none');
		$("#selbtn6").css('border-bottom','none');
		
		var groupno = this.parentNode.childNodes.value[1];
		
		document.location.href = "wall?groupno="+groupno;
		
		});
	
	$('#selbtn3').click(function(){
		$("#tab1").css('display','none');
		$("#tab2").css('display','none');
		$("#tab3").css('display','block');
		$("#tab4").css('display','none');
		$("#tab5").css('display','none');
		$("#tab6").css('display','none');
		
		$("#boarddis").css('display','none'); 
	
		
		$("#selbtn1").css('border-bottom','none');
		$("#selbtn2").css('border-bottom','none');
		$("#selbtn3").css('border-bottom','3px solid #B2EBF4');
		$("#selbtn4").css('border-bottom','none');
		$("#selbtn5").css('border-bottom','none');
		$("#selbtn6").css('border-bottom','none');
		
		});
	
	$('#selbtn4').click(function(){
		$("#tab1").css('display','none');
		$("#tab2").css('display','none');
		$("#tab3").css('display','none');
		$("#tab4").css('display','block');
		$("#tab5").css('display','none');
		$("#tab6").css('display','none');
		
	 	$("#boarddis").css('display','none'); 
		
		$("#selbtn1").css('border-bottom','none');
		$("#selbtn2").css('border-bottom','none');
		$("#selbtn3").css('border-bottom','none');
		$("#selbtn4").css('border-bottom','3px solid #B2EBF4');
		$("#selbtn5").css('border-bottom','none');
		$("#selbtn6").css('border-bottom','none');
	
		
		}); 

});

</script>

<style type="text/css">

.selectbtn {
	width: 16.6%;
	height: 100%;
    text-align: center;
	float: left;
	font-size: 21px;
	padding-top: 10px;
	
}

#selbtn1 {
	border-bottom: 3px solid #B2EBF4;
	cursor: pointer;
	/* margin-top: 10px; */
}

#selbtn2 {
	border-bottom: none;
	cursor: pointer;
	/* margin-top: 10px; */
}

#selbtn3 {
	border-bottom: none;
	cursor: pointer;
	/* margin-top: 10px; */
}

#selbtn4 {
	border-bottom: none;
	cursor: pointer;
	/* margin-top: 10px; */
}

#selbtn5 {
	border-bottom: none;
	cursor: pointer;
	/* margin-top: 10px; */
}

#selbtn6 {
	border-bottom: none;
	cursor: pointer;
	/* margin-top: 10px; */
}

/* #p1{
	width: 50%;
	heigth: 100%;
}

#p2{
	width: 100%;
} */

#p3{
	width: 100%;
	height: 45px;
	background-color: white; 
}
</style>
</head>
<body>
<!-- <div id="p1">
	<div id="p2">-->
			<div id="p3">
			
				<div style="width: 60%; height: 100%; ">
					<input type="hidden" name="groupno" id="groupno" value="<c:out value='${groupno }'/>" />
					<div class="selectbtn" id="selbtn1" ><div><span>전체</span></div></div>
					<div class="selectbtn" id="selbtn2"><div><span>멤버</span></div></div>
					<div class="selectbtn" id="selbtn3"><div><span>사진</span></div></div>
					<div class="selectbtn" id="selbtn4"><div><span>파일</span></div></div>
				
				</div>
			</div>
	<!--  </div>
</div> -->
</body>
</html>