<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
   $(function(){
      $("#passwordclickbtn").click(function(){
    	  document.frm.action = "/changepassword";
          document.frm.method = "post";
          document.frm.submit();
       });
      
   });
</script>

<style type="text/css">

.passwordmain {
	width: 650px;
	height: 660px;
	padding: 25px;
	border: 1px solid black;

} 

</style>
</head>
<body>	
<div style="width: 100%; text-align: center;">
<div class="passwordmain">
  <form name="frm">
	<div>
		<div style="width: 100%; height: 30px;"></div>
		
		<div style="width: 100%; height: 80px; ">
			<div><span style="font-size: 35px;">비밀번호 재설정</span></div>
		</div>
		
		<div style="width: 100%; height: 110px; ">
			<div>
				<span style="font-size: 13px;">	
					<%-- ${아지트주소 } --%> 어셈블에 참여 중인 회원님의 계정 비밀번호를 재설정하실 수 있습니다. <br />
					아래의 버튼을 클릭하여 새로운 비밀번호를 설정해주세요. <br />
					만약 새로운 비밀번호 설정을 요청하신 적이 없다면 이 메일을 무시해주세요. <br />
					기존 비밀번호가 유지됩니다.
				</span>
			</div>
		</div>
		
		<div style="width: 100%; height: 38px;  ">
			<div id="passwordclickbtn" style="cursor:pointer; width: 210px; height: 85%; background-color: #3DB7CC; color: white; text-align: center; padding-top: 13px;">
				<span style="font-size: 15px;">새 비밀번호 설정하기</span>
			</div>
		</div>
		
		<div style="width: 100%; height: 30px; "></div>
		
		<div style="width: 100%; height: 170px;  border-top: 1px solid black; border-bottom: 1px solid black; ">
			<%
				String mi_assemblename = request.getParameter("mi_assemblename");
				String mi_mememail = request.getParameter("mi_mememail");
			%>
			<div style="width: 20%; height: 100%; padding-top: 30px; float: left;" >
				<div style="width: 100%; height: 50%; float: left;"><span style="font-size: 16px;">어셈블명</span></div>
				<div style="width: 100%; height: 50%; float: left;"><span style="font-size: 16px;">참여 계정</span></div>	
			</div>
			
			<div style="width: 80%; height: 100%; padding-top: 30px; float: left;">
				
				<div style="width: 100%; height: 50%; float: left;"><span style="font-size: 16px;"><%= mi_assemblename %>(<a href="/changepassword?mi_assemblename=<%= mi_assemblename %>&mi_mememail=<%= mi_mememail %>">http://15.165.95.43:8080/newPassword</a>)</span></div>
				<div style="width: 100%; height: 50%; float: left;"><span style="font-size: 16px;"><%= mi_mememail %></span></div>
				
			</div>
		
		</div>
	
	</div>
 </form>
	
	<div style="width: 100%; height: 80px; padding-top: 30px; border-bottom: 1px solid #D5D5D5;">
		<div><span style="font-size: 13px;">더욱 좋은 서비스를 위해 노력하는 Assemble팀이 되겠습니다. <br />감사합니다.</span></div>
	</div>
	
	<div style="width: 100%; height: 70px; padding-top: 11px;">
		<div>
			<span style="color:#A6A6A6; font-size: 10px; ">
			     	본 메일은 발신전용이며, 문의에 대한 회신은 처리되지 않습니다. <br />
					Assemble 관련하여 궁금하신 점이나 불편한 사항은  도움말을 확인해보세요. <br />
					(주)Assemble | 대표이사 : 백진우 | 주소 : 금천구 가산동 147-44 대명 202호 | 문의 tlsgks8848@naver.com <br />
					Copyright © Assemble Enterprise All rights reserved.
			</span>
		
		</div>
	
   </div>
		


</div>
</div>

</body>
</html>