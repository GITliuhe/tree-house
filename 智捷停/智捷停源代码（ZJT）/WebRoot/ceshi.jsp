<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ceshi.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="icon" href="favicon.ico">
    <title>Dashboard Template for Bootstrap</title>
    <!-- Bootstrap core CSS -->
    <link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="assets/js/ie-emulation-modes-warning.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https@oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https@oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
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
                'echarts/chart/pie'   // 使用饼状图需加载pie模块，此处可按需加载
              ],
              function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var barChart = ec.init(document.getElementById('id-echart-bar'));
                var lineChart = ec.init(document.getElementById('id-echart-line'));
                var pieChart = ec.init(document.getElementById('id-echart-pie'));
                var barOption = {
                  title: {  //定义图表标题
                    text: 'ECharts 柱状图表示例'
                  },
                  tooltip: {
                    show: true    //是否显示提示信息
                  },
                  legend: { //定义图表副标题
                    data:['编程语言喜欢度百分比(%)']
                  },
                  xAxis : [ //定义图表X方向坐标
                    {
                      data : ["C&C++","Java","JavaScript","jQuery","Bootstrap","PHP"]
                    }
                  ],
                  yAxis : [//定义图表Y方向坐标
                    {
                      type : 'value',
                      axisLabel: {
                        formatter: '{value} %'
                      }
                    }
                  ],
                  series : [
                    {
                      "name":"喜欢度",
                      "type":"bar",
                      "data":[50, 70, 90, 60, 80, 65]
                    }
                  ]
                };
                // 为echarts对象加载数据
                barChart.setOption(barOption);
                var lineOption = {
                  title: {
                    text: '未来一周气温变化',
                    subtext: '纯属虚构'
                  },
                  tooltip: {
                    trigger: 'axis'
                  },
                  legend: {
                    data: ['最高气温', '最低气温']
                  },
                  toolbox: {                  //工具栏
                    show: true,               //显示工具栏组件
                    feature: {                //各工具配置项
                      mark: {
                        show: true
                      },
                      dataView: {
                        show: true,           //显示该工具
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
                      formatter: '{value} °C'//使用字符串模板，模板变量为刻度默认标签 {value}
                    }
                  }],
                  series: [{
                    name: '最高气温',                   //系列名称
                    type: 'line',
                    data: [11, 11, 15, 13, 12, 13, 10], //系列中的数据内容数组。数组项通常为具体的数据项。
                    markPoint: {                        //图表标注
                      data: [{
                        type: 'max',                    //特殊的标注类型，标注最大值
                        name: '最大值'
                      }, {
                        type: 'min',                    //特殊的标注类型，标注最小值
                        name: '最小值'
                      }]
                    },
                    markLine: {                         //图表标线
                      data: [{
                        type: 'average',                //平均值
                        name: '平均值'
                      }]
                    }
                  }, {
                    name: '最低气温',
                    type: 'line',
                    data: [1, -2, 2, 5, 3, 2, 0],
                    markPoint: {
                      data: [{
                        name: '周最低',
                        value: -2,    //标注值
                        xAxis: 1,
                        yAxis: -1.5
                      }]
                    },
                    markLine: {
                      data: [{
                        type: 'average',
                        name: '平均值'
                      }]
                    }
                  }]
                };
                // 为echarts对象加载数据
                lineChart.setOption(lineOption);
                var pieOption = {
                  title: {      //标题组件
                    text: '家庭支出',   //主标题文本，支持使用\n换行
                    subtext: '虚构图表',  //副标题文本，支持使用 \n 换行。
                    x: 'center'
                  },
                  tooltip: {
                    trigger: 'item',  //触发类型：数据项图形触发
                    formatter: "{a} <br/>{b} : {c} ({d}%)"  //字符串模板
                    //饼图、仪表盘、漏斗图: {a}（系列名称），{b}（数据项名称），{c}（数值）, {d}（百分比）
                  },
                  legend: {         //图例组件
                    orient: 'vertical',   //图例列表的布局朝向。
                    x: 'left',
                    data: ['日常开支', '投资理财', '奢侈消费', '子女教育', '家庭备用金']//图例的数据数组
                  },
                  toolbox: {  //工具栏
                    show: true,
                    feature: {
                      mark: {
                        show: true
                      },
                      dataView: {//数据视图工具，可以展现当前图表所用的数据，编辑后可以动态更新
                        show: true,
                        readOnly: false
                      },
                      magicType: {  //动态类型切换
                        show: true,
                        type: ['pie', 'funnel'],
                        option: {   //各个类型的专有配置项。在切换到某类型的时候会合并相应的配置项。
                          funnel: {
                            x: '25%',
                            width: '50%',
                            funnelAlign: 'left',
                            max: 1548
                          }
                        }
                      },
                      restore: {  //配置项还原。
                        show: true
                      },
                      saveAsImage: {//保存为图片
                        show: true
                      }
                    }
                  },
                  calculable: true,
                  series: [{
                    name: '支出类型',
                    type: 'pie',
                    radius: '55%',
                    center: ['50%', '60%'],
                    data: [{
                      value: 3000,
                      name: '日常开支'
                    }, {
                      value: 3200,
                      name: '投资理财'
                    }, {
                      value: 1000,
                      name: '奢侈消费'
                    }, {
                      value: 1600,
                      name: '子女教育'
                    }, {
                      value: 1600,
                      name: '家庭备用金'
                    }]
                  }]
                };
                // 为echarts对象加载数据
                pieChart.setOption(pieOption);
              }
      );
    </script>
  </head>
  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Bootstrap</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">EChart.js</a></li>
            <li><a href="#">Examples</a></li>
            <li><a href="#">About</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>
    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>
            <li><a href="#">EChart.js</a></li>
            <li><a href="#id-echart-bar">柱状图</a></li>
            <li><a href="#id-echart-line">折线图</a></li>
            <li><a href="#id-echart-pie">饼状图</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Bootstrap 图表</h1>
          <div id="id-echart-bar" style="height:500px;width:650px;"></div><hr>
          <div id="id-echart-line" style="height:500px;width:650px;"></div><hr>
          <div id="id-echart-pie" style="height:500px;width:650px;"></div><hr>
        </div>
      </div>
    </div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="dist/js/jquery-1.11.3.js"></script>
    <script>window.jQuery || document.write('<script src="assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="assets/dist/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="assets/js/vendor/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="assets/js/ie10-viewport-bug-workaround.js"></script>

  </body>
</html>
