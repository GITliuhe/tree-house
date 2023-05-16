package com.zjt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjt.entity.parkingLot;
import com.zjt.service.parkingLotService;






@WebServlet("/home")
public class homeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = (String) request.getSession().getAttribute("userName");
		
		if(userName!=null){
		parkingLotService service = new parkingLotService();
		List<parkingLot> parkingLotList = service.findAllparkingLot();
		
		request.setAttribute("parkingLotList", parkingLotList);
		request.setAttribute("userName", userName);
		request.getRequestDispatcher("/homepage.jsp").forward(request, response); 
		}else{
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
