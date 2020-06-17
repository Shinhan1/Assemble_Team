<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jsp로만 만든 채팅 (not controller)</title>
<head>

<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" type="text/css" href="/resources/assets/css/chat_css.css">  <!-- css 파일 경로  -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.min.js"></script>
<!-- <script src="https://raw.githubusercontent.com/stomp-js/stomp-websocket/master/lib/stomp.min.js"></script> -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script type="text/javascript">

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

/* function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    console.log(socket);
    console.log("coon : ${roomId}");
    
     stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
       
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/queue/${roomId}', function (greeting) {
            showGreeting(JSON.parse(greeting.body).content,JSON.parse(greeting.body).sendTime);
        });
        
        
    //stompClient.send("/app/welcome", {}, JSON.stringify( {'name': $("#name").val() }));
     
    
    }); 
    
    
} */




/* function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
} */

/* function sendName() {
   var name =  $("#name").val();
   var contents =  $("#contents").val();
   var roomid =  "${roomId}";
   
   var message = {
         'name': name,
          'contents' : contents,
          'roomid' : roomid
   };
   
   
   
   console.log(JSON.stringify(message));
   
   
   
    stompClient.send("/app/welcome/"+roomid, {}, JSON.stringify(message));
    
    
 
    console.log("세션${id}" );
    //세선 가져오는걸 id로      
   
   
    //여기서'name'이라는 변수에 name을 받아서 전송
    
    //세션을 엮어서 아이디로 출력
    {'contents': $("#contents").val() } 
   
}  */


/* function showGreeting(message,time) {
    $("#greetings").append("<tr><td>" + message +"&nbsp&nbsp&nbsp</td><td style='font-size : 5px'>"+time+"</td ></tr>");
   // $("#greetingstime").append("<td style='font-size : 5px'>"+time+"</td >");
}
 */

function showroom(room) {
    $("#rooms").append("<tr><td>" + room + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    
    $( "#send" ).click(function() { sendName(); });
});


</script>


</head>
<body>
   <form action="">
   </form>
            <c:forEach  var="i" items="${list }" >
               <tr>
                  <td>${i.roomname }</td>
                  <td>${i.senderno }</td>
                  <td>${i.chatcontent }</td>
                  <td>${i.chattime }</td>
               </tr>
               
            
            </c:forEach>

<div class="all">
   <div id="list_header">
      <span id="head_font">그룹대화</span>
      <a href="#" id="plus" class="plus">
         <span id="plus_chat_window" class="glyphicon glyphicon-plus icon_plus" onclick="newopenForm()"></span>        <!-- puls 이모티콘 추가-->
      </a>
   </div>
   
   
   
   
   <div id="list">
      <aside>
      <div id="grouplist">
            <ul id="group">
               <c:forEach var="i" items="${grouplist }">
                  <li class = "memno" id = "groupchat">
                     <div id = "groupchat">
                        <h2 class="memberno" id="${i.togetherno}"> ${i.roomname} </h2>
                     
                     
                     
                  </div>
               
               </li>         
                  
               </c:forEach>   
         </ul>
      </div>
         
           <ul id="alllist">
              <br />
              <span id="head_font">대화</span>
             <c:forEach var="a" items="${memlist }">
                <c:choose>
                   <c:when test="${mi_memid != a.mi_memid}">
                   <li class="memno">
                       <span class="dot" id ="${a.mi_memberno}d" ></span>            <!-- dot = 로그인/비로그인 으로 색 구분  -->
                       <div>
                          <h2 class="memname" id="${a.mi_memid }">  ${a.mi_memname}(${a.mi_memid })</h2>                  <!-- 사용자 id와 이름 가져오기 -->
                          <input type="hidden"  value="${a.mi_memberno}" />
                          <input type="hidden"  value="${a.mi_memname}" />
                       </div>
                  </li>
                   </c:when>
                   
                   <c:when test="${ mi_memid == a.mi_memid }">
                      <input type="hidden" id="myno" value= "${a.mi_memberno}" />
                      <input type="hidden" id="myname" value= "${a.mi_memname}" />
                   </c:when>
                
                
                </c:choose>
          
             
             </c:forEach>
             

               <!-- <li></li>이 DB에서 접속사용자 가져오게...  -->
             
           </ul>

           <footer class="footer">
             <input type="text" id="listsearch" onkeyup="list_search()" placeholder="이름 또는 아지트 아이디 검색">
          </footer>           
          
          <!-- 검색하기 기능  -->
          
       </aside>
   </div>
   

