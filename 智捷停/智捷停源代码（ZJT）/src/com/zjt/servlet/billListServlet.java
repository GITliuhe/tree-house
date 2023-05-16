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
import com.zjt.entity.order;
import com.zjt.service.billService;
import com.zjt.service.orderService;
@WebServlet("/mybill")
public class billListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		billService service=new billService();
		String userName = (String) request.getSession().getAttribute("userName");
		System.out.println(userName);
		List<bill> billList = service.showBillListByUserName(userName);
		
		request.setAttribute("billList",billList);
		request.getRequestDispatcher("/showBillList.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


	}

}

