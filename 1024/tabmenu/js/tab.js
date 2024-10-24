const targetLink = document.querySelectorAll('.tab_menu a'); //탭버튼
const tabContent=document.querySelectorAll('#tabContent>div');
// 탭내용

//targetLink 배열을 forEach로 순회

// targetLink.forEach(function(link){

//     link.addEventListener('click',function(e){
//         e.preventDefault(); //링크금지
//         let orgTarget = e.target.getAttribute('href');
//         //클릭(e.taget) - this로 변경 가능
//         //getAttribute 는 href, src 속성값을 읽어옴
//         //alert(orgTarget); #tab1 ,#tabs2, #tabs3
//         let tabTarget = orgTarget.replace("#","");
//         //#tab1 에서 #을 빈문자열로 대체 -> tab1 
//         //alert(tabTarget);

//         //모든 tabContent을 안보이게 설정
//         tabContent.forEach(function(content){
//             content.style.display = "none";
//         }); 
//         //클릭한 탭만보이게 설정
//         document.getElementById(tabTarget).style.display="block";

//         targetLink.forEach(function(link2){
//             link2.classList.remove('active');
//             e.target.classList.add('active');
//         });

//     }); 

// });


$(function(){
    $('.tab_menu a').click(function(){
        // let orgTarget = e.target.getAttribute('href');
        let orgTarget = $(this).attr('href');
        // alert(orgTarget);
        $('#tabContent > div').hide();


        $(orgTarget).show(); //id 선택자로 인식
        // 클릭한 요소만 보여달라
        $('.tab_menu a').removeClass('active');
        $(this).addClass('active');
        return false;
        //e.preventDefault(); 위와 동일
    });
});