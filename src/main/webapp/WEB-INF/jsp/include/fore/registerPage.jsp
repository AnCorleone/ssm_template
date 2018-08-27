<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/27
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<script>
    $(function () {
        /*判空操作*/

        $(".registerForm").submit(function () {
            <%--<c:if test="${!empty msg}">
            $("span.errorMessage").html("${msg}");
            $(".registerErrorMessageDiv").show();
            </c:if>--%>

            <%--判断用户名--%>
            if (0 == $("#name").val().length) {
                $("span.errorMessage").html("请输入用户名");
                $(".registerErrorMessageDiv").show();

                return false;
            }
            if (0 == $("#password").val().length) {
                $("span.errorMessage").html("请输入密码");
                $(".registerErrorMessageDiv").show();
                return false;
            }
            if (0 == $("#repeatpassword").val().length) {
                $("span.errorMessage").html("请输入重复密码");
                $(".registerErrorMessageDiv").show();
                return false;
            }
            if ($("#password").val() != $("#repeatpassword").val()) {
                $("span.errorMessage").html("两次输入的密码不一致");
                $(".registerErrorMessageDiv").show();
                return false;
            }
            return true;
        });
    });


</script>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
<form method="post" class="registerForm" action="foreregister">
    <%--错误信息--%>
    <div class="registerDiv">
        <div class="registerErrorMessageDiv">
            <div class="alert alert-danger role=" alert
            " >
            <button class="close" data-dismiss="alert" aria-label="Close"></button>
            <span class="errorMessage"></span>
        </div>
    </div>
    <%--注册信息--%>
    <table class="registerTable" align="center">
        <tr>
            <td class="registerTip registerTableLeftTD">设置会员名</td>
            <td></td>
        </tr>
        <tr>
            <td class="registerTableLeftTD"> 登录名</td>
            <td class="registerTableRightTD"><input type="text" id="name" name="name"
                                                    placeholder="会员名一旦设置成功无法修改"></td>
        </tr>

        <tr>
            <td class="registerTip registerTableLeftTD">设置登录密码</td>
            <td class="registerTableRightTD"> 登录时验证,保护账号信息</td>
        </tr>

        <tr>
            <td class="registerTableLeftTD"> 登录密码</td>
            <td class="registerTableRightTD"><input type="password" id="password" name="password"
                                                    placeholder="设置你的登录密码"></td>
        </tr>

        <tr>
            <td class="registerTableLeftTD">密码确认</td>
            <td class="registerTableRightTD"><input type="password" id="repeatpassword"
                                                    name="repeatpassword" placeholder="请再次输入你的密码">
            </td>
        </tr>

        <tr>
            <td colspan="2" class="registerButtonTD">
                <a href="registerSuccess.jsp">
                    <button>提 交</button>
                </a>
            </td>
        </tr>
    </table>
    </div>
</form>
</body>
</html>
