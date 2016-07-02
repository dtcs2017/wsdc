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
.info{width:500px; height:70px; margin:0 auto; background:;}
.info p{float:left; margin-left:20px;}
.input{margin-left:100px;}
</style>

<script type="text/javascript" src="resources/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="resources/js/jquery-2.1.4.js"></script>
<script type="text/javascript">
    $(document).ready (function ()
    {
        var pl = $("p:last");
        var reg = /(.*[\:\：]\s*)([\+\d\.]+)(\s*元)/g;
        $ (".sy_minus").click (function ()
        {
            var me = $ (this), txt = me.next (":text"), pc = me.closest("p");
            var val = parseFloat (txt.val ());
            val = val < 1 ? 1 : val;
            txt.val (val - 1);
            var price = parseFloat (pc.prev("p").text().replace(reg,'$2')) * txt.val ();
            pc.next("p").text (pc.next("p").text().replace(reg, "$1" + price + "$3"));
            var sum = 0;
            $(".p_num").next("p").each(function (i, dom)
            {
                sum += parseFloat ($(this).text().replace(reg, "$2"));
            });
            pl.text(pl.text().replace(reg, "$1" + sum + "$3"));
        });
         
        $(".sy_plus").click (function ()
        {
            var me = $ (this), txt = me.prev (":text"), pc = me.closest("p");
            var val = parseFloat (txt.val ());
            txt.val (val + 1);
            var price = parseFloat (pc.prev("p").text().replace(reg,'$2')) * txt.val ();
            pc.next("p").text (pc.next("p").text().replace(reg, "$1" + price + "$3"));
            var sum = 0;
            $(".p_num").next("p").each(function (i, dom)
            {
                sum += parseFloat ($(this).text().replace(reg, "$2"));
            });
            pl.text(pl.text().replace(reg, "$1" + sum + "$3"));
        });
    })[0].onselectstart = new Function ("return false");
</script>
<script>
          function makeorder(){
    			var goodsnumarr = document.getElementById("sy_num_gid1").value;
    			var goodsidarr = document.getElementById("goodsid").value;
    			var request={goodsidarr:goodsidarr,goodsnumarr:goodsnumarr};
    		$.post("order/shoppingcartbatchsave",request, function(data){
    			window.location.href="order/orderinfo";
    		});
          }
        </script>
</head>

<body>

<div class="container">

<div class="banner"></div>

<div class="main">
<form class="form-horizontal">
<h3 align="center">我的购物车</h3><br/>

<s:iterator value="shoppingcartlist">
<div class="info">
        <input type="hidden" id="goodsid" value='<s:property value="goods.goodsid" />'>
        <p><s:property value="goods.goodsname" /></p>
        <p class="">单价：<s:property value="goods.price" />元</p>
        <p class="p_num">
            <span class="sy_minus" id="sy_minus_gid1">-</span> 
            <input class="sy_num" id="sy_num_gid1" readonly="readonly" type="text" name="number1" value='<s:property value="goodsnum" />' /> 
            <span class="sy_plus" id="sy_plus_gid1">+</span>
        </p>
        <p class="">支付：<s:property value="goods.price" />元</p>
    </div>
</s:iterator>

	<div class="info">
        <p>总计：<s:property value="totalprice" />元</p>
    </div>
	<div class="info">
    <input class="btn btn-primary input" type="button" value="去结算" onclick="makeorder(this)">&nbsp;&nbsp;<input class="btn btn-primary input" type="button" value="返回" onclick="history.go(-1)">
    </div>
</form>
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