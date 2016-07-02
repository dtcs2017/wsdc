<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath()+"/";
%>
<!doctype html>
<html>
<head>
 <base href="<%=basePath %>">
    <meta charset="UTF-8">
    <title>『bento网上订餐』后台管理</title>
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
            <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span>欢迎使用『bento网上订餐』后台，。</span></div>
        </div>
       
        <div class="result-wrap">
            <div class="result-title">
                <h1>系统基本信息</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                    <li>
                        <label class="res-lab">操作系统</label><span class="res-info">WINNT</span>
                    </li>
                    <li>
                        <label class="res-lab">运行环境</label><span class="res-info">Apache/2.2.21 (Win32)</span>
                    </li>
                    
                    <li>
                        <label class="res-lab">版本</label><span class="res-info">v-0.1</span>
                    </li>
                    <li>
                        <label class="res-lab">上传附件限制</label><span class="res-info">2M</span>
                    </li>
                    <li>
                        <label class="res-lab">北京时间</label><span class="res-info">2015年12月29日 21:08:24</span>
                    </li>
                    <li>
                        <label class="res-lab">服务器域名/IP</label><span class="res-info">localhost [ 127.0.0.1 ]</span>
                    </li>
                    <li>
                        <label class="res-lab">Host</label><span class="res-info">127.0.0.1</span>
                    </li>
                </ul>
            </div>
        </div>
        
    </div>
    <!--/main-->
</div>
</body>
</html>