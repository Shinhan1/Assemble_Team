<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
   $(function(){
      $(".filename").click(function(){
          var filename = this.parentNode.childNodes[1].value;
          console.log(this.parentNode.childNodes[1].value);
          var url = "/download?filename=" + encodeURIComponent(filename); 
          
          
          document.location.href = url;
          
       });
      
   });
</script>
</head>
<body>

<div id="tab4" style="width: 100%; height:1000px; display: none; background-color: white; padding-top: 15px; padding-left: 4%;">
		 <c:forEach items="${filelist }" var="i"> 
			
			<div style="width: 48%; height: 90px; float: left; background-color:white; padding: 1%; border: 1px solid #EAEAEA;">
				<div style="width: 100%; height: 100%;">
					
					<div style="width: 83%; height: 100%; float: left;">
					
						<div style="width: 70%; height: 100%; float: left; padding-top: 15px; padding-left:15px; word-break:break-all;">
							<span style="font-size: 15px;"> ${i.filename }</span>					
						</div>
						
						
						<div style="width: 30%; height: 100%; float: left; text-align: center; padding-top: 25px;">
							<span style="font-size: 18px;">기타</span>
						</div>
					</div>
					
					<div style="float:left; width: 17%; height: 100%;">
						<input type="hidden" value="${i.filename }" />
						<div class="filename" style="cursor: pointer; width: 100%; height: 100%; float: left;">
							<img src="/resources/assets/img/downbtn.png" style="width: 100%; height: 100%; float: left;">	
						</div>
					</div>
				
				</div>
			
			</div>
			
			

		 </c:forEach> 
		
	
		
		



</div>

</body>
</html>