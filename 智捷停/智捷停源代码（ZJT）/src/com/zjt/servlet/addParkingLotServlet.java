package com.zjt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjt.entity.parkingLot;
import com.zjt.service.parkingLotService;

@WebServlet("/addParkingLot")
public class addParkingLotServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("/addParkingLot.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//1. ���ձ�����
		
		parkingLot parkinglot = new parkingLot();
		
		parkinglot.setOwnerId((String) request.getSession().getAttribute("ownerId"));
		parkinglot.setRates(request.getParameter("rates"));
		parkinglot.setPname(request.getParameter("pName"));
		parkinglot.setPlocation(request.getParameter("pLocation"));
		parkinglot.setParkingSpaceQuatity(request.getParameter("parkingSpaceQuatity"));
		
		
	
		
				
		//2. �������
		parkingLotService service = new parkingLotService();
		
		
		//3. �¼�ͣ��λ
		parkinglot= service.addparkingLot(parkinglot);
		
		request.setAttribute("parkingLot", parkinglot);
		
		request.getRequestDispatcher("/addParkingLotSuccess.jsp").forward(request, response);
	}

	}


