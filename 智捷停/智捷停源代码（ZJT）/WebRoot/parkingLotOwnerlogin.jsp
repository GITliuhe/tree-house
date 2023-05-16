<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
    <link href="css/signin.css" rel="stylesheet">

  </head>
  
  <body class="text-center">
  <nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark" aria-label="Main navigation">
  <div class="container-fluid">
    <a class="navbar-brand" href=""><h3>智捷停</h3></a>
    <button class="navbar-toggler p-0 border-0" type="button" data-bs-toggle="offcanvas" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link" href="index.jsp">返回首页</a>
        </li>
      </ul>
      
    </div>
  </div>
</nav> 
<main class="form-signin">
  <form action="parkingLotOwnerlogin" method="post">
   
    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
    <input type="text" id="inputEmail" class="form-control" placeholder="您的ID" required autofocus name="ownerId">
    <input type="text" id="inputPassword" class="form-control" placeholder="您的合作手机号" required name="phoneNumber">
    <div class="checkbox mb-3">
       <span style="color:red">${error}</span><br>
    </div>
    <button class="w-100 btn btn-lg btn-primary" type="submit">验证</button>
    
  </form>
</main>
<main class="form-signin">
<%@ include file="layout/footer.jsp" %>
</main>
  </body>
</html>

