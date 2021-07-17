<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    <h2>首页</h2>
    <a href="logout">退出登录</a>
    <hr />
    <ul>
        <shiro:hasRole name="admin">
            <li>菜单1</li>
        </shiro:hasRole>
        <li>菜单2</li>
        <li>菜单3</li>
        <shiro:hasRole name="user">
            <li>菜单4</li>
        </shiro:hasRole>
    </ul>
</body>
</html>