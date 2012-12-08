<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>

<body>
	<div align="center">
		<h1>
			<font face="微软雅黑"><strong>SuccessFactors Minerva's Book Library <font
					color="#00ff00">ON</font>
			</strong>
			</font>
		</h1>
		<h2>DBServer-Restlet WebService, JAXB</h2>
		<div align="right">
			<address>
				Alex Yan&nbsp;&nbsp;&nbsp;&nbsp; <br>
			</address>
		</div>
	</div>
</body>
</html>
