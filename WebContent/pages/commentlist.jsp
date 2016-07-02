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
        <link rel="stylesheet" type="text/css" href="resources/css/goodslist.css">
        <script type="text/javascript" src="resources/js/jquery-2.1.4.js"></script>
        <script type="text/javascript" src="resources/js/index.js"></script>
        <script>
          function addToShoppingcart(a){
    			var goodsid = a.value;
    			var request={goodsid:goodsid};
    		$.post("shoppingCart/addToShoppingcart",request, function(data){
    			window.alert("添加成功");
    		});
          }
        </script>
    </head>
    <body>
        <div id="header">
            <header>
                <div id="header_search">
                    <div>
                        <p>地址：重庆邮电大学<a href="">【切换地址】</a></p>
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
                        </ul>
                    </nav>
                </div>
            </header>
        </div>
        <div id="article">
<article id="goodslist">
    <div id="article_nav">
        <nav>
            <ul id="article_nav_description">
                <li id='li_1'><a href="goods/queryGoodsByPage?shop.shopid=<s:property value="shopid" />" onclick="javascript:li_click(this)">所有商品</a></li>
                <li id="li_2"><a href="usercomment/queryCommentByPage" onclick="javascript:li_click(this)">评价</a></li>
            </ul>
        </nav>
    </div>
     <table class="result-tab" width="100%" style="text-align:center;">
                        <tr>
                            <th>ID</th>
                            <th>用户</th>
                            <th>评论内容</th>
                            <th>创建时间</th>
                        </tr>
                        <tr>
                        <s:iterator value="pageBean.list">
                            <td><s:property value="usercommentid"/></td>
                            <td><s:property value="user.username"/></td>
                            <td><s:property value="content"/></td>
                            <td><s:property value="createtime"/></td>
                     
                        </tr>
                        </s:iterator>
                    </table>
                    
                   
</article>
<div class="paging">
    <ul>
         <s:if test="pageBean.currentPage == 1">
            首页	上一页
        </s:if>
        
        <s:else>
            <li><a class="page" href="usercomment/queryCommentByPage">首页</a></li>
            
            <li><a class="page" href='usercomment/queryCommentByPage?pageBean.currentPage=<s:property value="pageBean.currentPage - 1"/>'>上一页</a></li>
        </s:else>
        
        <s:if test="pageBean.currentPage != pageBean.totalPage">
            <li><a class="page" href='usercomment/queryCommentByPage?pageBean.currentPage=<s:property value="pageBean.currentPage + 1"/>'>下一页</a></li>
            
            <li><a class="page" href='usercomment/queryCommentByPage?pageBean.currentPage=<s:property value="pageBean.totalPage"/>'>尾页</a></li>
        </s:if>
        
        <s:else>
            下一页	尾页
        </s:else>
    </ul>
    <div class="forward">
        <span>第</span>
        <input type="text" value="1">
        <span>页</span>
        <span class="page_button">go</span>
    </div>
</div>
 <form style="text-align:center;" action="usercomment/addComment">
 <input type="hidden" name="shop.shopid" value='<s:property value="shopid" />'>
                   <span style="margin-left:-700px;;"> 评价商家：</sapn><br/><br/><textarea name="content" style="width:600px; height:150px;"></textarea>
      <input type="submit" value="提交评论">
                    </form>
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