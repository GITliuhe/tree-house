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
import com.zjt.entity.parkingSpace;
import com.zjt.service.parkingLotService;
import com.zjt.service.parkingSpaceService;


@WebServlet("/spaceDetail")
public class spaceDetail extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parkingLotId = (String)request.getSession().getAttribute("parkingLotId");;
		String pName = (String) request.getSession().getAttribute("pName");
		parkingLotService plService = new parkingLotService();
		 parkingLot pl = plService.findByParkingLotId(parkingLotId);
		parkingSpaceService service = new parkingSpaceService();
		List<parkingSpace> parkingSpaceList = service.findAllSpace(parkingLotId);
		request.setAttribute("parkingSpaceList", parkingSpaceList);
		request.setAttribute("parkingLotId", parkingLotId);
		request.setAttribute("pName", pName);
		request.getRequestDispatcher("/spaceDetail.jsp").forward(request, response);

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
