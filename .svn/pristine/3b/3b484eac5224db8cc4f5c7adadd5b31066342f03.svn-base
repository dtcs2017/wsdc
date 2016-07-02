<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/pages/common/Header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户分页DEMO</title>
<script type="text/javascript">
    
        function validate()
        {
        	
           var page = document.getElementById("currentPage").value;           
            if(page > <s:property value="pageBean.totalPage"/>)
            {
                alert("你输入的页数大于最大页数,请重新输入!");                
                return false;
            }
            
            return true;
        }
    
    </script>

  </head>
  
  <body>

    <h1><font color="blue">分页查询</font></h1><hr>
    <s:form action="user/queryUserByPage" method="post" theme="simple">
		<div align="center">

			用 户 名:
			<s:textfield name="user.username" cssStyle="width:300px"></s:textfield>
			

				<s:submit value="查詢"></s:submit>
		</div>
	</s:form>
    <table   align="center">
    
        <tr>
            <th>序号</th>
            <th>姓名</th>
            <th>资料</th>
        </tr>
    
    
    <s:iterator value="pageBean.list">
    
        <tr>
            <th><s:property value="id"/></th>
            <th><s:property value="username"/></th>
            <th><s:property value="userPic"/></th>        
        </tr>
    
    </s:iterator>
    
    </table>
    
    <center>
    
    
    
        共<s:property value="pageBean.totalPage"/>页 
        共<s:property value="pageBean.allRows"/>条记录
        
        <s:if test="pageBean.currentPage == 1">
            首页	上一页
        </s:if>
        
        <s:else>
            <a href="user/queryUserByPage">首页</a>
            
            <a href="user/queryUserByPage?pageBean.currentPage=<s:property value="pageBean.currentPage - 1"/>">上一页</a>
        </s:else>
        
        <s:if test="pageBean.currentPage != pageBean.totalPage">
            <a href="user/queryUserByPage?pageBean.currentPage=<s:property value="pageBean.currentPage + 1"/>">下一页</a>
            
            <a href="user/queryUserByPage?pageBean.currentPage=<s:property value="pageBean.totalPage"/>">尾页</a>
        </s:if>
        
        <s:else>
            下一页	尾页
        </s:else>
        
     <form action="user/queryUserByPage" onsubmit="return validate();">
            跳转至<input type="text" size="2" name="pageBean.currentPage" id="currentPage">页
            <input type="submit" value="跳转">
        </form>
    </center>
        
       
        
    



	<%@ include file="/pages/common/Bottom.jsp"%>
</body>
</html>