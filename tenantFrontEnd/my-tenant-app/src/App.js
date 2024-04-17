import logo from './logo.svg';
import React from 'react';
import {BrowserRouter, Route, Routes, Link} from 'react-router-dom';
import './App.css';
import Login from "./pages/Login";

const App = () =>{
  return(<>
  <BrowserRouter>
  <Routes>
    <Route path="/" element={<Login/>}/>
  </Routes>
  </BrowserRouter>
  </>
  );
};

export default App;
