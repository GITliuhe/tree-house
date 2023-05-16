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
 <%@ include file="layout/header.jsp" %>   
<main class="form-signin">
  <form method="post">
   
    <button class="w-100 btn btn-lg btn-primary" type="button"><a href="parkingLotOwnerRegister"><font color="white">我要合作</font></a></button><br><br><br>
    <button class="w-100 btn btn-lg btn-primary" type="button"><a href="parkingLotOwnerlogin"><font color="white">我已合作</font></a></button>
    
  </form>
</main>
<main class="form-signin">
<%@ include file="layout/footer.jsp" %>
</main>
  </body>
</html>