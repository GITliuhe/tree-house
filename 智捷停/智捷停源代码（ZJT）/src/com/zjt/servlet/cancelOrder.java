package com.zjt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjt.entity.bill;
import com.zjt.entity.chargeLevel;
import com.zjt.entity.order;
import com.zjt.service.billService;
import com.zjt.service.chargeLevelService;
import com.zjt.service.orderService;
import com.zjt.service.parkingSpaceService;



@WebServlet("/cancelOrder")
public class cancelOrder extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String orderNumber = request.getParameter("orderId");

		String orderDate = request.getParameter("orderDate");
	
		String userName = (String) request.getSession().getAttribute("userName");
		
		String carLicenseNumber = request.getParameter("carLicenseNumber");
		carLicenseNumber=new  String(carLicenseNumber.getBytes("ISO-8859-1"),"UTF-8");
		
		String spaceId = request.getParameter("spaceId");
		
		parkingSpaceService plService = new parkingSpaceService();
		String parkingLotId = plService.findParkingLoIdBySpaceId(spaceId);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		float carFee = 0;
		float parkignTime = 0;
		
		parkingSpaceService pService = new parkingSpaceService();
		chargeLevelService clService = new chargeLevelService();
		chargeLevel cl = clService.findByparkingLotId(parkingLotId);
		
		orderService odService = new orderService();
		billService bService = new billService();
		
		order orderInfo = odService.findCancelOrderTime(orderNumber,orderDate);
		parkignTime = orderInfo.getStatus()-cl.getMianfeiTime();
		
		
		if(parkignTime <= 0){
			odService.updateOrderStatus(orderNumber);
			odService.updateOrderFinishDate(orderNumber);
			pService.availableSpace(spaceId);
			request.getRequestDispatcher("freeCancle.jsp").forward(request, response);
			
		}else{
			String remark= "已取消订单超时费用";
			carFee = (float)Math.ceil(parkignTime/cl.getShoufeiTime())*cl.getShoufeiMoney();
			bill billOut = new bill();
			billOut.setCarFee((int) carFee);
			billOut.setMinutes((int) parkignTime);
			billOut.setInTime(orderDate);
			billOut.setOutTime(sdf.format(new Date()));
			billOut.setRemark(remark);
			billOut.setCarLicenseNumber(carLicenseNumber);
			billOut.setUserName(userName);
			bService.createCancelOrderBill(billOut);
			odService.updateOrderStatus(orderNumber);
			odService.updateOrderFinishDate(orderNumber);
			pService.availableSpace(spaceId);
			request.getRequestDispatcher("chargeCancle.jsp").forward(request, response);
		}
		
		

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
