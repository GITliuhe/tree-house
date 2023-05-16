<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'setChargeLevel.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	  <style>
     
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">

  </head>
  
  <body class="text-center">
    <main class="form-signin">
  <form action="chargeLevel" method="post">
   
    <h1 class="h3 mb-3 fw-normal">Please Set Your ChargeLevel</h1>
    <label for="inputEmail" class="visually-hidden">停车场ID：</label>
     <input type="text" id="inputEmail" class="form-control"  readonly="true" autofocus name="pId" value="${parkinglotId}">
    <br>
    <label for="inputEmail" class="visually-hidden">停车场名：</label>
     <input type="text" id="inputEmail" class="form-control"  readonly="true" autofocus name="pName" value="${pName}">
    <br>
    <label for="" class="visually-hidden">免费时长（分钟）:</label>
    <input type="text" id="inputEmail" class="form-control"  required autofocus name="freeTime" value="${chargeLevel.mianfeiTime}">
    <br>
    <label for="inputEmail" class="visually-hidden">收费基数（分钟）:</label>
     <input type="text" id="inputEmail" class="form-control"  required autofocus name="chargeTime" value="${chargeLevel.shoufeiTime}">
    <br>
    <label for="inputEmail" class="visually-hidden">收费金额（基数）:</label>
    <input type="text" id="inputEmail" class="form-control"  required autofocus name="chargeLevel" value="${chargeLevel.shoufeiMoney}">
    
   
    <div class="checkbox mb-3">
      
        <span style="color:red">${Message}</span><br>
     
    </div>
    <button class="w-100 btn btn-lg btn-primary" type="submit">设置</button>
    
  </form>
</main>
<main class="form-signin">
<%@ include file="layout/footer.jsp" %>
</main>
  </body>
</html>
