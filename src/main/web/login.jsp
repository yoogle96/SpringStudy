<%@page contentType="text/html; charset=utf-8" %>
<html>
    <head>

    </head>
    <body>
        <center>
            <h1>로그인</h1>
            <hr>
            <form action="login_proc.jsp" method="POST">
                <table border="1" callpadding="0" cellspacing="0">
                    <tr>
                        <td bgcolor="orange">아이디</td>
                        <td><input type="text" name="id"></td>
                    </tr>
                    <tr>
                        <td bgcolor="orange">비밀번호</td>
                        <td><input type="password" name="password"></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="로그인">
                        </td>
                    </tr>
                </table>
            </form>
        </center>
    </body>
</html>