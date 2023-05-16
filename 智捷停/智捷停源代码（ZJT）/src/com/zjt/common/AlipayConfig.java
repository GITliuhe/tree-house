package com.zjt.common;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 商户appid
		public static String APPID = "2021000117621100";
		// 私钥 pkcs8格式的
		
		 public static String RSA_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCpvAKJNVa+Zg3uv2HkTLKf9XxCeZcsjXBjYvc/DAG+syrz4RS8gvT7Ret4bCCToe5YLDvgYRLMfeyMFdPhhjdSW3mV0WS9cadNRCjiCzwQnW5b1koPDsX9QTDiFhewvArUpJgKjCuJhx7nx3pKbcobxGb91lZaIjQocg9fylvhUPbLAh1dYsglUcEICTMYReC1qddPSBITt+tEFc2Nj2zWbSRrIm+hQpUzcjwfhGTHcuT+ijKgSV1qRHTnepTjdd2Rc3lBJ/qXFY6AekaUlfSLFc3sd33R/jVBkIu3GwyVVIveKLnwzFOgJNjS/pl1F6MftPWp7geNylC9TtNlgpZpAgMBAAECggEAP6OaX8974o9pEeb30R1gq9Di8hmcsLunM9xbT2w1C0cqB56Qo82GBOBGVTRVUoUYVD7hhFNhNQLRugRFGP21qE9b2uxTlSQT0kiH+5iywJgGVLCXu+WSHk5fAaW+5Cjc9rVvvCSp/jqHP+fu1hEsAhU1eF7wqYLBg5igYw4APQ38Uoxz+ju6f/dJanqqFLWvsgQ2TojkKtwBKSO7lP5z1GtmDwD884qLepx7rEWsEn3jIagvMNQLgbll7gVVRPoC21OfV8mGGfXjYfTkT2+f1VhosgdxuXWSeP0rLdeqsFcJiMi7PKSSTObwamY4E/Lk/CMxQBXhyQVPQtKdLXr0AQKBgQDwZsPgzs52npMZbG9/8+VeXSNCmo724myCy2wtEU7mUvYV0p/QJ5WS2rxp6J1xttq5fRE9sLoPfV1XEYi95j5LKehpw/dvQvy+ET0MF4crCk0qQMJu49+mO3PgkeOlxzXzVVxOd3jKzjpO8/ZsfsHpS9F9f0XLoXyMD9jVp5pHCQKBgQC0v2qiVlLCLEDJWEwDvrzlHW8IMjXOhBkQ/KITlHFxBZPehW8JcgNd5Bu7CUF16vFgOjfP9fxG5+R+pjHQ4XhVjBtOYWJoXq6dwt/7OYwmAg1hF8Pa3t/Mly5WGaSp8OYb2Wm8o7XPu5ujEdiZtRW/VrMdHh9b5eU/kjqF7f9MYQKBgQCYh7uUseLR5H9UzDZaqvdHTjUHF2XKQ5Ox0TwLxEWZYd39rqvzuInwqZSOZicvdWOF+VKtH6qOFW7ZxahLRQEVU7vBD7O5BnmyZuGjAHKk3l5jhr9W+IJ4yJQXUrlr/9+9StXMe4VKuFrKqYQbBromOhLrW4t/TjDl9VARD8yVcQKBgDhb01EpH4cCK3Vcvd8RE29RfTSOC28Ii5RbYeI/EBxQw+nHq3bDgT8+iFMKsMmm53q8zHhg2Df3yKyg/7mFBHOQS1dmUDwBAeuZPyPjrsqPK0LSGTTe9+OgZEdemZSP1ABtC2ZRmbhbZE01nFdZOp291/3FTbvm9FOdMfhe3JMhAoGBAJFy4pZkr8E3fYmdG+JcHmuzDmeHFzFiR24eXfbhrpcgfyvxpqfAb/iAA1lPDK2WWybg58TmCDzoW6Mv0E5zUxR6jYuiGFrK7Qbfj++dhketeiVuE2aA72JsZMY553xszUcnhAcx2PdaAlt8u//1CXgD5OjdPhYR7fU1AZVDJ+M7";
			
		// 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
		public static String notify_url = "http://localhost:8080/alipay.trade.wap.pay-JAVA-UTF-8/notify_url.jsp";
		// 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
		public static String return_url = "http://localhost:8080/ZJT/myUnpayedbill";
		// 请求网关地址
		public static String URL = "https://openapi.alipaydev.com/gateway.do";
		// 编码
		public static String CHARSET = "UTF-8";
		// 返回格式
		public static String FORMAT = "json";
		// 支付宝公钥
		
		 public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhsHgbD0yIo3k97VwLWovBX8QN4uO6tMab4q3BFw+WoGhXcEclCWNzkv7NV0AWOlsxVF0XDn/wSA8ujLeAoqLe8DmoYFWW8W1pAQFtvg//E/1D1LpWOOiOFspayaIdFox2dA/cRnd/JnIWzkpF2tORr8zFjbaOxNoKz6ldI2vgzB19J9gSV4/Aa2U/rOrPWJcWXmv3AZzxOAyl7+ziowVDv8yhWQcubxUyL1zZnQ9ak9WSZYOSd8imkaWZrNEYoZIlYoK/+bbw9SnvqTtVliSO6dGCvUacCbdnDs8YrlK/anYTPBfuM1oskSntPdkDcpZP/pEqWcc2pJ3jOhjtt9VHwIDAQAB";

			//
		// 日志记录目录
		public static String log_path = "F:\\log";
		// RSA2
		public static String SIGNTYPE = "RSA2";



//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
