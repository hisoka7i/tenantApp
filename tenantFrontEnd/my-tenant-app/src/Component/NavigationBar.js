import 'bootstrap/dist/css/bootstrap.min.css';

import {Nav, Navbar, NavLink} from "react-bootstrap";
import {Link} from 'react-router-dom';

const NavigationBar=()=>{
    return(
        <Navbar sticky='top' collapseOnSelect expand='sm' bg='dark' variant='dark' className='bg-body-tertiary'>
            <Navbar.Toggle aria-controls='navbarScroll' data-bs-target='#navbarScroll' />
            <Navbar.Collapse id='navbarScroll'>
                <Nav>
                    <NavLink eventKey='1' as={Link} to='/'>Home</NavLink>
                    <NavLink eventKey='2' as={Link} to='/'>Login</NavLink>
                </Nav>
            </Navbar.Collapse>
        </Navbar>
    )
}
export default NavigationBar;