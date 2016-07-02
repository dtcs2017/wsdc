<%@ page language="java" contentType="text/html; charser=UTF-8"
    pageEncoding="UTF-8"%>
	<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath()+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
    <base href="<%=basePath %>">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <title></title>
        <link rel="stylesheet" type="text/css" href="resources/css/index.css">
        <script type="text/javascript" src="resources/js/jquery-2.1.4.js"></script>
        <script type="text/javascript" src="resources/js/index.js"></script>
    </head>
    <body>
        <div id="header">
            <header>
                <div id="header_search">
                    <div>
                        <p>地址：<span>重庆邮电大学</span><a href="javascript:;" onclick="show_change_address()">【切换地址】</a></p>
                    </div>
                    <div>
                        <input type="text" name="" id=""><button type="submit" id="search_button">搜索</button>
                    </div>
                    <div>
                        <a>欢迎您：张三</a>
                    </div>
                </div>
                <div id="header_nav">
                    <nav>
                        <ul>
                            <li><a href="home/index">首页</a></li>
                            <li><a href="shoppingCart/shoppingcartlsit">购物车</a></li>
                            <li><a href="user/myorder">订单</a></li>
                            <li><a href="user/myinfo">个人中心</a></li>
                            <li><a href="pages/shopmanage/addshop.jsp">商家入驻</a></li>
                        </ul>
                    </nav>
                </div>
            </header>
        </div>
        <div id="article">
            <article id="index">
                <div id="article_nav">
                    <nav>
                        <ul id="article_nav_classify">
                              <!-- 商品类别 （商家类别）-->
                            <li><span>商品分类:</span>
                            <s:iterator value="goodscategorylist" status="status">
                             <li><a href="goods/queryGoodsByPage?goodscategory.goodscategoryid=<s:property value="goodscategoryid" />"><s:property value="category" /></a></li>
                            </s:iterator>
                        </ul>
                        <ul id="article_nav_order">
                            <li><span>默认排序:</span></li>
                            <li><a href="home/index">销量高</a></li>
                            <li><a href="home/index">评价好</a></li>
                            <li><a href="home/index">送餐速度</a></li>
                        </ul>
                    </nav>
                </div>
                <div id="article_content">
                <!-- 商家列表 -->
                <s:iterator value="pageBean.list" status="count"> 
                <s:if test="#count.count%4==1">
                             <div class="article_content_list">
                             </s:if>
                        <a href='goods/queryGoodsByPage?shop.shopid=<s:property value="shopid" />' class="goods">
                        <div class="goods_picture">
                            <img src="<s:property value="photo" />">
                            <span><s:property value="sendtime" />分钟</span>
                        </div>
                        <div class="goods_description">
                            <p><s:property value="shopname" /></p>
                            <p>月销售量:<s:property value="salenum" /></p>
                            <p>起送价:<s:property value="sendprice" />元起</p>
                            <p></p>
                        </div>
                        </a>
                        <s:if test="#count.count%4==0">
                    </div>
                    </s:if>
                     </s:iterator>
    </div>
</article>
<div class="paging">
    <ul> 
         <s:if test="pageBean.currentPage == 1">
           <li><a class="page">首页</a></li>
           <li><a class="page">上一页</a></li>
        </s:if>
        
        <s:else>
            <li><a class="page" href="home/index">首页</a></li>
            
            <li><a class="page" href='home/index?pageBean.currentPage=<s:property value="pageBean.currentPage - 1"/>'>上一页</a></li>
        </s:else>
        
        <s:if test="pageBean.currentPage != pageBean.totalPage">
            <li><a class="page" href='home/index?pageBean.currentPage=<s:property value="pageBean.currentPage + 1"/>'>下一页</a></li>
            
            <li><a class="page" href='home/index?pageBean.currentPage=<s:property value="pageBean.totalPage"/>'>尾页</a></li>
        </s:if>
        
        <s:else>
            <li><a class="page">下一页</a></li>
            <li><a class="page">尾页</a></li>
        </s:else>
    </ul>
    <div class="forward">
        <span>第</span>
        <input type="text" value="1">
        <span>页</span>
        <span class="page_button">go</span>
    </div>
</div>
</div>
<div id="footer">
<footer>
    <ul>
        <li><a href="">关于我们</a></li>
        <li><a href="">帮助中心</a></li>
        <li><a href="">意见反馈</a></li>
        <li><a href="">联系我们</a></li>
    </ul>
    <address><small>&copy;隔壁老王</small></address>
</footer>
</div>
<div id="black_overlay">
</div>
<div id="change_address">
<div class="address">
    <div class="select" onclick="address1()">
        <span class="province">请选择地址</span>
    </div>
    <ul id="address1">
    </ul>
</div>
<div class="address">
    <div class="select" onclick="address2()">
        <span class="market">请选择地址</span>
    </div>
    <ul id="address2">
    </ul>
</div>
<p><span class="province"></span>&nbsp<span class="market"></span></p>
<div class="button">
    <button onclick="change_address()">确认</button>
    <button onclick="close_change_address()">取消</button>
</div>
</div>
</body>
</html>