<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addParkingLot.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">
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
  <form action="addParkingLot" method="post">
   
    <h1 class="h3 mb-3 fw-normal">Please Add your ParkingLot</h1>
    <table>
    <tr>
    <td><label for="inputEmail" class="visually-hidden">停车场名</label></td>
    <td><input type="text" id="inputEmail" class="form-control" placeholder="停车场名" required autofocus name="pName"></td>
    </tr>
    <tr>
    <td><label for="" class="visually-hidden">位置</label></td>
    <td><input type="text" id="inputEmail" class="form-control" placeholder="位置" required autofocus name="pLocation"></td>
    </tr>
    <tr>
    <td><label for="inputEmail" class="visually-hidden">车位数</label></td>
    <td><input type="text" id="inputEmail" class="form-control" placeholder="车位数" required autofocus name="parkingSpaceQuatity"></td>
    </tr>
    <tr>
    <td><label for="inputEmail" class="visually-hidden">收费标准</label></td>
    <td><input type="text" id="inputEmail" class="form-control" placeholder="收费标准" required autofocus name="rates"></td>
    </tr>
    
    </table>
    
    <div class="checkbox mb-3">
      
        <span style="color:red">${Message}</span><br>
     
    </div>
    <button class="w-100 btn btn-lg btn-primary" type="submit">添加</button>
    
  </form>
</main>
<main class="form-signin">
<%@ include file="layout/footer.jsp" %>
</main>
  </body>
</html>
