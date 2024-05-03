<%@ page import="com.hbsfdxwlxy.competition.managed.pojo.Dept" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html charset=UTF-8" %>
<%--导入JSTL核心标签库--%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>部门列表页面</title>
		<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
	</head>
	<script type="text/javascript">
		function del(deptno){
			if (window.confirm("要删除吗？")){
				document.location.href = "${pageContext.request.contextPath}/dept/delete?deptno="+deptno
			}else{
				window.alert("删除失败")
			}
		}
	</script>
	<body>
		<hr>
				<%--
					利用EL表达式和JSTL标签库去修改CRUD
				--%>
		<h1>欢迎${sessionScope.username}来到List Page页面</h1>
		<a href="user/exit"><h1>安全退出</h1></a>
		<h1>网站在线人数:${applicationScope.onlineUsers}</h1>
		<hr>
		<table align="center" border="1px" width="50%">
			<tr>
				<th>序号</th>
				<th>编号</th>
				<th>部门</th>
				<th>操作</th>
			</tr>
			<c:choose>
				<c:when test="${not empty requestScope.deptList}">
					<c:forEach items="${requestScope.deptList}" var="dept" varStatus="deptStatus">
					<tr>
						<td>${deptStatus.count}</td>
						<td>${dept.deptno}</td>
						<td>${dept.dname}</td>
						<td align="center">
							<a href="javascript:void(0)" onclick="del(${dept.deptno})">删除</a>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="dept/detail?f=m&deptno=${dept.deptno}">修改</a>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="dept/detail?f=d&deptno=${dept.deptno}">查看</a>
						</td>
					</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>

				</c:otherwise>
			</c:choose>
		</table>
		<hr>
		<a href="add.jsp"><h1>新增部门</h1></a>
	</body>
</html>