</div>
<!-- 채팅 목록 리스트 end  -->


<!-- 채팅 화면 div -->
<div class="show1" id="chatbox" style="z-index: 2">
    <div class="row chat-window col-xs-5 col-md-3 pull-right" id="chat_window_1">
        <div class="col-xs-12 col-md-12">
        
          <div class="panel panel-default">
          
                <div class="panel-heading top-bar">
                
                    <div class="col-md-7 col-xs-8" id="paneltit">
                        <span id="panel-title"><span class="dot"></span >이름</span>
                    </div>
                    
                    <div class="col-md-5 col-xs-5" style="text-align: right;" id="iconchat">
                        <a href="#"><span id="minim_chat_window" class="glyphicon glyphicon-arrow-down icon_arrow-down"></span></a>
                        <a href="#"><span id="plus_chat_window" class="glyphicon glyphicon-plus icon_plus" onclick="newopenForm()"></span></a>
                        <a href="#"><span class="glyphicon glyphicon-remove icon_close_chat" data-id="chat_window_1"  onclick="reset()"></span></a>
                    </div>
                    
                </div>
                <!-- 채팅화면 상단바  -->

                
                <div id="messagebody" class="panel-body msg_container_base">
                   
                 
                    
                    <!-- 메세지 대화 send 와 receive로 폼 주고 받기~~ -->
                    
                    
                </div>
                
             </div>
             
             <!-- 채팅화면 대화~~ end  -->
             
             <div class="panel-footer">
                <div class="input-group">
                   <input id="btn-input" type="text" class="form-control input-sm chat_input" placeholder="메세지를 입력해주세요..." required="required" />
                    <span class="input-group-btn">
                       <button class="btn btn-primary btn-sm" id="btn-chat">보내기</button>
                    </span>
                </div>
             </div>
             
             <!-- 채팅화면 글쓰기 폼 end  -->
             
        </div>
    </div> 
</div>

<!-- 채팅화면 div end  -->


<!-- 새로운 채팅 div  -->

<!-- 새로운 채팅 추가 div -->
<div class="show2" id="pluschatbox" style="z-index: 2">
    <div class="row pluschat-window col-xs-5 col-md-3 pull-right" id="pluschat_window">
        <div class="col-xs-12 col-md-12">
          <div class="panel panel-default">
          
                <div class="panel-heading top-bar">
                
                    <div class="col-md-10 col-xs-8" id="comment" >
                        <span class="comment">새로운대화</span>
                    </div>
                    
                    <div class="col-md-4 col-xs-5" style="text-align: right;" id="iconclose">
                        <a href="#"><span class="glyphicon glyphicon-remove icon_close_new" data-id="pluschat_window"></span></a>
                    </div>
                    
                </div> <!-- 새로운대화 상단바  -->
                
                
                <div id="myDropdown" class="dropdown-content" onclick = "filterFunction()">
                   <input type="text" placeholder="이름 또는 아지트 아이디를 입력하세요" id="myInput" >
                   
               
                   <c:forEach var="a" items="${memlist }">
                <c:choose>
                   <c:when test="${mi_memid != a.mi_memid}">
                  <div  id = "${a.mi_memberno}" class = "memberblock">
                         <a href="#" onclick= startchat("<c:out value="${a.mi_memname}"/>","<c:out value="${a.mi_memid}"/>","<c:out value="${a.mi_memberno}"/>") >
                            <span > ${a.mi_memname}(${a.mi_memid })</span>            
                         </a>                    
                      </div>

                   </c:when>
                </c:choose>
          
             
             </c:forEach>
                   
                   

               <!-- div가 리스트로 출력되어야 함! == db에서 사용자 리스트 가져오기  -->
               
               
                </div>

           <button class="new-chat" id="new-chat">대화시작하기</button>
           </div>
    
        </div>
    </div>
