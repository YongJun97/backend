$(function(){
    var swiper = new Swiper('.mySwiper',{
        slidesPerView:3,
        spaceBetween:30,
        navigation:{
            nextEl: ".swiper-button-next",
            prevEl: ".swiper-button-prev",
        },
        autoplay:true,
    });

    $('.btn_eventCntrol').click(function(){
        if($(this).hasClass('on')== false){
            $(this).addClass('on');
            swiper.autoplay.stop();
        }else{
            $(this).removeClass('on');
            swiper.autoplay()
        }
    });


    var num = 0;//슬라이드 증가번호
    var li_w = 1010;
    // alert(li_w);

    $('.next').click(function(){
        if(num == 3) return;
        num++;
        $('.listWrap').stop().animate({'margin-left': -li_w*num},500);
        
    });

    $('.prev').click(function(){
        if(num == 0) return;
        num--;
        $('.listWrap').stop().animate({'margin-left': -li_w*num},500);
        
    });


    







});