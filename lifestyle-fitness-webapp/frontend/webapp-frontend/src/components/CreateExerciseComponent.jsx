import {useState,useEffect} from 'react'
import ExerciseService from '../services/ExerciseService'
import{Link,useParams,useNavigate} from 'react-router-dom'
import { Container, FormGroup, Form } from 'react-bootstrap';

const CreateExerciseComponent = ()=> {
    const [exerciseName, setExerciseName] = useState('')
    const [sets, setSets] = useState('')
    const [reps, setReps] = useState('')
    const [time, setTime] = useState('')
    const [speed, setSpeed] = useState('')
    const [exerciseForm, setExerciseForm] = useState('')
    const navigate= useNavigate();
    const {exerciseId}= useParams();

    const exercise = { exerciseName, sets, reps, time, speed, exerciseForm }

    const saveOrUpdateExercise = (e) => {
        e.preventDefault();

        if (exerciseId) {
            ExerciseService.updateExercise(exerciseId, exercise).then((response) => {
                navigate("/exercise")
            }).catch(error => {
                console.log(error)
            })
        }
        else {
            ExerciseService.createExercise(exercise).then((response) => {
                console.log(response.data)
                navigate("/exercise")

            }).catch(error => {
                console.log(error)
            })
        }
    }

//this just fills the values for what we are updating in the html.
    useEffect(() => {
        ExerciseService.getAllExercisesById(exerciseId).then((response) => {
            setExerciseName(response.data.exerciseName)
            setSets(response.data.sets)
            setReps(response.data.reps)
            setTime(response.data.time)
            setSpeed(response.data.speed)
            setExerciseForm(response.data.exerciseForm)
        }).catch(error => {
            console.log(error)
        })
    },[exerciseId]) //needs a to figure out the use effects react 
    const addOrUpdateTitle= <h2>{exerciseId ? "Edit Exercise" : "Add Exercise"}</h2>;


    return  (
        <div>
            <Container>
                {addOrUpdateTitle}
                <Form >
                <FormGroup>
                    <label className='form-label'>Exercise Name</label>
                    <input type="Text" name='exerciseName' id='exerciseName' value={exerciseName}
                    onChange={(e)=> setExerciseName(e.target.value)} />
                </FormGroup>
                <FormGroup>
                    <label className='form-label'>sets</label>
                    <input type="Text" name='sets' id='sets' value={sets}
                    onChange={(e)=> setSets(e.target.value)} />
                </FormGroup>
                <FormGroup>
                    <label className='form-label'>reps</label>
                    <input type="Text" name='reps' id='reps' value={reps}
                    onChange={(e)=> setReps(e.target.value)} />
                </FormGroup>
                <FormGroup>
                    <label className='form-label'>exercise time</label>
                    <input type="Text" name='time' id='time' value={time}
                    onChange={(e)=> setTime(e.target.value)} />
                </FormGroup>
                <FormGroup>
                <label className='form-label'>speed</label>
                    <input type="Text" name='speed' id='speed' value={speed}
                    onChange={(e)=> setSpeed(e.target.value)} />
                </FormGroup>
                <FormGroup>
                    <select className='form-select' name='exerciseForm' value={exerciseForm}
                    onChange={(e)=> setExerciseForm(e.target.value)}>
                        <option value="aerobic">aerobic</option>
                        <option value="strength">strength</option>
                    </select>
                </FormGroup>
                <FormGroup>
                    <button className='btn btn-success' onClick={(e) => saveOrUpdateExercise(e)}>Save</button>
                    <Link to="/exercise" className='btn btn-danger'>Cancel</Link>
                </FormGroup>
                </Form>
            </Container>
        </div>
    )


};

export default CreateExerciseComponent;