</div>

<!-- 새로운 채팅 추가 end  -->












<!-- js -->

<script type="text/javascript">
   $(document).ready(function() {
      $('.show1').hide();          //페이지를 로드할 때 숨길 요소 [채팅창화면]
      $('.show2').hide();          //페이지를 로드할 때 숨길 요소 [새로운채팅화면]
   
   $("#sessionbutton").click(function(){
      
         var value = document.getElementById("sessiontest").value;
         sessionStorage.removeItem("id")
         sessionStorage.setItem("id", value ); // 저장
      
         console.log(sessionStorage.getItem("id") );
      
      
      
   })
   
   
   
      
      
   

   });
   
   
      function reset() {
         document.getElementById("panel-title").innerText = ""; 
         console.log("공백");
         
      }
   
   
   

</script>

<!-- 채팅 화면  클릭스js  -->
<script type="text/javascript">
   var rooom;
   var nameid;
   var sendernameid;
   var myno = document.getElementById("myno").value;
   var stompClient;
   

   $(function () {
      connect();
      
   });
      
   
      function connect(){
        var socket = new SockJS('/gs-guide-websocket');
       
            stompClient = Stomp.over(socket);
             console.dir(socket);

      
       stompClient.connect({}, function (frame) {
             setConnected(true);
              console.log('Connected: ' + frame);
              
              // 주소 구독
              stompClient.subscribe('/queue/'+myno, function (greeting) {
              
      
                /*  showGreeting((JSON.parse(greeting.body).id, JSON.parse(greeting.body).content,  JSON.parse(greeting.body).sendTime)); */
                 // 메시지 수신시
                 
   /*               console.log("방이름:"+room);
                 console.log("보낸사람 : "+JSON.parse(greeting.body).sender); */
                 

               
                  if(JSON.parse(greeting.body).sender != myno){
                  console.log("방이름 옐로우"+JSON.parse(greeting.body).sender);
  
                  console.log( document.getElementById(JSON.parse(greeting.body).sender+"d").parentNode.childNodes[5].innerText);
         
                    console.log(document.getElementById("panel-title").innerText);
                    console.log( document.getElementById(JSON.parse(greeting.body).sender+"d").parentNode.childNodes[5].innerText);
                
                var panel =   document.getElementById("panel-title"); 
                if(panel.innerText !=  document.getElementById(JSON.parse(greeting.body).sender+"d").parentNode.childNodes[5].innerText){
                   
                  document.getElementById(JSON.parse(greeting.body).sender+"d").style.backgroundColor ="blue";            
                   
                }
                
             
                 }
               

              
          //stompClient.send("/app/welcome", {}, JSON.stringify( {'name': $("#name").val() }));
           // stompClient.send("/app/welcome", {}, JSON.stringify( {'name': $("#name").val() }));
                
         
          
              
          
             });// connection end
            });
       
       
      };
      
      
      
   
         var receiverno;
   /* $(".memno").click(function(){ */
      $(document).on("click",".memno",function(){
      
      
         console.log("사이드바 클릭")
         
         var room;
         if(this.id== "groupchat"){
            console.log("그룹챗");
            
             var receivername = this.childNodes[1].innerText;
              receiverno =this.childNodes[1].childNodes[1].id;  
            //console.log(this.childNodes[1]..childNodes[1].id);
            room = receiverno;
            /*  receiverno = this.childNodes[1].childNodes[0].id.split(","); */
            room = this.childNodes[1].childNodes[1].id;
            
            console.log("방번호"+receivername);
          
          
      
         }else{
            
             var receivername = this.childNodes[5].childNodes[1].innerText;
             receiverno = this.childNodes[5].childNodes[5].value;
             console.log()
         
            document.getElementById(receiverno+"d").style.backgroundColor ="#bbbbbb";   
             var me = document.getElementById("myno").value;
             // var receiverno = this.childNodes[5].childNodes[5].value;
            
            if(me>receiverno){
               room = receiverno+me;
            }else{
               room = me+receiverno;
         }
      
         }
         
         
         document.getElementById("chatbox").style.display = "block";
           var memno = document.getElementsByClassName("memno");
          
           
          // document.getElementById("myid")
           console.log(document.getElementById("myno").value);
           console.log(document.getElementById("myname").value);
         
           sendernameid = document.getElementById("myname").value+"(${mi_memid})";
           console.log(sendernameid);
           
           //사용자 이름 표시
             var aaa=  document.getElementById("panel-title"); 
              console.dir(receivername);
             aaa.innerText = receivername;
             console.log(aaa.innerText);
             nameid = sendernameid;
       
      
       // sub 방 이름
/*         var room;
        var me = document.getElementById("myno").value;
       // var receiverno = this.childNodes[5].childNodes[5].value;
      
      if(me>receiverno){
         room = receiverno+me
      }else{
         room = me+receiverno
      } */
         
          console.log("룸네임"+room)
       rooom = room;
      
/*----------------------------------------------------------------  */
 
          $("").appendTo("#messagebody");
         $("#messagebody").empty();
         
   
        connect2();
          
         function connect2() {
             var socket2 = new SockJS('/socket2');   
             stompClient2= Stomp.over(socket2);
               
             stompClient2.connect({}, function (frame) {
                
                 setConnected(true);
                
               console.log("커넥트 2")
                stompClient2.subscribe('/queue/'+room, function (greeting) {
                   
                     console.log("불거오기 완료")
                  
                      // 채팅 내용 불러오기
                          if(JSON.parse(greeting.body).sender != myno){
                               var receivebody =   '<div class="row msg_container base_receive">'+
                              '<div class="col-xs-10 col-md-10">'+
                              '<div class="messages msg_receive">'+
                               '<p> '+JSON.parse(greeting.body).content+'</p>'+
                                '<time datetime="2009-11-13T20:00">'+JSON.parse(greeting.body).id+JSON.parse(greeting.body).sendTime+'</time>'+
                               '</div>'+
                              '</div>'+
                              '</div>'
               
               
                     
                           $(receivebody).appendTo("#messagebody");   
                          }
                          
                          
                       });
                      
                      
                      
                      
                      
                      
                      
                      
                      
                   });   //불러오기end
                 
                 
           
              
             
      
             
             
             
             $.ajax({
                url: "/chatroom/room/getchat",
                type : "POST",
                dateType :"list",
                data : {"roomid":room},
                success: function(list){
                    for(var i=0 ; i <list.length;i++){
                       var body = "";
                          var memno = document.getElementsByClassName("memno");
                      //   console.log("성공"+list[i].chatcontent);
                          
                          if(list[i].senderno == myno){
                              body =      '<div class="row msg_container base_sent">' +
                           '<div class="col-md-10 col-xs-10 " id="sent">' +
                               '<div class="messages msg_sent" id="msgsent">' +
                               '<p>'+ list[i].chatcontent + '</p>'+
                               ' <time>'+sendernameid+'• '+list[i].chattime+'</time>'+
                               '</div>' +
                               '</div>' +
                            '</div>';
            
                          }else {
                               
                          /*    console.log(document.getElementById(list[i].senderno).childNodes[1])  */
                       
                             body =   '<div class="row msg_container base_receive">'+
                               '<div class="col-xs-10 col-md-10">'+
                              '<div class="messages msg_receive">'+
                               '<p> '+list[i].chatcontent+'</p>'+
                               ' <time>'+document.getElementById(list[i].senderno).childNodes[1].innerText+'•'+list[i].chattime+'</time>'+
                               '</div>'+
                              '</div>'+
                              '</div>'
                             
                             
                             
                             }
                          
            
                        $(body).appendTo("#messagebody");
                          
                       
                         
                         
                      } 
                 

                   
                   
                   
                }
                
                
             });// ajax end
             
             
             
             
         }

         
         
 
          
      
          
   });
   
   
