<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>Success Page</title>
  </head>
  <script type="text/javascript">
      setTimeout(function(){
          window.location.href = "${pageContext.request.contextPath}/login.jsp";
      }, 3000);
  </script>
  <body>
      <h1>恭喜！注册成功,正在返回登录界面.....</h1>
  </body>
</html>
