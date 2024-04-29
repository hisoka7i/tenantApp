import React, { useEffect, useState } from 'react';
import Container from 'react-bootstrap/Container';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import axios from 'axios';
import { URL } from '../config'
import NavigationBar from '../Component/NavigationBar';
import { FaUserCheck, FaPhone } from "react-icons/fa";
import { FaRegAddressCard, FaPersonCircleCheck } from "react-icons/fa6";
import { BsCalendar2Date } from "react-icons/bs";



const Tenants = () => {
    const [userData, setUserData] = useState([]);

    //function to calculate due date
    function calculateDaysDue(dateOfArrival) {
     // Parse the date of arrival string
     const [arrivalDay, arrivalMonth, arrivalYear] = dateOfArrival.split('/').map(Number);
 
     // Get the current date
     const currentDate = new Date();
     const currentMonth = currentDate.getMonth();
     //write a return statement
     return Math.abs(arrivalDay-currentDate.getDate());
    }

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
                    <Card.Header text="dark"><h3><FaPersonCircleCheck /> {userInfo.name} {/* To access the complete user data and update it */}
                        <Button size="sm" variant="primary"><FaUserCheck />
                        </Button></h3></Card.Header>
                    <Card.Body>
                        {/* Phone number */}
                        <Card.Title size="lg">
                            Phone number: <FaPhone /> {userInfo.phone}</Card.Title>
                        <Card.Subtitle size="sm">
                            Date of arrival: <BsCalendar2Date /> {userInfo.doa}
                        </Card.Subtitle>
                        {/* Address will come under this */}
                        <Card.Text>
                            Address <FaRegAddressCard /> : {userInfo.address}
                        </Card.Text>

                    </Card.Body>
                    {/* Due date, will come under here */}
                    <Card.Footer className="text-muted">Rent Due in {calculateDaysDue(userInfo.doa)}</Card.Footer>
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