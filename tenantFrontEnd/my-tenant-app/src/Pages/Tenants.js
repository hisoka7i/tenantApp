import React, { useEffect, useState } from 'react';
import Container from 'react-bootstrap/Container';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import axios from 'axios';
import { URL } from '../config'
import NavigationBar from '../Component/NavigationBar';
import { FaUserCheck, FaPhone } from "react-icons/fa";
import { FaRegAddressCard,FaPersonCircleCheck } from "react-icons/fa6";


const Tenants = () => {
    const [userData, setUserData] = useState([]);
    function showUsers() {
        //need to add session storage
        axios
            .get(`${URL}/all`)
            .then((response) => {
                var status = response.status;
                var data = response.data;
                console.log(status)
                if (status == 200) {
                    const data2 = data;
                    setUserData(data2);
                }
            })
            .catch((error) => {
                console.log(error);
            });
    }
    const bgValue = "light";
    function showUsersData() {
        return userData.map((userInfo, i) => {
            return (
                <Card bg={bgValue} className="text-center" style={{ padding: '2rem' }}>
                    {/* Name */}
                    <Card.Header text="dark"><h3><FaPersonCircleCheck /> {userInfo.name}</h3></Card.Header>
                    <Card.Body>
                        {/* Phone number */}
                        <Card.Title>
                            Phone number: <FaPhone /> {userInfo.phone}</Card.Title>
                        {/* Address will come under this */}
                        <Card.Text>
                            <FaRegAddressCard /> {userInfo.address}
                        </Card.Text>
                        {/* To access the complete user data */}
                        <Button size="sm" variant="primary"><FaUserCheck />
                        </Button>
                    </Card.Body>
                    {/* Due date, will come under here */}
                    <Card.Footer className="text-muted">Rent Due in 2 days</Card.Footer>
                </Card>
            );
        });
    }

    useEffect(() => {
        showUsers();
    }, []);
    //add a function here 
    return (
        <>
            <NavigationBar />
            <Container fluid style={{ padding: '2rem' }}>
                {showUsersData()}
            </Container>
        </>
    )
}
export default Tenants;