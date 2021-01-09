<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ page import="task01.User"%>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
<!-- 指定字符集 -->
<meta charset="utf-8">
<!-- 使用Edge最新的浏览器的渲染方式 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>用户信息管理系统</title>

<!-- 1. 导入CSS的全局样式 -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- 2. jQuery导入，建议使用1.9以上的版本 -->
<script src="js/jquery-2.1.0.min.js"></script>
<!-- 3. 导入bootstrap的js文件 -->
<script src="js/bootstrap.min.js"></script>
<style type="text/css">
td, th {
	text-align: center;
}
</style>
</head>
<body>

	<%
		List<User> list = (List<User>) request.getAttribute("list");
	int pagesNumber = (int) request.getAttribute("pagesNumber");
	int datasNumber = (int) request.getAttribute("datasNumber");
	int currentPage = (int) request.getAttribute("currentPage");
	
	String name = (String)request.getAttribute("name");
	String address = (String)request.getAttribute("address");
	String email = (String)request.getAttribute("email");

	%>
	<div class="container">
		<h3 style="text-align: center">用户信息列表</h3>
		
		<!-- 模糊查询 -->
		<form class="navbar-form navbar-left" role="search">
  			<div class="form-group">
   		    姓名&nbsp; <input type="text" name="name" class="form-control" placeholder="请输入姓名：">
   		    籍贯&nbsp; <input type="text" name="address"  class="form-control" placeholder="请输入籍贯：">
   		    邮箱&nbsp; <input type="text" name="email"  class="form-control" placeholder="请输入邮箱：">
  			</div>
  			<button type="submit" onclick="window.location='${pageContext.request.contextPath}/userServletQuery'" class="btn btn-default">Submit</button>
		</form>
		
		<table border="1" class="table table-bordered table-hover">
			<tr class="success">
				<th>编号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>籍贯</th>
				<th>QQ</th>
				<th>邮箱</th>
				<th>操作</th>
				<script>
					window.onload = function() {

						var danxuan = document.getElementById("danxuan01");
						danxuan.onclick = function() {

							var array = document.getElementsByName("xuanze");

							for (var i = 0; i < array.length; i++) {
								array[i].checked = danxuan.checked;
							}
						}
					
						
					//选择删除单击事件
				
				    document.getElementById("quanxuankuan").onclick=function(){//跳转到删除servlet，传入我们上面得到的id数组
				    	var flag = confirm("请确认是否删除数据");
				    	if(flag){
							var xuanzes = document.getElementsByName("xuanze");
						    var ids = "id=-1";//ids为一个获取选择数据的id的字符串
						    for (var i = 0; i < xuanzes.length; i++) {
								 if(xuanzes[i].checked){
								   ids = ids+" or id="+xuanzes[i].value;    
							   }
						   }  
						  window.location.href="${pageContext.request.contextPath }/servletDeleteSelectedDatas?currentPage=${currentPage}&ids="+ids;
				    	}
				    
						  
					  }
					
				    
					}
					//单个删除按钮
				    function deleteUser(id){
						var flag = confirm("请确认是否删除数据");
						if (flag) {
							window.location.href="${pageContext.request.contextPath }/userServeltDelete?id="+id;
						}
					}
				</script>
				
				<th><span></span><input type="checkbox" id="danxuan01"></th>
			</tr>
			<c:forEach items="${list }" var="str" varStatus="s">
				<tr>
					<td>${s.count }</td>
					<td>${str.name }</td>
					<td>${str.gender }</td>
					<td>${str.age }</td>
					<td>${str.address }</td>
					<td>${str.qq }</td>
					<td>${str.email }</td>

					
				
					<td><a class="btn btn-default btn-sm"
						href="${pageContext.request.contextPath }/userServletUpdate01?id=${str.id}">修改</a>&nbsp;
						<a class="btn btn-default btn-sm" id="singleDelete" 
						href="javascript:deleteUser(${str.id});">删除</a></td>

					<td><input type="checkbox" name="xuanze" value="${str.id }"
						id="xuanze_${s.count}"></td>
				</tr>


			</c:forEach>


			<tr>
				<td colspan="9" align="center"><a class="btn btn-primary"
					href="add.jsp">添加联系人</a> 
					
					<a id="quanxuankuan" class="btn btn-primary"  }">删除选中</a>
					<a class="btn btn-primary" href="add.jsp">修改选中</a></td>


			</tr>

		</table>


	<div>

			<nav aria-label="Page navigation">

				<ul class="pagination">
					<c:if test="${currentPage <=1 }">
						<li class="disabled">
						<a
						href="${pageContext.request.contextPath }/userServletQuery?ye=${currentPage}&name=${name}&address=${address}&email=${email}"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
					</c:if>
					
					
					<c:if test="${currentPage >1 }">
						<li>
						<a
						href="${pageContext.request.contextPath }/userServletQuery?ye=${currentPage-1}&name=${name}&address=${address}&email=${email}"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
					</c:if>
						
					
					
					
					<c:forEach begin="1" end="${pagesNumber}" var="i">
						<c:if test="${currentPage == i }">
							<li class="active"><a
								href="${pageContext.request.contextPath }/userServletQuery?ye=${i }&name=${name}&address=${address}&email=${email}">${i }</a></li>
						</c:if>
						<c:if test="${currentPage != i }">

							<li><a
								href="${pageContext.request.contextPath }/userServletQuery?ye=${i }&name=${name}&address=${address}&email=${email}">${i }</a></li>
						</c:if>

					</c:forEach>
					
					<c:if test="${currentPage>=pagesNumber }">
                                        <li class="disabled">
                                        <a
                                        href="${pageContext.request.contextPath }/userServletQuery?ye=${currentPage}&name=${name}&address=${address}&email=${email}"
                                        aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                                 </a></li>
                           </c:if>
                                 
                                 <c:if test="${currentPage<pagesNumber }">
                                        <li>
                                        <a
                                        href="${pageContext.request.contextPath }/userServletQuery?ye=${currentPage+1}&name=${name}&address=${address}&email=${email}"
                                        aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                                 </a></li>
                                 </c:if>
                                 
					
			
						
					
						
					
						
					<span style="font-size: 25px; margin-left: 20px">共${datasNumber}条记录，共${pagesNumber }页</span>
				</ul>
			</nav>
		</div>



	</div>
	
</body>
</html>
