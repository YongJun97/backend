import "./App.css";
import { useState } from "react";
import Title from "./Title";
function App(){
  let TITLE = "Hello korea!"
  // function ClickHAndler(){
  //   console.log("클릭했다.");
  // }
  const [title, setTitle] = useState("Hello Korea");
  // 첫번째 인자는 값을 저장, 두번째 인자는 이변수 값의 변화를 감지
  const [text, setText] = useState("");

  const ClickHAndler=()=>{
    setTitle(prev => prev + " plus string");
    // prev는 현재 상태값
    // 이전의 상태를 기반으로 변경 될 때 사용
  }
  const changeHandler = (e) =>{
    // console.log(e.target.value);
    setText(e.target.value);
  }
  const onReset = () =>{
    setText('');
  }


  return (
    <div className="Wrapper">
      <Title title={title} text={text}/>
      <input type="text" value={text} onChange={changeHandler}/>
      <button onClick={onReset}>초기화</button>
      <button onClick={ClickHAndler}>change Title</button>
      {/* <div>
        <b>값:{text}</b>
      </div> */}
    </div>
    
  );
}
export default App;