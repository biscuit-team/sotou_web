<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登陆</title>
<script src="/sso/js/jquery.min.js"></script>
<script src="/sso/js/bootstrap.min.js"></script>
<link href="/sso/css/bootstrap.min.css" rel="stylesheet">
<link href="/sso/css/login.css" rel="stylesheet">
</head>
<body>
	<div class="center-block" id="page">
		<div class="header">
			<h1 id="logo">
				<a href=""><img alt="搜投网" src="/sso/images/sotou2.jpg"></a>
			</h1>
		</div>
		<div class="content">
			<div id="loginPic">
				<div class="pull-right" id="login-box">
					<form:form method="post" id="login-form"
						commandName="${commandName}" htmlEscape="true">

						<form:errors path="*" id="msg" cssClass="errors" element="div"
							htmlEscape="false" />

						<legend>登陆</legend>
						<c:choose>
							<c:when test="${not empty sessionScope.openIdLocalId}">
								<strong>${sessionScope.openIdLocalId}</strong>
								<input type="hidden" id="username" name="username"
									value="${sessionScope.openIdLocalId}" />
							</c:when>
							<c:otherwise>
								<form:input cssClass="form-control" cssErrorClass="error"
									id="username" size="25" placeholder="邮箱" path="username"
									autocomplete="off" htmlEscape="true" />
							</c:otherwise>
						</c:choose>

						<form:password cssClass="form-control" cssErrorClass="error"
							id="password" size="25" path="password"
							accesskey="${passwordAccessKey}" htmlEscape="true"
							autocomplete="off" placeholder="密码" />


						<div class="login-row">
							<label id="login-label" class="pull-left"> <input
								type="checkbox"><span style="margin-left: 5px;">自动登陆</span>
							</label> <a class="pull-right" href="" id="forgetPsw">忘记密码？</a>
						</div>

						<input class="btn" name="submit" value="登陆" type="submit"
							id="login-btn" />

						<input type="hidden" name="lt" value="${loginTicket}" />
						<input type="hidden" name="execution" value="${flowExecutionKey}" />
						<input type="hidden" name="_eventId" value="submit" />

					</form:form>
					<div class="row" id="otherAccount">
						<div class="col-md-4">
							<a href="${QQProviderUrl}"><img>QQ</a>
						</div>
						<div class="col-md-4">
							<a href="${SinaWeiboProviderUrl}"><img>新浪微博 </a>
						</div>
						<div class="col-md-4">
							<a><img>支付宝</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="footer"></div>
	</div>
</body>
</html>
