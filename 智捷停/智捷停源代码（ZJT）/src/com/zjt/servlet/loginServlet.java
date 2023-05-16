package com.zjt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zjt.service.userService;


@WebServlet("/login")
public class loginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		       //1.取得用户提交的用户名和密码
				String userName=request.getParameter("userName");
				String password=request.getParameter("password");

				//2.创建一个service对象
				userService service= new userService();
				
				//3.验证登录信息
				if(service.loginVerify(userName, password)){
					
					//将用户名存入会话
				    HttpSession session = request.getSession();
				    session.setAttribute("userName",userName);
					
				    response.sendRedirect("home");
				       
					}
					else{
						
						request.setAttribute("userName", userName);
						request.setAttribute("error", "用户名或密码错误");
						request.getRequestDispatcher("/login.jsp").forward(request, response);
					}

	}

}
