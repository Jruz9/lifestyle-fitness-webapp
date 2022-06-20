import React from 'react';
import './App.css';
import ListFoodComponent from './components/ListFoodComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom"
import CreateFoodComponent from './components/CreateFoodComponent';

function App() {
  return (
    <div>
      <Router>
          <HeaderComponent />
          <div className="container">
            <Routes>
              <Route path= "/" element={<ListFoodComponent/>}/>
              <Route path='/foods' element={<ListFoodComponent/>}/>
              <Route path='"/add-food' element={<CreateFoodComponent/>}/>
              </Routes>
          </div>
          <FooterComponent />
      </Router>
    </div>
  );
}

export default App;
