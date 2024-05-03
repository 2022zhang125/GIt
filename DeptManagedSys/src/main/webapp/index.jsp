<%@page contentType="text/html charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Welcome to Department Management System</title>
		<style>
			body {
			font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
			background-color: #f4f4f4;
			margin: 0;
			padding: 0;
			display: flex;
			justify-content: center;
			align-items: center;
			height: 100vh;
			}
			.container {
			text-align: center;
			}
			h1 {
			font-size: 2.5rem;
			color: #333;
			margin-bottom: 30px;
			text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.1);
			}
			a.button {
			text-decoration: none;
			color: #fff;
			background-color: #007bff;
			padding: 12px 20px;
			border-radius: 25px;
			font-size: 1.2rem;
			transition: background-color 0.3s, transform 0.3s;
			box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
			cursor: pointer;
			display: inline-block;
			}
			a.button:hover {
			background-color: #0056b3;
			transform: translateY(-2px);
			}
		</style>
	</head>
	<body>
		<div class="container">
			<h1>欢迎来到部门管理系统后台</h1>
			<a href="${pageContext.request.contextPath}/login.jsp" class="button">Get Started</a>
		</div>
	</body>
</html>
