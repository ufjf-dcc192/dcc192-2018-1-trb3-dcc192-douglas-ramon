<%-- 
    Document   : login
    Created on : Jul 7, 2018, 12:00:59 PM
    Author     : douglas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post">
            <div><label>Usuário: <input name="usuario" required/></label></div>
            <div><label>Senha: <input name="password" required type="senha"/></label></div>
            <div><input type="submit"/></div>
        </form>
    </body>
</html>
