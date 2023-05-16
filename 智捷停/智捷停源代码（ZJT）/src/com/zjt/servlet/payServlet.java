package com.zjt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.zjt.common.AlipayConfig;
import com.zjt.entity.bill;
import com.zjt.service.billService;


@WebServlet("/pay")
public class payServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String billNumber = request.getParameter("billNumber");
		String carFee = request.getParameter("carFee");
		String remark = new String(request.getParameter("remark").getBytes("ISO-8859-1"),"UTF-8");
		
		billService bService = new billService();
		bService.updateBillStausByBillId(billNumber);
		
		
		
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//��ʼ��
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL,AlipayConfig.APPID,AlipayConfig.RSA_PRIVATE_KEY,
															AlipayConfig.FORMAT,
															AlipayConfig.CHARSET,
															AlipayConfig.ALIPAY_PUBLIC_KEY,
															AlipayConfig.SIGNTYPE);
	        //����API��Ӧ��request
	        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
	        //�ڹ������������û�����֪ͨ��ַ
	        alipayRequest.setReturnUrl(AlipayConfig.return_url);
	        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
	        
	        //���ҵ�����
	        
	        //����
	        //�̻������ţ��豣֤���̻��˲��ظ�
	        String out_trade_no =billNumber;
	        //���۲�Ʒ�룬��֧����ǩԼ�Ĳ�Ʒ�����ơ�Ŀǰ��֧��FAST_INSTANT_TRADE_PAY 
	        String product_code = "FAST_INSTANT_TRADE_PAY";
	        //�����ܽ���λΪԪ����ȷ��С�������λ��ȡֵ��Χ[0.01,100000000]��
	        String total_amount = carFee ;
	        //��������
	        String subject = "ͣ������";
	        
	        //ѡ��
	        //��Ʒ�������ɿ�
	        String body = remark;
	        
	        alipayRequest.setBizContent("{" +
	                "\"out_trade_no\":\"" + out_trade_no + "\"," +
	                "\"product_code\":\"" + product_code + "\"," +
	                "\"total_amount\":\"" + total_amount + "\"," +
	                "\"subject\":\"" + subject + "\"," +
	                "\"body\":\"" + body + "\"}" );
	        //����
	        String form = "";
			try {
				form = alipayClient.pageExecute(alipayRequest).getBody();//����SDK���ɱ�
				
			} catch (AlipayApiException e) {
				e.printStackTrace();
				response.getWriter().write("�����쳣����");
		        response.getWriter().flush();
		        response.getWriter().close();
			}
			response.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
	        response.getWriter().write(form);//ֱ�ӽ������ı�html�����ҳ��
	        response.getWriter().flush();
	        response.getWriter().close();
 
	}



		
	

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		

		
	}

}
