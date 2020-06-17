<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="/resources/assets/css/chat_css.css">     <!-- css 파일 경로  -->


<style type="text/css">


#prodiv {
    border-bottom: 1px solid #D5D5D5; 
    float:left; 
    width: 33.3%; 
    height: 65px ;
}

.element {width: 20%; height: 100%; float: left;}

.textim {
       float:left; 
        width: 80%; height: 50%;
       padding-left: 30px;
       font-size: 21px;   
       padding-top: 20px;
       }

.element:hover, #layerClose:hover{cursor:pointer; opacity:0.8;}
</style>


</head>
<body>

<div id="tab2" style="display: none; height: 400px; background-color: white; z-index: -2;">
   <c:forEach items="${profilelist }" var="i">
	   <div id="prodiv" >
	      <div class="element"><img alt="프로필" src="/resources/assets/img/profileimage.png" style="width: 100%; height: 100%;"></div>
	      <div class="textim" >
	         <span>${i.mi_memid }(${i.mi_memname })</span>
	      </div>
	   
	   </div>
  </c:forEach> 
   
</div>
	



</body>
</html>








