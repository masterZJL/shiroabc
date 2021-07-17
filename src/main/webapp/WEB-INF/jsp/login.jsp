<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>hello world!</title>
</head>
<body>
    <h2>登陆页面</h2>
    <form action="dologin" method="post">
        名称：<input type="text" name="username" /><br />
        密码：<input type="text" name="password"><br />
        <button type="submit">登录</button>
    </form>
</body>
</html>