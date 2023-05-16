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

@WebServlet("/manageParkingLot")
public class manageParkingLotServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		parkingLot pl=new parkingLot();
		parkingLotService service = new parkingLotService();
			String ownerId = (String) request.getSession().getAttribute("ownerId");
		
		pl.setOwnerId(ownerId);
	
			
			
			List<parkingLot> parkingLotList=service.findAllowner(ownerId);
			request.setAttribute("parkingLotList", parkingLotList);
			
			request.getRequestDispatcher("/manageParkingLot.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
