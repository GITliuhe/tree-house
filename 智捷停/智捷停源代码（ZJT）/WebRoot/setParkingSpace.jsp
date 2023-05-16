<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'setParkingSpace.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/seat.css">
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/seat.js"></script>

  </head>
  
  <body>
    <div id="box">
		<h1>设置车位分布图</h1>
	</div>

	<div class="container" style="margin-top: 10px;">

		<div class="form-inline">
			<button class="btn btn-success" id="save">保存车位图</button>
		</div>

	</div>
  <script>
	var seats = $.seats({
		rows:5,
		cols:15,
		box:"#box",
		"step":1
	});
	$('#save').on('click', function() {
		console.log(seats.getSeats());
		localStorage.setItem("seats", JSON.stringify(seats.getSeats()));
		location.href = "setSpaceNumAndPrice.jsp";
	});
  </script>
  </body>
</html>
