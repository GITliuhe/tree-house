<%@ page language="java" import="java.util.*" import="com.zjt.entity.parkingLot"  import="com.zjt.entity.parkingSpace" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'parkingLotOwnerHome.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- Bootstrap core CSS -->
    <link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">
    <link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://echarts.baidu.com/build/dist/echarts.js"></script>

  </head>
  
  <body>
   <% 
   List<parkingSpace> parkingSpaceList=(List<parkingSpace>)request.getAttribute("parkingSpaceList");
   %>
<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
  <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#"><h3>智捷停</h3></a>
  <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
  <ul class="navbar-nav px-3">
    <li class="nav-item text-nowrap">
      <a class="nav-link" href="parkingLotOwnerHome">退出停车场</a>
    </li>
  </ul>
</header>

<div class="container-fluid">
  <div class="row">
    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
      <div class="position-sticky pt-3">
        <ul class="nav flex-column">
          <li class="nav-item">
            <a class="nav-link" href="AddparkingSpace?id=${parkinglotId}">
              <span data-feather="shopping-cart"></span>
              添加停车位
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="chargeLevel?parkinglotId=${parkinglotId}">
              <span data-feather="bar-chart-2"></span>
              设置收费标准
            </a>
          </li>
        </ul>

        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
          <span>Saved reports</span>
          <a class="link-secondary" href="#" aria-label="Add a new report">
            <span data-feather="plus-circle"></span>
          </a>
        </h6>
        <ul class="nav flex-column mb-2">
          <li class="nav-item">
            <a class="nav-link" href="spaceDetail?parkingLotId=${parkinglotId}">
              <span data-feather="file-text"></span>
                        停车位详情
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="currentSpaceStatus?parkingLotId=${parkinglotId}">
              <span data-feather="file-text"></span>
                       车位实时状态
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="weekOrder">
              <span data-feather="file-text"></span>
                     本周订单详情
            </a>
          </li>
        </ul>
      </div>
    </nav>

    <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">订单情况</h1>
        <div class="btn-toolbar mb-2 mb-md-0">
          <div class="btn-group me-2">
            
            <input type="hidden" id="mon" value="${mon}"> 
            <input type="hidden" id="tue" value="${tue}">
            <input type="hidden" id="wed" value="${wed}">
            <input type="hidden" id="thu" value="${thu}">
            <input type="hidden" id="fri" value="${fri}">
            <input type="hidden" id="sat" value="${sat}">
            <input type="hidden" id="sun" value="${sun}">
          </div>
     
          已选择停车场: ${pName}
        </div>
      </div>
      
    <div class="container-fluid">
      <div class="row">
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          
          
          <div id="id-echart-line" style="height:500px;width:1100px;"></div><hr style="width:1200px;">
          
          
        </div>
      </div>
    </div>

      <!--<canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>-->

      
    </main>
  </div>
</div>


    <script src="assets/dist/js/bootstrap.bundle.min.js"></script>
	<script src="assets/dist/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="js/dashboard.js"></script>
  </body>
  <script type="text/javascript">
  	 // 路径配置
      require.config({
        paths: {
          echarts: 'http://echarts.baidu.com/build/dist'
        }
      });
      // 使用
      require(
              [
                'echarts',
                'echarts/chart/bar',  // 使用柱状图需加载bar模块，此处可按需加载
                'echarts/chart/line', // 使用折线图需加载line模块，此处可按需加载
                //'echarts/chart/pie'   // 使用饼状图需加载pie模块，此处可按需加载
              ],
              function (ec) {
                // 基于准备好的dom，初始化echarts图表
                //var barChart = ec.init(document.getElementById('id-echart-bar'));
                var lineChart = ec.init(document.getElementById('id-echart-line'));
                //var pieChart = ec.init(document.getElementById('id-echart-pie'));
                
                var lineOption = {
                  title: {
                    text: '订单数量',
                    
                  },
                  tooltip: {
                    trigger: 'axis'
                  },
                  
                  toolbox: {                  //工具栏
                    show: true,               //显示工具栏组件
                    feature: {                //各工具配置项
                      mark: {
                        show: true
                      },
                      dataView: {
                        show: false,           //显示该工具
                        readOnly: false       //是否显示不可编辑(只读)
                      },
                      magicType: {            //动态类型切换
                        show: true,           //是否显示该工具
                        type: ['line', 'bar'] //启用的动态类型
                      },
                      restore: {              //配置项还原
                        show: true            //是否显示该工具
                      },
                      saveAsImage: {          //保存为图片
                        show: true            //是否显示该工具
                      }
                    }
                  },
                  calculable: true,//是否显示拖拽用的手柄（手柄能拖拽调整选中范围）
                  xAxis: [{
                    type: 'category', //类目轴，适用于离散数据的类目数据
                    boundaryGap: false,//坐标轴两边留白策略，类目轴和非类目轴的设置和表现不一样。
                    data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']//类目数据
                  }],
                  yAxis: [{
                    type: 'value',  //数值轴，适用于连续数据
                    axisLabel: {    //坐标轴刻度标签的相关设置。
                      formatter: '{value}单'//使用字符串模板，模板变量为刻度默认标签 {value}
                    }
                  }],
                  series: [{
                    name: '订单数',                   //系列名称
                    type: 'line',
                    data: [document.getElementById("mon").value,
                           document.getElementById("tue").value,
                           document.getElementById("wed").value,
                           document.getElementById("thu").value,
                           document.getElementById("fri").value,
                           document.getElementById("sat").value,
                           document.getElementById("sun").value], //系列中的数据内容数组。数组项通常为具体的数据项。
                    
                    
                  }, ]
                };
                // 为echarts对象加载数据
                lineChart.setOption(lineOption);
                
              }
      );
  </script>
</html>