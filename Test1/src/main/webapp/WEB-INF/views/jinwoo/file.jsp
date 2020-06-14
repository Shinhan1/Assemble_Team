<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

.filedata {
   height: 100%;
   float: left;

}

#dataname1 {
   width: 42%; display:table-cell; padding-top: 5px;

}

#dataname2 {
   width: 20%;  display:table-cell; padding-top: 7px;
}
#dataname3 {
   width: 13%; display:table-cell; padding-top: 7px;
}
#dataname4 {
   width: 25%;  display:table-cell; padding-top: 7px;
}



#data1 {
   width: 42%; font-size: 18px; padding-top: 7px;
}

#data2 {
   width: 20%; font-size: 14px; padding-top: 7px;
}
#data3 {
   width: 13%; font-size: 14px; padding-top: 7px;
}
#data4 {
   width: 14%;font-size: 14px; padding-top: 7px;
}

#data5 {
   width: 11%; font-size: 14px; padding-top: 7px;
}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
   $(function(){
      $(".filename").click(function(){
          var filename = this.parentNode.childNodes[1].value;
          console.log(this.parentNode.childNodes[1].value);
          var url = "/download?filename=" + encodeURIComponent(filename); 
          
          document.location.href = url;
          
       });
      
   });
</script>
</head>
<body>
   <div id="tab4" style="display:none; width: 100%;  border-top:double; border-bottom: double;">
      
     <c:forEach items="${filelist }" var="i">
   
      <div style="width: 100%; height: 50px; float: left; border-bottom: solid 1px;">
         <div class="filedata" id="data1" ><span>${i.filename }</span></div>
         <div class="filedata" id="data3" ><span>기타</span></div>
         <div class="filedata" id="data5" >
            <input type="hidden" value="${i.filename }" />
            <input type="button" value="다운로드" class="filename"/>
         </div>
      </div>
   
     </c:forEach>
   
   </div>

</body>
</html>

