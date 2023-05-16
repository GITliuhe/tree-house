package com.zjt.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class getSunday {
	public static String gettime()  {
	    Date now = new Date();
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
	    String MTime = dateFormat.format( now );
	    Date date1=null;
	    try {
	        date1 = dateFormat.parse(MTime);//系统当前时间
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date1);

	    cal.add(Calendar.DAY_OF_MONTH, -1);//取当前日期的前一天.

	    cal.add(Calendar.DAY_OF_MONTH, +1);//取当前日期的后一天.
	    // hour中存的就是星期几了，其范围 1~7
	    // 1=星期日 7=星期六，其他类推
	    int hour=cal.get(Calendar.DAY_OF_WEEK);
	    //System.out.println("当前系统日期"+MTime);
	    String stime=null;
	    String etime=null;
	    switch (hour) {
	        case 2:
	            //周一
	            stime=MTime;
	            cal.add(Calendar.DAY_OF_MONTH, +6);//获取当前日期的后六天.
	            String  date2=dateFormat.format(cal.getTime());
	            etime=date2;
	            break;
	        case 3:
	            //周二
	            cal.add(Calendar.DAY_OF_MONTH, -1);//获取当前日期的前一天.
	            String  date12=dateFormat.format(cal.getTime());
	            stime=date12;
	            cal.add(Calendar.DAY_OF_MONTH, +6);//获取周日时间
	            String  date22=dateFormat.format(cal.getTime());
	            etime=date22;
	            break;
	        case 4:
	            //周三
	            cal.add(Calendar.DAY_OF_MONTH, -2);
	            String  date13=dateFormat.format(cal.getTime());//取当前日期的前两天.
	            stime=date13;
	            cal.add(Calendar.DAY_OF_MONTH, +6);//获取周日时间
	            String  date23=dateFormat.format(cal.getTime());
	            etime=date23;
	            break;
	        case 5:
	            //周四
	            cal.add(Calendar.DAY_OF_MONTH, -3);//获取取当前日期的前三天.
	            String  date14=dateFormat.format(cal.getTime());
	            stime=date14;
	            cal.add(Calendar.DAY_OF_MONTH, +6);//获取周日时间
	            String  date24=dateFormat.format(cal.getTime());
	            etime=date24;
	            break;
	        case 6:
	            //周五
	            cal.add(Calendar.DAY_OF_MONTH, -4);//获取取当前日期的前四天.
	            String  date15=dateFormat.format(cal.getTime());
	            stime=date15;
	            cal.add(Calendar.DAY_OF_MONTH, +6);//获取周日时间
	            String  date25=dateFormat.format(cal.getTime());
	            etime=date25;
	            break;
	        case 7:
	            //周六
	            cal.add(Calendar.DAY_OF_MONTH, -5);//获取取当前日期的前五天.
	            String  date16=dateFormat.format(cal.getTime());
	            stime=date16;
	            cal.add(Calendar.DAY_OF_MONTH, +6);//获取周日时间
	            String  date26=dateFormat.format(cal.getTime());
	            etime=date26;
	            break;
	        default:
	            //周日
	            cal.add(Calendar.DAY_OF_MONTH, -6);
	            String  date7=dateFormat.format(cal.getTime());//取当前日期的前六天.
	            stime=date7;
	            etime=MTime;
	            break;
	    }
	    return etime;
	    
	}
	

}
