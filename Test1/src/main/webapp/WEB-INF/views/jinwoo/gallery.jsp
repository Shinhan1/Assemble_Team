<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="spring" uri="http://www.springframework.org/tags" %> 
<html lang="en">
<title>DASHGUM - Bootstrap Admin Template</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function (e){
		
		$(document).on("click","#galleryimg",function(){
			var path = $(this).attr('src')
			showImage(path);
		});//end click event
		
		function showImage(fileCallPath){
		    
		    $(".bigPictureWrapper").css("display","flex").show();
		    
		    $(".bigPicture")
		    .html("<img src='"+fileCallPath+"' >")
		    .animate({width:'100%', height: '100%'}, 0);
		    
		  }//end fileCallPath
		  
		$(".bigPictureWrapper").on("click", function(e){
		    $(".bigPicture").animate({width:'0%', height: '0%'}, 0);
		    setTimeout(function(){
		      $('.bigPictureWrapper').hide();
		    }, 0);
		  });//end bigWrapperClick event
	});
</script>
<style type="text/css">

.selectimgdiv {
	width: 25%;
	height: 170px;
	float: left;
	border : solid 1px white;
	background-color: white;
	text-align: center;
	padding-top: 20px;
}
	
.imgdiv {
	width : 90%;
	height: 100%;
	display: inline-block;
	border: 1px solid #D5D5D5;
}

.bigPictureWrapper {
			position: absolute;
			display: none;
			justify-content: center;
			align-items: center;
			top:0%;
			width:100%;
			height:100%;
			background-color: gray; 
			z-index: 100;
			background:rgba(255,255,255,0.8);
		}
		.bigPicture {
			position: relative;
			display:flex;
			justify-content: center;
			align-items: center;
		}
		
		.bigPicture img {
			width:800px;
		}
	
</style>

</head>
<body>

<div id="tab3" style="width: 100%; height:800px; background-color: white; display: none; padding-top: 10px;">

<div class='bigPictureWrapper'>
		<div class='bigPicture'>
		</div>
</div>
	
	<div style="width: 100%; height: 55px; text-align: center;"><span style=" font-size: 50px; color:#B2EBF4; font-weight: bold;">Gallery</span></div>
	<div style="width: 100%; height: 15px;  border-bottom: 3px solid #D4F4FA;"></div>

	
	

     <c:forEach var="i" items="${imagelist }">

			<div class="selectimgdiv" >
				<div class="imgdiv">
					<img id="galleryimg" src="<spring:url value='/resources/uploadFiles/${i.filename }'/>" style="width: 100%; height: 100%;"> 
				</div>
			</div>
		
      </c:forEach>  
	
	
						
	
	
	
</div>





					

  </body>
</html>
