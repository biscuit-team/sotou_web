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

    if((length==0 || length>140)&&(0<pre && pre<=140))
    {
        $('#commit_comment').attr('disabled','disabled');
        $('#commit_comment').addClass('button_disabled');
    }
    else if((0<length && length<=140) &&(pre==0 || pre>140))
    {
        $('#commit_comment').removeAttr('disabled');
        $('#commit_comment').removeClass('button_disabled');
    }
    commentInfo.preWordsNum = length;
}

function commitComment(){
    var content = $('#input_area').val();
    var id = 7105;

    if(content.length>0)
    {
        var data={"content":content,"id":id};
        $('#comments_wrapper').load("/invest/insertComment",data,function(){
            $('#input_area').val('');
            $('#commit_comment').attr('disabled','disabled');
            $('#commit_comment').addClass('button_disabled');
            $('#input_num').text(0)
        });
       /* $.ajax({
            url : "/invest/insertComment",
            type : "GET",
            data : data,
            dataType : "json",
            success : function(html){
                $('#comments_wrapper').html("");
                $('#comments_wrapper').html(html);
            }
        });*/
    }
    else
    {
        alert('Wrong!');
    }


}