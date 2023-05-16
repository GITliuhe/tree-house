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
    
    <title>My JSP 'homepage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- Bootstrap core CSS -->
    <link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
    a{text-decoration:none}
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
    <link href="css/offcanvas.css" rel="stylesheet">

  </head>
  
<body class="bg-light">
    
<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark" aria-label="Main navigation">
  <div class="container-fluid">
    <a class="navbar-brand" href=""><h3>智捷停</h3></a>
    <button class="navbar-toggler p-0 border-0" type="button" data-bs-toggle="offcanvas" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link" href="orderlist">全部订单</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="unUsedOrder">待使用订单</a>
        </li>
        
        <li class="nav-item">
          <a class="nav-link" href="mybill">我的账单</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="myUnpayedbill">我的未支付账单</a>
        </li>
        
        <li class="nav-item">
          <a class="nav-link" href="mycar">我的车辆</a>
        </li>
        <li class="nav-item">

          <a class="nav-link" href="logout">退出登录</a>
        </li>

      </ul>
      <form class="d-flex" action="searchParkingLot" method="post">
        <input class="form-control me-2" type="text" placeholder="输入您的目的地"  name="location">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
      <span class="headsp">
      	<img src="${pageContext.request.contextPath }/img/icon-user.png" >
      	<font color="white">${userName}</font>
      </span>
      	
    </div>
  </div>
</nav>



<main class="container">
  <div class="d-flex align-items-center p-3 my-3 text-white bg-purple rounded shadow-sm">
    <img class="me-3" src="img/2.jpeg" alt="" width="48" height="38">
    <div class="lh-1">
      <h1 class="h6 mb-0 text-white lh-1">智捷停</h1>
      <small>Since 2020</small>
    </div>
      
  </div>

  <div class="my-3 p-3 bg-white rounded shadow-sm">
    <h6 class="border-bottom pb-2 mb-0">停车场列表</h6>
    <c:forEach items="${parkingLotList}" var="parkingLot">
    <div class="d-flex text-muted pt-3">
      <svg class="bd-placeholder-img flex-shrink-0 me-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#007bff"/><text x="50%" y="50%" fill="#007bff" dy=".3em">32x32</text></svg>

      <p class="pb-3 mb-0 small lh-sm border-bottom">
      <strong class="d-block text-gray-dark">${parkingLot.pname}</strong>
           地址：${parkingLot.plocation},车位总数：${parkingLot.parkingSpaceQuatity},收费标准：${parkingLot.rates}<br>
      <br><a href="reserveParkingSpace?parkingLotId=${parkingLot.parkingLotId}&pname=${parkingLot.pname}&rates=${parkingLot.rates}"> <strong class="d-block text-gray-dark">预订车位</strong></a><br>
      <a href="videoPlay?parkingLotId=${parkingLot.parkingLotId}">停车场出入口摄像头</a>
      </p>
    </div>
     </c:forEach>
    
    
    
  </div>

  <div class="my-3 p-3 bg-white rounded shadow-sm">
      <%@ include file="layout/footer.jsp" %>
  </div>
</main>


    <script src="assets/dist/js/bootstrap.bundle.min.js"></script>

      <script src="js/offcanvas.js"></script>
 </body>
</html>
