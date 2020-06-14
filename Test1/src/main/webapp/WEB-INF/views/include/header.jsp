<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>ASSEMBLE</title>

    <!-- Bootstrap core CSS -->
    <link href="/resources/assets/css/bootstrap.css" rel="stylesheet">
    <!--external <css--></css-->
    <link href="/resources/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="/resources/assets/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="/resources/assets/js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="/resources/assets/lineicons/style.css">    
    <link rel="stylesheet" type="text/css" href="/resources/assets/lineicons/style.css?ver=1">    
    
    <!-- Custom styles for this template -->
    <link href="/resources/assets/css/style.css" rel="stylesheet">
    <link href="/resources/assets/css/style-responsive.css" rel="stylesheet">
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>    
<script type="text/javascript">
$(document).ready(function() {
	$("#category").click(function(){
		location.href="/makeCategory";
	});
	
/* 	 $(".category").click(function(){
		var categoryno = this.parentNode.childNodes[5].value; 
		console.log(this.parentNode.childNodes[5].value);
		document.location.href = "categoryGroupList?categoryno="+categoryno;
	});  */


/* 	$(".groupWall").click(function(){
		console.log("click");
		var categoryno = this.parentNode.childNodes[1].value;
 		var mi_assembleName = this.parentNode.childNodes[3].value;
		var groupno = this.parentNode.childNodes[5].value;
		
		console.log(categoryno);
		console.log(groupno);
		
		document.location.href = "/assemble.io/"+mi_assembleName+"/g/"+groupno+"/wall"+"?categoryno="+categoryno; 

	}); */

});




 </script>

  <body>

  <section id="container" >
      <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
      <!--header start -->
      <header class="header black-bg">
		<!--logo start-->
            <a href="/assemble.io/${mi_assemblename}/home?memberno=${memberno}" class="logo">
            	 <img src="/resources/assets/img/assemble2.png" id="logo">  
            	 <b class="teamname"> : </b>
            	 <b class="teamname"> ${mi_assemblename } </b>      	 
           	</a>
            <!--logo end-->
        
            <input type="search" name="search" id="search" placeholder="검색어를 입력하세요" />
            <button class="icon" ><i class="fa fa-search"></i></button>
        
        </header>
      <!--header end-->
      	
      
      <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
      <!--sidebar start-->
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              	  <div id="div1">
              	  	<p class="centered"><a href="profile.html"><img src="https://t1.daumcdn.net/agit_resources/images/empty_profile.png" class="img-circle" width="60"></a></p>
             	  </div>
             	  
              	  <div id="div2">
	              	  <h4 id="id1"><b><c:out value="${mi_memid }" /></b></h4>
	              	  <h4 id="name1"><c:out value="${mi_memname }" /></h5>
	              	  
	              	<!-- 로그아웃 -->
					<a href="/main">
						<img src="/resources/assets/img/off.png" alt="off" width="23" height="23" id="off"/>
					</a>
	              	  
              	  </div>
              	  
		              	 <a href="/myBoard"><input type="button" value="내글" class="bt1"/></a>
		              	  <!-- <input type="button" value="맨션" class="b1"/> -->
		              	   <a href="/tasks"><input type="button" value="요청" class="bt1"/></a>   
		              	   <a href="/bookmarks"><input type="button" value="북마크" class="bt2"/></a>   
  
		              	  <input type="button" value="아지트 멤버 초대하기" id="b3" onclick="location.href='/invited'" />
		              	  
		              	  <a href="/members"><input type="button" value="멤버" class="b4"/></a>   
		              	  <a href="/attendgroups"><input type="button" value="참여가능한 그룹" class="b4"/></a>   
        	  	
	              	  	  <input type="button" value="+ 카테고리 추가하기" class="b6" id="category"/>
	              	  	  
	              	  	  <input type="button" value="+ 새로운 그룹 만들기" class="b6"/>
					

       <!---------------------------------------------------------------------------->
                 <!--  <li class="mt">
                      <a class="active" href="index.html">
                          <i class="fa fa-dashboard"></i>
                          <span>내글, 맨션, 요청, 북마크</span> 
                      </a>
                  </li> -->

                  <li class="sub-menu">
         				<input type="button" value="" id="side"/>
                  </li>
					
					
					<c:forEach var="c" items="${categoryList}">
						<li class="sub-menu">
						<a href="javascript:;"> 
							<i class="fa fa-cogs"></i> 
							<span class="category">${c.categoryname }</span> 
						
						</a>

							<ul class="sub">
							
								<c:forEach var="g" items="${groupList }">
									<c:if test="${g.categoryno == c.categoryno }">
											<li><a href="/assemble.io/${c.assemblename }/g/${g.groupno }/wall">${g.groupname} </a>
											<%-- <input type="hidden" class="categoryno" value="${c.categoryno }" />
											<input type="hidden" class="assemblename" value="${c.assemblename }" />
											<input type="hidden" class="groupno" value="${g.groupno }" />
											<input type="button" value="${g.groupname }" class="groupWall"/> --%>
											</li>
									</c:if>
								</c:forEach>
							</ul>
						</li>
					</c:forEach>	
              </ul>
              <!-- sidebar menu end-->
          </div>
      </aside>
      <!--sidebar end-->
      
<!--   <div id="main">
      	<h2>여기는 메인</h2>
      </div> -->
      
      <div id="chatting">
      	<c:import url="/chatroom/room/side"></c:import>
      </div>
   </section>
   


 
<script src="/resources/assets/js/jquery.js"></script> 
 <script src="/resources/assets/js/jquery-1.8.3.min.js"></script> 
 <script src="/resources/assets/js/bootstrap.min.js"></script> 
 <script class="include" type="text/javascript" src="/resources/assets/js/jquery.dcjqaccordion.2.7.js"></script> 
 <script src="/resources/assets/js/jquery.scrollTo.min.js"></script> 

<!--     common script for all pages -->
 <script src="/resources/assets/js/common-scripts.js"></script>      
</body>

</html>