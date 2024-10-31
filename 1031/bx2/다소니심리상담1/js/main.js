$(function(){
    setTimeout(function(){
        $('.slider li .text0').addClass('on');
        $('.slider li .atext0').addClass('on');
        $('.slider li .aa').addClass('on');
    },1000);





   var slider = $('.slider').bxSlider({
        // auto:true,
        // controls:false,
        // pager:false,
        mode:'fade',
        pause:5000,
        onSlideBefore:function(){},
        onSlideAfter:function(){
            var k = slider.getCurrentSlide();
            $('.slider li').find('h2').removeClass('on');
            $('.slider li ').find('p').removeClass('on');
            $('.slider li .text'+k).addClass('on');
            $('.slider li .atext'+k).addClass('on');
            $('.slider li .aa').addClass('on');
        },
    });



});