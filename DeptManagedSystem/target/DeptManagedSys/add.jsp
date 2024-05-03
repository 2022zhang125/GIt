<%@page contentType="text/html charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Add Department</title>
		<style>
			body {
			font-family: Arial, sans-serif;
			background-color: #f9f9f9;
			margin: 0;
			padding: 0;
			}

			.container {
			max-width: 600px;
			margin: 50px auto;
			padding: 20px;
			background-color: #fff;
			border-radius: 8px;
			box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
			}

			h1 {
			text-align: center;
			color: #333;
			}

			form {
			margin-top: 20px;
			}

			table {
			width: 100%;
			}

			table th {
			text-align: right;
			padding: 10px;
			}

			table td {
			padding: 10px;
			}

			input[type="text"] {
			width: calc(100% - 20px);
			padding: 8px;
			margin-bottom: 10px;
			border: 1px solid #ccc;
			border-radius: 4px;
			box-sizing: border-box;
			}

			input[type="submit"] {
			width: 100%;
			padding: 10px;
			border: none;
			border-radius: 4px;
			background-color: #007bff;
			color: #fff;
			font-size: 16px;
			cursor: pointer;
			transition: background-color 0.3s;
			}

			input[type="submit"]:hover {
			background-color: #0056b3;
			}
		</style>
	</head>
	<body>
		<div class="container">
			<h1>新增部门</h1>
			<form action="${pageContext.request.contextPath}/dept/add" method="get">
				<table>
					<tr>
						<th>部门编号</th>
						<td><input type="text" name="deptno" required></td>
					</tr>
					<tr>
						<th>部门名称</th>
						<td><input type="text" name="dname" required></td>
					</tr>
					<tr>
						<th>部门位置</th>
						<td><input type="text" name="loc" required></td>
					</tr>
				</table>
				<input type="submit" value="保存">
			</form>
		</div>
	</body>
</html>
