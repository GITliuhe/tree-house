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
import com.zjt.service.parkingLotService;
import com.zjt.service.parkingSpaceService;

@WebServlet("/changeState")
public class ChangeState extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String spaceId= request.getParameter("spaceId");
		String parkingLotId = request.getParameter("parkingLotId");
		parkingLotService plService = new parkingLotService();
		 parkingLot pl = plService.findByParkingLotId(parkingLotId);
		 String pName = pl.getPname();
		parkingSpaceService service = new parkingSpaceService();
		parkingSpace ps=service.findSpaceByspaceId(spaceId);
		
		
		if(ps.getSpaceStatment().equals("1")){
			service.forbiddenSpace(spaceId);
			
		}else{
			service.availableSpace(spaceId);
		}
		
		
		
		//parkingSpace p1 = new parkingSpace();
		//p1.setSpaceId(spaceId);
		//p1.setSpaceStatment(Integer.parseInt(request.getParameter("state")));
		
		//System.out.println(p1.getSpaceId());
		//System.out.println(p1.getSpaceId());
		//System.out.println(p1.getSpaceStatment());
		//System.out.println(p1.getSpaceStatment());
		
		//service.changeState(p1);
		
		List<parkingSpace> parkingSpaceList = service.findAllSpace(parkingLotId);
		request.setAttribute("parkingSpaceList", parkingSpaceList);
		request.setAttribute("pName", pName);
		request.getRequestDispatcher("/spaceDetail.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
