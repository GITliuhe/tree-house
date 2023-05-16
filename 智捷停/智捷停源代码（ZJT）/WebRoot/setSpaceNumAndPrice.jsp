<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'setSpaceNumAndPrice.jsp' starting page</title>
    
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
	<link rel="stylesheet" href="css/spectrum.css">
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/spectrum.js"></script>
	<script src="js/JDialog.min.js"></script>
	<script src="js/seat.js"></script>

  </head>
  
  <body>
    <div id="box">
		<h1>设置车位编码和单价</h1>
	</div>

	<div class="container" style="margin-top: 10px;">

		<div class="form-inline">
			<label>单价</label>
			<input type="text" class="form-control" id="price" value="100" placeholder="单价">
			<label>车位编码</label>
			<input type="text" class="form-control" id="spaceNumber" value="Axxx" placeholder="车位编码">
			<button class="btn btn-info" id="set-price">设置</button>
			<a href="step3.html" class="btn btn-success">保存设置</a>
		</div>

	</div>
<script>
	try {
		var datas = JSON.parse(localStorage.getItem("seats"));
	} catch (e){}
	var seats = $.seats({
		box:"#box",
		step:2,
		datas:datas
	});

	$('#set-price').on('click', function() {
		var spaceNumber = $('#spaceNumber').val();
		var price = $('#price').val();
		seats.setPrice(price, spaceNumber);
		//更新座位信息
		localStorage.setItem("seats", JSON.stringify(seats.getSeats()));
		JDialog.msg({type:"ok", content:"更新票价成功.", container:"#box"});
	});

	
</script>
  </body>
</html>
