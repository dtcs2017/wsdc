<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath()+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <base href="<%=basePath %>">
    <title>信息管理系统————登录页面</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<link rel="stylesheet" href="css/common.css"/>
	<style type="text/css">
		p{text-align:left;width:100%}
		.header{width:100%;height:78px;background:url(./image/head_bg.png) repeat-x;}
		.wrapper{width:1000px;margin:0 auto}
		img.title{display:inline-block;float:left;margin-top:26px}
		.content{width:100%;height:500px;background:url(./image/body.png) repeat-x;}
		.content .wrapper{width:900px;padding:50px;height:400px;}
		p.logo-title{font-size:20px}
		.left,.right{height:100%;width:50%;float:left}
		input{padding:10px;width:300px;height:45px;border:1px solid #CECECE;margin-left:7px}
		.last{margin-top:15px;}
		button{width:120px;height:40px;background:#6CC6FF;color:white;border:none;margin-left:-30px}
		form{width:390px;margin-top:-50px}
		body{background:white}
	</style>

  </head>
  
  <body>
 
  <center>
    <div class="header">
    	<div class="wrapper">
    		<br>
    		<h2><font color="blue">隔壁老王</font></h2>
    	</div>
    </div>
    <div class="content">
    	<div class="wrapper">
    		<div class="left">
    			<p class="logo-title">欢迎商家登录&nbsp;&nbsp;&nbsp;&nbsp;<a href="pages/shopmanage/addshop.jsp">商家入驻</a></p>
    			<img style="margin:0;padding:0;margin-top:30px;margin-left:-50px" src="resources/admin/image/rihe.png">
    		</div>
    		<div class="right">
    		<form action="shoplogin/shoplogin" method="post">
    		  <div style="margin-top:100px">
    			用户姓名:<input type="text" name="shopname" placeholder="用户姓名">
    		</div>
    		<div>
    			用户密码:<input type="password" name="shoppassword"  placeholder="用户密码">
    		</div>
    		<hr style="border: 1px solid #E0E0E0;margin:20px"/>
    		<div style="margin-top:10px;">
    			<button type="submit">登录</button>
    			<a href="pages/admin/adminlogin.jsp">管理员登录</a>
    		</div>
    		</form>
    		</div>
    	</div>
    </div>
    <hr style="border: 1px solid #E0E0E0;margin:20px"/>
   	<div class="footer">
   		<p style="text-align: center;color:#919191">隔壁老王管理系统欢迎您</p>
   	</div>
    
  </center>  
  </body>
</html>

   	