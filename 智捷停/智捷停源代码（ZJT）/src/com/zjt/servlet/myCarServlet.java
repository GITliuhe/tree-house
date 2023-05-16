package com.zjt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjt.entity.car;
import com.zjt.entity.order;
import com.zjt.service.carService;
import com.zjt.service.orderService;

@WebServlet("/mycar")
public class myCarServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName=(String) request.getSession().getAttribute("userName");
		carService service=new carService();
		List<car> carList = service.findCarByUserName(userName);
		
		request.setAttribute("carList",carList);
		request.getRequestDispatcher("/myCarList.jsp").forward(request, response);


	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


	}

}
