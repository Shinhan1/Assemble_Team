<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>DASHGUM - Bootstrap Admin Template</title>

    <!-- Bootstrap core CSS -->
    <link href="/resources/assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="/resources/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="/resources/assets/js/fancybox/jquery.fancybox.css" rel="stylesheet" />
    <!-- Custom styles for this template -->
    <link href="/resources/assets/css/style.css" rel="stylesheet">
    <link href="/resources/assets/css/style-responsive.css" rel="stylesheet">

    <script src="/resources/assets/js/jquery.js"></script>


    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>


      <div id="tab3" style="display: none;" >
      
    <!--   <section id="main-content">
          <section class="wrapper site-min-height"> -->
             <h3><i class="fa fa-angle-right"></i> Gallery</h3>
             <hr>
            <div class="row mt">
               <!-- <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 desc">
                  <div class="project-wrapper">
                          <div class="project">
                              <div class="photo-wrapper">
                                  <div class="photo">
                                     <a class="fancybox" href="/resources/assets/img/portfolio/port04.jpg"><img class="img-responsive" src="/resources/assets/img/portfolio/port04.jpg" alt=""></a>
                                  </div>
                                  <div class="overlay"></div>
                              </div>
                          </div>
                      </div>
               </div>col-lg-4 -->
               
               
               <c:forEach var="i" items="${imagelist }">
               
                  <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 desc">
        
                     <div class="project-wrapper">
                             <div class="project">
                                 <div class="photo-wrapper">
                                     <div class="photo">
                                        <a class="fancybox" href="<spring:url value='/resources/uploadFiles/${i.filename }'/>"><img class="img-responsive" src="<spring:url value='/resources/uploadFiles/${i.filename }'/>" alt=""></a>
                                     </div>
                                     <div class="overlay"></div>
                                 </div>
                             </div>
                         </div>
                  </div>
                     
               
               </c:forEach>   
               
               

            </div><!-- /row -->


 
  </div>


    <!-- js placed at the end of the document so the pages load faster -->
   <script src="/resources/assets/js/fancybox/jquery.fancybox.js"></script>    
    <script src="/resources/assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="/resources/assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="/resources/assets/js/jquery.scrollTo.min.js"></script>
    <script src="/resources/assets/js/jquery.nicescroll.js" type="text/javascript"></script>


    <!--common script for all pages-->
    <script src="/resources/assets/js/common-scripts.js"></script>

    <!--script for this page-->
  
  <script type="text/javascript">
      $(function() {
        //    fancybox
          jQuery(".fancybox").fancybox();
      });

  </script>
  
  <script>
      //custom select box

      $(function(){
          $("select.styled").customSelect();
      });

  </script>

  </body>
</html>