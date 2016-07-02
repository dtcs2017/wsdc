<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/pages/common/Header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册DEMO</title>
<script type="text/javascript">
	function checkreg()
	{
		username = document.getElementById("username").value;
		email = document.getElementById("email").value;
		password = document.getElementById("password").value;
		repassword = document.getElementById("repassword").value;
		if(username=="")
		{
			alert("请输入用户名!");
			document.getElementById("username").focus();
			return false;
		}
		if(email=="")
		{
			alert("请输入用户邮箱!");
			document.getElementById("email").focus();
			return false;
		}
		else
		{
			 if(email.indexOf("@")==-1||email.indexOf(".")==-1||(email.indexOf("@")>email.indexOf(".")))
			 {
				 alert("用户邮箱格式不正确!");
				 document.getElementById("email").focus();
				return false;
			 }
		}
		
		if(password == "")
		{
			alert("请输入用户密码!");
			document.getElementById("password").focus();
			return false;
		}
		if(repassword == "")
		{
			alert("请输入确认密码!");
			document.getElementById("repassword").focus();
			return false;
		}
		if(password != repassword)
		{
			alert("两次密码不一样!");
			document.getElementById("password").value="";
			document.getElementById("repassword").value="";
			return false;
		}
		
		return true;
		
	}



</script>
</head>
<body>
	<s:form action="register" method="post"
		enctype="multipart/form-data" theme="simple">
		<div align="center">
			<!--  用户文件:
			<s:file name="file" cssStyle="width:300px"></s:file>-->
			<p>
				用 户 名:
				<s:textfield name="user.username" cssStyle="width:300px" id="username"></s:textfield>
			<p>
			<p>
				邮箱:
				<s:textfield name="user.email" cssStyle="width:300px" id="email"></s:textfield>
			<p>
				密 码:
				<s:password name="user.password" cssStyle="width:300px" id="password"></s:password>
			<p>
				密 码 确 认:
				<s:password name="repassword" cssStyle="width:300px" id="repassword"></s:password>
			<p>
				<s:submit  onclick="return checkreg()"/>
		</div>
	</s:form>
	<p>
		<%@ include file="/pages/common/Bottom.jsp"%>
</body>
</html>