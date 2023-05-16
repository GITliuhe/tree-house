package com.zjt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjt.entity.parkingLot;
import com.zjt.entity.parkingSpace;
import com.zjt.service.parkingSpaceService;


@WebServlet("/AddparkingSpace")
public class AddparkingSpace extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String parkingLotId = (String)request.getSession().getAttribute("parkingLotId");;
		String pName = (String) request.getSession().getAttribute("pName");
		request.setAttribute("parkingLotId", parkingLotId);
		request.getRequestDispatcher("/AddparkingSpace.jsp").forward(request, response);		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		System.out.println(id);
		//1. 接收表单数据
		parkingSpace pSpace = new parkingSpace();
		pSpace.setParkingLotId(id);
		pSpace.setSpaceNumber(request.getParameter("spaceNum"));
		
		pSpace.setRates(request.getParameter("rates"));
		
		parkingSpaceService service = new parkingSpaceService();

		service.addParkingSpace(pSpace);
		
		List<parkingSpace> parkingSpaceList = service.findAllSpace(id);
	    request.setAttribute("parkingSpaceList", parkingSpaceList);
		request.getRequestDispatcher("/parkingLotOwnerHome1.jsp").forward(request, response);
	}

}
