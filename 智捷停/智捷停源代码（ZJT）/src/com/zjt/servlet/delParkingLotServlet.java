package com.zjt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjt.entity.parkingLot;
import com.zjt.service.orderService;
import com.zjt.service.parkingLotService;

@WebServlet("/delParkingLot")
public class delParkingLotServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		parkingLot pl=new parkingLot();
		String parkingLotId=(String)request.getParameter("parkingLotId");
		pl.setParkingLotId(request.getParameter("parkingLotId"));
		
		//2. 检查数据
		
		parkingLotService service = new parkingLotService();

		
		
		//3. 删除停车场
		pl = service.delParkingLot(pl);
		
		request.setAttribute("parkingLot", pl);
		request.getRequestDispatcher("/delParkingLotSuccess.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
