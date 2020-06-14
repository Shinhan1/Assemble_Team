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
$(function() {
$('.element').click(function(e) {
    var divTop = e.clientY - 120; //상단 좌표
    var divLeft = e.clientX - 310; //좌측 좌표
    $('#layer').css({
        "top": divTop
        ,"left": divLeft
        , "position": "absolute"
    }).show();
});
$("#layerClose").click(function(){
    $('#layer').css('display','none');
});

});
</script>

<style type="text/css">


.element {width: 20%; height: 100%; background-color: black; float: left;}

.textim {
       float:left; 
        width: 80%; height: 50%;
       padding-left: 30px;
       font-size: 18px;   
       }

#layer{display:none; }
.element:hover, #layerClose:hover{cursor:pointer; opacity:0.8;}
</style>


</head>
<body>

   <div id="tab2" style="display: none; height: 400px; background-color: white;">
         <c:forEach items="${profilelist }" var="i">
            <div style=" float:left; width: 50%; height: 65px ;">
            
               <div>
                  <div class="element"><span></span></div>
                  <div class="textim"><span>${i.mi_memid }(${i.mi_memname })</span></div>
                  <%-- <div class="textim"><span>${i.소속정보 }</span></div> --%>
               </div>
            </div>
            
         </c:forEach> 
      </div>
      <!-- <div class="textim" >
         <span>아이디(이름)</span>
      </div>
      
      <div class="textim">
         <span>소속정보</span>
         
      </div> -->
<!--    <div style=" float:left; width: 50%; height: 65px ;">
      <div class="element"></div>
      <div class="textim" >
         <span>아이디(이름)</span>
      </div>
      
      <div class="textim">
         <span>소속정보</span>
         
      </div>
   </div> -->
      
   <%--  <c:forEach var="i" items="${list }">
      <h2>${i.mi_memid }</h2>
      <h2>${i.mi_memname }</h2>
   </c:forEach> --%>
      

      

<!-- <div id="layer" style="width: 250px; height: 350px; background-color: pink;"> -->
   



</body>
</html>







