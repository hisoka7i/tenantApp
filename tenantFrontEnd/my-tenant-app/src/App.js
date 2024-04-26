import logo from './logo.svg';
import React from 'react';
import {BrowserRouter, Route, Routes, Link} from 'react-router-dom';
import './App.css';
import Login from "./pages/Login";
import Tenants from './pages/Tenants';
import Tenant from './pages/Tenant';
const AuthorizeAdmin=()=>{
  const status = sessionStorage['type'];
  if(status=='admin'){
    return <Tenants />
  }else{
    <Login />
  }
}
const App = () =>{
  return(<>
  <BrowserRouter>
  <Routes>
    <Route path="/" element={<Tenant/>}/>
    <Route path="/all" element={<AuthorizeAdmin />}/>
  </Routes>
  </BrowserRouter>
  </>
  );
};

export default App;
