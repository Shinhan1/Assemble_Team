<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>categoryForm.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		
		$(".btn").click(function(){
			var categoryno = this.parentNode.childNodes[3].value;
			console.log(this.parentNode.childNodes[3].value);
			 document.location.href = "categoryGroupList?categoryno="+categoryno; 
			
		});
	
	});
</script>
</head>
<body>
	<c:forEach var="i" items="${categoryList }">
		<table>
			<tr>
				<th class="a">
					<input type="button" class="btn" value="${i.categoryname }" />
					<input type="hidden" name="categoryno" value="${i.categoryno }" />
				</th>	
			</tr>
		</table>
	</c:forEach>
	
	<div id="bbb">
		
	</div>

</body>
</html>