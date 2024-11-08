$(function(){
    var a2 = $('#area2').offset().top;
    var a3 = $('#area3').offset().top;
    var ash = $('#ashColorArea').offset().top;
console.log(a2,a3,ash);
    $(window).scroll(function(){
        var sct = $(this).scrollTop();

        $('#sValue').text(sct);
        $('#area1').css('background-position-y',sct);

        if(sct > a2){
            $('#area2').css('background-position-y',sct -a2);
        }else{
            $('#area3').css('background-position-y','top')
        }
        if(sct > a3){
            $('#area3').css('background-position-y',(sct -a3)*2);
        }else{
            $('#area3').css('background-position-y','top')
        }

        if(sct > ash){
            var h4 = sct - ash - 800;
            console.log(h4);
            $('#area4').css('background-position-y',h4);
        }else{
            $('#area4').css('background-position-y','-200');
        }
        
    });




});