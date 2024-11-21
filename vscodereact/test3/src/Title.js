

function Title({title, text}){
    // console.log("props===");
    // console.log(props);


    return(
        <>
            <h2 className="title">{title}</h2>
            <p>{text}</p>
        </>

    );
}
export default Title;
// props 란? 부모의 컴포넌트가 자식 컴포넌트에게 넘겨주는 데이터
// App.js => App라는 부모 컴포넌트
// Title.js => Title이라는 자식 컴포넌트
// Title={"Hello Korea"} => 자식에게 넘겨주는 props
// props title 이라는 key값에 App.js 에서 전달한 Hello Korea
// 라는 텍스트를 value 가지는 객체 라는 걸 확인가능