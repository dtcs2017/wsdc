<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title></title>

<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">

<style>
* {
	margin: 0;
	padding: 0;
}

.container {
	width: 100%;
	min-height: 600px;
}

.banner {
	width: 100%;
	height: 100px;
	background-image: url(resources/images/banner.jpeg);
}

.main {
	width: 90%;
	height: 480px;
	margin: 0 auto;
	background:;
}

#main-left {
	width: 20%;
	height: 480px;
	float: left;
	background-image: url(images/bg.png);
}

#main-right {
	width: 70%;
	height: 480px;
	float: left;
}

#main-right .myinfo {
	width: 650px;
	height: 400px;
	margin: 0 auto;
	margin-top: 30px;
}

.myinfo h4 {
	text-align: center;
}

.main ul {
	list-style-type: none;
	text-align: center;
}

.main ul li {
	margin-top: 20px;
}

.main ul li a {
	text-decoration: none;
}

.main ul li a:hover {
	text-decoration: underline;
}

.foot {
	width: 100%;
	height: 50px;
	background-color: #006bc7;
	position: fixed;
	bottom: 0;
	height: 50px;
	width: 100%;
	color: white;
	box-shadow: 0 -2px 2px gray;
	z-index: 1;
}

.foot ul {
	overflow: hidden;
	margin-left: 500px;
}

.foot li {
	list-style-type: none;
	float: left;
	text-align: center;
	width: 112px;
	height: 25px;
	border: 1px solid white;
	border-top: 0;
	margin-right: -1px;
}

.foot a {
	line-height: 26px;
	color: white;
}

.foot address {
	text-align: center;
}
</style>
</head>

<body>

	<div class="container">

		<div class="banner"></div>

		<div class="main">

			<div id="main-left">
				<ul>
					<h2>个人中心</h2>
					<li><a href="user/myinfo">个人信息</a></li>
					<li><a href="user/myaddress">收货地址</a></li>
					<li><a href="user/myorder">我的订单</a></li>
				</ul>
			</div>

			<div id="main-right">

				<form class="myinfo form-horizontal">

					<table class="table">
						<tr>
							<th>订单编号</th>
							<th>订单生成日期</th>
							<th>订单状态</th>
							<th>订单详情</th>
						</tr>
						<s:iterator value="orderlist">
							<tr>
								<td><s:property value="orderno" /></td>
								<td><s:property value="createtime" /></td>
								<td><s:if test="state==1">
                            		已完成
                            		
                            	 </s:if> <s:else>
                            		未付款
                            	</s:else></td>
                            	<td><a href='order/orderdetail?orderno=<s:property value="orderno" />'>进入</a></td>
							</tr>
						</s:iterator>
					</table>

				</form>

			</div>
		</div>

		<div class="foot">
			<ul>
				<li><a href="">关于我们</a></li>
				<li><a href="">帮组中心</a></li>
				<li><a href="">意见反馈</a></li>
				<li><a href="">联系我们</a></li>
			</ul>
			<address>
				<small>©隔壁老王</small>
			</address>
		</div>
		<ul>
			<li><a></a></li>
			<ul>
	</div>


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>

</html>