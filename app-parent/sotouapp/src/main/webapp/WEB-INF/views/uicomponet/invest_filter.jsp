<%--
  Created by IntelliJ IDEA.
  User: shuhzhang
  Date: 14-1-15
  Time: 下午2:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- css: invest_filter.css
     js:invest_filter.js, invest_pager.js
-->
<div>
<div class="condition_decorator" >
    <div class="container filter_contain">
        <div class="condition_contain">
            <table style="text-align:center">
                <tr>
                    <td class="condition_left">预期利率 :</td>

                    <td ><div id="rate0" onclick="changeCondition('rate0')" class="active" data-min="0" data-max="-1">不限</div>
                    </td>
                    <td><div id="rate1" onclick="changeCondition('rate1')" data-min="0" data-max="0.1">10%以下</div>
                    </td>
                    <td><div id="rate2" onclick="changeCondition('rate2')" data-min="0.1" data-max="0.18">10%-18%</div>
                    </td>
                    <td><div id="rate3" onclick="changeCondition('rate3')" data-min="0.18" data-max="0.24">18%-24%</div>
                    </td>
                    <td><div id="rate4" onclick="changeCondition('rate4')" data-min="0.24" data-max="-1">24%以上</div>
                    </td>
                    <td><div id="rate_self_wrap" class="self_wrap"><div id="rate_self_text" class="self_text" onclick="selfDefine('rate')">自定义</div>
                        <div id="rate_input_wrap" class="input_wrap hide"><input id="rate_min_input" type='text' class="form-control self_def" onfocus="showConfirmButton('rate')">% - <input id="rate_max_input" type='text' class="form-control self_def">%
                            <button class="self_def_button" onclick="selfDefConfirm('rate')">确定</button>
                        </div>
                    </div>
                    </td>
                </tr>

                <tr>
                    <td class="condition_left">贷款金额 :</td>

                    <td><div class="active" id="sum0" onclick="changeCondition('sum0')" data-min="0" data-max="-1">不限</div>
                    </td>
                    <td><div id="sum1" onclick="changeCondition('sum1')" data-min="0" data-max="5000">5千以下</div>
                    </td>
                    <td><div id="sum2" onclick="changeCondition('sum2')" data-min="5000" data-max="10000">5千-1万</div>
                    </td>
                    <td><div id="sum3" onclick="changeCondition('sum3')" data-min="10000" data-max="50000">1万-5万</div>
                    </td>
                    <td><div id="sum4" onclick="changeCondition('sum4')" data-min="50000" data-max="100000">5万-10万</div>
                    </td>
                    <td><div id="sum5" onclick="changeCondition('sum5')" data-min="100000" data-max="200000">10万-20万</div>
                    </td>
                    <td><div id="sum6" onclick="changeCondition('sum6')" data-min="200000" data-max="-1">20万以上</div>
                    </td>
                    <td><div id="sum_self_wrap" class="self_wrap"><div id="sum_self_text" class="self_text" onclick="selfDefine('sum')">自定义</div>
                        <div id="sum_input_wrap" class="input_wrap hide"><input id="sum_min_input" type='text' class="form-control self_def " > 万 - <input id="sum_max_input" type='text' class="form-control self_def "> 万
                            <button class="self_def_button" onclick="selfDefConfirm('sum')">确定</button>
                        </div>
                    </div>
                    </td>

                </tr>

                <tr>
                    <td class="condition_left">贷款周期 :</td>
                    <td><div id="period0" onclick="changeCondition('period0')" class="active" data-min="0" data-max="-1">不限</div>
                    </td>
                    <td><div id="period1" onclick="changeCondition('period1')" data-min="0" data-max="1">1个月内</div>
                    </td>
                    <td><div id="period2" onclick="changeCondition('period2')" data-min="1" data-max="3">1-3个月</div>
                    </td>
                    <td><div id="period3" onclick="changeCondition('period3')" data-min="3" data-max="6">3-6个月</div>
                    </td>
                    <td><div id="period4" onclick="changeCondition('period4')" data-min="6" data-max="12">6-12个月</div>
                    </td>
                    <td><div id="period5" onclick="changeCondition('period5')" data-min="12" data-max="24">12-24个月</div>
                    </td>
                    <td><div id="period6" onclick="changeCondition('period6')" data-min="24" data-max="-1">24个月以上</div>
                    </td>
                    <td><div id="period_self_wrap" class="self_wrap"><div id="period_self_text" class="self_text" onclick="selfDefine('period')">自定义</div>
                        <div id="period_input_wrap" class="input_wrap hide"><input id="period_min_input" type='text' class="form-control self_def" > - <input id="period_max_input" type='text' class="form-control self_def"> 个月
                            <button class="self_def_button" onclick="selfDefConfirm('period')">确定</button>
                        </div>
                    </div>
                    </td>

                </tr>
                <!--<tr>
                <td class="condition_left">预期利率 :</td>
                <td >
                    <ul>
                        <li ><a id="rate0" onclick="changeCondition('rate0')" class="active">不限</a>
                        </li>
                        <li><a id="rate1" onclick="changeCondition('rate1')">10%以下</a>
                        </li>
                        <li><a id="rate2" onclick="changeCondition('rate2')">10%-18%</a>
                        </li>
                        <li><a id="rate3" onclick="changeCondition('rate3')">18%-24%</a>
                        </li>
                        <li><a id="rate4" onclick="changeCondition('rate4')">24%以上</a>
                        </li>
                        <li><a id="rate5" onclick="changeCondition('rate5')">自定义</a>
                        </li>
                    </ul>
                </td>
                </tr>

                <tr>
                <td class="condition_left">贷款金额 :</td>
                <td >
                    <ul>
                        <li><a class="active" id="sum0" onclick="changeCondition('sum0')">不限</a>
                        </li>
                        <li><a id="sum1" onclick="changeCondition('sum1')">5千以下</a>
                        </li>
                        <li><a id="sum2" onclick="changeCondition('sum2')">5千-1万</a>
                        </li>
                        <li><a id="sum3" onclick="changeCondition('sum3')">1万-5万</a>
                        </li>
                        <li><a id="sum4" onclick="changeCondition('sum4')">5万-10万</a>
                        </li>
                        <li><a id="sum5" onclick="changeCondition('sum5')">10万-20万</a>
                        </li>
                        <li><a id="sum6" onclick="changeCondition('sum6')">20万以上</a>
                        </li>
                        <li><a id="sum7" onclick="changeCondition('sum7')">自定义</a>
                        </li>
                    </ul>
                </td>
                </tr>

                <tr>
                <td class="condition_left">贷款周期 :</td>
                <td >
                    <ul>
                        <li><a id="period0" onclick="changeCondition('period0')" class="active">不限</a>
                        </li>
                        <li><a id="period1" onclick="changeCondition('period1')">1个月内</a>
                        </li>
                        <li><a id="period2" onclick="changeCondition('period2')">1-3个月</a>
                        </li>
                        <li><a id="period3" onclick="changeCondition('period3')">3-6个月</a>
                        </li>
                        <li><a id="period4" onclick="changeCondition('period4')">6-12个月</a>
                        </li>
                        <li><a id="period5" onclick="changeCondition('period5')">12-24个月</a>
                        </li>
                        <li><a id="period6" onclick="changeCondition('period6')">24个月以上</a>
                        </li>
                        <li><a id="period7" onclick="changeCondition('period7')">自定义</a>
                        </li>
                    </ul>
                </td>
                </tr>	-->
            </table>
        </div>
    </div>
