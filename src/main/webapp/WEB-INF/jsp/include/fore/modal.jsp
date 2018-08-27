<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/22
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<div class="modal" id="loginModal" tabindex="-1" role="dialog">
	<div class="modal-dialog loginDivInProductPageModalDi">
		<div class="modal-content">
			<div class="loginDivInProductPage">
				<div class="loginErrorMessageDiv">
					<div class="alert alert-danger">
						<button class="close" type="button" data-dismiss="alert" aria-label="close">
						</button>
						<span class="errorMessage"></span>
					</div>
				</div>
				<div class="login_acount_text">账户登录</div>
				<%--账户--%>
				<div class="loginInput">
					<span class="loginInputIcon">
						<span class="glyphicon glyphicon-user"></span>
					</span>
					<input id="name" name="name" placeholder="手机号/邮箱/会员名" type="text">
				</div>

				<%--密码--%>
				<div class="loginInput">
					<span class="loginInputIcon">
						<span class="glyphicon glyphicon-lock"></span>
					</span>
					<input id="password" name="password" type="password" placeholder="密码">
				</div>

				<span class="text-danger"> 请不要输入真实的天猫账号和密码</span>

				<div>
					<a href="#nowhere">忘记登录密码</a>
					<a href="register.jsp" class="pull-right">免费注册</a>
				</div>
				<div style="margin-top:20px">
					<button class="btn btn-block redButton
					 loginSubmitButton" type="submit">登录</button>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="modal" id="deleteConfirmModal" tabindex="-1" role="dialog">
	<div class="modal-dialog deleteConfirmModalDiv">
		<div class="modal-content">
			<div class="modal-header">
				<button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span
						class="sr-only">Close</span></button>
				<h4 class="modal-title">确认删除？</h4>
			</div>
			<div class="modal-footer">
				<button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
				<button class="btn btn-primary deleteConfirmButton" id="submit" type="button">确认</button>
			</div>
		</div>
	</div>
</div>
</div>
</body>
</html>
