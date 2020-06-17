<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
    <link href="/resources/assets/js/fullcalendar/bootstrap-fullcalendar.css" rel="stylesheet" />
        
    <!-- Custom styles for this template -->
    <link href="/resources/assets/css/style.css" rel="stylesheet">
    <link href="/resources/assets/css/style-responsive.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
		<div id="tab5" style="display: none;">
			<div class="row mt">
                  <aside class="col-lg-9 mt">
                      <section class="panel">
                          <div class="panel-body">
                              <div id="calendar" class="has-toolbar"></div>
                          </div>
                      </section>
                  </aside>
              </div>
         </div>

 <script src="/resources/assets/js/jquery.js"></script>
    <script src="/resources/assets/js/jquery-ui-1.9.2.custom.min.js"></script>
	<script src="/resources/assets/js/fullcalendar/fullcalendar.min.js"></script>    
    <script src="/resources/assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="/resources/assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="/resources/assets/js/jquery.scrollTo.min.js"></script>
    <script src="/resources/assets/js/jquery.nicescroll.js" type="text/javascript"></script>


    <!--common script for all pages-->
    <script src="/resources/assets/js/common-scripts.js"></script>

    <!--script for this page-->
	<script src="/resources/assets/js/calendar-conf-events.js"></script>    
  
  <script>
      //custom select box

      $(function(){
          $("select.styled").customSelect();
      });

  </script>
</body>
</html>