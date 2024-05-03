<%@page contentType="text/html charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Login & Register</title>
		<style>
			body {
			font-family: Arial, sans-serif;
			background-color: #f9f9f9;
			margin: 0;
			padding: 0;
			display: flex;
			justify-content: center;
			align-items: center;
			height: 100vh;
			}
			.form-container {
			background-color: #fff;
			border-radius: 8px;
			box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
			padding: 40px;
			width: 400px;
			}
			.form-container h1 {
			font-size: 24px;
			color: #333;
			text-align: center;
			margin-bottom: 30px;
			}
			.form-container form input[type="text"],
			.form-container form input[type="password"] {
			width: 100%;
			padding: 15px;
			margin-bottom: 20px;
			border: none;
			border-radius: 5px;
			box-sizing: border-box;
			}
			.form-container form input[type="submit"],
			.form-container form input[type="button"] {
			width: 100%;
			padding: 15px;
			border: none;
			border-radius: 5px;
			background-color: #007bff;
			color: #fff;
			font-size: 16px;
			cursor: pointer;
			transition: background-color 0.3s;
			}
			.form-container form input[type="submit"]:hover,
			.form-container form input[type="button"]:hover {
			background-color: #0056b3;
			}
			.form-container form .link {
			text-align: center;
			margin-top: 20px;
			}
			.form-container form .link a {
			color: #007bff;
			text-decoration: none;
			}
		</style>
	</head>
	<body>
		<div class="form-container">
			<h1>欢迎进入登录系统</h1>
			<form action="${pageContext.request.contextPath}/user/login" method="post">
				<input type="text" name="username" placeholder="账号" required>
				<input type="password" name="password" placeholder="密码" required>
				<input type="submit" value="登录">
				<div class="link">
					<a href="${pageContext.request.contextPath}/register.jsp">没有账号？点击注册</a>
				</div>
			</form>
		</div>
	</body>
</html>
