$(function(){
    //visual-item을 감싸는 .visual-img 변수 $slick에저장    
    var $slick = $('.visual-img');


// on 매서드는 제이쿼리 에서 여러개의 이벤트를 등록 가능
    $slick.on('init',function(event,slick,currentSlide){


    });
    
    $slick.on('afterChange',function(event,slick,currentSlide){
        //event객체 - 이벤트정보
         // console.log('이벤트위치정보',event.clientX, event.clientY);
        //$slick 다양한 메서드나 속성접근
        console.log('total slide',slick.slideCount); // 전체슬라이드의 개수
         $(".visual-item").removeClass("active");
         $(this).find(".visual-item").eq(currentSlide).addClass('active');
         //currentSlide - 현재 활성화된 슬라이드 번호
    });
    
    
    $slick.slick({
        dots:false,
        infinite:true,
        arrows:true,
        autoplay:true,
        fade:true,
        autoplayspeed:5000,
    });
    
    
    });