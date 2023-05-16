package com.zjt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjt.common.getMonday;
import com.zjt.service.orderService;


@WebServlet("/weekOrder")
public class weekOrder extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String parkingLotId = (String)request.getSession().getAttribute("parkingLotId");;
		String pName = (String) request.getSession().getAttribute("pName");
		orderService oService = new orderService();
		 int[] data = new int[7];
		 String Monday = getMonday.gettime();
		 data[0]=oService.findQuantityBydate(Monday);
		 
		 SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		 
		 Date date = null;
		try {
			date = ft.parse(Monday);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 for(int x = 1; x < data.length; x++) {
			 Calendar cal = Calendar.getInstance();
			 cal.setTime(date);
			 cal.add(Calendar.DAY_OF_MONTH, +x);
			 String  date2=ft.format(cal.getTime());
			 data[x]=oService.findQuantityBydate(date2);
			}
		 
		 
		 
		 int mon = data[0];
		 int tue = data[1];
		 int wed = data[2];
		 int thu = data[3];
		 int fri = data[4];
		 int sat = data[5];
		 int sun = data[6];
		 
		 request.setAttribute("mon", mon);
		 request.setAttribute("tue", tue);
		 request.setAttribute("wed", wed);
		 request.setAttribute("thu", thu);
		 request.setAttribute("fri", fri);
		 request.setAttribute("sat", sat);
		 request.setAttribute("sun", sun);
		 request.setAttribute("pName", pName);
		 request.getRequestDispatcher("/weekOrder.jsp").forward(request, response);

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
