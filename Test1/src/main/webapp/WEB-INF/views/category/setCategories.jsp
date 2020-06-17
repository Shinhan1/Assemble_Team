<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/assemble.io/${mi_assemblename}/header"></c:import>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
.main {
   width: 50%;
   height: 100%;
   position: absolute;
   margin-top: 5%;
   margin-bottom: 5%;
   margin-left: 25%;
}

.contents {
   background-color: white;
   /* border: 1px solid #CCCCCC; */
   margin: 0;
   padding: 0;
}

table {
   float: right;
   font-size: 15px;
   width: 100%;
   border-collapse: collapse;
   border-spacing: 0;
}

tr, th, td {
   border: 1px solid #dcdfe4;
   border-spacing: 0;
   letter-spacing: 1px;
   height: 50px;
}

table th {
   background-color: #f5f5f5;
   padding-left: 20px;
}

table th:last-child {
   padding-left: 20px;
   width: 60%;
}

td {
   padding-left: 20px;
   color: #757575;
   background-color: white;
}

td:hover, td:active {
   color: #5a86dd;
}

#inputPlus {
   border: 1px solid #dcdfe4;
   border-radius: 1rem;
   height: 30px;
   width: 80%;
}

#btnPlus {
    -webkit-border-top-right-radius: 5px;
   -webkit-border-bottom-right-radius: 5px;
   -moz-border-radius-topright: 5px;
   -moz-border-radius-bottomright: 5px;
   border-top-right-radius: 5px;
   border-bottom-right-radius: 5px;
   background-color: #dcdfe4;
   border: 2px solid #dcdfe4;
   color: #757575;
   height : 80%;
   width: 15%;
   height: 34px;
   margin-left: -20px;
}
/* #btnPlus:active, #btnPlus:hover {
   color: white;
} */
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">

$(function(){
   $("#btnPlus").click(function(){
      console.log(this.parentNode.childNodes);
      var name = this.parentNode.childNodes[1].value;
      var btn = this.parentNode.childNodes[3].value;
      
      document.location.href = "makeCategoryOk?cgName="+name;
   });
});

</script>
</head>
<body>

<div class="main">
   <div class="contents">
               <table>
               <thead>
                  <tr>
                     <th><b>카테고리 추가</b></th>
                     <th><b>카테고리 이름</b></th>
                  </tr>               
             
               </thead>
               
               <tbody>
                  <tr>   
                     <td rowspan="10">
                        <input type="text" name="" id="inputPlus" />
                        <input type="button" value="+" id="btnPlus"/>
                        <!-- <button id="btnPlus" ><i class="fa fa-plus" aria-hidden="true"></i></button> -->   
                     </td>
                  
                  <!-- 카테고리 이름 -->   
                     <td><b> Make your category~! Make your category~!</b></td>
                  </tr>
                    
                  <c:forEach var="i" items="${categoryList2 }">
                      <tr><td>${i.categoryname }</td></tr>
                  </c:forEach> 
                  
               
               
               </tbody>
            </table>
      </div>
   
</div>
<script src="/resources/assets/js/jquery.js"></script>
<script src="/resources/assets/js/jquery-1.8.3.min.js"></script>
<script src="/resources/assets/js/bootstrap.min.js"></script>
<script class="include" type="text/javascript"
   src="/resources/assets/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="/resources/assets/js/jquery.scrollTo.min.js"></script>

<!--     common script for all pages -->
<script src="/resources/assets/js/common-scripts.js"></script>

</body>
</html>