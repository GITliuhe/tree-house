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

@WebServlet("/searchParkingLot")
public class searchParkingLotServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String location=request.getParameter("location");
		parkingLotService service = new parkingLotService();
		List<parkingLot> parkingLotList = service.findAllparkingLotByLocation(location);
		
		request.setAttribute("parkingLotList", parkingLotList);
		request.getRequestDispatcher("/homepage.jsp").forward(request, response); 

	}

}
