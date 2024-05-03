<%@page contentType="text/html charset=UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>登录页面</title>
	</head>
	<body>
		<hr>
		<h1>欢迎进入登录系统</h1>
		<form action="${pageContext.request.contextPath}/user/login" method="post">
			<table border="1px" align="center">
				<tr>
					账号:<input type="text" name="username" />
				</tr>
				<br>
				<tr>
					密码:<input type="password" name="password"/>
				</tr>
			</table>
			<input type="submit" value="登录">
			<input type="button" value="注册" onclick="window.location.href = '${pageContext.request.contextPath}/register.jsp'">
		</form>
		<hr>
	</body>
</html>