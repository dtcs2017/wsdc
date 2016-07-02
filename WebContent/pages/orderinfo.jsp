<%@ page language="java" contentType="text/html; charser=UTF-8"
    pageEncoding="UTF-8"%>
	<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath()+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="zh-CN">
 <head>
 <base href="<%=basePath %>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title></title>

<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">

<style>
*{margin:0; padding:0;}
.container{width:100%; min-height:600px;}
.banner{width:100%; height:100px;  background-image: url(resources/images/banner.jpeg);}
.main{width:90%; height:480px; margin:0 auto; background:;}
.space1{width:100%; height:20px; background:;}
.content{width:100%; height:440px; background:; }
.orderinfo{width:35%; height:380px; background:; float:left;}
.other{width:60%; height:440px; background:; float:right;}
.text{margin-left:50px;}
.moneypay{margin-left:50px; border:1px #0089DC solid; padding:10px;;}
.other ul{margin-left:50px;}
.other ul li{list-style-type:none; height:80px;}
.space2{width:20px; height:440px; background:blue;}

.foot{width:100%; height:50px; background-color: #006bc7;
    position: fixed;
    bottom: 0;
    height: 50px;
    width: 100%;
    color: white;
    box-shadow: 0 -2px 2px gray;
    z-index: 1;}

.foot ul{ overflow: hidden;
    margin-left: 500px;}
.foot li{  list-style-type: none;
    float: left;
    text-align: center;
    width: 112px;
    height: 25px;
    border: 1px solid white;
    border-top: 0;
    margin-right: -1px;}

.foot a{ line-height: 26px; color:white;}

.foot address{ text-align: center;}


</style>
<style>
p.p_num {
    width: 78px;
    height: 24px;
    border-top: solid 1px #d0d0d0;
    position: relative;
    border-bottom: solid 1px #d0d0d0;
    margin-top: -3px;
}
 
span.sy_minus,span.sy_plus {
    width: 15px;
    height: 24px;
    line-height: 24px;
    text-align: center;
    display: block;
    position: absolute;
    top: 0px;
    font-size: 14px;
    border: solid 1px #d0d0d0;
    background: #ebebeb;
    cursor: pointer;
    border-top: none;
    border-bottom: none;
}
 
span.sy_minus {
    left: 0px;
}
 
span.sy_plus {
    right: 0px;
}
 
input.sy_num {
    width: 44px;
    height: 18px;
    line-height: 24px;
    text-align: center;
    position: absolute;
    top: 0px;
    left: 17px;
}
 
span.sy_num {
    padding: 5px 8px;
    border: solid 1px #d0d0d0;
    border-left: none;
    border-right: none;
    cursor: pointer;
}
.style{}
.hidden{display:hidden;}
</style>
<script type="text/javascript" src="resources/js/jquery-1.8.0.min.js"></script>
<script>
          function saveorder(){
        	var request={success:1};
    		$.post("order/saveorder",request, function(data){
    			window.alert("下单成功");
    			window.location.href='user/myorder';
    		});
          }
        </script>
</head>

<body>

<div class="container">

<div class="banner"></div>

<div class="main">

<div class="space1"></div>
<div class="content">

<div class="orderinfo">
<!-- orderinfo start -->
<form class="form-horizontal">

 <table class="table">
 <tr><th><h3>订单详情<h3></th></tr>
 <tr><th>商品</th><th>数量</th></tr>
 <s:iterator value="shoppingcartlist">
 <tr><td><s:property value="goods.goodsname" /></td><td><s:property value="goodsnum" /></td></tr>
		</s:iterator>
</table>
<p class="">总共需要支付：<s:property value="totalprice" />元</p>
</form>
<!-- orderinfo end -->
</div>

<div class="other">
<!-- other start-->
<ul>
<li><h4>派送地址：</h4><span class="text"><s:property value="addr.area" />&nbsp;&nbsp;&nbsp;<input class="btn btn-primary" type="button" value="修改地址" onclick="location.href='user/myaddress'"><span></li>
<li><h4>支付方式：</h4><br/><span class="moneypay">货到付款</span><span class="moneypay">某宝</span><span class="moneypay">某行</span></li>
<li><h4>备注：</h4><br/><br/>
<textarea class="form-control" rows="3"></textarea></li>
</ul>

<button type="button" onclick="saveorder()" class="btn btn-info" style="float:right; margin-right:50px;margin-top:100px;">确认下单</button>
<!-- other end -->
</div>

</div>
<div class="space1"></div>

</div>

<div class="foot">
 <ul>
        <li><a href="">关于我们</a></li>
        <li><a href="">帮组中心</a></li>
        <li><a href="">意见反馈</a></li>
        <li><a href="">联系我们</a></li>
    </ul>
    <address><small>©隔壁老王</small></address>
</div>

</div>


  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
</body>

</html>