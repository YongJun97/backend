import { useState } from "react";

function InputSample2(){
    const [text,setText] = useState('');
    
    const onChange = (e) =>{
        setText(e.target.value); // e.target 글씨가 변경되는 상태 value 값
    }

    const onReset = () =>{
        setText('');
    }
    
    return(
        <div>
            <input onChange={onChange} value={text}/>
            <button onClick={onReset}>초기화</button>
                <div>
                    <b>값:{text} </b>
                </div>
        </div>
    );
}
export default InputSample2;