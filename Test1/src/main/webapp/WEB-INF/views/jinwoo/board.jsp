<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {

   
   $('#writebtn1').click(function(){
      $("#writediv1").css('display','block');
      $("#writediv2").css('display','none');
      $("#writediv3").css('display','none');
      $(".boarddiv").css('height','310px');
      
      $("#writebtn1").css('background-color','white');
      $("#writebtn2").css('background-color','#D5D5D5');
      $("#writebtn3").css('background-color','#D5D5D5');
      
   
      
      
      
      });
   
   $('#writebtn2').click(function(){
      $("#writediv1").css('display','none');
      $("#writediv2").css('display','block');
      $("#writediv3").css('display','none');
      $(".boarddiv").css('height','390px');
      
      $("#writebtn1").css('background-color','#D5D5D5');
      $("#writebtn2").css('background-color','white');
      $("#writebtn3").css('background-color','#D5D5D5');

      
      
      });
   
   $('#writebtn3').click(function(){
      $("#writediv1").css('display','none');
      $("#writediv2").css('display','none');
      $("#writediv3").css('display','block');
      $(".boarddiv").css('height','340px');
      
      $("#writebtn1").css('background-color','#D5D5D5');
      $("#writebtn2").css('background-color','#D5D5D5');
      $("#writebtn3").css('background-color','white');
      
      });
   
   $(document).ready(function(){
       /* $("#fileInput1").on('change', function(){  // 값이 변경되면
         if(window.FileReader){  // modern browser
            var filename = $(this)[0].files[0].name;
         } else {  // old IE
             var filename = $(this).val().split('/').pop().split('\\').pop();  // 파일명만 추출
         }

          // 추출한 파일명 삽입
         $("#userfile1").val(filename);

      });
      
      $("#fileInput2").on('change', function(){  // 값이 변경되면
         if(window.FileReader){  // modern browser
            var filename = $(this)[0].files[0].name;
         } else {  // old IE
             var filename = $(this).val().split('/').pop().split('\\').pop();  // 파일명만 추출
         }

          // 추출한 파일명 삽입
         $("#userfile2").val(filename);

      });
      
      $("#fileInput3").on('change', function(){  // 값이 변경되면
         if(window.FileReader){  // modern browser
            var filename = $(this)[0].files[0].name;
         } else {  // old IE
             var filename = $(this).val().split('/').pop().split('\\').pop();  // 파일명만 추출
         }

          // 추출한 파일명 삽입
         $("#userfile3").val(filename);

      }); */
      
      $("#btn1").click(function(){
          var data = $("#fileInput1").val(); 
          console.log(data);
          
          if(data==""){       
             
             console.log(document.frm);

             document.frm1.action = "/writeOk";
             document.frm1.submit(); 
          }else{
             console.log("file in");
             document.frm1.action = "/upload";
             document.frm1.method = "post";
             document.frm1.submit();
          }       
          
       }); 
      
        $(function(){
             
             $("#btn3").click(function(){
                var data = $("#fileInput3").val();       
                
                if(data==""){
                   console.log("not file");       
                   document.frm3.action = "/requestOk";
                   document.frm3.method = "post";
                   document.frm3.submit();
                }else{
                   console.log("file in");
                   document.frm3.action = "/requestFileOk";
                   document.frm3.method = "post";
                   document.frm3.submit();
                }       
                
             });
          
         });

      
   });
   
    

});

$(function() {
   $(function() {
      init(); 
   })
   
   function init() {
      $fileBox = $('.input-file1');
      fileLoad(); 
   }
   
   function fileLoad() { 
      $.each($fileBox, function(idx){ 
         var $this = $fileBox.eq(idx),
         $btnUpload = $this.find('[type="file"]'),
         $label = $this.find('.file-label1'); 
         
      $btnUpload.on('change', function() {
         if(window.FileReader){  // modern browser
            var filename = $(this)[0].files[0].name;
         } else {  // old IE
             var filename = $(this).val().split('/').pop().split('\\').pop();  // 파일명만 추출
         }

          // 추출한 파일명 삽입
         $(".file-name1").val(filename); })
         
      $btnUpload.on('focusin focusout', function(e) {
         e.type == 'focusin' ? $label.addClass('file-focus') : $label.removeClass('file-focus'); 
      })
   })
   
   }
   
   
   function init() {
      $fileBox = $('.input-file2');
      fileLoad(); 
   }
   
   function fileLoad() { 
      $.each($fileBox, function(idx){ 
         var $this = $fileBox.eq(idx),
         $btnUpload = $this.find('[type="file"]'),
         $label = $this.find('.file-label2'); 
         
      $btnUpload.on('change', function() {
         if(window.FileReader){  // modern browser
            var filename = $(this)[0].files[0].name;
         } else {  // old IE
             var filename = $(this).val().split('/').pop().split('\\').pop();  // 파일명만 추출
         }

          // 추출한 파일명 삽입
         $(".file-name2").val(filename); })
         
      $btnUpload.on('focusin focusout', function(e) {
         e.type == 'focusin' ? $label.addClass('file-focus') : $label.removeClass('file-focus'); 
      })
   })
   
   }
   
   
   function init() {
      $fileBox = $('.input-file3');
      fileLoad(); 
   }
   
   function fileLoad() { 
      $.each($fileBox, function(idx){ 
         var $this = $fileBox.eq(idx),
         $btnUpload = $this.find('[type="file"]'),
         $label = $this.find('.file-label3'); 
         
      $btnUpload.on('change', function() {
         if(window.FileReader){  // modern browser
            var filename = $(this)[0].files[0].name;
         } else {  // old IE
             var filename = $(this).val().split('/').pop().split('\\').pop();  // 파일명만 추출
         }

          // 추출한 파일명 삽입
         $(".file-name3").val(filename); })
         
      $btnUpload.on('focusin focusout', function(e) {
         e.type == 'focusin' ? $label.addClass('file-focus') : $label.removeClass('file-focus'); 
      })
   })
   
   }
});
</script>

