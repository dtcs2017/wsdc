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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="resources/login/styles/clicki.web.csss" media="screen" />
<link rel="stylesheet" type="text/css" href="resources/login/styles/clicki.loginandreg.css?V=20120501" media="screen" />
<link rel="stylesheet" type="text/css" href="resources/login/styles/clicki.webkitanimation.css?V=20120501" media="screen" />

<title>欢迎</title>
<!--[if lte IE 9 ]><link rel="stylesheet" href="resources/styles/clicki.iehotfix.css?V=20120501" /><![endif]-->
<!--[if lte IE 9]>
<style>
body {background:#2f7fb2 url(resources/styles/images/topbg_01.png?V=20120501) top center no-repeat;}
html{height:100%;overflow:hidden;background:#2f7fb2 url(resources/styles/images/topbg_01.png?V=20120501) top center no-repeat;}
</style>
<![endif]-->

<style>
.top-space{width:100%; height:100px;}
.main-login{width:100%; height:470px; background:#2F7FB2;}
.main-login-left{width:60%; height:470px; float:left;}
.main-login-right{width:40%; height:470px; float:left;}
</style>
</head>
<body>
<div class="top-space"></div>

<div class="main-login">
<div class="main-login-left"></div>

<div class="main-login-right">
<div class="theCenterBox" style="">
  <div class="theLoginBox">
    <div class="loginTxt">登录</div>
    <div class="theLoginArea" id="loginBox">
      <form id="leftForm" action="login" method="post">
        <p style="position: relative;">
          <label for="LoginForm_email">邮箱：</label>
          <input placeholder="请输入您的账号" name="email" id="LoginForm_email" type="text" maxlength="255" />
          <span>请输入您的账号</span> </p>
        <p style="position: relative;">
          <label for="LoginForm_password">密码：</label>
          <input placeholder="请输入您的密码" name="password" id="LoginForm_password" type="password" maxlength="16" />
          <span>请输入您的密码</span> </p>
        <div class="loginSubmitBnt fixPadding">
          <div>
            <input id="ytautoLogin" type="hidden" value="0" name="LoginForm[rememberMe]" />
            <input id="autoLogin" class="theRememberMe" name="LoginForm[rememberMe]" value="1" checked="checked" type="checkbox" />
            <label class="theRememberMeLabel" for="autoLogin">记住用户名和密码</label>
            <em class="forgotPasswordEm"><a href="http://www.jq-school.com" title="忘记密码">忘记密码?</a>&nbsp;&nbsp;&nbsp;<a href="pages/user/Register.jsp" title="马上注册">马上注册</a></em>
            <div class="login_submit">
              <input name="userSubmit" class="theSubmitButton" value="" type="submit" />
            </div>
          </div>
          <!--<p class="G-c036">请使用Chrome,Firefox,Safari或IE9以获得最佳浏览体验</p>-->
        </div>
      </form>
    </div>
  </div>
</div>
</div>

</div>
</body>
</html>
