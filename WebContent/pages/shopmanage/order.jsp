<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath()+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<base href="<%=basePath %>">
    <meta charset="UTF-8">
    <title>商家管理</title>
    <link rel="stylesheet" type="text/css" href="resources/adminmanage/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="resources/adminmanage/css/main.css"/>
    <script type="text/javascript" src="resources/adminmanage/js/libs/modernizr.min.js"></script>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.html" class="navbar-brand">商家管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="shopmanage/index">首页</a></li>
                <li><a href="home/index" target="_blank">网站首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
               <li><a href="pages/shopmanage/password.jsp">修改密码</a></li>
                <li><a href="shopmanage/logout">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
     <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
      <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>常用操作</a>
                    <ul class="sub-menu">
                       <li><a href="shopmanage/index"><i class="icon-font">&#xe008;</i>首页</a></li>
                        <li><a href="shopmanage/getgoodslist"><i class="icon-font">&#xe012;</i>商品管理</a></li>
                        <li><a href="shopmanage/getorderlist"><i class="icon-font">&#xe006;</i>订单管理</a></li>
                        <li><a href="shopmanage/getcommentlist"><i class="icon-font">&#xe004;</i>评论管理</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">订单管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="shopmanage/getorderlist" method="post">
                    <table class="search-tab">
                        <tr>
                            <th width="70">订单名:</th>
                            <td><input class="common-text" placeholder="关键字" name="order.orderno" value="" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                     
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" type="checkbox"></th>
                            <th>ID</th>
                            <th>订单名</th>
                            <th>用户名</th>
                            <th>用户电话</th>
                            <th>用户地址</th>
                            <th>创建时间</th>
                            <th>总金额</th>
                            <th>实际支付金额</th>
                            <th>状态</th>
                            <th>操作</th>
                        </tr>
                        <tr>
                        <s:iterator value="pageBean.list">
                            <td class="tc"><input name="id[]" value="59" type="checkbox"></td>
                            <td><s:property value="orderid"/></td>
                            <td><s:property value="orderno"/></td>
                            <td><s:property value="user.username"/></td>
                            <td><s:property value="usertel"/></td>
                            <td><s:property value="address.area"/></td>
                            <td><s:property value="createtime"/></td>
                            <td><s:property value="totalamount"/></td>
                            <td><s:property value="amount"/></td>
                            <td>
                            	<s:if test="state==1">
                            		已完成
                            		
                            	 </s:if>
                            	<s:else>
                            		未付款
                            		<!--   <a class="link-update" href='shopmanage/orderchangestate?order.orderid=<s:property value="orderid"/>'>审核</a>-->
                            	</s:else>
                            	
                            </td>
                            <td>
                               
                                <a class="link-del" href='shopmanage/orderdel?order.orderid=<s:property value="orderid"/>'>删除</a>
                            </td>
                        </tr>
                        </s:iterator>
                    </table>
                    <div class="list-page">  
                     <s:if test="pageBean.currentPage == 1">
            首页	上一页
        </s:if>
        
        <s:else>
            <a href="admin/getuserlist">首页</a>
            
            <a href='order/getorderlist?pageBean.currentPage=<s:property value="pageBean.currentPage - 1"/>'>上一页</a>
        </s:else>
        
        <s:if test="pageBean.currentPage != pageBean.totalPage">
            <a href='order/getorderlist?pageBean.currentPage=<s:property value="pageBean.currentPage + 1"/>'>下一页</a>
            
            <a href='order/getorderlist?pageBean.currentPage=<s:property value="pageBean.totalPage"/>'>尾页</a>
        </s:if>
        
        <s:else>
            下一页	尾页
        </s:else> <s:property value="pageBean.allRows"/> 条 <s:property value="pageBean.currentPage"/>/<s:property value="pageBean.totalPage"/> 页</div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>