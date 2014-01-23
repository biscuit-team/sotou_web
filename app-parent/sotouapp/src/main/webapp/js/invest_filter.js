filter = {};
initialFilter();

function initialFilter(){

    var sortCondition = {};
    sortCondition['rate'] = true;
    sortCondition['period'] = true;
    sortCondition['sum'] = true;
    sortCondition['process'] = true;
    filter.sorted = 'default';
    filter.sortCondition = sortCondition;
    filter.hidden = true;
    filter.chosenRate = 'rate0';
    filter.chosenPeriod = 'period0';
    filter.chosenSum = 'sum0';
}

function changeCondition(id){
    var map = {}
    var key = 'chosen';
    var type = '';
    if(id.indexOf('rate') ==0)
    {
        key +='Rate';
        type = 'rate';
    }
    else if(id.indexOf('sum') ==0)
    {
        key +='Sum';
        type = 'sum';
    }
    else if(id.indexOf('period') ==0)
    {
        key +='Period';
        type = 'period';
    }

    hideSelfDefine(type);
    changeFilterUI(type,id);
    ajaxCall();
}
function changeFilterUI(type,newId){
    var map ={'rate':'Rate','sum':'Sum','period':'Period'};
    var key = 'chosen'+map[type];
    var oldId = filter[key];
    filter[key] = newId;
    $('#'+oldId).removeClass('active');
    $('#'+newId).addClass('active');
}
function ajaxCall(){
    var array = $('.filter_contain .active');
    var rate = $(array[0]);
    var sum = $(array[1]);
    var period = $(array[2]);
    var rateMin = rate.attr('data-min');
    var rateMax = rate.attr('data-max');
    var sumMin = sum.attr('data-min');
    var sumMax = sum.attr('data-max');
    var periodMin = period.attr('data-min');
    var periodMax = period.attr('data-max');
    var orderBy = filter.sorted;
    var oType = filter.sortCondition[orderBy];
    var map ={true:'desc',false:'asc'};
    var orderType=map[oType];
    var per = 20;
    var page = 0;
    var data ={'per':per,'page':page,'orderBy':orderBy,'orderType':orderType,'rate.min':rateMin,
        'rate.max':rateMax,'sum.min':sumMin,'sum.max':sumMax,'period.min':periodMin,
        'period.max':periodMax};
    $.ajax({
        url : "http://localhost:8080/invest/query.json",
        type : "GET",
        data : data,
        dataType : "json",
        success : function(data){
            display(data);
        }
    });
}
function display(data){
    console.log(data);
}
function selfDefine(type){
    changeFilterUI(type,'');
    var textId = '#'+type+'_self_text';
    var inputWrapId = '#'+type+'_input_wrap';
    var selfWrapId = '#'+type+'_self_wrap';
    var minInputId = '#'+type+'_min_input';
    $(textId).addClass('hide');
    $(inputWrapId).removeClass('hide');
    $(selfWrapId).css('overflow','visible');
    $(minInputId).focus();
}
function hideSelfDefine(type){
    var textId = '#'+type+'_self_text';
    var inputWrapId = '#'+type+'_input_wrap';
    var selfWrapId = '#'+type+'_self_wrap';
    $(textId).removeClass('hide');
    $(inputWrapId).addClass('hide');
    $(selfWrapId).css('overflow','hidden');
    $('#'+type+'_self_wrap').removeClass('active'); //change
}

//检查自定义框中输入是否正确，在jsp页面调用
function checkRange(){
    var content = event.target.value;
    var valid = /^[0-9]*/g.exec(content)[0];
    event.target.value = valid;
}

