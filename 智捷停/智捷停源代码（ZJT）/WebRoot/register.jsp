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
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
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
 <%@ include file="layout/sendSMScode1.jsp" %>
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
  <form action="register" method="post">
   
    <h1 class="h3 mb-3 fw-normal">Please Regist</h1>
    <label for="inputEmail" class="visually-hidden">用户名</label>
    <input type="text" id="inputEmail" class="form-control" placeholder="用户名" required autofocus name="userName">
    <label for="" class="">性别</label>
    <input type="radio"    required autofocus name="sex" value="男">男
    <input type="radio"   required autofocus name="sex" value="女">女
    <label for="" class="visually-hidden" >密码</label>
    <input type="password" id="inputPassword" class="form-control" placeholder="密码" required name="password1">
    <label for="" class="visually-hidden">确认密码</label>
    <input type="password" id="inputPassword2" class="form-control" placeholder="确认密码" required name="password2">
    <label for="" class="visually-hidden">真实姓名</label>
    <input type="text" id="inputEmail" class="form-control" placeholder="真实姓名" required autofocus name="realName">
    <label for="" class="visually-hidden">手机号</label>
    <input type="text" id="phoneNumber" class="form-control" placeholder="手机号" required autofocus name="phoneNumber">
    <input type="code" class="form-control" id="code" name="code" placeholder="验证码" required>
    <input class="btn btn-success" id="btn" name="btn" value="发送验证码" onclick="sendMessage()" />
    <div class="checkbox mb-3">
      
        <span style="color:red">${error}</span><br>
     
    </div>
    <button class="w-100 btn btn-lg btn-primary" type="button" id="lo">注册</button>
    
  </form>
</main>
<main class="form-signin">
<%@ include file="layout/footer.jsp" %>
</main>
  </body>
  <%@ include file="layout/sendSMScode2.jsp" %>
</html>

