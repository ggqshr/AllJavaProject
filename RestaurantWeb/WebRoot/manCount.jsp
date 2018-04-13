<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<base href="<%=basePath%>">

<title>增加食物</title>
<script type="text/javascript" src="res/js/tj.js"></script>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link type="text/css" rel="stylesheet" href="res/css/H-ui.css" />
<link type="text/css" rel="stylesheet" href="res/css/H-ui.admin.css" />
<link type="text/css" rel="stylesheet"
	href="res/font/font-awesome.min.css" />
<style>
body {
	min-height: 200px;
	font-size: 14px;
}

td, th {
	font-size: 14px;
}

input[type="text"] {
	padding: 5px 5px;
	font-size: 14px;
}
</style>
<script type="text/javascript">
  		function Test(){
  			document.getElementById('form1').submit();
  		}
  </script>

</head>

<body>
	<div class="pd-20">
		<div class="Huiform">
			<!--  <form action="userUpdateServlet" method="post"> -->
			<form id="form1" name="form1" action="BaseServlet?dw=1" method="post">
				<table class="table table-border table-bordered table-bg">
					<thead>
						<tr>
							<th colspan="2"><font size='4'>选择</font></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th colspan="2"><button type="button"
									onclick="window.location.href='queryFoodAsDay.jsp'"
									class="btn btn-success radius">按天统计饭菜销售情况</button></th>
						</tr>
						<tr>
							<th colspan="2"><button type="button"
									onclick="window.location.href='queryFoodAsWeek.jsp'"
									class="btn btn-success radius">按周统计饭菜销售情况</button></th>
						</tr>
						<tr>
							<th colspan="2"><button type="button"
									onclick="window.location.href='queryFoodAsMonth.jsp'"
									class="btn btn-success radius">按月统计饭菜销售情况</button></th>
						</tr>
						<tr>
							<th colspan="2"><button type="button" onclick="tj('waiter')"
									class="btn btn-success radius">查看员工销售业绩</button></th>
						</tr>
						<tr>
							<th colspan="2"><button type="button" onclick="tj('combo')"
									class="btn btn-success radius">统计套餐销售情况</button></th>
						</tr>
						<tr>
							<input type="text" id="aa" name="ggq" style="display: none">
						</tr>
					</tbody>
				</table>
		</div>
	</div>
	<script type="text/javascript" src="res/js/jquery.min.js"></script>
	<script type="text/javascript" src="res/js/Validform_v5.3.2_min.js"></script>
	<script type="text/javascript" src="res/js/H-ui.js"></script>
	<script type="text/javascript" src="res/js/H-ui.admin.js"></script>
	<script type="text/javascript">
$(".Huiform").Validform(); 
</script>

</body>
</html>
