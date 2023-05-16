package com.zjt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjt.entity.car;
import com.zjt.service.carService;
@WebServlet("/delCar")
public class delCarServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			car c1=new car();
			String carLicenseNumber=request.getParameter("carLicenseNumber");
			carLicenseNumber=new  String(carLicenseNumber.getBytes("ISO-8859-1"),"UTF-8"); 
			
			System.out.println(carLicenseNumber);
			c1.setCarLicenseNumber(carLicenseNumber);
			
			carService service= new carService();
			c1=service.delCar(c1);
			
			request.getRequestDispatcher("/delCarSuccess.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


	}

}
