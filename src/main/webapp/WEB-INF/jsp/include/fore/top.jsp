<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/21
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<html>
<head>
    <nav class="top">
        <a href=""><span>

        </span></a>

        <span> 喵, 欢迎来到天猫 </span>

        <c:if test="${!empty user}">
            <a href="../../../fore/login.jsp">${user.name}</a>
            <a href="forelogout">退出</a>
        </c:if>

        <c:if test="${empty user}">
            <a href="../../../fore/login.jsp">请登录</a>
            <a href="register.jsp">免费注册</a>
        </c:if>

        <span class="pull-right">
            <a href="forebought">我的订单</a>
            <a href="forecart">
                <span style="color: #C40000; margin: 0px;" class="glyphicon glyphicon-shopping-cart redColor">
            </span>
                购物车 <strong> ${cartTotalItemNumber}</strong>件
            </a>
        </span>
    </nav>
</head>
<body>

</body>
</html>
