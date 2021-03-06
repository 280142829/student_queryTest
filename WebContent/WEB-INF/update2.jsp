<%@page import="org.apache.commons.beanutils.BeanUtils"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page import="java.util.*"%>
<%@ page import="task01.User"%>
<% 
String path = request.getContextPath(); 
// 获得项目完全路径
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
    <head>
    <base href="<%=basePath%>"/>
        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>修改用户</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-2.1.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        
    </head>
    <% 
   User user = (User)request.getAttribute("user2");
	
    %>
    <body>
        <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">修改联系人</h3>
        <form action="${pageContext.request.contextPath}/userServletUpdate02" method="post">
          <div class="form-group">
          <input type="hidden" name="id" value="${user.id}">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name"  readonly="readonly" placeholder="请输入姓名" value="${user.name} "/>
          </div>

          <div class="form-group">
            <label>性别：</label>
            <c:if test="${user.gender=='男'}">
				<input type="radio" name="gender" value="男" checked="checked"/>男
				<input type="radio" name="gender" value="女" />女
            </c:if>
              <c:if test="${user.gender=='女'}">
             	 <input type="radio" name="gender" value="男"  />男
				<input type="radio" name="gender" value="女" checked="checked"/>女
              
              </c:if>
                
          </div>

          <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age"  name="age" placeholder="请输入年龄" value="${user.age }"/>
          </div>

          <div class="form-group">
            <label for="address">籍贯：</label>
    
    
            <c:if test="${user.address=='广东'}">
            	   <select name="address" class="form-control"  }">     
                <option value="广东" selected="selected">广东</option>
                <option value="广西">广西</option>
                <option value="湖南">湖南</option>
            </select>
            </c:if>
             <c:if test="${user.address=='广西'}">
            	   <select name="address" class="form-control"  }">     
                <option value="广东" >广东</option>
                <option value="广西" selected="selected">广西</option>
                <option value="湖南">湖南</option>
            </select>
            </c:if>
             <c:if test="${user.address=='湖南'}">
            	   <select name="address" class="form-control"  }">     
                <option value="广东" >广东</option>
                <option value="广西">广西</option>
                <option value="湖南" selected="selected">湖南</option>
            </select>
            </c:if>
          
          </div>

          <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" name="qq" placeholder="请输入输入Qq" value="${user.qq}"/>
          </div>

          <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" name="email" placeholder="请输入邮箱地址" value="${user.email }"/>
          </div>

             <div class="form-group" style="text-align: center">
                <input class="btn btn-primary" type="submit" value="提交" />
               <input id="chongzhi" type="hidden" value="${user2}">
                <input class="btn btn-default" type="reset" value="重置" onclick="window.location.href='update.jsp'"/>
             
                <input id="fanhui"  class="btn btn-default" type="button" value="返回" onclick="window.location.href = 'userServletQuery'" />

             </div>
        </form>
        </div>
    </body>
</html>