</div>

<div class="plat_decorator" >
    <div class="container ">
        <div class="plat_contain">
            <table><tr>
                <td class="platname_cell">
                    <div style="height:40px;overflow:hidden;display:block" id="plat_wrap" class="">
                        <ul >
                            <!--<li class="active">全部（300）
                            </li>
                            <li>人人贷（50）
                            </li>
                            <li>拍拍贷（50）
                            </li>
                            <li>翼龙贷（50）
                            </li>
                            <li>陆金所（50）
                            </li>
                            <li>红岭创投（50）
                            </li>
                            <li>第一P2p（50）
                            </li>
                            <li>第一P2p（50）
                            </li>-->
                        </ul>
                    </div>
                </td>
                <td style="vertical-align:middle">
                    <button id="plat_btn" type="button" class="btn btn-primary btn-xs hide" onclick="togglePlat()">
                        <div id="plat_show"><span class="glyphicon glyphicon-collapse-down"></span> 更多</div>
                        <div id="plat_hide" class="hide"><span class="glyphicon glyphicon-collapse-up"></span> 收起</div>
                    </button>
                </td>
            </tr></table>
        </div>
    </div>
</div>

<div style="text-align:center;width:100%" id="fixedMenu">
    <div class="container" >
        <div class="sortbar">
            <div class="sort_filter">
                <ul class="sort_btns">
                    <li id='sort_rate' onclick="sort('rate')" >利率 <span class="glyphicon glyphicon-arrow-down arrow"></span>
                    </li >
                    <li id='sort_period' onclick="sort('period')">周期 <span class="glyphicon glyphicon-arrow-down arrow"></span>
                    </li>
                    <li id='sort_sum' onclick="sort('sum')">金额 <span class="glyphicon glyphicon-arrow-down arrow"></span>
                    </li >
                    <li id='sort_process' onclick="sort('process')">进度 <span class="glyphicon glyphicon-arrow-down arrow"></span>
                    </li>
                </ul>
            </div>
            <div class="calculator">
                <span>欲投资金额：</span>
                <div class="input-group input-group-sm input_num" >
                    <input type="text" id="invest_num" class="form-control">
                    <span class="input-group-addon">元</span>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <div class="item_contain">
        <!-- 用于clone的item div开始-->
        <div class="info-item hide" id="item_template">
            <div class="item-header">
                <div class="pull-left title">
                    <span class="platform"><a class="loan_plat" >拍拍贷</a></span><span ><strong class=""><a class="title-content loan_use">资金周转</a></strong></span><span
                        class="item-mark"></span>
                </div>
                <div class="pull-right total-num"><span class="total_profit">5,110</span><span class="left" style="font-size:12px;">元</span></div>
            </div>
            <hr>
            <div class="item-content">

                <div class="d01 pull-left">
                    <div class="progress progress-striped active"
                         style="margin-bottom: 0px; margin-top: 5px">
                        <div class="progress-bar progress-bar-warning invest_process" role="progressbar"
                             aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
                             style="width: 40%">
                            <span class="sr-only">40% Complete (warning)</span>
                        </div>
                    </div>
                    <p class="bellow item-dec">已投<span class="have_invested">2万</span>元可投<span class="remain_invest">3万元</span></p>
                </div>
                <div class="d02 pull-left">
                    <p>
                        <span class="num loan_sum">50,000</span><span class="left">元</span>
                    </p>
                    <p class="item-dec">金额</p>
                </div>
                <div class="d03 pull-left">
                    <p class="num ">
                        <span class="profit_rate">10</span>%
                    </p>
                    <p class="item-dec">年利率</p>
                </div>
                <div class="d04 pull-left">
                    <p class="num "><span class="reward_rate">2.2</span>%</p>
                    <p class="item-dec">奖金</p>
                </div>
                <div class="d05 pull-left">
                    <p>
                        <span class="num loan_period">12</span><span class="left period_unit">月</span>
                    </p>
                    <p class="item-dec">周期</p>
                </div>
                <div class="d06 pull-left">
                    <p class="item-repay back_type">等额本息</p>
                    <p class="item-guarantee ensure_type">本息保障</p>
                </div>

                <div class="dbtn pull-right">
                    <button class="btn btn-warning">查看</button>
                </div>
                <div class="d07 pull-right">
                    <p>
                        <span class="num interest_profit">5,000</span><span class="left">元</span><span
                            class="item-s-dec">息</span>
                    </p>
                    <p>
                        <span class="num reward_profit">110</span><span class="left">元</span><span class="item-s-dec">奖</span>
                    </p>
                </div>

            </div>
        </div>
        <!-- 用于clone的item div结束-->
        <div id="item_wrap" class="item_wrap">

        </div>
        <div id="loader" class="loader hide">
            <img src="../../../images/loading.gif">
        </div>
    </div>
