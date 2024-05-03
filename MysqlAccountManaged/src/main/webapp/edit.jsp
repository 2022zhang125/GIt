<%@ page import="com.hbsfdxwlxy.javaweb.bean.Dept" %>
<%@page contentType="text/html charset=UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>修改部门</title>
	</head>
	<body>
		<hr>
		<h1>修改界面</h1>
		<form action="${pageContext.request.contextPath}/dept/edit?deptno=${requestScope.dept.deptno}" method="post">
			<table border="1px" width="30%">
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
				<th><input type="submit" value="修改"></th>
			</table>
		</form>
	</body>
</html>