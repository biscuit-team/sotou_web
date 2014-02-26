<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title></title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width">

<link rel="stylesheet" href="/css/bootstrap.min.css">
<style>
body {
	padding-top: 50px;
	padding-bottom: 20px;
}

.my_navbar {
	background-color: #F0AB00;
	height: 50px;
	position: absolute;
	top: 0px;
	width: 100%;
}

.td_title {
	text-align: center;
}

.em_num {
	font-size: 1.5em;
	padding-left: 0.5em;
}

td {
	vertical-align: bottom;
	font-size: 1em;
}

.rate_calc input,.rate_calc table {
	width: 150px;
}
</style>
<link rel="stylesheet" href="/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="/css/main.css">
<link rel="stylesheet" href="/css/product_comment.css">

<script src="/js/product_comment.js"></script>
<!--[if lt IE 9]>
	<script src="js/vendor/html5-3.6-respond-1.1.0.min.js"></script>
	<![endif]-->
</head>
<body>
	<div class="my_navbar"></div>

	<!-- Main jumbotron for a primary marketing message or call to action -->


	<div class="container">

		<div class="panel">


			<div class="page-header">
				<h1>
					淘宝卖家 实体经营 <small class="day_left">剩余六天</small>
				</h1>
			</div>

			<div class="row">

				<div class="col-lg-6">

					<div class="main_field">
						<table>
							<tr>
								<td class="td_title">金 额</td>
								<td>:</td>
								<td><span class="em_num">5,000</span>元</td>
							</tr>
							<tr>
								<td class="td_title">年利率</td>
								<td>:</td>
								<td><span class="em_num">18.00</span>%</td>
							</tr>
							<tr>
								<td class="td_title">奖 励</td>
								<td>:</td>
								<td><span class="em_num">2.2</span>%</td>
							</tr>
							<tr>
								<td class="td_title">期 限</td>
								<td>:</td>
								<td><span class="em_num">10</span>个月</td>
							</tr>

						</table>

					</div>

					<div class="second_field">
						<table>

							<tr>
								<td class="td_title">标的类型</td>
								<td>:</td>
								<td><span class="biao-icon-jing"></span></td>

								<td class="td_title">还款方式</td>
								<td>:</td>
								<td>按月还款/等额本息</td>
							</tr>
							<tr>
								<td class="td_title">保障方式</td>
								<td>:</td>
								<td>本金</td>


								<td class="td_title">每月还款</td>
								<td>:</td>
								<td>518元</td>
							</tr>

						</table>
					</div>

					<div class="foot_info">

						<small>来自<a>宜人贷</a> | 浏览量 2183
						</small>

					</div>

				</div>

				<div class="biao_process">
					<span class="process_bar"></span>
				</div>
				<div class="rate_calc">
					<span><input type="text" /></span><span>/1800元可投</span>
					<table>
						<tr>
							<td>利率收益</td>
							<td>180元</td>
						</tr>

						<tr>
							<td>奖励</td>
							<td>22元</td>
						</tr>
						<tr>
							<td>总收益</td>
							<td>22元</td>
						</tr>
					</table>
				</div>
				<div class="want_link"></div>

				<div class="col-lg-6"></div>
			</div>
		</div>

	</div>


	<div class="container">

		<!-- Nav tabs -->
		<ul class="nav nav-tabs">
			<li class="active"><a href="#invest_details" data-toggle="tab">借款详情</a></li>
			<li><a href="#comment" data-toggle="tab">评论</a></li>
		</ul>

		<!-- Tab panes -->
		<div class="tab-content">
			<div class="tab-pane fade in active" id="invest_details">
				<h2>借款人说明</h2>
				<p>近期因工作需要，购买一辆车，资金需要5万元。望给予批准！</p>
				<h2>还款表现</h2>

				<h2>投标记录</h2>
			</div>
			<div class="tab-pane fade" id="comment">
                <div id="comments_wrapper" class="comments_wrapper" style="padding-top: 20px;width: 600px">
                    <c:import url="/invest/10/comment"></c:import>
                    <div class="comment_item">
                        wait a moment, I will disappear!!!
                    </div>
                </div>
                <div style="width:600px">
                    <div class="input_wrapper">
                        <textarea id="input_area" class="input_area" placeholder="请输入评论" style="height: 67px;"></textarea>
                    </div>
                    <div class="toolbar_wrapper">
                        <div class="toolbar">
                            字数:<span id="input_num">0</span>/140
                        </div>
                        <button id="commit_comment" class="commit_comment button_disabled" disabled="disabled">发表评论</button>
                    </div>
                </div>
			</div>
		</div>

	</div>

	<div class="container">


		<hr>

		<footer>
			<p>&copy; Sotou 2013</p>
		</footer>
	</div>
	<!-- /container -->
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="js/vendor/jquery-1.10.1.min.js"><\/script>')
	</script>

	<script src="/js/vendor/bootstrap.min.js"></script>

	<script src="/js/main.js"></script>
    <script>
        $().ready(function(){
            $('#input_area').bind('input propertychange',function(event){computeWords(event)});
            $('#commit_comment').bind('click',function(){commitComment()});
        });
    </script>
</body>
</html>
