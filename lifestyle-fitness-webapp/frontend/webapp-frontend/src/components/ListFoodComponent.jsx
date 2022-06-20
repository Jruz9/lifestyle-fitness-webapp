import React, { Component } from 'react';
import FoodServices from '../services/FoodServices';
import Table from 'react-bootstrap/Table';
import { Link } from 'react-router-dom';

class ListFoodComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            foods: []
        }

        this.addNewFood = this.addNewFood.bind(this);
    }
    



    componentDidMount() {
        FoodServices.getFood().then((res) => {
            this.setState({ foods: res.data });
        });
    }

    addNewFood(){
        // this.props.history.push("/add-food");
        <Link to="/add-food" state={this.addNewFood}/>
    }

    render() {
        return (
            <div>
                <h2 className='text-center'>Food List</h2>
                <div className='row'>
                    <button className='btn btn-primary' onClick={this.addNewFood}> Add Food</button>
                </div>
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
                                this.state.foods.map(
                                    food =>
                                        <tr key={food.id}>
                                            {/* you have to use the ending name of the geters and setters of the java spring entinties */}
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
                </div>

            </div>
        )
    }
}

export default ListFoodComponent;