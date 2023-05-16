package com.zjt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjt.entity.parkingLot;
import com.zjt.service.parkingLotService;

@WebServlet("/modifyParkingLot")
public class modifyParkingLotServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parkingLotId = request.getParameter("parkingLotId");

		parkingLotService service = new parkingLotService();
		parkingLot parkingLot = service.findByParkingLotId(parkingLotId);
		request.setAttribute("parkingLot", parkingLot);
		request.getRequestDispatcher("/modifyParkingLot.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		parkingLot pl = new parkingLot();
		pl.setParkingLotId(request.getParameter("parkingLotId"));
		pl.setPname(request.getParameter("pName"));
		pl.setPlocation(request.getParameter("pLocation"));
		pl.setParkingSpaceQuatity(request.getParameter("parkingSpaceQuatity"));
		pl.setRates(request.getParameter("rates"));
		
				
		//2. 检查数据
		
		parkingLotService service = new parkingLotService();
		
		
		
		//3. 修改停车场信息
		pl = service.updateparkingLot(pl);
		String parkingLotId = request.getParameter("parkingLotId");
		parkingLot newpl = service.findByParkingLotId(parkingLotId);
		request.setAttribute("pl", newpl);
		request.getRequestDispatcher("/modifyParkingLotSuccess.jsp").forward(request, response);
		
	}
		
	}


