import logo from './logo.svg';
import React from 'react';
import {BrowserRouter, Route, Routes, Link} from 'react-router-dom';
import './App.css';
import Tenants from './pages/Tenants';
import LoginPage from './pages/LoginPage';
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
