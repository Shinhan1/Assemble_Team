<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/assemble.io/${mi_assemblename}/header"></c:import>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>group Make.jsp</title>
</head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet" type="text/css" href="resources/assets/css/hancss/clicklist.css">     <!-- css 파일 경로  -->
<link rel="stylesheet" type="text/css" href="/resources/assets/css/chat_css.css">     <!-- css 파일 경로  -->

<script type="text/javascript">
</script>

<style>

/* 
#main {
   width: 50%;
   height: 100%;
   position: absolute;
   /*     background: white; */
   margin-top: 5%;
   margin-bottom: 5%;
   margin-left: 25%;
}
 */

</style>

<body>
<div id="main" style="z-index: -2">
   <form name="frm" action="/insertGroupOk" enctype="multipart/form-data">
     
     
     <div class="div0">
      <section class="bookmarks-page">
         <header class="page-header bookmarks-page__header" style="margin-bottom: 0;">
         
            <h2 class="page-header__title">
               <span>그룹 생성</span>                                 <!-- div 제목  -->
            </h2>
            
            <div class="page-header__info">
            
               <div class="page__options bookmarks-page__options">
                  
<!--                   <div class="page__options mentions-page__options">
                     <button class="option-button1" autofocus="autofocus">카테고리명</button>
                  </div> -->
   
                  
               <form class="search-field bookmarks-page__search">
                 <table>
                     <tr>
                        <td>카테고리명</td>
                        <td style="padding-left: 10%;">
                            <select name="categorList" id="category">
                                <c:forEach var="i" items="${categoryList2 }">
                                   <option value="${i.categoryno }" >${i.categoryname }</option>
                                </c:forEach> 
                          </select>
                        </td>
                     </tr>
                 </table>
                
               </form>
                  

               </div>
               
            </div>
         </header>
      
      
         <div class="scroll-container scroll-container--window undefined" tabindex="-1" id="div1">
            <div class="bookmarks-page__list-wrap">
               
               <table>
                    
                    <tr>
                       <td style="padding: 5px;">그룹명</td>
                       <td style="padding-left: 25%; "><input type="text" name="groupname" id="groupname" /></td>
                    </tr>
                 </table>
                 
                 <input type="submit" value="등록" style="margin-top: 10%; width: 120px;" />
               
               </div>
            </div>
            
         </section>
      </div>
        
     </form>
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