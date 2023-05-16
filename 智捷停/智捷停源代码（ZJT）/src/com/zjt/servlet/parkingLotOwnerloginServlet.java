package com.zjt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zjt.entity.parkingLot;
import com.zjt.entity.parkingSpace;
import com.zjt.service.parkingLotOwnerService;
import com.zjt.service.parkingLotService;
import com.zjt.service.userService;


@WebServlet("/parkingLotOwnerlogin")
public class parkingLotOwnerloginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/parkingLotOwnerlogin.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ownerId=request.getParameter("ownerId");
		String phoneNumber=request.getParameter("phoneNumber");

		
		parkingLotOwnerService ploService= new parkingLotOwnerService();
		
		
		if(ploService.loginVerify(ownerId, phoneNumber)){
			
			
		    HttpSession session = request.getSession();
		    session.setAttribute("ownerId",ownerId);
		    
		    String ownerName =ploService.getNameByid(ownerId) ;
		    
		    session.setAttribute("ownerName", ownerName);
			
//		    parkingLot pl=new parkingLot();
//			parkingLotService plService = new parkingLotService();
//			
//		
//			pl.setOwnerId(ownerId);			
//			List<parkingLot> parkingLotList=plService.findAllowner(ownerId);
//			request.setAttribute("parkingLotList", parkingLotList);
			response.sendRedirect("parkingLotOwnerHome");
		       
			}
			else{
				
				request.setAttribute("ownerId", ownerId);
				request.setAttribute("error", "您的手机号与注册手机号不符，请您重新输入！");
				request.getRequestDispatcher("/parkingLotOwnerlogin.jsp").forward(request, response);
			}

	}

}