<style type="text/css">
   .writebtn {
      width: 32.9%;
      height: 50px;
      border : none;
   }
   
   #writebtn1 {
      background-color: white;
   
   }
   
   #writebtn2 {
      background-color: #D5D5D5;
   }
   
   #writebtn3 {
      background-color: #D5D5D5;
   }
   
   
   
   
   
   .writediv {
      width:100%; height: 100%;
      background-color: white;
   
   }
   
   #writediv1{

      display: block;
   }
   
   #writediv2{

      display: none;
   }
   
   #writediv3{
      display: none;
   }

   .buttonbo {

  background-color: #4CAF50; /* Green */
  border: none;
  color: white;

  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
/*   margin-top : 50px; */
  transition-duration: 0.4s;
  cursor: pointer;
  height : 40px;
  width : 100px;
  
  background-color: white;
  color: black;
  border: 2px solid #e7e7e7;
  
}

.button:hover {background-color: #e7e7e7;}

.btn-group {margin: 0;}
.btn-group .button2 {
  background-color: #EAEAEA; /* Green */
  border: none;
  color: white;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;

  width: 70px;
  height: 25px;
  float: left;
}
.btn-group .button3 {
  background-color: #FF0000; 
  border: none;
  color: white;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;

  width: 70px;
  height: 25px;
  float: left;
}




.input-file {
  display: inline-block;
}

.input-file [type="file"] {
  position: absolute;
  width: 1px;
  height: 1px;
  padding: 0;
  margin: -1px;
  overflow: hidden;
  clip: rect(0, 0, 0, 0);
  border: 0 none;
}
.input-file .file-label {
  display: inline-block;
  min-width: 53px;
  height: 27px;
  line-height: 24px;
  padding: 0 10px;
  border-radius: 2px;
  font-size: 13px;
  background-color: #333;
  color: #fff;
  text-align: center;
}
.input-file .file-name {

  width: 90%;
}  
</style>
</head>
<body>
<div class="boarddiv" id="tab1" style="height: 310px; display: block;">

   <div style="width: 100%; height: 15%; background-color: white;">
      <input class="writebtn" id="writebtn1" type="button" value="글쓰기" />
      <input class="writebtn" id="writebtn2" type="button" value="일정" />
      <input class="writebtn" id="writebtn3" type="button" value="요청" />
   </div>
   
   <div style="width: 100%; height: 90%;">
      <div class="writediv" id="writediv1" >
      
         <form name="frm1" enctype="multipart/form-data">
                    
               <div style="padding: 20px 20px 0 20px;"><textarea style="resize: vertical; width: 100%;" rows="8" name="contents" placeholder="그룹 멤버들과 공유할 내용을 적어주세요."></textarea></div>

                      
                      <!-- <div class="form-group" style="width: 40%; float: left;">
                        <label for="InputSubject1">파일첨부</label>
                        <input id="fileInput1" name="uploadFile" filestyle="" type="file" data-class-button="btn btn-default" data-class-input="form-control" data-button-text="" data-icon-name="fa fa-upload" class="form-control" tabindex="-1" style="position: absolute; clip: rect(0px 0px 0px 0px);">
                        <div class="bootstrap-filestyle input-group">
                             <input type="hidden" id="fileStatus" name="fileStatus" value="0" />
                           <input type="text" id="userfile1" class="form-control" name="uploadFile"  disabled="">
                           <span class="group-span-filestyle input-group-btn" tabindex="0">
                              <label for="fileInput1" class="btn btn-default">
                                 <span class="glyphicon fa fa-upload"></span>
                              </label>
                           </span>
                        </div>
                  </div> -->
                  
                  <div class="input-file1" style="padding: 0 20px 0 20px;">
                   <!--  <input type="text" readonly="readonly" class="file-name1" />
                    <label style="margin-top: 3px;" for="fileInput1" class="file-label1"></label> -->
                     <input type="hidden" id="filestatus" name="filestatus" value="0" />
                    <input type="file" name="uploadFile" id="fileInput1" class="file-upload" />
                  </div>
                  
                  <input type="hidden" name="groupno" id="groupno" value="<c:out value='${groupno }'/>" />
                  <input type="hidden" name="memberno" id="memberno" value="<c:out value='${memberno }'/>" />
                  
                  <%-- <div>
                     <c:out value='${groupno }'/> , <c:out value='${categoryno }' />, <c:out value='${memberno }'/>
                  </div> --%>
                     
                          <div style="padding-right: 20px;">
                            <div style="float: right;"><input class="buttonbo" id="btn1" type="button" value="등록" /></div>
                            <div style="float: right;"><input class="buttonbo" type="reset" value="취소" /></div>
                          </div>
               </form>
               
      </div>
      
      <div class="writediv" id="writediv2" >
         <form name="frm2" enctype="multipart/form-data">
                          
                          <div style="padding-left: 20px;">
                          <div style="margin-left: 8px; float: left; font-size: 13px"><%@ include file="calendar.jsp" %> 
                          </div> 
                          <div style="float: left; margin-left: 10px; ">
                          <select style="font-size: 16px;"> 
                          <option selected>시간 설정</option>    
                          
                          <option>12:00 AM</option>
                          <option>1:00 AM</option>
                          <option>2:00 AM</option>
                          <option>3:00 AM</option>
                          <option>4:00 AM</option>
                          <option>5:00 AM</option>
                          <option>6:00 AM</option>
                          <option>7:00 AM</option>
                          <option>8:00 AM</option>
                          <option>9:00 AM</option>
                          <option>10:00 AM</option>
                          <option>11:00 AM</option>
                          <option>12:00 PM</option>
                          <option>13:00 PM</option>
                          <option>14:00 PM</option>
                          <option>15:00 PM</option>
                          <option>16:00 PM</option>
                          <option>17:00 PM</option>
                          <option>18:00 PM</option>
                          <option>19:00 PM</option>
                          <option>20:00 PM</option>
                          <option>21:00 PM</option>
                          <option>22:00 PM</option>
                          <option>23:00 PM</option>
                    
                           </select>
                          </div>
                          
                          <div style="padding-top: 40px;"><input type="text" name="" id="" style="width: 80%;" placeholder="일정 제목을 입력하세요."/></div>
                          
                          </div>
                          
                          <div style="padding: 20px 20px 0 20px;"><textarea style="resize: vertical; width: 100%;" rows="8"  name="contents" 
                             placeholder="그룹 멤버들과 공유할 내용을 적어주세요."></textarea></div>        
                             
                                <div class="input-file2" style="padding: 0 20px 0 20px;">
                        <!--   <input type="text" readonly="readonly" class="file-name2" />
                          <label style="margin-top: 3px;" for="fileInput1" class="file-label2">파일첨부</label> -->
                          <input type="file" name="uploadFile" id="fileInput2" class="file-upload" />
                          <input type="hidden" id="fileStatus" name="fileStatus" value="0" />
                        </div>
                                          
                            <div style="padding-right: 20px;">
                            <div style="float: right;"><input class="buttonbo" type="button" value="등록" /></div>
                            <div style="float: right;"><input class="buttonbo" type="reset" value="취소" /></div>
                            </div>
                            </form>   
      
               </div>
            <div class="writediv" id="writediv3" >
            
               <form name="frm3" enctype="multipart/form-data">
                                     <div style="padding:10px 20px 0 20px; height: 25px">
                                         
                                         <div><input type="text" name="response" id="" style="width: 59%; float: left;" placeholder="담당자를 입력하세요"/></div>
                                         
                                         <div class="btn-group" style="float: right;">
                                   <button class="button3"  disabled="disabled">요청</button>
                                   <button class="button2"  disabled="disabled">진행</button>
                                   <button class="button2"  disabled="disabled">종료</button>
                                 </div>
                              </div>
                                      <div style="padding: 20px 20px 0 20px;"><textarea style="resize: vertical; width: 100%;" rows="8" name="contents" 
                                         placeholder="그룹 멤버들과 공유할 내용을 적어주세요."></textarea></div>
                                         
                                         
                                         <div class="input-file3" style="padding: 0 20px 0 20px;">
                                   <!-- <input type="text" readonly="readonly" class="file-name3" />
                                   <label style="margin-top: 3px;" for="fileInput1" class="file-label3">파일첨부</label> -->
                                   <input type="file" name="uploadFile" id="fileInput3" class="file-upload" />
                                   <input type="hidden" id="fileStatus" name="fileStatus" value="0" />
                                 </div>
                                 
                                 
                                 <input type="hidden" name="groupno" id="groupno" value="<c:out value='${groupno }'></c:out>" />
                                 <input type="hidden" name="memberno" id="memberno" value="<c:out value='${memberno }'></c:out>" />
                                 
                                 
                                 
                                 
                                 
                              <div style="padding-right: 20px;">
                                      <div style="float: right;"><input class="buttonbo" id="btn3" type="button" value="등록" /></div>
                                      <div style="float: right;"><input class="buttonbo" type="reset" value="취소" /></div>
                                      </div>
                                 </form>
         
      
      </div>
   
   </div>
</div>

</body>
</html>
