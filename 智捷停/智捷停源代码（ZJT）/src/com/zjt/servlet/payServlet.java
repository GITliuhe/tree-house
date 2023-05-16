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
		//初始化
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL,AlipayConfig.APPID,AlipayConfig.RSA_PRIVATE_KEY,
															AlipayConfig.FORMAT,
															AlipayConfig.CHARSET,
															AlipayConfig.ALIPAY_PUBLIC_KEY,
															AlipayConfig.SIGNTYPE);
	        //创建API对应的request
	        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
	        //在公共参数中设置回跳和通知地址
	        alipayRequest.setReturnUrl(AlipayConfig.return_url);
	        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
	        
	        //填充业务参数
	        
	        //必填
	        //商户订单号，需保证在商户端不重复
	        String out_trade_no =billNumber;
	        //销售产品码，与支付宝签约的产品码名称。目前仅支持FAST_INSTANT_TRADE_PAY 
	        String product_code = "FAST_INSTANT_TRADE_PAY";
	        //订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]。
	        String total_amount = carFee ;
	        //订单标题
	        String subject = "停车费用";
	        
	        //选填
	        //商品描述，可空
	        String body = remark;
	        
	        alipayRequest.setBizContent("{" +
	                "\"out_trade_no\":\"" + out_trade_no + "\"," +
	                "\"product_code\":\"" + product_code + "\"," +
	                "\"total_amount\":\"" + total_amount + "\"," +
	                "\"subject\":\"" + subject + "\"," +
	                "\"body\":\"" + body + "\"}" );
	        //请求
	        String form = "";
			try {
				form = alipayClient.pageExecute(alipayRequest).getBody();//调用SDK生成表单
				
			} catch (AlipayApiException e) {
				e.printStackTrace();
				response.getWriter().write("捕获异常出错");
		        response.getWriter().flush();
		        response.getWriter().close();
			}
			response.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
	        response.getWriter().write(form);//直接将完整的表单html输出到页面
	        response.getWriter().flush();
	        response.getWriter().close();
 
	}



		
	

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		

		
	}

}
