import React, { useState, useEffect } from 'react';
import FoodServices from '../services/FoodServices';
import Table from 'react-bootstrap/Table';
import {Link} from 'react-router-dom'

function ListFoodComponent(){

    //useState is a Hook (function) that allows you to have state variables in functional components.
    const [foods,setFoods]=useState([])

    //Use effect   Effects Hooks are equivalent to componentDidMount(), componentDidUpdate(), and componentWillUnmount() lifecycle methods.
    useEffect(
        () =>{
            getAllFoods()
        },[])

    const getAllFoods = () => {
        FoodServices.getFood().then((response)=>{
            setFoods(response.data)
            console.log(response.data);
        });
    };

    const deleteFood= (foodId)=>{
        FoodServices.deleteFood(foodId).then((response) => {
            getAllFoods();
        }).catch(error =>{
            console.log(error);
            
        })

    }




        return (
            <div className='container'>
                <h2 className='text-center'>Food List</h2>
                <Link to="/add-food/" className='btn btn-primary mb-2'>Add Food</Link>
                <div className='row'>
                    <Table striped bordered hover>

                        <thead>
                            <tr>
                                <th>Food Name</th>
                                <th>Calories</th>
                                <th>protein</th>
                                <th>carbs</th>
                                <th>sugar</th>
                                <th>Total Fat</th>
                                <th>mealtime</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                foods.map(
                                    food =>
                                        <tr key={food.foodId}>
                                            {/* you have to use the ending name of the geters and setters of the java spring entinties */}
                                            <td>{food.foodName}</td>
                                            <td>{food.calorie}</td>
                                            <td>{food.protein}</td>
                                            <td>{food.carbs}</td>
                                            <td>{food.sugar}</td>
                                            <td>{food.fat}</td>
                                            <td>{food.foodTime}</td>
                                            <td>    
                                                {/* need to add website html or react-page to render, that why it has the error */}
                                                <Link className='btn btn-info' to={`/edit-food/ ${food.foodId}`}>Update</Link>
                                                <button className='btn btn-danger' onClick={() => deleteFood(food.foodId)} style={{marginLeft:"10px"}}>Delete</button>
                                            </td>
                                        </tr>
                                )
                            }
                        </tbody>

                    </Table>
                </div>

            </div>
        )
    }

export default ListFoodComponent;