function selfDefConfirm(type){
    var minVal = $('#'+type+'_min_input').val();
    var maxVal = $('#'+type+'_max_input').val();
    minVal = parseInt(minVal);
    maxVal = parseInt(maxVal);
    if(isNaN(minVal))
        minVal = 0;
    if(isNaN(maxVal))
        maxVal = -1;

    if(minVal > maxVal &&(maxVal != -1))
    {
        var tmp = minVal;
        minVal = maxVal;
        maxVal = tmp;
    }

    var text = adaptText(type,minVal,maxVal);
    $('#'+type+'_self_text').text(text);
    $('#'+type+'_self_text').removeClass('hide');
    $('#'+type+'_input_wrap').addClass('hide');
    ajaxCall();
}
function adaptText(type,minVal,maxVal){
    var text = '';
    var textEle = $('#'+type+'_self_wrap');
    if((maxVal == -1)&&(minVal == 0))
    {
        text = '自定义';
        changeCondition(type+'0');
    }
    else
    {

        if(type == 'rate')
        {
            textEle.attr('data-min',minVal/100);
            textEle.attr('data-max',maxVal/100);
            if(maxVal != -1)
            {
                text = minVal+'%-'+maxVal+'%';
            }
            else if(minVal !=0)
                text = minVal+'%以上';
        }
        else if(type == 'sum')
        {
            textEle.attr('data-min',minVal*10000);
            textEle.attr('data-max',maxVal*10000);
            if(maxVal != -1 && (minVal != 0))
            {
                text = minVal+'万-'+maxVal+'万';
            }
            else if(maxVal == -1)
            {
                text = minVal+'万以上';
            }
            else if(minVal ==0)
            {
                text = maxVal+'万以下'
            }
        }
        else if(type == 'period')
        {
            textEle.attr('data-min',minVal);
            textEle.attr('data-max',maxVal);
            if(maxVal != -1 && (minVal != 0))
            {
                text = minVal+'-'+maxVal+'个月';
            }
            else if(maxVal == -1)
            {
                text = minVal+'个月以上';
            }
            else if(minVal ==0)
            {
                text = maxVal+'个月内'
            }
        }
        $('#'+type+'_self_wrap').addClass('active');	//change
    }
    return text;
}
function platShow(){
    $('#plat_wrap').collapse('show');
    $('#plat_show').addClass('hide');
    $('#plat_hide').removeClass('hide');
    var ele = $('#fixedMenu');
    ele.attr('offsetTop',ele.offset().top);
}
function platHide(){
    $('#plat_wrap').collapse('hide');
    $('#plat_wrap').css('height','50px');
    $('#plat_show').removeClass('hide');
    $('#plat_hide').addClass('hide');
    var ele = $('#fixedMenu');
    ele.attr('offsetTop',ele.offset().top);
}

function sort(orderBy){
    var newId = 'sort_'+orderBy;
    if(filter.sorted == orderBy)
    {

        var span = $('#'+newId+' span');
        span.removeClass();
        var sortCondition = filter.sortCondition;
        var temp = sortCondition[orderBy];
        temp = !temp;
        sortCondition[orderBy] = temp;
        var map = {true:'glyphicon glyphicon-arrow-down arrow',false:'glyphicon glyphicon-arrow-up arrow'};
        span.addClass(map[temp]);
    }
    else
    {
        var oldId = 'sort_'+filter.sorted;
        $('#'+oldId).removeClass('active');
        $('#'+newId).addClass('active');
        filter.sorted = orderBy;
    }
    ajaxCall();
}





/*function togglePlat(){
 var hidden = !(filter.hidden);
 if(hidden) //应当是折叠状态
 {
 $('#plat_wrap').collapse('hide');
 $('#plat_wrap').css('height','60px');
 }
 else //应当是展开状态
 {
 $('#plat_wrap').collapse('show');
 }
 filter.hidden = hidden;

 }

 function changeInvest(){

 }


 function hideConfirmButton(type){

 }

 function showConfirmButton(type){
 var ele = $('#'+type+'_self_wrap');
 ele.css('overflow','visible');
 }

 function numToUnit(num){
 var ini = 1000;
 num /= 1000;
 if(num<10)
 return num+'千';
 else
 return (num/10)+'万';
 }*/