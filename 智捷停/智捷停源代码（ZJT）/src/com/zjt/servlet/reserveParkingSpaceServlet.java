package com.zjt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjt.entity.bill;
import com.zjt.entity.car;
import com.zjt.entity.order;
import com.zjt.entity.parkingSpace;
import com.zjt.entity.user;
import com.zjt.service.billService;
import com.zjt.service.carService;
import com.zjt.service.orderService;
import com.zjt.service.parkingSpaceService;
import com.zjt.service.userService;


@WebServlet("/reserveParkingSpace")
public class reserveParkingSpaceServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    String parkingLotId=request.getParameter("parkingLotId");	
	    String userName = (String) request.getSession().getAttribute("userName");
	    String pname = request.getParameter("pname");
	    pname=new  String(pname.getBytes("ISO-8859-1"),"UTF-8");
	    String rates = request.getParameter("rates");
	    rates=new  String(rates.getBytes("ISO-8859-1"),"UTF-8");
	    
	    carService cservice = new carService();
	    parkingSpaceService pservice = new parkingSpaceService();
	    
	    List<car> carList = cservice.findCarByUserName(userName);
	    List<parkingSpace> spaceList = pservice.findSpaceByplId(parkingLotId);
	    
		request.setAttribute("userName", userName);
		request.setAttribute("pname", pname);
		request.setAttribute("carList", carList);
		request.setAttribute("spaceList", spaceList);
		request.setAttribute("rates", rates);
		request.getRequestDispatcher("/reserveParkingSpace.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName");
		String carLicenseNumber=request.getParameter("carLicenseNumber");
		String spaceId = request.getParameter("spaceId");
		String parkingLot = request.getParameter("pname");
		
		
		orderService oservice = new orderService();
		userService uService = new userService();
		parkingSpaceService pservice = new parkingSpaceService();
		parkingSpace ps = pservice.findSpaceByspaceId(spaceId);
		String SpaceNumber = ps.getSpaceNumber();
		billService bService = new billService();
		
		bill billInfo = bService.findBillInfoByCarLicenseNumber(carLicenseNumber);
		order orderInfo = oservice.findOrderInfoByCarLicenseNumber(carLicenseNumber);
		
		if(billInfo.getBillNumber()==null){
			if(orderInfo.getOrderNumber()==null){
			
				user user = uService.showInfo(userName);
				String phoneNumber = user.getPhoneNUmber();
				pservice.updateSpaceStatment(spaceId);
				oservice.createOrder(userName,carLicenseNumber,spaceId,phoneNumber,SpaceNumber,parkingLot);
				
				request.getRequestDispatcher("/reserveSuccess.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("/banReserveFororder.jsp").forward(request, response);
			}
		}else{
			request.getRequestDispatcher("/banReserveForBill.jsp").forward(request, response);
		}
		
		

	}

}
