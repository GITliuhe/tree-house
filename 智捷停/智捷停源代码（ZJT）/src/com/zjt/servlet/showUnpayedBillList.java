package com.zjt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjt.entity.bill;
import com.zjt.service.billService;


@WebServlet("/myUnpayedbill")
public class showUnpayedBillList extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		billService service=new billService();
		String userName = (String) request.getSession().getAttribute("userName");

		List<bill> billList = service.showBillListByUserNameStatus(userName);
		
		request.setAttribute("billList",billList);
		request.getRequestDispatcher("/showUnpayedBill.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}