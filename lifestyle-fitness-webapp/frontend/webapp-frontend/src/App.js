import React from 'react';
import './App.css';
import ListFoodComponent from './components/ListFoodComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom"
import CreateFoodComponent from './components/CreateFoodComponent';
import ListExerciseComponent from './components/ListExerciseComponent';
import CreateExerciseComponent from './components/CreateExerciseComponent';

function App() {
  return (
    <div>
      <Router>
          <HeaderComponent />
          <div className="container">
            <Routes>
              <Route path= "/" element={<ListFoodComponent/>}/>
              <Route path='/foods' element={<ListFoodComponent/>}/>
              <Route path='/add-food' element={<CreateFoodComponent/>}/>
              <Route path='/edit-food/:foodId' element ={<CreateFoodComponent/>}/>
              <Route path='/exercise' element={<ListExerciseComponent/>}/>
              <Route path='/add-exercise' element={<CreateExerciseComponent/>}/>
              <Route path='/edit-exercise/:exerciseId' element={<CreateExerciseComponent/>}/>
              </Routes>
          </div>
          <FooterComponent />
      </Router>
    </div>
  );
}

export default App;
