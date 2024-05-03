<%@ page import="com.hbsfdxwlxy.competition.pojo.Dept" %>
<%@page contentType="text/html charset=UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>部门详情</title>
		<style>
			body {
			font-family: Arial, sans-serif;
			margin: 0;
			padding: 0;
			background-color: #f4f4f4;
			}
			.container {
			max-width: 600px;
			margin: 50px auto;
			padding: 20px;
			background-color: #fff;
			border-radius: 5px;
			box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
			}
			h1 {
			text-align: center;
			color: #333;
			}
			table {
			width: 100%;
			border-collapse: collapse;
			margin-top: 20px;
			}
			table td {
			padding: 10px;
			border: 1px solid #ddd;
			}
			input[type="text"] {
			width: calc(100% - 20px);
			padding: 5px;
			border: none;
			border-bottom: 1px solid #ddd;
			margin: 5px 0;
			}
			input[type="button"] {
			background-color: #007bff;
			color: #fff;
			border: none;
			padding: 10px 20px;
			border-radius: 5px;
			cursor: pointer;
			margin-top: 20px;
			}
			input[type="button"]:hover {
			background-color: #0056b3;
			}
		</style>
	</head>
	<body>
		<div class="container">
			<h1>部门详情</h1>
			<hr>
			<table>
				<tr>
					<td>部门编号：</td>
					<td><input type="text" value="${requestScope.dept.deptno}" readonly></td>
				</tr>
				<tr>
					<td>部门名称：</td>
					<td><input type="text" value="${requestScope.dept.dname}" readonly></td>
				</tr>
				<tr>
					<td>部门位置：</td>
					<td><input type="text" value="${requestScope.dept.loc}" readonly></td>
				</tr>
			</table>
			<input type="button" value="回退" onclick="javascript:history.back(-1)">
		</div>
	</body>
</html>
