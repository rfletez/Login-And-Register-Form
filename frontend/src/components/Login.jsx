import { useState } from 'react';
import { axios } from 'axios';
import { useNavigate } from 'react-router-dom';

function Login() {

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    async function login(event) {
        event.preventDefault();

        try {
            await axios.post("http://localhost:8101/api/v1/com/employeePath/login", {
                email: email,
                password: password,
            }).then((result) => {
                console.log(result.data);

                if(result.data.message === "Email does not exists") {
                    alert("Email does not exists");
                }
                else if(result.data.message === "Login successful") {
                    navigate("/home");
                }
                else {
                    alert("Email and Password do not match");
                }
            }, fail => {
                console.error(fail);
            });
        }
        catch(err) {
            alert(err);
        }
    }

    return(
        <div>
            <div className='container'>

                <div className='row'>
                    <h2>Login</h2>
                    <hr/>
                </div>

                <div className='row'>
                    <div className='col-sm-6'>
                        <form>
                            <div className='form-group'>
                                <label>Email</label>
                                <input type='email' 
                                    className='form-control' 
                                    id='email' 
                                    placeholder='Enter email...'
                                    value={email}
                                    onChange={(event) => {
                                        setEmail(event.target.value)
                                    }} />
                            </div>

                            <div className='form-group'>
                                <label>Password</label>
                                <input type='password' 
                                    className='form-control' 
                                    id='password' 
                                    placeholder='Enter password...'
                                    value={password}
                                    onChange={(event) => {
                                        setPassword(event.target.value)
                                    }} />
                            </div>

                            <button type='submit' className='btn btn-primary' onClick={login}>Login</button>
                        </form>
                    </div>
                </div>

            </div>

        </div>
    );
}
export default Login;