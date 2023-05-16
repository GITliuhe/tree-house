package com.zjt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjt.entity.parkingLotOwner;
import com.zjt.entity.user;
import com.zjt.service.parkingLotOwnerService;
import com.zjt.service.userService;


@WebServlet("/parkingLotOwnerRegister")
public class parkingLotOwnerRegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/parkingLotOwnerRegister.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String realName=request.getParameter("realName");
		String phoneNumber=request.getParameter("phoneNumber");
		String businessLicenseNumber=request.getParameter("businessLicenseNumber");
		
		parkingLotOwnerService service= new parkingLotOwnerService();
		parkingLotOwner pOwner= new parkingLotOwner();
		
		pOwner.setOwnerName(realName);
		pOwner.setPhoneNumber(phoneNumber);
		pOwner.setBusinessLicenseNumber(businessLicenseNumber);
		
		service.addParkingLotOwner(pOwner);
		parkingLotOwner newOwner= service.getOwnerByphoneNumber(phoneNumber);
		
		request.setAttribute("newOwner", newOwner);
		request.getRequestDispatcher("/registerSuccess.jsp").forward(request, response);

	}

}
