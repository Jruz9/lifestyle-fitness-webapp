// This is the list componenet for the excerises the user wants
import React, {useState, useEffect} from 'react';
import ExerciseService from '../services/ExerciseService';
import Table from 'react-bootstrap/Table'
import { Link } from 'react-router-dom';

function ListExerciseComponent(){
    const [exceriseList,setExercise]=useState([])

        //Use effect   Effects Hooks are equivalent to componentDidMount(), componentDidUpdate(), and componentWillUnmount() lifecycle methods.
        useEffect(
            () =>{
                displayAllExercise()
            },[])
    

        const displayAllExercise = () => {
            ExerciseService.getAllExercises().then((response)=>{
                setExercise(response.data)
                console.log(response.data);
            });
        };
    
        const deleteExercise= (exerciseId)=>{
            ExerciseService.deleteExercise(exerciseId).then((response) => {
                displayAllExercise();
            }).catch(error =>{
                console.log(error);
                
            })
    
        }
        return(
            <div className='container'>
                <h2 className='text-center'>Exercise Routine</h2>
                <Link to='/add-exercise' className='btn btn-primary mb-2'>Add Exercise</Link>
                <div className='row'>
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
                            exceriseList.map(
                                exercise =>
                                <tr key={exercise.exerciseId}>
                                    <td>{exercise.exerciseName}</td>
                                    <td>{exercise.sets}</td>
                                    <td>{exercise.reps}</td>
                                    <td>{exercise.time}</td>
                                    <td>{exercise.speed}</td>
                                    <td>{exercise.exerciseForm}</td>
                                    <td>
                                        {/*@todo add modal to the delete button*/}
                                        <Link className='btn btn-info' to= {`/edit-exercise/${exercise.exerciseId}`}>Update</Link>
                                        <button className='btn btn-danger' onClick={() => deleteExercise(exercise.exerciseId)} style={{marginLeft:"10px"}}>Delete</button>
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

export default ListExerciseComponent;