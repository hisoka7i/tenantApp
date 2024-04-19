import 'bootstrap/dist/css/bootstrap.min.css';
import React, { useEffect, useState } from 'react';
import NavigationBar from '../Component/NavigationBar';
import axios from 'axios';
import { URL } from '../config'
import './styles/Tenants.css';

const Tenants = () => {
    const [userData,
        setUserData] = useState([]);
    function showUsers() {
        //need to add session storage
        axios
            .get(`${URL}/all`)
            .then((response) => {
                var status = response.status;
                var data = response.data;
                if (status == 200) {
                    const data2 = data;
                    console.log(data2)
                    setUserData(data2);
                }
            })
            .catch((error) => {
                console.log(error);
            });
    }
    function showUsersData() {
        return userData.map((userInfo, i) => {
            return (
                <div class="card">
                <div class="card-header">{userInfo.name}</div> 
        <div class="card-info"><span>Gender:</span >  {userInfo.gender} </div>
        <div class="card-info">
            <span>Phone:</span > {userInfo.phone} </div>
        <div class="card-info">
            <span>Rent:</span > ${userInfo.rent} </div>
        <div class="card-info">
            <span>Due Date:</span> 30th June
        </div>
            </div>
            );
        });
    }
    useEffect(() => {
        showUsers();
    }, []);
    return (
        <>
            <NavigationBar />
            <div class="card-container">   
                {showUsersData()}
            </div>
        </>
    )
}
export default Tenants;