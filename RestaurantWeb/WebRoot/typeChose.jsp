<%@page import="cn.restaurant.entity.Combo"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.restaurant.entity.Food"%>

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
  int sd=2;
   %>
	<div class="pd-20">
		<div class="Huiform">
			<!--  <form action="userUpdateServlet" method="post"> -->
			<form id="form1" action="BaseServlet?tc=1" method="post">
				<table class="table table-border table-bordered table-bg">
					<thead>
						<tr>
						</tr>
					</thead>
					<tbody>
						<tr>

						</tr>
						<tr>
							<%
        Combo combo=(Combo)session.getAttribute("comboIfm1");
        String adr=(String)session.getAttribute("adr1");
        int num=1;
			if(combo.getNoodlesNum()>0)
			{
         %>
						
						<tr>
							<th>
								<button type="button" onclick="tj('noodles')"
									class="btn btn-success radius">
									<i class="icon-ok"></i>请选择<%=combo.getNoodlesNum() %>种面食
								</button>
							</th>
						</tr>
						<% 
		}
		if(combo.getMeatNum()>0)
		{
		 %>
						<tr>
							<th>
								<button type="button" onclick="tj('meat')"
									class="btn btn-success radius">
									<i class="icon-ok"></i>请选择<%=combo.getMeatNum() %>种荤菜
								</button>
							</th>
						</tr>
						<%
			}
			if(combo.getVegetableNum()>0)
			{
			
			 %>
						<tr>
							<th>
								<button type="button" onclick="tj('vegetable')"
									class="btn btn-success radius">
									<i class="icon-ok"></i>请选择<%=combo.getVegetableNum() %>种素菜
								</button>
							</th>
						</tr>
						<%
			}
			if(combo.getSoupNum()>0)
			{
			 %>
						<tr>
							<th>
								<button type="button" onclick="tj('soup')"
									class="btn btn-success radius">
									<i class="icon-ok"></i>请选择<%=combo.getSoupNum() %>种汤菜
								</button>
							</th>
						</tr>
						<%
			}
			 %>
						</tr>
						<tr>
							<input type="text" id="aa" name="ggq" style="display: none">
						</tr>
						<tr>
							<th>
							<th>
								<button type="button" onclick="tj('sub')"
									class="btn btn-success radius">
									<i class="icon-ok"></i>结账
								</button>
							</th>
							</th>
							<th>
								<button type="button" onclick="window.location.href='<%=adr %>'"
									class="btn btn-success radius">
									<i class="icon-ban"></i>返回
								</button>
							</th>
						<tr>
							<input type="text" id="aa" name="ggq" style="display: none">
						</tr>
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
