package com.zjt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.zjt.common.RootResp;
import com.zjt.entity.bill;
import com.zjt.entity.chargeLevel;
import com.zjt.entity.order;
import com.zjt.service.billService;
import com.zjt.service.chargeLevelService;
import com.zjt.service.orderService;
import com.zjt.service.parkingSpaceService;


@WebServlet("/paizhaoServlet")
public class licenseCheckServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	public  void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String imageData=request.getParameter("imageData");
		String extName=request.getParameter("extName");
		String parkingLotId = request.getParameter("parkingLotId");
		
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
				
				
				orderService odService = new orderService();
				billService bService = new billService();
				parkingSpaceService pService = new parkingSpaceService();
				
				 
				order orderInfo = odService.findCarByCarNumb(carNo);
				String spaceId = orderInfo.getSpaceId();
				String userName = orderInfo.getUserName();
				String orderDate = orderInfo.getOrderDate();
				int orderStatus = orderInfo.getStatus();
				

				
				bill billInfo = new bill();
				billInfo.setCarLicenseNumber(carNo);
				billInfo.setUserName(userName);
				billInfo.setStatus(0);
				int status = billInfo.getStatus();
			
				
				String remark= "ͣ���շ�";
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
				if(orderInfo.getOrderNumber() != null){
					
					if(orderStatus==0){
						billInfo.setInPicture(inPic);
						billInfo.setInTime(sdf.format(new Date()));
						billInfo.setRemark(remark);
						billInfo.setStatus(0);
						
						bService.createBill(billInfo);
						
						
     					odService.updateOrderStatus(orderInfo.getOrderNumber());
						json.put("msg","Ԥ����"+carNo+"ʶ���볡��ע���벻Ҫռ��������Ԥ����λ��ף��ͣ����죡" );
						 
						
					}else{
						float carFee = 0;
						float parkignTime = 0;
						
						chargeLevelService clService = new chargeLevelService();
						chargeLevel cl = clService.findByparkingLotId(parkingLotId);
						
						bill billInfoOut = bService.findByStatus(carNo,orderDate);
						parkignTime = billInfoOut.getMinutes()-cl.getMianfeiTime();
						System.out.println(parkignTime);
						bill billOut = new bill();
						if(parkignTime <= 0){
							
							billOut.setCarFee(0);
							carFee=0;
							
							billOut.setStatus(1);
							billOut.setMinutes((int) parkignTime);
							billOut.setOutPic(inPic);
							billOut.setOutTime(sdf.format(new Date()));
							billOut.setBillNumber(billInfoOut.getBillNumber());
							bService.updateBillInfoByBillId(billOut);
							odService.updateOrderFinishDate(orderInfo.getOrderNumber());
							pService.availableSpace(spaceId);
							
							json.put("msg","Ԥ������"+carNo+"��������ͣ��ʱ��С�����ʱ����ͣ����Ϊ��"+carFee+"������ɷ�" );
						}else{
							carFee = (float)Math.ceil(parkignTime/cl.getShoufeiTime())*cl.getShoufeiMoney();
							
							billOut.setCarFee((int) carFee);
							billOut.setMinutes((int) parkignTime);
							billOut.setOutPic(inPic);
							billOut.setOutTime(sdf.format(new Date()));
							billOut.setBillNumber(billInfoOut.getBillNumber());
							bService.updateBillInfoByBillId(billOut);
							odService.updateOrderFinishDate(orderInfo.getOrderNumber());
							pService.availableSpace(spaceId);
							json.put("msg","Ԥ������"+carNo+"��������ͣ����Ϊ��"+carFee+"���뼰ʱ�ɷ�" );
						}
						
						
						
						
					}
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


