package com.zjt.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class getSunday {
	public static String gettime()  {
	    Date now = new Date();
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//���Է�����޸����ڸ�ʽ
	    String MTime = dateFormat.format( now );
	    Date date1=null;
	    try {
	        date1 = dateFormat.parse(MTime);//ϵͳ��ǰʱ��
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date1);

	    cal.add(Calendar.DAY_OF_MONTH, -1);//ȡ��ǰ���ڵ�ǰһ��.

	    cal.add(Calendar.DAY_OF_MONTH, +1);//ȡ��ǰ���ڵĺ�һ��.
	    // hour�д�ľ������ڼ��ˣ��䷶Χ 1~7
	    // 1=������ 7=����������������
	    int hour=cal.get(Calendar.DAY_OF_WEEK);
	    //System.out.println("��ǰϵͳ����"+MTime);
	    String stime=null;
	    String etime=null;
	    switch (hour) {
	        case 2:
	            //��һ
	            stime=MTime;
	            cal.add(Calendar.DAY_OF_MONTH, +6);//��ȡ��ǰ���ڵĺ�����.
	            String  date2=dateFormat.format(cal.getTime());
	            etime=date2;
	            break;
	        case 3:
	            //�ܶ�
	            cal.add(Calendar.DAY_OF_MONTH, -1);//��ȡ��ǰ���ڵ�ǰһ��.
	            String  date12=dateFormat.format(cal.getTime());
	            stime=date12;
	            cal.add(Calendar.DAY_OF_MONTH, +6);//��ȡ����ʱ��
	            String  date22=dateFormat.format(cal.getTime());
	            etime=date22;
	            break;
	        case 4:
	            //����
	            cal.add(Calendar.DAY_OF_MONTH, -2);
	            String  date13=dateFormat.format(cal.getTime());//ȡ��ǰ���ڵ�ǰ����.
	            stime=date13;
	            cal.add(Calendar.DAY_OF_MONTH, +6);//��ȡ����ʱ��
	            String  date23=dateFormat.format(cal.getTime());
	            etime=date23;
	            break;
	        case 5:
	            //����
	            cal.add(Calendar.DAY_OF_MONTH, -3);//��ȡȡ��ǰ���ڵ�ǰ����.
	            String  date14=dateFormat.format(cal.getTime());
	            stime=date14;
	            cal.add(Calendar.DAY_OF_MONTH, +6);//��ȡ����ʱ��
	            String  date24=dateFormat.format(cal.getTime());
	            etime=date24;
	            break;
	        case 6:
	            //����
	            cal.add(Calendar.DAY_OF_MONTH, -4);//��ȡȡ��ǰ���ڵ�ǰ����.
	            String  date15=dateFormat.format(cal.getTime());
	            stime=date15;
	            cal.add(Calendar.DAY_OF_MONTH, +6);//��ȡ����ʱ��
	            String  date25=dateFormat.format(cal.getTime());
	            etime=date25;
	            break;
	        case 7:
	            //����
	            cal.add(Calendar.DAY_OF_MONTH, -5);//��ȡȡ��ǰ���ڵ�ǰ����.
	            String  date16=dateFormat.format(cal.getTime());
	            stime=date16;
	            cal.add(Calendar.DAY_OF_MONTH, +6);//��ȡ����ʱ��
	            String  date26=dateFormat.format(cal.getTime());
	            etime=date26;
	            break;
	        default:
	            //����
	            cal.add(Calendar.DAY_OF_MONTH, -6);
	            String  date7=dateFormat.format(cal.getTime());//ȡ��ǰ���ڵ�ǰ����.
	            stime=date7;
	            etime=MTime;
	            break;
	    }
	    return etime;
	    
	}
	

}
