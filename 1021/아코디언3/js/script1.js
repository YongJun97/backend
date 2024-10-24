const btnCollapse = document.querySelector('#btn-collapse');//all버튼
const heading = document.querySelectorAll('.panel-heading');
const question = document.querySelectorAll('.panel-question');
// heading 과 body를 감싸는 qusstion
const p_body = document.querySelectorAll('.panel-body');

heading.forEach(function(headingElement){

    headingElement.addEventListener('click',function(e){
        question.forEach(function(q){
            q.classList.remove('on');
        const body = q.querySelector('.panel-body');
        body.style.display = 'none'; // 숨기기
        body.style.opacity = '0'; //
        });
        e.target.parentNode.classList.add('on');

    });

});
btnCollapse.addEventListener('click',function(){
    question.forEach(function(q){
        q.classList.remove('on');
    });
});