/*    function openForm() {   //이름클릭
     document.getElementById("chatbox").style.display = "block";
     var memno = document.getElementsByClassName("memno");YG
     console.dir(this);
   
      
   
   
   } */

   function closeForm() {
     document.getElementById("chatbox").style.display = "none";
   }
   
   
   
   $(document).on('click', '.panel-heading span.icon_arrow-down', function (e) {
       var $this = $(this);
       
       if (!$this.hasClass('panel-collapsed')) {
           $this.parents('.panel').find('.panel-body').slideUp();
           $this.addClass('panel-collapsed');
           $this.removeClass('glyphicon-arrow-down').addClass('glyphicon-arrow-up');
       } else {
           $this.parents('.panel').find('.panel-body').slideDown();
           $this.removeClass('panel-collapsed');
           $this.removeClass('glyphicon-arrow-up').addClass('glyphicon-arrow-down');
       }
   });
   
   $(document).on('focus', '.panel-footer input.chat_input', function (e) {
       var $this = $(this);
       if ($('#minim_chat_window').hasClass('panel-collapsed')) {
           $this.parents('.panel').find('.panel-body').slideDown();
           $('#minim_chat_window').removeClass('panel-collapsed');
           $('#minim_chat_window').removeClass('glyphicon-arrow-up').addClass('glyphicon-arrow-down');
       }
   });
   
   $(document).on('click', '#newchat', function (e) {
       var size = $( ".chat-window:last-child" ).css("margin-left");
       size_total = parseInt(size) + 400;
       alert(size_total);
       var clone = $( "#chat_window" ).clone().appendTo( ".container" );
       clone.css("margin-left", size_total);
   });
   
   $(document).on('click', '.icon_close_chat', function (e) {
       //$(this).parent().parent().parent().parent().remove();
       $( "#chatbox" ).hide();
   });
   
   
   // 보내기 function start
   function send(sender){

      //document.getElementById("myname").value
      var name =  $("#name").val();
      var contents =  $("#btn-input").val(); 
      
      
      //방 이름 설정
        var room;
        var me = document.getElementById("myno").value;
/*        var receiverno = this.childNodes[5].childNodes[5].value;
      
      if(me>receiverno){
         room = receiverno+me
      }else{
         room = me+receiverno
      } */
        
      
      var message = {
            'name': nameid,
             'contents' : contents,
             'roomid' : rooom,
             'sender' : document.getElementById("myno").value
             };
      
      console.log(JSON.stringify(message));

      stompClient.send("/app/welcome/"+rooom, {}, JSON.stringify(message));
      stompClient2.send("/app/status/"+receiverno, {}, JSON.stringify(message));


      
      
       //여기서'name'이라는 변수에 name을 받아서 전송
       
       //세션을 엮어서 아이디로 출력
      /* {'contents': $("#contents").val() } */
      
      var chat = $("#btn-input").val(); 
      var dt = new Date();
      var time = dt.getHours() + ":" + dt.getMinutes() + ":" + dt.getSeconds();
   
      if (chat =="") {
          alert('메시지를 입력하세요');
      } else{
         var body =      '<div class="row msg_container base_sent">' +
                     '<div class="col-md-10 col-xs-10 " id="sent">' +
                           '<div class="messages msg_sent" id="msgsent">' +
                           '<p>'+ chat + '</p>'+
                           ' <time datetime="2009-11-13T20:00">'+sendernameid+'•'+time+'</time>'+
                           '</div>' +
                           '</div>' +
                      '</div>';
   }
      
   $(body).appendTo("#messagebody");
   
   $('#btn-input').val('');
   
   $("#messagebody").animate({ scrollTop: $("#messagebody")[0].scrollHeight}, 'slow');
   
   // db에 채팅내용 저장 
    $.ajax({
       url: "/chatroom/room/inputchat/",
       type : "POST",
       data : {"roomid":rooom,
             "assemblename" : "${mi_assembleName}",  //세션에서 어셈블이름 불러와야함
             "chatcontents":   contents,
             "senderno" : myno
       }
    });
   
   
   
   
   
   
   
   }
   // send function end

   
   // 메시지 출력
   function showGreeting(name,message,time) {
      
          $("#greetings").append("<tr><td>" + message +"&nbsp&nbsp&nbsp</td><td style='font-size : 5px'>"+time+"</td ></tr>");
    
          console.log("받기"+name+message+time);
          
          
       var receivebody =   '<div class="row msg_container base_receive">'+
                            '<div class="col-xs-10 col-md-10">'+
                        '<div class="messages msg_receive">'+
                         '<p>'+name+' : '+message+'</p>'+
                       '<time datetime="2009-11-13T20:00">Rajesh M • Yesterday 10:05:41 </time>'+
                       '</div>'+
                      '</div>'+
                  '</div>'

    
                  
                  
        $(receivebody).appendTo("#messagebody");            
                  
   }
   
   // 연결 끊기
    function disconnect() {
       if (stompClient2 !== null) {
           stompClient2.disconnect();
       }
       setConnected(false);
       console.log("Disconnected");
   };
    
   
   
   
   $( "#btn-chat" ).click(function() {
      send()
   });
   
   $('#btn-input').keypress(function (e) {
     if (e.which == 13) {
       send()
     }
   });
   
   
   
   
   
