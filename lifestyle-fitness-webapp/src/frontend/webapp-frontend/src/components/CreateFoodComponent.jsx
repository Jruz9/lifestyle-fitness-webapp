import { useState } from 'react';
import FoodServices from '../services/FoodServices';
import { Link, useParams } from 'react-router-dom';
import { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';


const CreateFoodComponent = () => {
    const [foodName, setFoodName] = useState('')
    const [calorie, setCalorie] = useState('')
    const [protein, setProtein] = useState('')
    const [carbs, setCarbs] = useState('')
    const [sugar, setSugar] = useState('')
    const [fat, setFat] = useState('')
    const [foodTime, setFoodTime] = useState('')
    const history = useNavigate();
    const { foodId } = useParams();

    const food = { foodName, calorie, protein, carbs, sugar, fat, foodTime }

    const saveOrUpdateFood = (e) => {
        e.preventDefault();

        if (foodId) {
            FoodServices.updateFood(foodId, food).then((response) => {
                history("/foods")
            }).catch(error => {
                console.log(error)
            })
        }
        else {
            FoodServices.createFood(food).then((response) => {
                console.log(response.data)
                history("/foods")

            }).catch(error => {
                console.log(error)
            })
        }
    }

//this just fills the values for what we are updating in the html.
    useEffect(() => {
        FoodServices.getFoodById(foodId).then((response) => {
            setFoodName(response.data.foodName)
            setCalorie(response.data.calorie)
            setProtein(response.data.protein)
            setCarbs(response.data.carbs)
            setSugar(response.data.sugar)
            setFat(response.data.fat)
            setFoodTime(response.data.foodTime)
        }).catch(error => {
            console.log(error)
        })
    },[foodId]) //needs a to figure out the use effects react 

    const title = () => {
        if (foodId) {
            return <h2 className='text-center'>Update Food</h2>
        }
        else {
            return <h2 className='text-center'>Add Food</h2>
        }
    }

    // const title =<h2>{foodId ? 'Edit food' : 'Add Food'}</h2>

    return (
        <div>
            <br></br>
            <div className="container">
                <div className='row'>
                    <div className='card col-md-6 offset-md-3 offset-md-3'>
                        {title()}
                        <div className='card-body'>
                            <form>
                                {/* add more cards to update the information of the food */}
                                <div className='form-group mb-2'>
                                    <label className='form-label'>food name :</label>
                                    <input
                                        type="text"
                                        placeholder=':Enter your food name'
                                        name='foodName'
                                        className='"form-control'
                                        value={foodName}
                                        onChange={(e) => setFoodName(e.target.value)}>
                                    </input>
                                </div>
                                <div className='form-group mb-2'>
                                    <label className='form-label'>calories :</label>
                                    <input
                                        type="number"
                                        placeholder=':Enter how many calories'
                                        name='calorie'
                                        className='"form-control'
                                        value={calorie}
                                        onChange={(e) => setCalorie(e.target.value)}>
                                    </input>
                                </div>
                                <div className='form-group mb-2'>
                                    <label className='form-label'>protein :</label>
                                    <input
                                        type="number"
                                        placeholder=':Enter the amount of protein per gram '
                                        name='protein'
                                        className='"form-control'
                                        value={protein}
                                        onChange={(e) => setProtein(e.target.value)}>
                                    </input>
                                </div>
                                <div className='form-group mb-2'>
                                    <label className='form-label'>carbs :</label>
                                    <input
                                        type="number"
                                        placeholder=':Enter the amount of carbs per gram'
                                        name='carbs'
                                        className='"form-control'
                                        value={carbs}
                                        onChange={(e) => setCarbs(e.target.value)}>
                                    </input>
                                </div>
                                <div className='form-group mb-2'>
                                    <label className='form-label'>sugar :</label>
                                    <input
                                        type="number"
                                        placeholder=':Enter enter the amount of sugar per gram'
                                        name='sugar'
                                        className='"form-control'
                                        value={sugar}
                                        onChange={(e) => setSugar(e.target.value)}>
                                    </input>
                                </div>
                                <div className='form-group mb-2'>
                                    <label className='form-label'>fat :</label>
                                    <input
                                        type="number"
                                        placeholder=':Enter the amount of fat per gram'
                                        name='fat'
                                        className='"form-control'
                                        value={fat}
                                        onChange={(e) => setFat(e.target.value)}>
                                    </input>
                                </div>

                                <div className='form-group mb-2'>
                                    <select className='form-select' name='foodTime' value={foodTime} onChange={(e) => setFoodTime(e.target.value)}>
                                        <option value="breakfast">breakfast</option>
                                        <option value="lunch">lunch</option>
                                        <option value="dinner">dinner</option>
                                        <option value="snack">snack</option>
                                    </select>
                                </div>

                                <button className='btn btn-success' onClick={(e) => saveOrUpdateFood(e)}>submit</button>
                                <Link to="/foods" className='btn btn-danger'>Cancel</Link>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )

}

export default CreateFoodComponent;