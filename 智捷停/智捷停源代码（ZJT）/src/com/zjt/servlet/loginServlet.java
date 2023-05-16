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
		       //1.ȡ���û��ύ���û���������
				String userName=request.getParameter("userName");
				String password=request.getParameter("password");

				//2.����һ��service����
				userService service= new userService();
				
				//3.��֤��¼��Ϣ
				if(service.loginVerify(userName, password)){
					
					//���û�������Ự
				    HttpSession session = request.getSession();
				    session.setAttribute("userName",userName);
					
				    response.sendRedirect("home");
				       
					}
					else{
						
						request.setAttribute("userName", userName);
						request.setAttribute("error", "�û������������");
						request.getRequestDispatcher("/login.jsp").forward(request, response);
					}

	}

}
