<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <script type="text/javascript">
      alert("존재하지 않는 어셈블입니다.");
      location.href="<c:out value="/assembleLogin" />";
            
   </script>

</body>
</html>