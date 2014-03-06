commentInfo = {};
commentInfo.preWordsNum = 0;
function computeWords(event){
    var content = event.target.value;
    var length = content.length;
    var pre = commentInfo.preWordsNum;
    $('#input_num').text(length);
    if(length>140)
        $('#input_num').addClass('input_over');
    else
        $('#input_num').removeClass('input_over');

    if((length<=4 || length>140)&&(0<pre && pre<=140))
    {
        $('#commit_comment').attr('disabled','disabled');
        $('#commit_comment').addClass('button_disabled');
    }
    else if((4<length && length<=140) &&(pre<=4 || pre>140))
    {
        $('#commit_comment').removeAttr('disabled');
        $('#commit_comment').removeClass('button_disabled');
    }
    commentInfo.preWordsNum = length;
}

function commitComment(){
    var content = $('#input_area').val();
    var id = 1;

    if(content.length>4)
    {
        var data={"content":content,"id":id};
        $('#comments_wrapper').load("/invest/insertComment",data,function(){
            $('#input_area').val('');
            $('#commit_comment').attr('disabled','disabled');
            $('#commit_comment').addClass('button_disabled');
            $('#input_num').text(0);
            commentInfo.preWordsNum = 0;
        });
    }
    else
    {
        alert('Wrong!');
    }


}