package com.zjt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjt.common.GetMessageCode;




@WebServlet("/sendSMS")
public class sendSMScode extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String phone=request.getParameter("phone");
		System.out.println(phone);
		//根据获取到的手机号发送验证码
		String code=GetMessageCode.getCode(phone); 
		System.out.println(code);
		response.getWriter().print(code);

		
	}

}
