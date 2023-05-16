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
    <link href="css/signin.css" rel="stylesheet">

  </head>
  
  <body class="text-center">
    
<main class="form-signin">
  <form >
   
    <h1 class="h3 mb-3 fw-normal">设置成功!</h1>
    
    <h2 class="h3 mb-3 fw-normal">点击“继续”，返回主菜单</h2>
    
    <button class="w-100 btn btn-lg btn-primary" type="button"><a href="parkingLotOwnerHome"><font color="white">继续</font></a></button>
    
  </form>
</main>
<main class="form-signin">
<%@ include file="layout/footer.jsp" %>
</main>
  </body>
</html>