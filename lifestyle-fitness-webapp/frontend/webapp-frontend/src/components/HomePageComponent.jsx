//this is just the homepage layout for web application.
import {useState, useEffect} from 'react'
import FoodServices from '../services/FoodServices'
import ExerciseService from '../services/ExerciseService'
import Table from "react-bootstrap/Table";

function HomePageComponent(){



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

const filterFoodEvent= food.filter( foods =>{
    return foods.foodTime==='breakfast'
});

const getTotalCalories=filterFoodEvent.reduce(
    (totalCalories,currentCalories)=>
        totalCalories+currentCalories.calorie,0);


return (
    <div className="container">
        <h2 className='text-center'>breakfast Foods</h2>
        <Table striped bordered hover>
            <thead>
            <th>Food Name</th>
            <th>Calories</th>
            <th>protein</th>
            <th>carbs</th>
            <th>sugar</th>
            <th>Total Fat</th>
            <th>mealtime</th>
            </thead>
            <tbody>
            {
                filterFoodEvent.map(
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
        <div className="container">
            <Table striped bordered hover>
                <thead>
                <th style={{paddingRight:"10px"}}>Totals</th>
                <th>Total calories </th>
                <th>Total Protein</th>
                <th>Total carbs </th>
                <th>Total sugar </th>
                <th>Total fat </th>


                </thead>
                <tbody>
                {
                   <tr>
                       <td><b>Total:</b></td>
                       <td>{getTotalCalories}</td>
                   </tr>

                }
                </tbody>
            </Table>
        </div>
        <div className="container">
            <h2 className="text-center">Aerobic Exercises</h2>
            <Table striped bordered hover>
                <thead>
                <tr>
                <th>Exercise Name</th>
                <th>sets</th>
                <th>reps</th>
                <th>exercise time</th>
                <th>speed</th>
                <th>exercise type</th>
                </tr>
                </thead>
                <tbody>
                {
                    exercise.map(
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
            </Table>
        </div>
    </div>
)
}

export default HomePageComponent;





