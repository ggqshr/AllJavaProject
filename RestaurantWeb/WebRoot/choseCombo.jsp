<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.restaurant.entity.Combo"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<base href="<%=basePath%>">
<script type="text/javascript" src="res/js/test.js"></script>
<script type="text/javascript" src="res/js/add_food.js"></script>
、
<script type="text/javascript" src="res/js/tj.js"></script>
<title>增加食物</title>

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
	<%
  String adr=(String)session.getAttribute("adr");
  int sd=2;
   %>
	<div class="pd-20">
		<div class="Huiform">
			<!--  <form action="userUpdateServlet" method="post"> -->
			<form id="form1" action="BaseServlet?oc=1" method="post">
				<table class="table table-border table-bordered table-bg">
					<thead>
						<tr>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th>序号</th>
							<th>套餐名</th>
							<th>套餐价格</th>
							<th>套餐内容</th>
						</tr>
						<tr>
							<%
        List<Combo> foods=(List<Combo>)session.getAttribute("list");
        int num=1;
        for (Combo food : foods) {
			
         %>
						
						<tr>
							<th><%=num++ %></th>
							<th><%=food.getComboName() %></th>
							<th><%=food.getComboPrice() %></th>
							<th>面食数量：<%=food.getNoodlesNum() %> 荤菜数量:<%=food.getMeatNum() %>
								<br> 素菜数量：<%=food.getVegetableNum() %> 汤类数量：<%=food.getSoupNum() %></th>
							<th><button type="button" class="btn btn-success radius"
									onClick="tj('<%=food.getComboNumber() %>')">购买</button></th>
						</tr>
						<% 
		}
		 %>
						</tr>
						<tr>
							<input type="text" id="aa" name="ggq" style="display: none">
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>
								<button type="button" onclick="window.location.href='<%=adr %>'"
									class="btn btn-success radius">返回</button>
							</td>
						</tr>
						<tr>
							<input type="text" id="aa" name="ggq" style="display: none">
						</tr>
					</tbody>
				</table>
			</form>
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
