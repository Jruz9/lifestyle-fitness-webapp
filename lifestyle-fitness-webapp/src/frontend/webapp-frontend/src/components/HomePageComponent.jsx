//this is just the homepage layout for web application.
import {useEffect, useState} from 'react'
import FoodServices from '../services/FoodServices'
import ExerciseService from '../services/ExerciseService'
import Table from "react-bootstrap/Table";

function HomePageComponent()
{

    const [food, setFoods] = useState([])

const [exercise, setExercise] = useState([])

useEffect(
    () => {
        getAllFoodItems()
    }, [])


useEffect(
    () => {
        fetchAllExerciseItems()
    }
    , [])


const getAllFoodItems = () => {
    FoodServices.getFood()
        .then((response) => {
            setFoods(response.data)
            console.log(response.data)
        });
};

const fetchAllExerciseItems = () => {
    ExerciseService.getAllExercises().then((response) => {
        setExercise(response.data)
        console.log(response.data)
    });
};

function filterFoodEvent(eventString){
    return food.filter(foods => {
        return foods.foodTime === eventString
    });
}


function filterExerciseForm(exerciseFormString){
    return exercise.filter(exercises => {
        return exercises.exerciseForm === exerciseFormString
    });
    }

const getCalorieTotal=food.reduce(
                (total,current)=>
                    total+current.calorie,0);


//when ready replace this and put it indo another file to compute.
const getTotalProtein=food.reduce(
    (total,current)=>
        total+current.protein,0).toFixed(2);

const getTotalSugar=food.reduce(
    (total,current)=>
        total+current.sugar,0).toFixed(2);

const getTotalCarbs=food.reduce(
    (total,current)=>
        total+current.carbs,0).toFixed(2);

const getTotalFat=food.reduce(
    (total,current)=>
        total+current.fat,0).toFixed(2);

return (
    <div className="container">
        <h2 className='text-center'>Food Diet</h2>
        <Table striped bordered hover size="md">
            <thead>
            <tr>
            <th>Food Name</th>
            <th>Calories</th>
            <th>protein</th>
            <th>carbs</th>
            <th>sugar</th>
            <th>Fat</th>
            <th>mealtime</th>
            </tr>
            </thead>
            <tbody>
            {
                filterFoodEvent("breakfast").map(
                    food =>
                        <tr key={food.foodId}>
                            <td>{food.foodName}</td>
                            <td>{food.calorie}</td>
                            <td>{food.protein}</td>
                            <td>{food.carbs}</td>
                            <td>{food.sugar}</td>
                            <td>{food.fat}</td>
                            <td>{food.foodTime}</td>
                        </tr>
                )

            }
            </tbody>

            <tbody>
            {
                filterFoodEvent("lunch").map(
                    food =>
                        <tr key={food.foodId}>
                            <td>{food.foodName}</td>
                            <td>{food.calorie}</td>
                            <td>{food.protein}</td>
                            <td>{food.carbs}</td>
                            <td>{food.sugar}</td>
                            <td>{food.fat}</td>
                            <td>{food.foodTime}</td>
                        </tr>
                )

            }
            </tbody>
            <tbody>
            {
                filterFoodEvent("dinner").map(
                    food =>
                        <tr key={food.foodId}>
                            <td>{food.foodName}</td>
                            <td>{food.calorie}</td>
                            <td>{food.protein}</td>
                            <td>{food.carbs}</td>
                            <td>{food.sugar}</td>
                            <td>{food.fat}</td>
                            <td>{food.foodTime}</td>
                        </tr>
                )

            }
            </tbody>
            <tbody>
            {
                filterFoodEvent("snack").map(
                    food =>
                        <tr key={food.foodId}>
                            <td>{food.foodName}</td>
                            <td>{food.calorie}</td>
                            <td>{food.protein}</td>
                            <td>{food.carbs}</td>
                            <td>{food.sugar}</td>
                            <td>{food.fat}</td>
                            <td>{food.foodTime}</td>
                        </tr>
                )

            }
            </tbody>

        </Table>


        {/*this table is for getting the total of all your food and nutrients*/}
        <div className="container">
            <Table striped bordered hover size="xl">
                <thead>
                <tr>
                <th style={{paddingRight:"10px"}}>Totals</th>
                <th>Total calories </th>
                <th>Total Protein</th>
                <th>Total carbs </th>
                <th>Total sugar </th>
                <th>Total fat </th>
                </tr>
                </thead>
                <tbody>
                {
                   <tr>
                       <td><b>Total:</b></td>
                       <td>{getCalorieTotal}</td>
                       <td>{getTotalProtein}</td>
                       <td>{getTotalCarbs}</td>
                       <td>{getTotalSugar}</td>
                       <td>{getTotalFat}</td>
                   </tr>

                }
                </tbody>
            </Table>
        </div>


        <div className="container">
            <h2 className="text-center">Exercises</h2>
            <Table striped bordered hover size="md">
                <thead>
                <th>Exercise Name</th>
                <th>sets</th>
                <th>reps</th>
                <th>time</th>
                <th>speed</th>
                <th>type</th>
                </thead>

                <tbody>
                {
                    filterExerciseForm("aerobic").map(
                        exerciseItems =>
                            <tr key={exerciseItems.exerciseId}>
                                    <td>{exerciseItems.exerciseName}</td>
                                    <td>{exerciseItems.sets}</td>
                                    <td>{exerciseItems.reps}</td>
                                    <td>{exerciseItems.time}</td>
                                    <td>{exerciseItems.speed}</td>
                                    <td>{exerciseItems.exerciseForm}</td>
                            </tr>
                    )
                }
                </tbody>

                <tbody>
                {
                    filterExerciseForm("strength").map(
                        exerciseItemsStrength =>
                            <tr key={exerciseItemsStrength.exerciseId}>
                                <td>{exerciseItemsStrength.exerciseName}</td>
                                <td>{exerciseItemsStrength.sets}</td>
                                <td>{exerciseItemsStrength.reps}</td>
                                <td>{exerciseItemsStrength.time}</td>
                                <td>{exerciseItemsStrength.speed}</td>
                                <td>{exerciseItemsStrength.exerciseForm}</td>
                            </tr>
                    )
                }
                </tbody>
            </Table>
        </div>
    </div>
)
}

export default HomePageComponent;





