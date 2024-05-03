<%--
  Created by IntelliJ IDEA.
  User: victus
  Date: 2024/2/8
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>银行账户系统</title>
</head>
<body>
<form action="transfer" method="post">
    转出账户：<input type="text" name="fromActno"><br>
    转入账户：<input type="text" name="toActno"><br>
    转出金额：<input type="text" name="money"><br>
    <input type="submit" value="转账">
</form>
</body>
</html>
