<%@ page import="com.hbsfdxwlxy.competition.pojo.Dept" %>
<%@page contentType="text/html charset=UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>修改部门信息</title>
		<style>
			body {
			font-family: Arial, sans-serif;
			background-color: #f4f4f4;
			margin: 0;
			padding: 0;
			}
			#container {
			width: 50%;
			margin: 50px auto;
			background-color: #fff;
			padding: 20px;
			border-radius: 5px;
			box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
			}
			h1 {
			text-align: center;
			}
			form {
			margin-top: 20px;
			}
			table {
			width: 100%;
			}
			table tr td {
			padding: 10px;
			}
			input[type="text"] {
			width: calc(100% - 20px);
			padding: 5px;
			border: 1px solid #ccc;
			border-radius: 3px;
			}
			input[type="submit"] {
			width: 100%;
			padding: 10px;
			background-color: #007bff;
			color: #fff;
			border: none;
			border-radius: 3px;
			cursor: pointer;
			}
			input[type="submit"]:hover {
			background-color: #0056b3;
			}
		</style>
	</head>
	<body>
		<div id="container">
			<h1>修改部门信息</h1>
			<form action="${pageContext.request.contextPath}/dept/edit?deptno=${requestScope.dept.deptno}" method="post">
				<table>
					<tr>
						<td>编号：</td>
						<td><input type="text" value="${requestScope.dept.deptno}" readonly></td>
					</tr>
					<tr>
						<td>部门：</td>
						<td><input type="text" name="editName" value="${requestScope.dept.dname}"></td>
					</tr>
					<tr>
						<td>地点：</td>
						<td><input type="text" name="editLoc" value="${requestScope.dept.loc}"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="修改"></td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
