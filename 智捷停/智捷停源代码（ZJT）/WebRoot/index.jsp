<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <!-- Bootstrap core CSS -->
    <link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
    body{
        background-image: url(img/2.jpeg);    
        background-size:cover;
    }
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
    <link href="cover.css" rel="stylesheet">
  </head>
  
  <body class="d-flex h-100 text-center text-white bg-dark">
    
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
  <header class="mb-auto">
    <div>
      <h3 class="float-md-start mb-0">智捷停</h3>
      <nav class="nav nav-masthead justify-content-center float-md-end">
        <a class="nav-link active" aria-current="page" href="#"></a>
        <a class="nav-link" href="#"></a>
        <a class="nav-link" href="#"></a>
      </nav>
    </div>
  </header>

  <main class="px-3">
    <h1>智 捷 停 ！</h1>
    <br>
    <p class="lead">开启您的智慧停车之旅！</p>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <p class="lead">
      <a href="login" class="btn btn-lg btn-secondary fw-bold border-white bg-white"><font color="black">登录</font></a>
      <a href="register" class="btn btn-lg btn-secondary fw-bold border-white bg-white"><font color="black">注册</font></a>
      <a href="parkingLotOwnerCooperation" class="btn btn-lg btn-secondary fw-bold border-white bg-white"><font color="black">商家合作</font></a>
     
    </p>
  </main>

  <%@ include file="layout/footer.jsp" %>
</div>
  </body>
</html>
