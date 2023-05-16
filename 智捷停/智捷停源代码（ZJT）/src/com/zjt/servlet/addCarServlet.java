package com.zjt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjt.entity.car;
import com.zjt.service.carService;
@WebServlet("/addcar")
public class addCarServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/addcar.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName");
		String carLicenseNumber=request.getParameter("carLicenseNumber");
		carService service=new carService();
		if(service.carLicenseNumberexist(carLicenseNumber)){
		car car=new car();
		car.setUserName(userName);
		car.setCarLicenseNumber(carLicenseNumber);
		service.addCar(car);
		response.sendRedirect("mycar");
		}else{
			request.setAttribute("error", "车牌号重复，请重新添加！");
			request.getRequestDispatcher("/addcar.jsp").forward(request, response);
		}


	}

}
