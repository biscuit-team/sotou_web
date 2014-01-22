<%--
  Created by IntelliJ IDEA.
  User: shuhzhang
  Date: 14-1-15
  Time: 下午2:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <div style="height:50px;overflow:hidden;display:block" id="plat_wrap" class="">
                        <ul >
                            <li>全部（300）
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
                            </li>
                        </ul>
                    </div>
                </td>
                <td style="vertical-align:top">
                    <button id="plat_show" type="button" class="btn btn-primary btn-xs" onclick="platShow()">
                        <span class="glyphicon glyphicon-collapse-down"></span> 更多
                    </button>
                    <button id="plat_hide" type="button" class="btn btn-primary btn-xs hide" onclick="platHide()">
                        <span class="glyphicon glyphicon-collapse-up"></span> 收起
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
                    <input type="text" class="form-control">
                    <span class="input-group-addon">元</span>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<script>
    $().ready(function(){
        var ele = $('#fixedMenu');
        ele.attr('offsetTop',ele.offset().top);
        $('.filter_contain td .self_def').bind('keyup',function(event){checkRange(event)});

    });
    $('#plat_wrap').on('hidden.bs.collapse', function () {
        var ele = $('#fixedMenu');
        ele.attr('offsetTop',ele.offset().top);
    });
    $('#plat_wrap').on('shown.bs.collapse', function () {
        var ele = $('#fixedMenu');
        ele.attr('offsetTop',ele.offset().top);
    });

    $(window).scroll(function () {
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
    });

</script>