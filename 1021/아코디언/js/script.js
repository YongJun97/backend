const btnCollapse = document.querySelector('#btn-collapse');
const heading = document.querySelectorAll('.panel-heading');
const question = document.querySelectorAll('.panel-question');
// heading 과 body를 감싸는 question
const p_body = document.querySelectorAll('.panel-body');

heading.forEach(function(headingElement){
    
    headingElement.addEventListener('click',function(e){
        question.forEach(function(q){
            q.classList.remove('on');
        });
        e.target.parentNode.classList.add('on');
    });

});
btnCollapse.addEventListener('click',function(){
    question.forEach(function(q){
        q.classList.remove('on');
    });
});