<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showOrderList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">
  </head>
  
  <body>
  <nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark" aria-label="Main navigation">
  <div class="container-fluid">
    <a class="navbar-brand" href=""><h3>智捷停</h3></a>
    <button class="navbar-toggler p-0 border-0" type="button" data-bs-toggle="offcanvas" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link" href="home">返回主页</a>
        </li>
        

      </ul>
      
    </div>
  </div>
</nav>
<br><br><br>
    <table align="center" class="table table-dark table-striped" >
         <tr>
              <th>订单编号</th>
              <th>用户名称</th>
              <th>车牌号</th>
              <th>车位编号</th>
              <th>停车场名称</th>
              <th>下单时间</th>
              <th>完成时间</th>
              <th>摄像头</th>
              
         </tr>
         <c:forEach items="${orderList}" var="order">
         <tr>
              <td>${order.orderNumber}</td>
              <td>${order.userName}</td>
              <td>${order.carLicenseNumber}</td>
              <td>${order.spaceNumber}</td>
              <td>${order.parkingLot}</td>
              <td>${order.orderDate}</td>
              <td>${order.finishDate}</td>
              <td><a href="spaceLicenseCheck?orderNumber=${order.orderNumber}">车位摄像头</a></td>
         </tr>
         </c:forEach>
       
         
      
      </table>
   
      <%@ include file="layout/footer.jsp" %>


  </body>
</html>
