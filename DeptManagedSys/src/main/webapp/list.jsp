<%@ page import="com.hbsfdxwlxy.competition.pojo.Dept" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html charset=UTF-8" %>
<%--导入JSTL核心标签库--%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
		<title>Department List</title>
		<style>
			body {
			font-family: Arial, sans-serif;
			background-color: #f9f9f9;
			margin: 0;
			padding: 0;
			}

			header {
			background-color: #007bff;
			color: #fff;
			padding: 20px;
			text-align: center;
			}

			nav {
			margin-top: 10px;
			}

			nav a {
			color: #fff;
			text-decoration: none;
			margin-left: 10px;
			}

			main {
			padding: 20px;
			}

			table {
			width: 100%;
			border-collapse: collapse;
			}

			table th, table td {
			padding: 10px;
			border: 1px solid #ccc;
			}

			table th {
			background-color: #f0f0f0;
			text-align: left;
			}

			table td {
			text-align: center;
			}

			table td a {
			color: #007bff;
			text-decoration: none;
			margin: 0 5px;
			}

			table td a:hover {
			text-decoration: underline;
			}

			footer {
			background-color: #007bff;
			color: #fff;
			padding: 10px;
			text-align: center;
			position: fixed;
			bottom: 0;
			width: 100%;
			}
		</style>
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
		<header>
			<h1>欢迎用户, ${sessionScope.username}!</h1>
			<nav>
				<a href="user/exit">安全登出</a>
			</nav>
		</header>
		<main>
			<table>
				<thead>
					<tr>
						<th>序号</th>
						<th>编号</th>
						<th>部门</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.deptList}" var="dept" varStatus="deptStatus">
						<tr>
							<td>${deptStatus.count}</td>
							<td>${dept.deptno}</td>
							<td>${dept.dname}</td>
							<td>
								<%--!!!!!--%>
								<a href="javascript:void(0)" onclick="del(${dept.deptno})">Delete</a>
								<a href="dept/detail?f=m&deptno=${dept.deptno}">Edit</a>
								<a href="dept/detail?f=d&deptno=${dept.deptno}">View</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="add.jsp">新增部门</a>
		</main>
		<footer>
			<p>Online users: ${applicationScope.onlineUsers}</p>
		</footer>
	</body>
</html>
