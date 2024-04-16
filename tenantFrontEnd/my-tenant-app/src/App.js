import logo from './logo.svg';
import React from 'react';
import {BrowserRouter, Route, Routes, Link} from 'react-router-dom';
import './App.css';

const App = () =>{
  return(<>
  <BrowserRouter>
  <Routes>
    <Route path="/login" />
  </Routes>
  </BrowserRouter>
  </>
  );
};

export default App;
