
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>银行转账系统</title>
    <base href="http://localhost:8080/bank/">
  </head>
  <body>
  <h1>转账系统</h1>
  <hr>
    <form action="transfer" method="post">
        转出账号：<input type="text" name="fromAct"><br>
        转入账号：<input type="text" name="toAct"><br>
        转出金额：<input type="text" name="money"><br>
        <input type="submit" value="转账">
    </form>
  </body>
</html>
