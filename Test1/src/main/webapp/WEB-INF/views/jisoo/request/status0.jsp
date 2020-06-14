<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<!------ Include the above in your HEAD tag ---------->
<link rel="stylesheet" type="text/css" href="resources/assets/css/hancss/clicklist.css">  	<!-- css 파일 경로  -->

<meta charset="UTF-8">

<title>status0.div</title>

</head>
<body>
	
			<div class="scroll-container scroll-container--window undefined" tabindex="-1" id="div1">
				<div class="bookmarks-page__list-wrap">
				
					<div class="sdf active">
						<h2>요청된 게시물만~~</h2>							
					</div>
					
				</div>
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

	
</body>
</html>