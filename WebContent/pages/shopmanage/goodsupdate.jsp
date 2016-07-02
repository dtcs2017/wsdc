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
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="/jscss/admin/design/">用户管理</a><span class="crumb-step">&gt;</span><span>修改用户</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="shopmanage/goodsupdateoperate" method="post" id="myform" name="myform" enctype="multipart/form-data">
                    <table class="insert-tab" width="100%">
                    <input type="hidden" name="goods.goodsid" value="<s:property value="goods.goodsid"/>">
                        <tbody>
                         <tr>
                            <th width="120"><i class="require-red">*</i>商品分类：</th>
                            <td>
                                <select name="goodscategory.goodscategoryid" id="catid" class="required">
                                    <option value="">请选择</option>
                                    <s:iterator value="categorylist">
                                    <option value='<s:property value="goodscategoryid"/>'><s:property value="category"/></option>
                                    </s:iterator>
                                </select>
                            </td>
                        </tr>
                         <tr>
                            <th><i class="require-red">*</i>商品名：</th>
                            <td>
                                <input class="common-text" name="goods.goodsname" size="50" value="<s:property value="goods.goodsname"/>" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>商品图片：</th>
                            <td>
                                <input class="common-text" name="goods.photo" size="50" value="<s:property value="goods.photo"/>" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>销量：</th>
                            <td>
                                <input class="common-text" name="goods.sales" size="50" value="<s:property value="goods.sales"/>" type="text">
                            </td>
                        </tr>
                         <tr>
                            <th><i class="require-red">*</i>单价：</th>
                            <td>
                                <input class="common-text" name="goods.price" size="50" value="<s:property value="goods.price"/>" type="text">
                            </td>
                        </tr>
                         <tr>
                            <th><i class="require-red">*</i>商品简介：</th>
                            <td>
                                <textarea name="goods.introduc" class="common-textarea" id="content"  cols="30" style="width: 98%;" rows="10">
                                	<s:property value="goods.introduc"/>
                                </textarea>
                            </td>
                        </tr>
                        <tr>
                         
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>