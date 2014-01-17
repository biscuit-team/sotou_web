filter = {};
initialFilter();

function initialFilter(){

    var sortCondition = {};
    sortCondition['rate'] = true;
    sortCondition['period'] = true;
    sortCondition['sum'] = true;
    sortCondition['process'] = true;
    filter.sorted = 'rate';
    filter.sortCondition = sortCondition;
    filter.hidden = true;
    filter.chosenRate = 'rate0';
    filter.chosenPeriod = 'period0';
    filter.chosenSum = 'sum0';
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

function togglePlat(){
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

function changeCondition(id){

    var key = 'chosen';
    if(id.indexOf('rate') ==0)
        key +='Rate';
    else if(id.indexOf('sum') ==0)
        key +='Sum';
    else if(id.indexOf('period') ==0)
        key +='Period';
    var oldId = filter[key];
    filter[key] = id;
    changeFilterUI(oldId,id);

}
function changeFilterUI(oldId,newId){
    $('#'+oldId).removeClass('active');
    $('#'+newId).addClass('active');
}
function ajaxCall(){

}
