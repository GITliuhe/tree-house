package com.zjt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.lgr.car.utils.Base64Util;
import com.zjt.common.CarApi;
import com.zjt.common.GetMessageCode;
import com.zjt.common.RootResp;
import com.zjt.common.sendSuccessful;
import com.zjt.common.sendWarning;
import com.zjt.entity.order;
import com.zjt.service.orderService;


@WebServlet("/spaceLicenseCheck")
public class spaceLicenseCheck extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String orderNumber = request.getParameter("orderNumber");
		request.setAttribute("orderNumber", orderNumber);
		request.getRequestDispatcher("/spaceLicenceCheck.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String imageData=request.getParameter("imageData");
		String extName=request.getParameter("extName");
		String orderNumber = request.getParameter("orderNumber");
		
		System.out.println(orderNumber);
		
		String msg = null;
		//System.out.println(parkingLotId);
		
		CarApi faceApi = new CarApi();
		RootResp resp = faceApi.carVerify(imageData);
		Map<String,Object> json = new HashMap<String, Object>();
		json.put("errorCode", 1);
		json.put("msg", "����ʶ��ʧ��");
		if(resp!=null){
			//ret=0��ʾʶ��ɹ�
			
			if(resp.getRet()==0) {
				
				
				JSONObject object = JSONObject.parseObject(resp.getData().toString());
				//��ȡʶ��ɹ��ĳ��ƺ���
	            String carNo = object.getString("Number");
				json.put("errorCode", 0);
				
				System.out.println("carNo="+carNo);
				String savePath = request.getSession().getServletContext().getRealPath("/attached/face/")+"/";
				String inPic = UUID.randomUUID()+"."+extName;
				savePath += inPic;
			
				System.out.println("savePath="+savePath);
				
				try {
					Base64Util.decoderBase64File(imageData, savePath);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				orderService oService = new orderService();
				
				order orderInfo = oService.findOrderInfoByOrderNumber(orderNumber);
				
				String phoneNumber = orderInfo.getPhoneNumber();
				String carLicenseNumber = orderInfo.getCarLicenseNumber();
				
				if(carLicenseNumber.equals(carNo)){
					
					String code=sendSuccessful.getCode(phoneNumber); 
					System.out.println(code);
					
					json.put("msg","Ԥ������"+carNo+"����ͣ��λ��Ԥ����λһ�£�ף��������죡" );
				}else{
					
					String code=sendWarning.getCode(phoneNumber); 
					System.out.println(code);
					
					json.put("msg","Ԥ������"+carNo+"����ͣ��λ��Ԥ����λ��һ�£������˶Ժ���ȷ������" );
				}
				
			}

			
	}else{
			json.put("errorCode", resp.getRet());
			json.put("msg", "����ʶ��ʧ��");
			
			
			}
		Gson gson = new Gson();
		String json1 = gson.toJson(json);
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("application/json; charset=utf-8");  
		PrintWriter writer = response.getWriter();
		writer.append(json1);
	}

}