</script>



<!-- 새로운 채팅 추가 js  -->
<script type="text/javascript">
   
   function newopenForm() {
     document.getElementById("pluschatbox").style.display = "block";
     
     map.clear();
     console.log(1);
     
   }

   function newcloseForm() {
     document.getElementById("pluschatbox").style.display = "none";
   }
   
   $(document).on('click', '#pluschat', function (e) {
       var size = $( ".pluschat-window:last-child" ).css("margin-left");
        size_total = parseInt(size) + 400;
       alert(size_total);
       var clone = $( "#pluschat-window" ).clone().appendTo( ".container" );
       clone.css("margin-left", size_total);
   });
   
   $(document).on('click', '.icon_close_new', function (e) {
       //$(this).parent().parent().parent().parent().remove();
       $( "#pluschatbox" ).hide();
   });
   
   
</script>



<!-- 새로운 채팅 = 검색기능 js  -->
<script>
   
   function myFunction() {
      document.getElementById("myDropdown").classList.toggle("plusshow");

   }
   
   function filterFunction() {
     var input, filter, ul, li, a, i;
     
     input = document.getElementById("myInput");
     
     filter = input.value.toUpperCase();
     
     div = document.getElementById("myDropdown");
     a = div.getElementsByTagName("a");
     
     for (i=0; i<a.length; i++) {
       txtValue = a[i].textContent || a[i].innerText;
       if (txtValue.toUpperCase().indexOf(filter) > -1) {
         a[i].style.display = "block";                        /* 검색을 하면 리스트 보이게  */
       } else {
         a[i].style.display = "none";
       }
     }
   }
