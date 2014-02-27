<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
<script src="/sso/js/jquery.min.js"></script>
<script src="/sso/js/bootstrap.min.js"></script>
<link href="/sso/css/bootstrap.min.css" rel="stylesheet">
<link href="/sso/css/login.css" rel="stylesheet">
</head>
<body>
	<div class="container" id="page">
		<div class="header">
			<h1 id="logo">
				<a href=""><img alt="搜投网" src="/sso/images/sotou2.jpg"></a>
			</h1>
		</div>
		<div class="content" id="register-content">
			<div class="content-head">
				<h3>注册搜投</h3>
			</div>
			<div class="content-body" style="height: 500px;">
				<div class="pull-left" id="register-right">
					<form id="register-form" role="form" method="post">

						<c:if test="${success eq false}">
							<div>${msg}</div>
						</c:if>


						<div class="form-group">
							<label for="inputEmail" class="col-md-2 control-label">邮箱</label>
							<div class="col-md-9">
								<input type="email" class="form-control" id="inputEmail"
									name="email" value="${param.email}">
								<div class="focus-text">
									<p>邮箱可用于登陆和找回密码</p>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="inputUsername" class="col-md-2 control-label">用户名</label>
							<div class="col-md-9">
								<input type="text" class="form-control" id="inputUsername"
									name="username" value="${param.username}">
								<div class="focus-text">
									<p>中文或英文，4-16个字符</p>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword" class="col-md-2 control-label">密码</label>
							<div class="col-md-9">
								<input type="password" class="form-control" id="inputPassword"
									name="password">
								<div class="focus-text">
									<p>6-16个字符，建议使用字母加数字或符号组合</p>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword2" class="col-md-2 control-label">重复密码</label>
							<div class="col-md-9">
								<input type="password" class="form-control" id="inputPassword2"
									name="password2">
								<div class="focus-text">
									<p>请再次输入密码</p>
								</div>
							</div>
						</div>
						<div class="col-md-2"></div>
						<div class="col-md-9">
							<input type="submit" value="注册" class="btn" id="register-btn">
						</div>
					</form>
				</div>
				<div class="pull-right"></div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
</body>
</html>