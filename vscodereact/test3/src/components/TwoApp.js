import React,{useState} from 'react'


function TwoApp() {
	const [photo,setPhoto] = useState('../image2/dish2.jpg');
	const changePhoto = (e) =>{
		setPhoto(e.target.value);
	}
  return (
	<div>
	  <h3 className='alert alert-success'>TwoApp입니다. 라이오버튼</h3>
		<div>
			<b>이미지 선택: </b>
			      
			<label>
				<input type="radio" name='photo' value={'../image2/dish1.jpg'} onClick={changePhoto}/> 이미지1
			</label>
			      
                <label>
                    <input type={"radio"} name={'photo'} value={'../image2/dish2.jpg'} defaultChecked onClick={changePhoto}/> 이미지 2
                </label>
                      
                <label>
                    <input type={"radio"} name={'photo'} value={'../image2/dish3.jpg'} onClick={changePhoto}/> 이미지 3
                </label>
                      
                <label>
                    <input type={"radio"} name={'photo'} value={'../image2/dish4.jpg'} onClick={changePhoto}/> 이미지 4
                </label>
                      
                <label>
                    <input type={"radio"} name={'photo'} value={'../image2/dish5.jpg'} onClick={changePhoto}/> 이미지 5
                </label>
                      
		</div>
		<img src={photo}/>
	</div>
  )
}

export default TwoApp