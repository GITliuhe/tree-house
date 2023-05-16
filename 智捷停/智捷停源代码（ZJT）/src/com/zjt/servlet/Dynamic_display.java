package com.zjt.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zjt.common.getMonday;
import com.zjt.common.getSunday;
import com.zjt.entity.parkingLot;
import com.zjt.entity.parkingSpace;
import com.zjt.service.orderService;
import com.zjt.service.parkingLotService;
import com.zjt.service.parkingSpaceService;


@WebServlet("/Dynamic_display")
public class Dynamic_display extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 
		 
		 
		 String parkinglotId = request.getParameter("parkingLotId");
		 
		 parkingLotService plService = new parkingLotService();
		 parkingLot pl = plService.findByParkingLotId(parkinglotId);
		 String pName = pl.getPname();
		 
		 HttpSession session = request.getSession();
		 session.setAttribute("parkingLotId",parkinglotId);
		 session.setAttribute("pName", pName);
		 
		 String l = (String) session.getAttribute("parkingLotId");
		 String n = (String) session.getAttribute("pName");
		 
		 System.out.println("停车场ID："+l);
		 System.out.println("停车场名称："+n);
		 
		 
		 parkingSpaceService service = new parkingSpaceService();
		 
		 List<parkingSpace> parkingSpaceList = service.findAllSpace(parkinglotId);
		 
		 request.setAttribute("parkinglotId", parkinglotId);
		 request.setAttribute("parkingSpaceList", parkingSpaceList);
		 request.setAttribute("pName", pName);
     	 request.getRequestDispatcher("/parkingLotOwnerHome1.jsp").forward(request, response);

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
