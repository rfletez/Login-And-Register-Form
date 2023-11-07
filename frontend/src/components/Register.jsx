import { useState } from 'react';
import { axios } from 'axios';

function Register() {

    const [employeeName, setEmployeeName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    async function save(event) {
        event.preventDefault();

        try {
            await axios.post("http://localhost:8101/api/v1/com/employeePath/save", {
                employeeName: employeeName,
                email: email,
                password: password
            });
            alert("Employee registration successful");
        }
        catch(err) {
            alert(err);
        }
    }

    return (
        <div>
            <div class="container mt-4">
                <div class="card">
                    <h1>Employee Registration</h1>

                    <form>
                        <div class="form group">
                            <label>Employee Name</label>
                            <input type="text" class="form-control" 
                                id="employee_name" 
                                placeholder="Enter your name..."
                                value={employeeName}
                                onChange={(event) => {
                                    setEmployeeName(event.target.value);
                                }} 
                            />
                        </div>

                        <div class="form group">
                            <label>Employee Email</label>
                            <input type="text" class="form-control"
                                id="employee_email" 
                                placeholder="Enter your email..."
                                value={email}
                                onChange={(event) => {
                                    setEmail(event.target.value);
                                }} />
                        </div>

                        <div class="form group">
                            <label>Employee Password</label>
                            <input type="text" class="form-control"
                                id="employee_password" 
                                placeholder="Enter your password..."
                                value={password}
                                onChange={(event) => {
                                    setPassword(event.target.value);
                                }} />
                        </div>

                        <button type="submit" class="btn btn-primary mt-4" onClick={save}>Save</button>

                    </form>
                </div>
            </div>

        </div>
    );
}
export default Register;