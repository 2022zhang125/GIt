<%@ page import="com.hbsfdxwlxy.javaweb.bean.Dept" %>
<%@page contentType="text/html charset=UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>部门详情</title>
	</head>
	<body>
		<h1>部门详情</h1>
		<hr>
		<table border="1px">
			<tr>
				<td>部门编号：<input type="text" value="${requestScope.dept.deptno}" readonly></td>
			</tr>
			<tr>
				<td>部门名称：<input type="text" value="${requestScope.dept.dname}" readonly></td>
			</tr>
			<tr>
				<td>部门位置：<input type="text" value="${requestScope.dept.loc}" readonly></td>
			</tr>
		</table>
		<input type="button" value="回退" onclick="javascript:history.back(-1)">
	</body>
</html>