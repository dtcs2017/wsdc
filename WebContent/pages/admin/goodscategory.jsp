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
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">商品类别</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="admin/getgoodscategorylist" method="post">
                    <table class="search-tab">
                        <tr>
                            <th width="70">类别名:</th>
                            <td><input class="common-text" placeholder="关键字" name="goodscategory.category" value="" id="" type="text"></td>
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
                        <a href="pages/admin/goodscategoryadd.jsp"><i class="icon-font"></i>添加类别</a>
                        <a id="batchDel" href="javascript:void(0)"><i class="icon-font"></i>批量删除</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" type="checkbox"></th>
                            <th>ID</th>
                            <th>上级ID</th>
                            <th>类别名</th>
                            <th>操作</th>
                        </tr>
                        <tr>
                        <s:iterator value="pageBean.list">
                            <td class="tc"><input name="id[]" value="59" type="checkbox"></td>
                            <td><s:property value="goodscategoryid"/></td>
                            <td><s:property value="pid"/></td>
                            <td><s:property value="category"/></td>
                            <td>
                                <a class="link-update" href='admin/goodscategoryupdate?goodscategory.goodscategoryid=<s:property value="goodscategoryid"/>'>修改</a>
                                <a class="link-del" href='admin/goodscategorydel?goodscategory.goodscategoryid=<s:property value="goodscategoryid"/>'>删除</a>
                            </td>
                        </tr>
                        </s:iterator>
                    </table>
                    <div class="list-page">  
                     <s:if test="pageBean.currentPage == 1">
            首页	上一页
        </s:if>
        
        <s:else>
            <a href="admin/getgoodscategorylist">首页</a>
            
            <a href='admin/getgoodscategorylist?pageBean.currentPage=<s:property value="pageBean.currentPage - 1"/>'>上一页</a>
        </s:else>
        
        <s:if test="pageBean.currentPage != pageBean.totalPage">
            <a href='admin/getgoodscategorylist?pageBean.currentPage=<s:property value="pageBean.currentPage + 1"/>'>下一页</a>
            
            <a href='admin/getgoodscategorylist?pageBean.currentPage=<s:property value="pageBean.totalPage"/>'>尾页</a>
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