import logo from './logo.svg';
import React from 'react';
import {BrowserRouter, Route, Routes, Link} from 'react-router-dom';
import './App.css';
import Login from "./pages/Login";
import Tenants from './pages/Tenants';
const AuthorizeAdmin=()=>{
  const status = sessionStorage['id'];
  if(status==1){
    return <Tenants />
  }else{
    <Login />
  }
}
const App = () =>{
  return(<>
  <BrowserRouter>
  <Routes>
    <Route path="/" element={<Login/>}/>
    <Route path="/all" element={<AuthorizeAdmin />}/>
  </Routes>
  </BrowserRouter>
  </>
  );
};

export default App;
