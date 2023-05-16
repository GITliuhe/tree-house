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
    
    <title>My JSP 'reserveParkingSpace.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- Bootstrap core CSS -->
    <link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/seat.css" type="text/css" rel="stylesheet" />
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="js/layer-v3.0.3/layer/mobile/need/layer.css" rel="stylesheet" type="text/css" />
    <link href="js/layer-v3.0.3/layer/mobile/need/layer.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="js/phone.js" ></script>
    <script type="text/javascript" src="js/layer-v3.0.3/layer/mobile/layer.js"></script>

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
    <link href="css/form-validation.css" rel="stylesheet">

  </head>
  
  <body class="bg-light">
    
<div class="container">
  <main>
    <div class="py-5 text-center">
      <img class="d-block mx-auto mb-4" src="img/2.jpeg" alt="" width="72" height="57">
      <h2>预订车位</h2>
      <p class="lead">智捷停！带您体验便捷生活！</p>
    </div>   
     <hr class="my-4">
    <div class="row g-3 "  >
      <div class="col-md-12 col-lg-12 ">
        <h4 class="mb-3">您的订单</h4>
        <form class="needs-validation" action="reserveParkingSpace" method="post">
          <div class="row g-3">
            <div class="col-sm-6">
              <label for="firstName" class="form-label">用户名</label>
              <input type="text" class="form-control" id="firstName" placeholder="" value="${userName}" required name="userName">
              <div class="invalid-feedback">
                Valid first name is required.
              </div>
            </div>

            <div class="col-sm-6">
              <label for="lastName" class="form-label">停车场</label>
              <input type="text" class="form-control" id="lastName" placeholder="" value="${pname}" required name="pname">
              <div class="invalid-feedback">
                Valid last name is required.
              </div>
            </div>

            <div class="col-md-6">
              <label for="country" class="form-label">选择预订车辆</label>
              <select class="form-select" id="country" required name="carLicenseNumber">
                <option value="">选择您的车辆</option>
                <c:forEach items="${carList}" var="car">
                     <option values="${car.carLicenseNumber}">${car.carLicenseNumber}</option>
                </c:forEach>
              </select>
              <div class="invalid-feedback">
                Please select a valid country.
              </div>
            </div>
            <div class="col-md-6">
              <label for="state" class="form-label">选择预订车位</label>
              <select class="form-select" id="state" required name="spaceId">
                <option value="">选择车位</option>
                <c:forEach items="${spaceList}" var="space">
                     <option value="${space.spaceId}">${space.spaceNumber}</option>
                </c:forEach>
              </select>
              <div class="invalid-feedback">
                Please provide a valid state.
              </div>
            </div>
          </div>
          <hr class="my-4">
          <button class="w-100 btn btn-primary btn-lg" type="submit">提交订单</button>
        </form>
      </div>
    </div>
  </main>

  <footer class="my-5 pt-5 text-muted text-center text-small">
    <%@ include file="layout/footer.jsp" %>
  </footer>
</div>


         <script src="js/jquery-1.12.4.js" type="text/javascript"></script>
    <script src="assets/dist/js/bootstrap.bundle.min.js"></script>

      <script src="js/form-validation.js"></script>
      
   

      
  </body>
</html>
