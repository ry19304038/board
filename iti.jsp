<%@ page pageEncoding="UTF-8"
	contentType="text/html;charset=Windows-31J" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<!--
#183642
#313D5A
#73628A
#CBC5EA
#EAEAEA
-->

  <head>
    <meta charset = "utf-8">

    <link href="itistyle.css" rel="stylesheet">
    <link href="modal.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap" rel="stylesheet">
    <link href="https://use.fontawesome.com/releases/v5.0.8/css/all.css" rel="stylesheet">
  </head>
  <body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="modal.js"></script>

    <div class="container">
      <div class = "base">
        <div class = "content">
          <div class = "sidebar">
            <div class = "catepic">
              <h1>CPRIME THREAD</h1>
            </div>
            <div class="threadbox">
      				<table border="1">
      					<tr><th>スレッドのタイトル</th>
      					<c:forEach var="prof" items="${ThreadList}">
      						<tr>
      							<td><a href="/myapps22/ResList?th_id=${prof.th_id}">${prof.th_title}</a></td>
      					</c:forEach>
      				</table>
      			</div>
            <div class = "panels">
              <button id="js-show-popup"> Create a new Thread</button>
              <div class="popup" id="js-popup">
                <div class="popup-inner">
                  <h1>スレッドの作成</h1>
            			<form method='post' action='CreateThreadServlet'>
            				スレッドのタイトル<input type='text' name='th_title'required><br>
            				スレッドの作成者<input type='text' name='th_name' required></br>
            			<input type="submit" class = sub value = "create"></button>
            			</form>
                  </div>
                <div class="black-background" id="js-black-bg"></div>

            </div>
          </div>
          </div>
          <div class = "body">
            <div class = "title">
            	<h1></h1>
            </div>
            <div class = "thread">
              <div class = "re_scroller">
                <!--<div class="resBox">-->
          				<table border="1">
          					<tr><th>投稿者</th><th>レスの内容</th><th>レス日</th>
          					<c:forEach var="prof" items="${ResList}">
          						<tr>
          							<td>${prof.res_name}</td>
          							<td>${prof.res_text}</td>
          							<td>${prof.res_date}</td>
          						</c:forEach>
          					</table>
          			<!--</div>-->
              </div>
              </div>
              <div class="createres">
        				<form method='post' action='CPrimeThread'>
        					*name<input type='text' name='res_name' required></br>
                  *message<input type='text' name='res_text' required><br>
        					<input type="hidden"name='id' value='<%=request.getParameter("th_id") %>'>
        					<input type="submit"></button>
        				</form>
        	 </div>
        	 <div class = "hidebox"></div>
            </div>
          </div>
      </div>
    </div>
  </body>
</html>
