import Hello from "./Hello";
import './App.css';
function App(){
  const name = 'react';
  const style = {
    backgroundColor:'black',
    color: 'aqua',
    fontSize:24, //기본단위 px
    padding:'1rem' //다른단위는 문자열
  }
  return(
    <>
    {/*주석은 화면에 안보인다*/}
    /*ㅁㄴㅇㄴㅁㅇㅁㅇㄴ*/
    <Hello
    // 열리는 태그 내부에서는 주석을 붙일 수 있다
    />
    <div style = {style}>  {name}</div>
    <div className="line-box"></div>
    </>
  );

}
export default App;