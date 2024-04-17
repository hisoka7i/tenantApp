import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';
import { useNavigate } from 'react-router';
import NavigationBar from '../Component/NavigationBar';
import './styles/Login.css';
import axios from 'axios';
import {URL} from '../config'


const Login = () => {
    const navigate = useNavigate();
    var name = "";
    var password = "";
    function handler1(e){
        name = e.target.value;
    }
    function handler2(e){
        password = e.target.value;
        console.log(name+password);
    }
    function loginFunction(){
        const body = {
            "name":name,
            "password":password
        }
        axios.post(`${URL}/login`,body).then((response)=>{
            console.log(response.data);
            var status = response.status;
            if(status==200){
                console.log("This part is working!");
            }
        }).catch((error)=>{
            console.log(error);
        })
    }
    return (
        <>
            <NavigationBar />
            <div class="container-main">
                <div class="container">
                    <h2>Login</h2>
                    <form action="#" method="post">
                        <label for="username">Username:</label>
                        <input type="text" id="username" onBlur={handler1} name="username" required />
                        <label for="password">Password:</label>
                        <input type="password" id="password" onBlur={handler2} name="password" required />
                        <button type="submit" onClick={loginFunction}>Let me in!</button>
                    </form>
                </div>
            </div>
        </>
    )
};
export default Login;