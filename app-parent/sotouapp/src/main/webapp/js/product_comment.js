function computeWords(event){
    var content = event.target.value;
    var length = content.length;
    $('#input_num').text(length);
    if(length > 140)
    {
        $('#input_num').addClass('input_over');
        $('#commit_comment').attr('disabled','disabled');
        $('#commit_comment').addClass('button_disabled');
    }
    else
    {
        $('#input_num').removeClass('input_over');
        $('#commit_comment').removeAttr('disabled');
        $('#commit_comment').removeClass('button_disabled');
    }
}

function commitComment(){
    var content = $('#input_area').val();
    var id = 7105;
    var data={content:content,id:id};
    if(content.length>0)
    {
        $.ajax({
            url : "/invest/insertComment",
            type : "GET",
            data : data,
            dataType : "json",
            success : function(html){
                $('#comments_wrapper').html("");
                $('#comments_wrapper').html(html);
            }
        });
    }

}