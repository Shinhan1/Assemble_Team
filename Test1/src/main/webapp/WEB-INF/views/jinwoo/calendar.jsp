<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

 <script src="/resources/assets2/js/jquery.js"></script>
<script src="/resources/assets2/js/bootstrap-datepicker.js"></script>
<script src="/resources/assets2/js/bootstrap-datepicker.kr.min.js"></script>

<link href="/resources/assets2/css/bootstrap-datepicker3.css" rel="stylesheet" />

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker3.min.css">
</head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker3.standalone.min.css">
<body>
	<div>
		<label>날짜</label> <input type="text" id="datePicker">
	</div>
	<!-- <button type="button" id="click-btn">날짜 값 확인용</button> -->

	 <script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js">
		
	</script> 
	 <script type="text/javascript">
		 $('#datePicker').datepicker({
			format : "yyyy/mm/dd", // 달력에서 클릭시 표시할 값 형식
			language : "kr" // 언어 (js 추가가 필요하다)
			
		});

		$('#click-btn').on('click', function() {
			var date = $('#dateRangePicker').val();
			alert(date);
		}); 
	</script> 
</body>
</html>