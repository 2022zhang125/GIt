<%@page contentType="text/html charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset='utf-8'>
        <title>注册页面</title>
    </head>
    <body>
        <hr>
        <h1>欢迎进入注册系统</h1>
        <form action='${pageContext.request.contextPath}/user/register' method='post'>
            <table border='1px' align='center'>
                <tr>
                    账号:<input type='text' name='username'/>
                </tr>
                <br>
                <tr>
                    密码:<input type='password' name='password'/>
                </tr>
            </table>
            <input type='submit' value='注册'/>
        </form>
        <hr>
    </body>
</html>

