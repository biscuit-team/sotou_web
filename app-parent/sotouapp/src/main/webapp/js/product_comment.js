function computeWords(event){
    var content = event.target.value;
    var length = content.length;
    $('#input_num').text(length);
    if(length > 14)
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
    alert('123');
}