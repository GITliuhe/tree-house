<%@ page language="java" import="java.util.*" import="com.zjt.entity.parkingLot" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'manageParkingLot.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">
  </head>
  
  <body>
  <% 
  	List<parkingLot> parkingLotList=(List<parkingLot>)request.getAttribute("parkingLotList");//内置对象,强制类型转换
  
  %>
   <table  align="center" class="table table-dark table-striped">
         <tr>
         	  <th></th>
         	  <th>停车场编号</th>
              <th>停车场名</th>
              <th>位置</th>
			  <th>车位数</th>
			  <th>收费标准</th>
              
         </tr>
         <% 
 			for (parkingLot parkingLot:parkingLotList){
 		%>
				<tr>
					<td><input type="checkbox" value="<%=parkingLot.getParkingLotId()%>" name="parkingLotId" ></td>
					<td><%=parkingLot.getParkingLotId() %></td>
					<td><%=parkingLot.getPname() %></td>
					<td><%=parkingLot.getPlocation() %></td>
					<td><%=parkingLot.getParkingSpaceQuatity() %></td>
					<td><%=parkingLot.getRates() %></td>
					<td><a href="modifyParkingLot?parkingLotId=<%=parkingLot.getParkingLotId()%>">修改</a></td>
					<td><a href="delParkingLot?parkingLotId=<%=parkingLot.getParkingLotId()%>">删除</a></td>
					
				</tr>
 		<%
 			}
 		%>
 	    
         
      
      </table>
            <table align="center" >
        
          <tr>
               <td>
                   <button class="btn btn-info" type="button"><a href="addParkingLot" style="text-decoration: none"><font color="white">添加停车场</font></a></button>
               	  
               </td>
         
         </tr>
              
          <tr>
               <td>
                   <button class="btn btn-info" type="button"><a href="parkingLotOwnerHome" style="text-decoration: none"><font color="white">返回</font></a></button>
               	  
               </td>
         
         </tr>
      </table>
  </body>
</html>
