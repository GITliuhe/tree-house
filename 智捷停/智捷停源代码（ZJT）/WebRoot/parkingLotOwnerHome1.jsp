<%@ page language="java" import="java.util.*" import="com.zjt.entity.parkingLot"  import="com.zjt.entity.parkingSpace" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'parkingLotOwnerHome.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- Bootstrap core CSS -->
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
    <link href="css/dashboard.css" rel="stylesheet">
    <link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://echarts.baidu.com/build/dist/echarts.js"></script>

  </head>
  
  <body>
   <% 
   List<parkingSpace> parkingSpaceList=(List<parkingSpace>)request.getAttribute("parkingSpaceList");
   %>
<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
  <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#"><h3>智捷停</h3></a>
  <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
  <ul class="navbar-nav px-3">
    <li class="nav-item text-nowrap">
      <a class="nav-link" href="parkingLotOwnerHome">退出停车场</a>
    </li>
  </ul>
</header>

<div class="container-fluid">
  <div class="row">
    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
      <div class="position-sticky pt-3">
        <ul class="nav flex-column">
          <li class="nav-item">
            <a class="nav-link" href="AddparkingSpace?id=${parkinglotId}">
              <span data-feather="shopping-cart"></span>
              添加停车位
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="chargeLevel?parkinglotId=${parkinglotId}">
              <span data-feather="bar-chart-2"></span>
              设置收费标准
            </a>
          </li>
        </ul>

        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
          <span>Saved reports</span>
          <a class="link-secondary" href="#" aria-label="Add a new report">
            <span data-feather="plus-circle"></span>
          </a>
        </h6>
        <ul class="nav flex-column mb-2">
          <li class="nav-item">
            <a class="nav-link" href="spaceDetail?parkingLotId=${parkinglotId}">
              <span data-feather="file-text"></span>
                        停车位详情
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="currentSpaceStatus?parkingLotId=${parkinglotId}">
              <span data-feather="file-text"></span>
                       车位实时状态
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="weekOrder">
              <span data-feather="file-text"></span>
                     本周订单详情
            </a>
          </li>
        </ul>
      </div>
    </nav>

    <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">停车位</h1>
        <div class="btn-toolbar mb-2 mb-md-0">
          <div class="btn-group me-2">
            
          </div>
     
          已选择停车场: ${pName}
        </div>
      </div>
      
    <div class="container-fluid">
      <div class="row">
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          
          
          
          
        </div>
      </div>
    </div>

      <!--<canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>-->

      
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th>车位id</th>
              <th>停车场id</th>
              <th>停车位标识</th>
              <th>车位状态</th>
              <th>操作</th>
            </tr>
          </thead>
          <tbody>   
                  
          	<% 
 				for (parkingSpace parkingSpace:parkingSpaceList){
 			%>
            <tr>
              <td><%=parkingSpace.getSpaceId()%></td>
              <td><%=parkingSpace.getParkingLotId()%></td>
              <td><%=parkingSpace.getSpaceNumber()%></td>
              <td><%=parkingSpace.getSpaceStatment()%></td>
              <td><a href="changeState?spaceId=<%=parkingSpace.getSpaceId()%>&state=<%=parkingSpace.getSpaceStatment()%>&parkingLotId=<%=parkingSpace.getParkingLotId()%>">修改车位状态</a></td>
            </tr>
            <% 
            	}
            %>
            
          </tbody>
        </table>
      </div>
    </main>
  </div>
</div>


    <script src="assets/dist/js/bootstrap.bundle.min.js"></script>
	<script src="assets/dist/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="js/dashboard.js"></script>
  </body>
  
</html>