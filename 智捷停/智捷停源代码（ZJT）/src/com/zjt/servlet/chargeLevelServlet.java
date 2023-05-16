package com.zjt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjt.entity.chargeLevel;
import com.zjt.entity.parkingLot;
import com.zjt.service.chargeLevelService;
import com.zjt.service.parkingLotService;


@WebServlet("/chargeLevel")
public class chargeLevelServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parkinglotId = (String) request.getSession().getAttribute("parkingLotId");
		
		
		
		chargeLevelService clservice = new chargeLevelService();	
		chargeLevel cl = clservice.findByparkingLotId(parkinglotId);

		parkingLotService service = new parkingLotService(); 
		parkingLot pl = service.findByParkingLotId(parkinglotId);
		String pName = pl.getPname();
		
		
		if(cl.getMianfeiTime() == 0){
		
			
			request.setAttribute("parkinglotId", parkinglotId);
			request.setAttribute("pName", pName);
			request.setAttribute("Message", "这是您第一次设置您的收费标准！！！");
			request.getRequestDispatcher("/setChargeLevel.jsp").forward(request, response);
		}else{
			request.setAttribute("parkinglotId", parkinglotId);
			request.setAttribute("pName", pName);
			request.setAttribute("chargeLevel", cl);
			request.setAttribute("Message", "您可以修改您的收费标准！");
			request.getRequestDispatcher("/setChargeLevel.jsp").forward(request, response);
		}
		

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String parkingLotId=request.getParameter("pId");
		String pName=request.getParameter("pName");
		String freeTime=request.getParameter("freeTime");
		String chargeTime=request.getParameter("chargeTime");
		String chargeLevel=request.getParameter("chargeLevel");
		
		chargeLevelService service = new chargeLevelService();	
		chargeLevel cl = service.findByparkingLotId(parkingLotId);
		
		if(cl.getMianfeiTime() == 0){
			service.addChargeLevel(parkingLotId,pName,freeTime,chargeTime,chargeLevel);
			request.getRequestDispatcher("/setChargeLevelSuccessful.jsp").forward(request, response);
			
		}else{
			service.modifyChargeLevelByParkingLotId(parkingLotId,freeTime,chargeTime,chargeLevel);
			request.getRequestDispatcher("/setChargeLevelSuccessful.jsp").forward(request, response);
			
		}

		
	}

}
