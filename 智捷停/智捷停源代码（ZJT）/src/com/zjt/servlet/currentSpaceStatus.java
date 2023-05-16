package com.zjt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjt.service.parkingSpaceService;


@WebServlet("/currentSpaceStatus")
public class currentSpaceStatus extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parkingLotId = (String)request.getSession().getAttribute("parkingLotId");;
		String pName = (String) request.getSession().getAttribute("pName");;
		 parkingSpaceService service = new parkingSpaceService();
		 int sumOfspace = service.findSumSpaceByparkingLotId(parkingLotId);
		 int orderedSpace = service.findOrderedSpaceByparkingLotId(parkingLotId);
		 int availableSpace=sumOfspace-orderedSpace;
		 request.setAttribute("orderedSpace", orderedSpace);
		 request.setAttribute("availableSpace", availableSpace);
		 request.setAttribute("pName", pName);
		 request.getRequestDispatcher("/currentSpaceStatus.jsp").forward(request, response);

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
