package com.zjt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjt.entity.user;
import com.zjt.service.userService;


@WebServlet("/register")
public class registerServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/register.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName");
		String passwd1=request.getParameter("password1");
		String passwd2=request.getParameter("password2");
		String realName=request.getParameter("realName");
		String sex=request.getParameter("sex");
		String phoneNumber=request.getParameter("phoneNumber");
		
		userService service= new userService();
		user user= new user();
    	
		
            if(service.registVerify(userName, passwd1, passwd2)){
            	if(service.exist(userName)){
            	
            	user.setUserName(userName);
            	user.setPasswords(passwd1);
            	user.setRealName(realName);
            	user.setSex(sex);
            	user.setPhoneNUmber(phoneNumber);
            	
            	
            	
            	service.addUser(user);
            	
    			
    			
    			response.sendRedirect("login");
            	}else{
            		request.setAttribute("userName", userName);
            		request.setAttribute("error", "此用户名已存在");
            		request.getRequestDispatcher("/register.jsp").forward(request, response);
            	}
            
            }
            else{
            	request.setAttribute("userName", userName);
            	request.setAttribute("error","用户名或密码格式错误！！！");
            	request.getRequestDispatcher("/register.jsp").forward(request, response);
            	
            }

	}

}
