
import { userRef }from 'react';


function User({user}){
    return(
        <div>
             <b>{user.username}</b><span>({user.email})</span>
        </div>

    );

}

function UserList1({users}){




    return (
        <div>

            {users.map(user => (
          <User user={user} key = {user.id}/>
          ))};
          {/* <User user={users[1]} />
          <User user={users[2]} /> */}
        </div>
    );
}
export default UserList1;