</script>



<!-- 채팅목록에서 검색 js  -->
<script>

function list_search() {
   
    var input, filter, ul, li, a, i, txtValue;
    input = document.getElementById("listsearch");
    filter = input.value.toUpperCase();
    ul = document.getElementById("alllist");
    li = ul.getElementsByTagName("li");
    
    for (i = 0; i < li.length; i++) {
        a = li[i].getElementsByTagName("a")[0];
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
};


// 단체 채팅 생성
   
   var map =new Map();
   
function startchat(name,id,plusmemberno) {
   
   pulsmember = name+"("+id+")";
   console.log("넘어온 데이터", pulsmember+plusmemberno);
   
   if(map.has(plusmemberno)){
   
      map.delete(plusmemberno);
      var block = document.getElementById(plusmemberno);
      block.style.backgroundColor = "#f6f6f6";

      
   }else{
      map.set(plusmemberno,pulsmember);
   
      var block = document.getElementById(plusmemberno);
      block.style.backgroundColor = "#00bcd4";
      
   }
      console.dir(map);



   
   
   var clickmem = document.getElementById("new-chat"); 
   
   clickmem.style.color = "#497BD9";                  //검색해서 나온 이용자를 클릭 하면 버튼 활성화!
   /* color: #497BD9; 버튼이 파란색으로 바뀐다..... */

   
   
};



// 단채채팅 만들기
$("#new-chat").click(function(){
   var title ="";
   var roomid=[];
      

   if(map.size < 1){
      alert("2명이상 선택해주세요");
      
      // 블록색 원래대로
      var block =document.getElementsByClassName("memberblock");
      
      for(var i = 0 ; i < block.length;i++){
         block[i].style.backgroundColor = "#f6f6f6";
      }
      title ="";
      roomid=[];
      map =new Map();
      
   }else{
   
      for ( let item of map ) {
         title= title+item[1];
         roomid.push(Number(item[0]) );
         }
         roomid.push(Number(document.getElementById("myno").value));   
         title = title+document.getElementById("myname").value;
         console.log(title);
         console.log(roomid.sort(function(a, b) { // 오름차순
          return a - b;
   
      }));
      
      var togetherno = "";
      for(var i = 0 ; i < roomid.length;i++){
         togetherno = togetherno + roomid[i];
      }
      
      console.log(togetherno+"g");
      togetherno = togetherno+"g";
      
      // 창닫고
      document.getElementById("pluschatbox").style.display = "none";
      // 블록색 원래대로
      var block =document.getElementsByClassName("memberblock");
      
      for(var i = 0 ; i < block.length;i++){
         block[i].style.backgroundColor = "#f6f6f6";
      }
      
      
      //backgroundColor = "#f6f6f6";
      //block.style.backgroundColor = "#f6f6f6";
      console.dir(document.getElementById(togetherno));
      
      if(document.getElementById(togetherno) == null){
         
          var aaa=  document.getElementById("panel-title"); 
          aaa.innerText = title;
          $("#messagebody").empty();
      
          // 단체채팅 생성하면 목록에 추가
          var newgroupchat = 
             '<li class="memno" id ="groupchat">'+      
             '<div>'+
                '<h2 class="memname" id='+roomid+'>'+ title+' </h2>'+                  
             '</div>'+
            '</li>';
          
            
      /*       <li class = "memno" id = "groupchat">
            <div id = "groupchat">
               <h2 class="memberno" id="${i.togetherno}"> ${i.roomname} </h2>
         </div>
            </li>    */
            
            
          
          $(newgroupchat).appendTo("#group");   
          
          
             for(var i = 0 ; i < roomid.length;i++){
               
                $.ajax({
                   url: "/chatroom/room/insertgroup",
                   type : "POST",
                   data : {"togetherno":togetherno,
                         "assemblename" : "withh",  //세션에서 어셈블이름 불러와야함
                         "roomname" : title,
                         "memberno": roomid[i]
                   }
                });
             
            } 
      }else {
         
      
         alert("채팅방이 존재합니다.");

          }//null if end

   }// if end
});




</script>





</body>
</html>