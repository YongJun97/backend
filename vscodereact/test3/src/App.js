import InputSample from "./InputSample";
import React, { useState } from 'react';
import MultiinputForm from "./MultiinputForm";
function App(){
    const [likeCount, setLikeCount] = useState(0);
    return(
        <div>
            {/* <InputSample/> */}
            {/* <div>
                <h1>좋아요 수: {likeCount}</h1>
                <button onClick={() => setLikeCount(likeCount + 1)}>좋아요</button>    
            </div>         */}
            <MultiinputForm/>
        </div>

    );
}

export default App;