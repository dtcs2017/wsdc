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
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="resources/adminmanage/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="resources/adminmanage/css/main.css"/>
    <script type="text/javascript" src="resources/adminmanage/js/libs/modernizr.min.js"></script>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.html" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="pages/admin/adminindex.jsp">首页</a></li>
               <li><a href="home/index" target="_blank">网站首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="http://www.jscss.me">管理员</a></li>
                <li><a href="pages/admin/password.jsp">修改密码</a></li>
                <li><a href="admin/logout">退出</a></li>
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
                       <li><a href="admin/getuserlist"><i class="icon-font">&#xe008;</i>用户管理</a></li>
                        <li><a href="admin/getshopcategorylist"><i class="icon-font">&#xe005;</i>商家分类</a></li>
                        <li><a href="admin/getshoplist"><i class="icon-font">&#xe006;</i>商家管理</a></li>
                        <li><a href="admin/getgoodscategorylist"><i class="icon-font">&#xe004;</i>商品分类</a></li>
                        <li><a href="admin/getgoodslist"><i class="icon-font">&#xe012;</i>商品管理</a></li>
                        <li><a href="admin/getareacatelist"><i class="icon-font">&#xe052;</i>地理类别</a></li>
                        <li><a href="admin/getaddresslist"><i class="icon-font">&#xe052;</i>地理管理</a></li>
                        <li><a href="admin/getcommentlist"><i class="icon-font">&#xe052;</i>评论管理</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="icon-font">&#xe018;</i>系统管理</a>
                    <ul class="sub-menu">
                        
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="/jscss/admin/design/">用户管理</a><span class="crumb-step">&gt;</span><span>新增用户</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="admin/useradd" method="post" id="myform" name="myform" enctype="multipart/form-data">
                    <table class="insert-tab" width="100%">
                        <tbody><tr>
                            <th><i class="require-red">*</i>用户名：</th>
                            <td>
                                <input class="common-text" name="user.username" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>密码：</th>
                            <td>
                                <input class="common-text" name="user.password" size="50" value="" type="password">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>性别：</th>
                            <td>
                                <input type="radio" name="user.sex" value="0"  checked="checked" >男  <input type="radio" name="user.sex" value="1">女
                            </td>
                        </tr>
                        <tr>
                                <th><i class="require-red">*</i>头像：</th>
                                <td><input name="user.photo" id="" type="file"><!--<input type="submit" onclick="submitForm('/jscss/admin/design/upload')" value="上传图片"/>--></td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>邮箱：</th>
                            <td>
                                <input class="common-text" name="user.email" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>电话：</th>
                            <td>
                                <input class="common-text" name="user.tel" size="50" value="" type="text">
                            </td>
                        </tr>
                           
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