</div>

<div class="container">
    <div id="pagination" class="pager_contain">
        <a class="jPaginatorMax" id="max_backward"><span class="glyphicon glyphicon-fast-backward"></span></a>

        <div class='paginator_p_wrap'>

            <div class='paginator_p_bloc'>

            </div>

        </div>


        <a class="jPaginatorMax" id="max_forward"><span class="glyphicon glyphicon-fast-forward"></span></a>
        <div class="paginator_slider"></div>

    </div>
</div>
<!--<ul class="pagination">
  <li><a href="#">&laquo;</a></li>
  <li><a href="#">1</a></li>
  <li id="pre_omit" class=""><a href="#">...</a></li>
  <li><a href="#">2</a></li>
  <li><a href="#">3</a></li>
  <li><a href="#">4</a></li>
  <li><a href="#">5</a></li>
  <li><a href="#">6</a></li>
  <li id="post_omit" class=""><a href="#">...</a></li>
  <li><a href="#">&raquo;</a></li>
</ul>-->
</div>
<script>
    $().ready(function(){
        var ele = $('#fixedMenu');
        ele.attr('offsetTop',ele.offset().top);
        $('.filter_contain td .self_def').bind('keyup',function(event){checkRange(event)});
        $('#invest_num').bind('keyup',function(event){
            checkRange(event);
            if($('#invest_num').val() != filter.invest)
            {
                console.log('in');
                calcuAllProfit();
            }
        });
        ajaxCall({'refreshPage':true,'refreshPlat':true});

    });
    $('#plat_wrap').on('hidden.bs.collapse', function () {
        var ele = $('#fixedMenu');
        ele.attr('offsetTop',ele.offset().top);
    });
    $('#plat_wrap').on('shown.bs.collapse', function () {
        var ele = $('#fixedMenu');
        ele.attr('offsetTop',ele.offset().top);
    });

    $(window).scroll(function (e) {
        clearTimeout($.data(this, 'scrollTimer'));
        $.data(this, 'scrollTimer', setTimeout(function() {
            var offset = Math.max(document.body.scrollTop || document.documentElement.scrollTop);
            var ele = $('#fixedMenu');
            if(offset > parseInt(ele.attr('offsetTop')))
            {
                ele.addClass('fixedTop');
            }
            else
            {
                ele.removeClass('fixedTop');
            }
            console.log("Haven't scrolled in 250ms!");
        }, 100));

    });

</script>