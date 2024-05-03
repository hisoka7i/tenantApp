import logo from './logo.svg';
import React from 'react';
import {BrowserRouter, Route, Routes, Link} from 'react-router-dom';
import './App.css';
import Tenants from './Pages/Tenants.js';
import LoginPage from './Pages/LoginPage.js';
const AuthorizeAdmin=()=>{
  const status = sessionStorage['type'];
  if(status=='admin'){
    return <Tenants />
  }else{
    <LoginPage />
  }
}
const App = () =>{
  return(<>
  <BrowserRouter>
  <Routes>
    <Route path="/" element={<LoginPage/>}/>
    <Route path="/all" element={<AuthorizeAdmin />}/>
  </Routes>
  </BrowserRouter>
  </>
  );
};

export default App;
