import { useState } from "react";

function InputSample(){
    const[inputs, setInputs] = useState({
        name:'' ,
        nickname:'',
        email:''
    });
   const {name , nickname, email} = inputs; //비구조화 할당을 통해 값 추출
 
    const onChange = (e) =>{ //키보드를 사용하여 입력 삭제 됬을때
       const {value, name} = e.target; // 우선  에서 name과 value를 추출
        // console.log(e.target.value);
        console.log(e.target.name);
        setInputs({
            ...inputs, // 기존의 input 객체를 복사한 뒤,
            [name]: value // name(name or nickname) 키를 가진 값을 value로 설정
        });
    }
    const onReset = () =>{
        setInputs({
            name:'',
            nickname:'',
            email:''
        });
    }
    return(
        <div>
            <input name="name" placeholder="이름" onChange={onChange} value={name}/>
            <input name="nickname" placeholder="닉네임" onChange={onChange} value={nickname}/>
            <input name="email" placeholder="이메일" onChange={onChange} value={email}/>
            <button onClick={onReset}>초기화</button>
            <div>
                <b>값: </b>
                {name} ({nickname}) - {email}
            </div>
        </div>
    );
}
export default InputSample;